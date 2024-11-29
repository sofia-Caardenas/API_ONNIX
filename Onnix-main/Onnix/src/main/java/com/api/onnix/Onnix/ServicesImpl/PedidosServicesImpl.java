package com.api.onnix.Onnix.ServicesImpl;

import com.api.onnix.Onnix.DTO.DetallePedidosDTO;
import com.api.onnix.Onnix.DTO.PedidosDTO;
import com.api.onnix.Onnix.Entity.DetallePedidosEntity;
import com.api.onnix.Onnix.Entity.PedidosEntity;
import com.api.onnix.Onnix.Mapper.PedidosMapper;
import com.api.onnix.Onnix.Repository.DetallePedidosRepository;
import com.api.onnix.Onnix.Repository.PedidosRepository;
import com.api.onnix.Onnix.Services.PedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PedidosServicesImpl implements PedidosServices {

    @Autowired
    PedidosRepository pedidosRepository;

    @Autowired
    DetallePedidosRepository detallePedidosRepository;

    @Override
    public List<DetallePedidosDTO> getPedidosSinEntregar() {
        List<DetallePedidosDTO> response = new ArrayList<>();
        List<DetallePedidosEntity> data = detallePedidosRepository.findAllBySinEntregar();
        for(DetallePedidosEntity datos : data){
            DetallePedidosDTO pedidos = PedidosMapper.toDetallePedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }

    @Override
    public List<DetallePedidosDTO> getPedidos() {
        List<DetallePedidosDTO> response = new ArrayList<>();
        List<DetallePedidosEntity> data = detallePedidosRepository.findAll();
        for(DetallePedidosEntity datos : data){
            DetallePedidosDTO pedidos = PedidosMapper.toDetallePedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }


    @Override
    public List<DetallePedidosDTO> getPedidosSinEntregarCliente(Long idCliente) {
        List<DetallePedidosDTO> response = new ArrayList<>();
        List<DetallePedidosEntity> data = detallePedidosRepository.findAllBySinEntregarCliente(idCliente);
        for(DetallePedidosEntity datos : data){
            DetallePedidosDTO pedidos = PedidosMapper.toDetallePedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }

    @Override
    public List<DetallePedidosDTO> getPedidosCliente(Long idCliente) {
        List<DetallePedidosDTO> response = new ArrayList<>();
        List<DetallePedidosEntity> data = detallePedidosRepository.findAllByCliente(idCliente);
        for(DetallePedidosEntity datos : data){
            DetallePedidosDTO pedidos = PedidosMapper.toDetallePedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }

    @Override
    public boolean guardarPedidoDetalle(List<DetallePedidosDTO> detallePedidosDTO) {
        try {
            PedidosEntity pedidosEntity = PedidosMapper.toPedidoEntity(detallePedidosDTO.get(0).getPedidos());
            PedidosDTO pedidosDTO = PedidosMapper.toPedidosDTO(pedidosRepository.save(pedidosEntity));
            for (DetallePedidosDTO detalles : detallePedidosDTO){
                detalles.setPedidos(pedidosDTO);
                DetallePedidosEntity detallePedidosEntity = PedidosMapper.toDetallePedidoEntity(detalles);
                detallePedidosRepository.save(detallePedidosEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean actualizarEstadoPedido(PedidosDTO pedidosDTO) {
        try {
            PedidosEntity pedidosEntity = pedidosRepository.findAllById(Collections.singleton(pedidosDTO.getId())).get(0);
            pedidosEntity.setId(pedidosDTO.getId());
            pedidosEntity.setEstado(pedidosDTO.getEstado());
            pedidosRepository.save(pedidosEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}

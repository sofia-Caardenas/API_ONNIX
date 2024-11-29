package com.api.onnix.Onnix.ServicesImpl;

import com.api.onnix.Onnix.DTO.HistorialPedidosDTO;
import com.api.onnix.Onnix.Entity.HistorialPedidosEntity;
import com.api.onnix.Onnix.Mapper.PedidosMapper;
import com.api.onnix.Onnix.Repository.HistorialPedidosRepository;
import com.api.onnix.Onnix.Services.HistorialPedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialPedidosServicesImpl implements HistorialPedidosServices {

    @Autowired
    HistorialPedidosRepository historialPedidosRepository;

    @Override
    public List<HistorialPedidosDTO> getHistorialPedidosSinEntregar() {
        List<HistorialPedidosDTO> response = new ArrayList<>();
        List<HistorialPedidosEntity> data = historialPedidosRepository.findAllBySinEntregar();
        for(HistorialPedidosEntity datos : data){
            HistorialPedidosDTO pedidos = PedidosMapper.toHistorialPedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }

    @Override
    public List<HistorialPedidosDTO> getHistorialPedidos() {
        List<HistorialPedidosDTO> response = new ArrayList<>();
        List<HistorialPedidosEntity> data = historialPedidosRepository.findAll();
        for(HistorialPedidosEntity datos : data){
            HistorialPedidosDTO pedidos = PedidosMapper.toHistorialPedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }

    @Override
    public List<HistorialPedidosDTO> getHistorialPedidosSinEntregarCliente(Long idCliente) {
        List<HistorialPedidosDTO> response = new ArrayList<>();
        List<HistorialPedidosEntity> data = historialPedidosRepository.findAllBySinEntregarCliente(idCliente);
        for(HistorialPedidosEntity datos : data){
            HistorialPedidosDTO pedidos = PedidosMapper.toHistorialPedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }

    @Override
    public List<HistorialPedidosDTO> getHistorialPedidosCliente(Long idCliente) {
        List<HistorialPedidosDTO> response = new ArrayList<>();
        List<HistorialPedidosEntity> data = historialPedidosRepository.findAllByCliente(idCliente);
        for(HistorialPedidosEntity datos : data){
            HistorialPedidosDTO pedidos = PedidosMapper.toHistorialPedidosDTO(datos);
            response.add(pedidos);
        }
        return response;
    }



    @Override
    public boolean guardarHistorialPedido(HistorialPedidosDTO historialPedidosDTO) {
        try {
            HistorialPedidosEntity historialPedidosEntity = PedidosMapper.toHistorialPedidoEntity(historialPedidosDTO);
            historialPedidosRepository.save(historialPedidosEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }


}

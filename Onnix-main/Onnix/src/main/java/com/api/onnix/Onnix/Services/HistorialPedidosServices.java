package com.api.onnix.Onnix.Services;

import com.api.onnix.Onnix.DTO.DetallePedidosDTO;
import com.api.onnix.Onnix.DTO.HistorialPedidosDTO;

import java.util.List;

public interface HistorialPedidosServices {


    List<HistorialPedidosDTO> getHistorialPedidosSinEntregar();

    List<HistorialPedidosDTO> getHistorialPedidos();

    List<HistorialPedidosDTO> getHistorialPedidosSinEntregarCliente(Long idCliente);

    List<HistorialPedidosDTO> getHistorialPedidosCliente(Long idCliente);

    boolean guardarHistorialPedido(HistorialPedidosDTO historialPedidosDTO);
}

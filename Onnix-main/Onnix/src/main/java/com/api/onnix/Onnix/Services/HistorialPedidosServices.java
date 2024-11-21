package com.api.onnix.Onnix.Services;

import com.api.onnix.Onnix.DTO.DetallePedidosDTO;
import com.api.onnix.Onnix.DTO.HistorialPedidosDTO;

import java.util.List;

public interface HistorialPedidosServices {


    List<HistorialPedidosDTO> getHistorialPedidosSinEntregar();

    List<HistorialPedidosDTO> getHistorialPedidosSinEntregarCliente(Long idCliente);

    boolean guardarHistorialPedido(HistorialPedidosDTO historialPedidosDTO);
}

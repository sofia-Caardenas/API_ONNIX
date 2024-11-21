package com.api.onnix.Onnix.Services;

import com.api.onnix.Onnix.DTO.ContactosDTO;
import com.api.onnix.Onnix.DTO.DetallePedidosDTO;
import com.api.onnix.Onnix.DTO.PedidosDTO;

import java.util.List;

public interface PedidosServices {

    List<DetallePedidosDTO> getPedidosSinEntregar();

    List<DetallePedidosDTO> getPedidosSinEntregarCliente(Long idCliente);

    boolean guardarPedidoDetalle(List<DetallePedidosDTO> detallePedidosDTO);
}

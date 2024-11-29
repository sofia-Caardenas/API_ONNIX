package com.api.onnix.Onnix.Mapper;

import com.api.onnix.Onnix.DTO.*;
import com.api.onnix.Onnix.Entity.*;

public class PedidosMapper {

    // Convierte de Entidad a DTO
    public static DetallePedidosDTO toDetallePedidosDTO(DetallePedidosEntity detallePedidos) {
        DetallePedidosDTO detallePedidosDTO = new DetallePedidosDTO();
        detallePedidosDTO.setId(detallePedidos.getId());
        detallePedidosDTO.setCantidad(detallePedidos.getCantidad());
        detallePedidosDTO.setPrecio(detallePedidos.getPrecio());
        detallePedidosDTO.setSubtotal(detallePedidos.getSubtotal());

        PedidosDTO pedidosDTO = new PedidosDTO();
        pedidosDTO.setFechaPedido(detallePedidos.getPedidos().getFechaPedido());
        pedidosDTO.setEstado(detallePedidos.getPedidos().getEstado());
        pedidosDTO.setTotal(detallePedidos.getPedidos().getTotal());
        pedidosDTO.setId(detallePedidos.getPedidos().getId());

        UsuariosDTO usuariosDTO = new UsuariosDTO();
        usuariosDTO.setNombre(detallePedidos.getPedidos().getUsuarios().getNombre());
        usuariosDTO.setId(detallePedidos.getPedidos().getUsuarios().getId());
        pedidosDTO.setUsuarios(usuariosDTO);

        detallePedidosDTO.setPedidos(pedidosDTO);

        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setNombre(detallePedidos.getProductos().getNombre());
        productosDTO.setPrecio(detallePedidos.getProductos().getPrecio());
        detallePedidosDTO.setProductos(productosDTO);

        return detallePedidosDTO;
    }

    // Convierte de DTO a Entidad
    public static DetallePedidosEntity toDetallePedidoEntity(DetallePedidosDTO detallePedidosDTO) {
        DetallePedidosEntity detallePedidos = new DetallePedidosEntity();
        detallePedidos.setCantidad(detallePedidosDTO.getCantidad());
        detallePedidos.setPrecio(detallePedidosDTO.getPrecio());
        detallePedidos.setSubtotal(detallePedidosDTO.getSubtotal());

        PedidosEntity pedidosEntity = new PedidosEntity();
        pedidosEntity.setId(detallePedidosDTO.getPedidos().getId());
        detallePedidos.setPedidos(pedidosEntity);

        ProductosEntity productosEntity = new ProductosEntity();
        productosEntity.setId(detallePedidosDTO.getProductos().getId());
        detallePedidos.setProductos(productosEntity);
        return detallePedidos;
    }

    // Convierte de DTO a Entidad
    public static PedidosEntity toPedidoEntity(PedidosDTO pedidosDTO) {
        PedidosEntity pedidos = new PedidosEntity();
        pedidos.setFechaPedido(pedidosDTO.getFechaPedido());
        pedidos.setEstado(pedidosDTO.getEstado());
        pedidos.setTotal(pedidosDTO.getTotal());
        UsuariosEntity usuario = new UsuariosEntity();
        usuario.setId(pedidosDTO.getUsuarios().getId());
        pedidos.setUsuarios(usuario);
        return pedidos;
    }

    // Convierte de Entidad a DTO
    public static PedidosDTO toPedidosDTO(PedidosEntity pedidos) {
        PedidosDTO pedidosDTO = new PedidosDTO();
        pedidosDTO.setId(pedidos.getId());
        pedidosDTO.setFechaPedido(pedidos.getFechaPedido());
        pedidosDTO.setEstado(pedidos.getEstado());
        pedidosDTO.setTotal(pedidos.getTotal());
        UsuariosDTO usuariosDTO = new UsuariosDTO();
        usuariosDTO.setId(pedidos.getUsuarios().getId());
        pedidosDTO.setUsuarios(usuariosDTO);
        return pedidosDTO;
    }

    // Convierte de Entidad a DTO
    public static HistorialPedidosDTO toHistorialPedidosDTO(HistorialPedidosEntity historialPedidos) {
        HistorialPedidosDTO historialPedidosDTO = new HistorialPedidosDTO();
        historialPedidosDTO.setId(historialPedidos.getId());
        historialPedidosDTO.setFechaPedido(historialPedidos.getFechaPedido());
        historialPedidosDTO.setEstado(historialPedidos.getEstado());

        UsuariosDTO usuariosDTO = new UsuariosDTO();
        usuariosDTO.setNombre(historialPedidos.getPedidos().getUsuarios().getNombre());
        usuariosDTO.setEmail(historialPedidos.getPedidos().getUsuarios().getEmail());
        usuariosDTO.setEstado(historialPedidos.getPedidos().getUsuarios().getEstado());
        usuariosDTO.setId(historialPedidos.getPedidos().getUsuarios().getId());
        historialPedidosDTO.setUsuarios(usuariosDTO);

        PedidosDTO pedidosDTO = new PedidosDTO();
        pedidosDTO.setFechaPedido(historialPedidos.getPedidos().getFechaPedido());
        pedidosDTO.setEstado(historialPedidos.getPedidos().getEstado());
        pedidosDTO.setTotal(historialPedidos.getPedidos().getTotal());
        pedidosDTO.setId(historialPedidos.getPedidos().getId());
        historialPedidosDTO.setPedidos(pedidosDTO);

        return historialPedidosDTO;
    }

    // Convierte de DTO a Entidad
    public static HistorialPedidosEntity toHistorialPedidoEntity(HistorialPedidosDTO historialPedidosDTO) {
        HistorialPedidosEntity historialPedidos = new HistorialPedidosEntity();
        historialPedidos.setFechaPedido(historialPedidosDTO.getFechaPedido());
        historialPedidos.setEstado(historialPedidosDTO.getEstado());

        UsuariosEntity usuario = new UsuariosEntity();
        usuario.setId(historialPedidosDTO.getUsuarios().getId());
        historialPedidos.setUsuarios(usuario);

        PedidosEntity pedido = new PedidosEntity();
        pedido.setId(historialPedidosDTO.getPedidos().getId());
        historialPedidos.setPedidos(pedido);

        return historialPedidos;
    }

}

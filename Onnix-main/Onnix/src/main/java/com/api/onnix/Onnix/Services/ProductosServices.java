package com.api.onnix.Onnix.Services;

import com.api.onnix.Onnix.DTO.ProductosDTO;
import com.api.onnix.Onnix.DTO.UsuariosDTO;

import java.util.List;

public interface ProductosServices {

    List<ProductosDTO> getProductos();

    List<ProductosDTO> getProductosById(Long id);

    List<ProductosDTO> getProductosByNombre(String nombre);

    boolean crearProductos(ProductosDTO productosDTO);

    boolean actualizarProducto(ProductosDTO datosNew);
}

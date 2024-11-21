package com.api.onnix.Onnix.Mapper;

import com.api.onnix.Onnix.DTO.ProductosDTO;
import com.api.onnix.Onnix.Entity.ProductosEntity;

public class ProductosMapper {

    // Convierte de Entidad a DTO
    public static ProductosDTO toProductosDTO(ProductosEntity productos) {
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setId(productos.getId());
        productosDTO.setNombre(productos.getNombre());
        productosDTO.setDescripcion(productos.getDescripcion());
        productosDTO.setPrecio(productos.getPrecio());
        productosDTO.setStock(productos.getStock());
        productosDTO.setRutaImagen(productos.getRutaImagen());
        productosDTO.setEstado(productos.getEstado());
        return productosDTO;
    }

    // Convierte de DTO a Entidad
    public static ProductosEntity toProductosEntity(ProductosDTO productosDTO) {
        ProductosEntity productos = new ProductosEntity();
        productos.setNombre(productosDTO.getNombre());
        productos.setDescripcion(productosDTO.getDescripcion());
        productos.setPrecio(productosDTO.getPrecio());
        productos.setStock(productosDTO.getStock());
        productos.setRutaImagen(productosDTO.getRutaImagen());
        productos.setEstado(productosDTO.getEstado());
        productos.setFechaAgregado(productosDTO.getFechaAgregado());
        return productos;
    }

}

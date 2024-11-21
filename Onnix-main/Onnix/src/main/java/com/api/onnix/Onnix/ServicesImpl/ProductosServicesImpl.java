package com.api.onnix.Onnix.ServicesImpl;

import com.api.onnix.Onnix.DTO.ProductosDTO;
import com.api.onnix.Onnix.Entity.ProductosEntity;
import com.api.onnix.Onnix.Mapper.ProductosMapper;
import com.api.onnix.Onnix.Repository.ProductosRepository;
import com.api.onnix.Onnix.Services.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductosServicesImpl implements ProductosServices {

    @Autowired
    ProductosRepository productosRepository;

    @Override
    public List<ProductosDTO> getProductos() {
        List<ProductosDTO> response = new ArrayList<>();
        List<ProductosEntity> data = productosRepository.findAll();
        for(ProductosEntity datos : data){
            ProductosDTO productos = ProductosMapper.toProductosDTO(datos);
            response.add(productos);
        }
        return response;
    }

    @Override
    public List<ProductosDTO> getProductosById(Long id) {
        List<ProductosDTO> response = new ArrayList<>();
        List<ProductosEntity> data = productosRepository.findAllById(Collections.singleton(id));
        for(ProductosEntity datos : data){
            ProductosDTO productos = ProductosMapper.toProductosDTO(datos);
            response.add(productos);
        }
        return response;
    }

    @Override
    public List<ProductosDTO> getProductosByNombre(String nombre) {
        List<ProductosDTO> response = new ArrayList<>();
        List<ProductosEntity> data = productosRepository.findAllByNombre(nombre);
        for(ProductosEntity datos : data){
            ProductosDTO productos = ProductosMapper.toProductosDTO(datos);
            response.add(productos);
        }
        return response;
    }

    @Override
    public boolean crearProductos(ProductosDTO productosDTO) {
        try {
            ProductosEntity productosEntity = ProductosMapper.toProductosEntity(productosDTO);
            productosRepository.save(productosEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean actualizarProducto(ProductosDTO datosNew) {
        try {
            // Busca el usuario actual por su ID en la base de datos
            List<ProductosEntity> data = productosRepository.findAllById(Collections.singleton(datosNew.getId()));
            for (ProductosEntity dataOld : data) {
                // Convierte la entidad a DTO para manipulación de los datos
                ProductosDTO datosOld = ProductosMapper.toProductosDTO(dataOld);
                // Agrega los campos faltantes (fecha)
                datosOld.setFechaAgregado(dataOld.getFechaAgregado());
                ProductosDTO dtoActualizado = getProductosDTO(datosNew, datosOld);
                // Convierte el DTO actualizado a entidad
                ProductosEntity productosEntity = ProductosMapper.toProductosEntity(dtoActualizado);
                // Asegura que el ID del usuario se mantenga en la entidad actualizada
                productosEntity.setId(datosNew.getId());
                // Actualiza los cambios en base de datos
                productosRepository.save(productosEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    // Valida y actualiza solo los campos que llegan con datos nuevos
    private static ProductosDTO getProductosDTO(ProductosDTO datosNew, ProductosDTO datosOld) {
        ProductosDTO dto = new ProductosDTO();

        // Asigna los valores de 'datosNew' si no son nulos, de lo contrario usa los valores de 'datosOld'
        dto.setNombre(datosNew.getNombre() != null ? datosNew.getNombre() : datosOld.getNombre());
        dto.setDescripcion(datosNew.getDescripcion() != null ? datosNew.getDescripcion() : datosOld.getDescripcion());
        dto.setPrecio(datosNew.getPrecio() != null ? datosNew.getPrecio() : datosOld.getPrecio());
        dto.setStock(datosNew.getStock() != null ? datosNew.getStock() : datosOld.getStock());
        dto.setFechaAgregado(datosNew.getFechaAgregado() != null ? datosNew.getFechaAgregado() : datosOld.getFechaAgregado());
        dto.setEstado(datosNew.getEstado() != null ? datosNew.getEstado() : datosOld.getEstado());
        dto.setRutaImagen(datosNew.getRutaImagen() != null ? datosNew.getRutaImagen() : datosOld.getRutaImagen());

        return dto;
    }


}

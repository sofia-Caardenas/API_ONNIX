package com.api.onnix.Onnix.Controller;

import com.api.onnix.Onnix.DTO.ProductosDTO;
import com.api.onnix.Onnix.DTO.UsuariosDTO;
import com.api.onnix.Onnix.Services.ProductosServices;
import com.api.onnix.Onnix.Services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RequestMapping("/api/v1/Productos")
public class ProductosController {

    @Autowired
    ProductosServices productosServices;

    @GetMapping(value="/getProductos")
    public ResponseEntity<List<ProductosDTO>> getProductos() {
        return new ResponseEntity<>(productosServices.getProductos(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getProductosById/{id}")
    public ResponseEntity<List<ProductosDTO>> getProductosById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(productosServices.getProductosById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getProductosByNombre/{nombre}")
    public ResponseEntity<List<ProductosDTO>> getProductosByNombre(@PathVariable(value = "nombre") String nombre) {
        return new ResponseEntity<>(productosServices.getProductosByNombre(nombre), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/crearProductos", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> crearProductos(@RequestBody ProductosDTO productosDTO) {
        return new ResponseEntity<>(productosServices.crearProductos(productosDTO), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/actualizarProducto", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> actualizarProducto(@RequestBody ProductosDTO productosDTO) {
        return new ResponseEntity<>(productosServices.actualizarProducto(productosDTO), new HttpHeaders(), HttpStatus.OK);
    }

}

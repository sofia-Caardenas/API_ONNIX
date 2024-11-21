package com.api.onnix.Onnix.Controller;

import com.api.onnix.Onnix.DTO.HistorialPedidosDTO;
import com.api.onnix.Onnix.Services.HistorialPedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RequestMapping("/api/v1/HistorialPedidos")
public class HistorialPedidosController {

    @Autowired
    HistorialPedidosServices historialPedidosServices;

    @GetMapping(value="/getHistorialPedidosSinEntregar")
    public ResponseEntity<List<HistorialPedidosDTO>> getHistorialPedidosSinEntregar() {
        return new ResponseEntity<>(historialPedidosServices.getHistorialPedidosSinEntregar(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getHistorialPedidosSinEntregarCliente/{idUsuario}")
    public ResponseEntity<List<HistorialPedidosDTO>> getHistorialPedidosSinEntregarCliente(@PathVariable(value = "idUsuario") Long idUsuario) {
        return new ResponseEntity<>(historialPedidosServices.getHistorialPedidosSinEntregarCliente(idUsuario), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/guardarHistorialPedido", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> guardarHistorialPedido(@RequestBody HistorialPedidosDTO HistorialPedidosDTO) {
        return new ResponseEntity<>(historialPedidosServices.guardarHistorialPedido(HistorialPedidosDTO), new HttpHeaders(), HttpStatus.OK);
    }

}

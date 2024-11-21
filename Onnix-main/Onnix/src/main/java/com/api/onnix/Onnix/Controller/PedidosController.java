package com.api.onnix.Onnix.Controller;

import com.api.onnix.Onnix.DTO.DetallePedidosDTO;
import com.api.onnix.Onnix.Services.PedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RequestMapping("/api/v1/Pedidos")
public class PedidosController {

    @Autowired
    PedidosServices pedidosServices;

    @GetMapping(value="/getPedidosSinEntregar")
    public ResponseEntity<List<DetallePedidosDTO>> getPedidosSinEntregar() {
        return new ResponseEntity<>(pedidosServices.getPedidosSinEntregar(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getPedidosSinEntregarCliente/{idUsuario}")
    public ResponseEntity<List<DetallePedidosDTO>> getPedidosSinEntregarCliente(@PathVariable(value = "idUsuario") Long idUsuario) {
        return new ResponseEntity<>(pedidosServices.getPedidosSinEntregarCliente(idUsuario), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/guardarPedidoDetalle", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> guardarPedidoDetalle(@RequestBody List<DetallePedidosDTO> detallePedidosDTO) {
        return new ResponseEntity<>(pedidosServices.guardarPedidoDetalle(detallePedidosDTO), new HttpHeaders(), HttpStatus.OK);
    }

}

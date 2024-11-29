package com.api.onnix.Onnix.Controller;

import com.api.onnix.Onnix.DTO.DetallePedidosDTO;
import com.api.onnix.Onnix.DTO.PedidosDTO;
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

    @GetMapping(value="/getPedidos")
    public ResponseEntity<List<DetallePedidosDTO>> getPedidos() {
        return new ResponseEntity<>(pedidosServices.getPedidos(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getPedidosSinEntregarCliente/{idUsuario}")
    public ResponseEntity<List<DetallePedidosDTO>> getPedidosSinEntregarCliente(@PathVariable(value = "idUsuario") Long idUsuario) {
        return new ResponseEntity<>(pedidosServices.getPedidosSinEntregarCliente(idUsuario), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getPedidosCliente/{idUsuario}")
    public ResponseEntity<List<DetallePedidosDTO>> getPedidosCliente(@PathVariable(value = "idUsuario") Long idUsuario) {
        return new ResponseEntity<>(pedidosServices.getPedidosCliente(idUsuario), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/guardarPedidoDetalle", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> guardarPedidoDetalle(@RequestBody List<DetallePedidosDTO> detallePedidosDTO) {
        return new ResponseEntity<>(pedidosServices.guardarPedidoDetalle(detallePedidosDTO), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/actualizarEstadoPedido", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> actualizarEstadoPedido(@RequestBody PedidosDTO pedidosDTO) {
        return new ResponseEntity<>(pedidosServices.actualizarEstadoPedido(pedidosDTO), new HttpHeaders(), HttpStatus.OK);
    }

}

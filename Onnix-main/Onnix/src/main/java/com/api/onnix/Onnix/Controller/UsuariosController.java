package com.api.onnix.Onnix.Controller;

import com.api.onnix.Onnix.DTO.UsuariosDTO;
import com.api.onnix.Onnix.Services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RequestMapping("/api/v1/Usuarios")
public class UsuariosController {

    @Autowired
    UsuariosServices usuariosServices;

    @GetMapping(value="/getUsuarios")
    public ResponseEntity<List<UsuariosDTO>> getUsuarios() {
        return new ResponseEntity<>(usuariosServices.getUsuarios(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getUsuariosById/{id}")
    public ResponseEntity<List<UsuariosDTO>> getUsuariosById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(usuariosServices.getUsuariosById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/getUsuariosByNombre/{nombre}")
    public ResponseEntity<List<UsuariosDTO>> getUsuariosByNombre(@PathVariable(value = "nombre") String nombre) {
        return new ResponseEntity<>(usuariosServices.getUsuariosByNombre(nombre), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/crearUsuario", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> crearUsuario(@RequestBody UsuariosDTO usuariosDTO) {
        return new ResponseEntity<>(usuariosServices.crearUsuario(usuariosDTO), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/actualizarUsuario", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> actualizarUsuario(@RequestBody UsuariosDTO usuariosDTO) {
        return new ResponseEntity<>(usuariosServices.actualizarUsuario(usuariosDTO), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/login", consumes = "application/json",produces = "application/json")
    public ResponseEntity<List<UsuariosDTO>> login(@RequestBody UsuariosDTO usuariosDTO) {
        return new ResponseEntity<>(usuariosServices.login(usuariosDTO.getEmail(),usuariosDTO.getClave()), new HttpHeaders(), HttpStatus.OK);
    }

}

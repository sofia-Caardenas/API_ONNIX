package com.api.onnix.Onnix.Controller;

import com.api.onnix.Onnix.DTO.ContactosDTO;
import com.api.onnix.Onnix.Services.ContactosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RequestMapping("/api/v1/Contactos")
public class ContactosController {

    @Autowired
    ContactosServices contactosServices;

    @GetMapping(value="/getContactosByIdUsuario/{idUsuario}")
    public ResponseEntity<List<ContactosDTO>> getContactosByIdUsuario(@PathVariable(value = "idUsuario") Long idUsuario) {
        return new ResponseEntity<>(contactosServices.getContactosByIdUsuario(idUsuario), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/crearContactos", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> crearContactos(@RequestBody ContactosDTO contactosDTO) {
        return new ResponseEntity<>(contactosServices.crearContactos(contactosDTO), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/actualizarContactos", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Boolean> actualizarContactos(@RequestBody ContactosDTO contactosDTO) {
        return new ResponseEntity<>(contactosServices.actualizarContactos(contactosDTO), new HttpHeaders(), HttpStatus.OK);
    }

}

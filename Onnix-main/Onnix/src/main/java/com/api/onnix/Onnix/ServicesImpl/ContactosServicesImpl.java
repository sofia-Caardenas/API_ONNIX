package com.api.onnix.Onnix.ServicesImpl;

import com.api.onnix.Onnix.DTO.ContactosDTO;
import com.api.onnix.Onnix.Entity.ContactosEntity;
import com.api.onnix.Onnix.Mapper.ContactosMapper;
import com.api.onnix.Onnix.Repository.ContactosRepository;
import com.api.onnix.Onnix.Services.ContactosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ContactosServicesImpl implements ContactosServices {

    @Autowired
    ContactosRepository contactosRepository;

    @Override
    public List<ContactosDTO> getContactosByIdUsuario(Long id) {
        List<ContactosDTO> response = new ArrayList<>();
        List<ContactosEntity> data = contactosRepository.findAllByIdUsuario(id);
        for(ContactosEntity datos : data){
            ContactosDTO productos = ContactosMapper.toContactosDTO(datos);
            response.add(productos);
        }
        return response;
    }

    @Override
    public boolean crearContactos(ContactosDTO contactosDTO) {
        try {
            ContactosEntity contactosEntity = ContactosMapper.toContactosEntity(contactosDTO);
            contactosRepository.save(contactosEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean actualizarContactos(ContactosDTO datosNew) {
        try {
            // Busca el usuario actual por su ID en la base de datos
            List<ContactosEntity> data = contactosRepository.findAllById(Collections.singleton(datosNew.getId()));
            for (ContactosEntity dataOld : data) {
                // Convierte la entidad a DTO para manipulación de los datos
                ContactosDTO datosOld = ContactosMapper.toContactosDTO(dataOld);
                ContactosDTO dtoActualizado = getContactosDTO(datosNew, datosOld);
                // Convierte el DTO actualizado a entidad
                ContactosEntity contactosEntity = ContactosMapper.toContactosEntity(dtoActualizado);
                // Asegura que el ID del usuario se mantenga en la entidad actualizada
                contactosEntity.setId(datosNew.getId());
                // Actualiza los cambios en base de datos
                contactosRepository.save(contactosEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    // Valida y actualiza solo los campos que llegan con datos nuevos
    private static ContactosDTO getContactosDTO(ContactosDTO datosNew, ContactosDTO datosOld) {
        ContactosDTO dto = new ContactosDTO();

        // Asigna los valores de 'datosNew' si no son nulos, de lo contrario usa los valores de 'datosOld'
        dto.setTelefono1(datosNew.getTelefono1() != null ? datosNew.getTelefono1() : datosOld.getTelefono1());
        dto.setTelefono2(datosNew.getTelefono2() != null ? datosNew.getTelefono2() : datosOld.getTelefono2());
        dto.setDireccion(datosNew.getDireccion() != null ? datosNew.getDireccion() : datosOld.getDireccion());
        dto.setEstado(datosNew.getEstado() != null ? datosNew.getEstado() : datosOld.getEstado());
        dto.setUsuarios(datosOld.getUsuarios());

        return dto;
    }


}

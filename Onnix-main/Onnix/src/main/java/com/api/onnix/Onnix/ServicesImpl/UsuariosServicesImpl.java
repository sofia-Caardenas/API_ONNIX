package com.api.onnix.Onnix.ServicesImpl;

import com.api.onnix.Onnix.DTO.UsuariosDTO;
import com.api.onnix.Onnix.Entity.UsuariosEntity;
import com.api.onnix.Onnix.Mapper.UsuariosMapper;
import com.api.onnix.Onnix.Repository.UsuariosRepository;
import com.api.onnix.Onnix.Services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UsuariosServicesImpl implements UsuariosServices{

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public List<UsuariosDTO> getUsuarios() {
        List<UsuariosDTO> response = new ArrayList<>();
        List<UsuariosEntity> data = usuariosRepository.findAll();
        for(UsuariosEntity datos : data){
            UsuariosDTO usuarios = UsuariosMapper.toUsuariosDTO(datos);
            response.add(usuarios);
        }
        return response;
    }

    @Override
    public List<UsuariosDTO> getUsuariosById(Long id) {
        List<UsuariosDTO> response = new ArrayList<>();
        List<UsuariosEntity> data = usuariosRepository.findAllById(Collections.singleton(id));
        for(UsuariosEntity datos : data){
            UsuariosDTO usuarios = UsuariosMapper.toUsuariosDTO(datos);
            response.add(usuarios);
        }
        return response;
    }

    @Override
    public List<UsuariosDTO> getUsuariosByNombre(String nombre) {
        List<UsuariosDTO> response = new ArrayList<>();
        List<UsuariosEntity> data = usuariosRepository.findAllByNombre(nombre);
        for(UsuariosEntity datos : data){
            UsuariosDTO usuarios = UsuariosMapper.toUsuariosDTO(datos);
            response.add(usuarios);
        }
        return response;
    }

    @Override
    public boolean crearUsuario(UsuariosDTO usuariosDTO) {
        try {
            UsuariosEntity usuariosEntity = UsuariosMapper.toUsuariosEntity(usuariosDTO);
            usuariosRepository.save(usuariosEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean actualizarUsuario(UsuariosDTO datosNew) {
        try {
            // Busca el usuario actual por su ID en la base de datos
            List<UsuariosEntity> data = usuariosRepository.findAllById(Collections.singleton(datosNew.getId()));
            for (UsuariosEntity dataOld : data) {
                // Convierte la entidad a DTO para manipulación de los datos
                UsuariosDTO datosOld = UsuariosMapper.toUsuariosDTO(dataOld);
                // Agrega los campos faltantes (clave y estado)
                datosOld.setClave(dataOld.getClave());
                datosOld.setEstado(dataOld.getEstado());
                UsuariosDTO dtoActualizado = getUsuariosDTO(datosNew, datosOld);
                // Convierte el DTO actualizado a entidad
                UsuariosEntity usuariosEntity = UsuariosMapper.toUsuariosEntity(dtoActualizado);
                // Asegura que el ID del usuario se mantenga en la entidad actualizada
                usuariosEntity.setId(datosNew.getId());
                // Actualiza los cambios en base de datos
                usuariosRepository.save(usuariosEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    // Valida y actualiza solo los campos que llegan con datos nuevos
    private static UsuariosDTO getUsuariosDTO(UsuariosDTO datosNew, UsuariosDTO datosOld) {
        UsuariosDTO dto = new UsuariosDTO();

        // Asigna los valores de 'datosNew' si no son nulos, de lo contrario usa los valores de 'datosOld'
        dto.setNombre(datosNew.getNombre() != null ? datosNew.getNombre() : datosOld.getNombre());
        dto.setEmail(datosNew.getEmail() != null ? datosNew.getEmail() : datosOld.getEmail());
        dto.setClave(datosNew.getClave() != null ? datosNew.getClave() : datosOld.getClave());
        dto.setEstado(datosNew.getEstado() != null ? datosNew.getEstado() : datosOld.getEstado());
        dto.setRoles(datosNew.getRoles() != null ? datosNew.getRoles() : datosOld.getRoles());

        return dto;
    }

    @Override
    public List<UsuariosDTO> login(String usuario, String pass){
        List<UsuariosDTO> response = new ArrayList<>();
        List<UsuariosEntity> data = usuariosRepository.findAllByNombre(usuario,pass);
        for(UsuariosEntity datos : data){
            UsuariosDTO usuarios = UsuariosMapper.toUsuariosDTO(datos);
            response.add(usuarios);
        }
        return response;
    }

}

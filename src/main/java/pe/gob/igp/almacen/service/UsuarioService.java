package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.UsuarioEntity;
import pe.gob.igp.almacen.repository.UsuarioRepository;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public UsuarioEntity findById(Integer usuarioId){
        return usuarioRepository.getOne(usuarioId);
    }
    
}

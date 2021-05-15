package pe.gob.igp.almacen.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.UsuarioEntity;
import pe.gob.igp.almacen.repository.UsuarioRepository;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
}

package pe.gob.igp.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.OrigenEntity;
import pe.gob.igp.almacen.repository.OrigenRepository;

@Service
public class OrigenService {
    
    @Autowired
    private OrigenRepository origenRepository;

    public List<OrigenEntity> getOrigen(){
        return origenRepository.findAll();
    }
}

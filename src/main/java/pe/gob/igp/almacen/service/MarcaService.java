package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.MarcaEntity;
import pe.gob.igp.almacen.repository.MarcaRepository;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    public MarcaEntity findById(Integer marcaId){
        return marcaRepository.getOne(marcaId);
    }


}

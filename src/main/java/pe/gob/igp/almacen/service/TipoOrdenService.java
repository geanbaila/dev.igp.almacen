package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.TipoOrdenEntity;
import pe.gob.igp.almacen.repository.TipoOrdenRepository;

@Service
public class TipoOrdenService {
    
    @Autowired
    private TipoOrdenRepository tipoOrdenRepository;

    public TipoOrdenEntity findById(Integer tipoOrdenId){
        return tipoOrdenRepository.getOne(tipoOrdenId);
    }
}

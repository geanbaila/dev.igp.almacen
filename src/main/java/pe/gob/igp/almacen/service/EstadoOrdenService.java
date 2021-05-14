package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.EstadoOrdenEntity;
import pe.gob.igp.almacen.repository.EstadoOrdenRepository;



@Service
public class EstadoOrdenService {
    
    @Autowired
    private EstadoOrdenRepository estadoOrdenRepository;

    public EstadoOrdenEntity findById(Integer estadoId){
        return estadoOrdenRepository.getOne(estadoId);
    }
}

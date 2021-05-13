package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.PuestoEntity;
import pe.gob.igp.almacen.repository.PuestoRepository;

@Service
public class PuestoService {
    
    @Autowired
    private PuestoRepository puestoRepository;

    public PuestoEntity findById(Integer puestoId){
        return puestoRepository.getOne(puestoId);
    }
}

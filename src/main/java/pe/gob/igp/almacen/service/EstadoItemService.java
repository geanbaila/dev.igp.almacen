package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.EstadoItemEntity;
import pe.gob.igp.almacen.repository.EstadoItemRepository;

@Service
public class EstadoItemService {
    
    @Autowired
    private EstadoItemRepository estadoItemRepository;

    public EstadoItemEntity findById(Integer estadoItemId){
        return estadoItemRepository.getOne(estadoItemId);
    }
}

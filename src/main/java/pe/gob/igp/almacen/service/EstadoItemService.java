package pe.gob.igp.almacen.service;

import java.util.List;

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

    public List<EstadoItemEntity> getEstadoItem(){
        return estadoItemRepository.findAll();
    }
}

package pe.gob.igp.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.MotivoEntity;
import pe.gob.igp.almacen.repository.MotivoRepository;

@Service
public class MotivoService {
    
    @Autowired
    private MotivoRepository motivoRepository;

    public List<MotivoEntity> getMotivo(){
        return motivoRepository.findAll();
    }
}

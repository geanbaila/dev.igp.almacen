package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.AuditoriaEntity;
import pe.gob.igp.almacen.repository.AuditoriaRepository;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public void save(AuditoriaEntity auditoria){
        auditoriaRepository.save(auditoria);
    }
    
}

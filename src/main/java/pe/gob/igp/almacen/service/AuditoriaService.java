package pe.gob.igp.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.igp.almacen.entity.AuditoriaEntity;
import pe.gob.igp.almacen.repository.AuditoriaRepository;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(propagation=Propagation.REQUIRED)
    public void save(AuditoriaEntity auditoria){
        auditoriaRepository.save(auditoria);
    }
    
}

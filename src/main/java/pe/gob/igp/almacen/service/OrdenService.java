package pe.gob.igp.almacen.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.AuditoriaEntity;
import pe.gob.igp.almacen.entity.OrdenEntity;
import pe.gob.igp.almacen.repository.OrdenDetalleRepository;
import pe.gob.igp.almacen.repository.OrdenRepository;

@Service
public class OrdenService {
    
   @Autowired
   private OrdenRepository ordenRepository;

   @Autowired
   private AuditoriaService auditoriaService;

   @Autowired
   private OrdenDetalleRepository ordenDetalleRepository;
   
   public List<OrdenEntity> getOrden(){
       return ordenRepository.findAll();
   }
   
   public OrdenEntity findById(Integer ordenId){
       return ordenRepository.getOne(ordenId);
   }

   public OrdenEntity save(OrdenEntity orden){
       String operacion = (orden.getId()==null)?"insert":"update";
       orden = ordenRepository.saveAndFlush(orden);
       callAuditor(orden.getId(), operacion);
       return orden;
   }

   public void remove(Integer ordenId){
        ordenDetalleRepository.deleteAll(ordenId);
        ordenRepository.deleteById(ordenId);
        callAuditor(ordenId, "delete");
   }

    public void callAuditor(Integer ordenId, String operacion){
        AuditoriaEntity auditoria = new AuditoriaEntity(
            new Date(System.currentTimeMillis()), 
            SecurityContextHolder.getContext().getAuthentication().getName(), 
            operacion+":OrdenEntity:"+ordenId+":"+getClass().getName());
        auditoriaService.save(auditoria);
    }

}

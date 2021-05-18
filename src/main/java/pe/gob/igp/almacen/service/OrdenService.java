package pe.gob.igp.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.OrdenEntity;
import pe.gob.igp.almacen.repository.OrdenDetalleRepository;
import pe.gob.igp.almacen.repository.OrdenRepository;

@Service
public class OrdenService {
    
   @Autowired
   private OrdenRepository ordenRepository;

   @Autowired
   private OrdenDetalleRepository ordenDetalleRepository;
   
   public List<OrdenEntity> getOrden(){
       return ordenRepository.findAll();
   }
   
   public OrdenEntity findById(Integer ordenId){
       return ordenRepository.getOne(ordenId);
   }

   public OrdenEntity save(OrdenEntity orden){
       return ordenRepository.save(orden);
   }

   public void remove(Integer ordenId){
        ordenDetalleRepository.deleteAll(ordenId);
        ordenRepository.deleteById(ordenId);
   }


}

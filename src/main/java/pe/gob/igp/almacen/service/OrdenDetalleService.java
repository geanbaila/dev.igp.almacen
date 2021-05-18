package pe.gob.igp.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.OrdenDetalleEntity;
import pe.gob.igp.almacen.repository.OrdenDetalleRepository;

@Service
public class OrdenDetalleService {

    @Autowired
    private OrdenDetalleRepository ordenDetalleRepository;

    public OrdenDetalleEntity save(OrdenDetalleEntity ordenDetalle){
        return ordenDetalleRepository.save(ordenDetalle);
    } 
    
    public List<OrdenDetalleEntity> getOrdenDetalle(Integer OrdenId){
        return ordenDetalleRepository.getOrdenDetalle(OrdenId);
    }

    public void remove(Integer ordenDetalleId){
        ordenDetalleRepository.deleteById(ordenDetalleId);
    }

    public void removeAll(Integer ordenId){
        ordenDetalleRepository.deleteAll(ordenId);
    }
}

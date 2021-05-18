package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.OrdenEntity;

public interface OrdenRepository extends JpaRepository<OrdenEntity,Integer>{
    
}

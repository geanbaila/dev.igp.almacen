package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.PuestoEntity;

public interface PuestoRepository extends JpaRepository<PuestoEntity,Integer>{
    
}

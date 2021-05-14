package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.EstadoOrdenEntity;

public interface EstadoOrdenRepository extends JpaRepository<EstadoOrdenEntity,Integer>{
    
}

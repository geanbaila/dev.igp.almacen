package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.TipoOrdenEntity;

public interface TipoOrdenRepository extends JpaRepository<TipoOrdenEntity,Integer>{
    
}

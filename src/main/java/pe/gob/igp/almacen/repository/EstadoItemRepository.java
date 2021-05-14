package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.EstadoItemEntity;

public interface EstadoItemRepository extends JpaRepository<EstadoItemEntity,Integer>{
    
}

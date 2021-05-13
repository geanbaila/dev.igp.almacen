package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.ModeloEntity;

public interface ModeloRepository extends JpaRepository<ModeloEntity, Integer>{
    
}

package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity,Integer>{
    
}

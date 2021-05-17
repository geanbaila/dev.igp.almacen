package pe.gob.igp.almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.gob.igp.almacen.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity,Integer>{

    @Query("SELECT i FROM ItemEntity i WHERE i.codigoPatrimonial like ?1%")
    List<ItemEntity> findLike(String codigoPatrimonial);
}

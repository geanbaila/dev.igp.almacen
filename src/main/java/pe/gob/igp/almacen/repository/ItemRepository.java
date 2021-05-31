package pe.gob.igp.almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.gob.igp.almacen.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity,Integer>{

    @Query("SELECT i FROM ItemEntity i WHERE i.codigoPatrimonial LIKE ?1%")
    List<ItemEntity> findLike(String codigoPatrimonial);

    @Query("SELECT i FROM ItemEntity i  WHERE "+
    "(i.codigoPatrimonial LIKE %?1% or i.denominacion LIKE %?1% or i.serie LIKE %?1% or i.marca.nombre like %?1% or i.modelo.nombre like %?1%)")
    List<ItemEntity> advantageSearch(String criterio);
}

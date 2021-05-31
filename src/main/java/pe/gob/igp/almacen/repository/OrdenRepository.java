package pe.gob.igp.almacen.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.gob.igp.almacen.entity.OrdenEntity;

public interface OrdenRepository extends JpaRepository<OrdenEntity,Integer>{

    //countQuery, nativeQuery
    @Query("SELECT o FROM OrdenEntity o WHERE o.numeroOrden LIKE %?1% or o.recibe.nombre LIKE %?1% or (?1 between o.fechaSalidaPrevista AND o.fechaRetornoPrevista)")
    Page<OrdenEntity> findAllBy(Pageable page, String criterio);

    @Query("SELECT o FROM OrdenEntity o WHERE "+
    "(o.numeroOrden LIKE %?1% or o.recibe.nombre LIKE %?1% or o.recepciona.nombre LIKE %?1% or o.origen.nombre LIKE %?1%) ")
    List<OrdenEntity> findAllBy(String criterio);

}



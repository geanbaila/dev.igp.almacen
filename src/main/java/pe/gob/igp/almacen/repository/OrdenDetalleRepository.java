package pe.gob.igp.almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.igp.almacen.entity.OrdenDetalleEntity;

public interface OrdenDetalleRepository extends JpaRepository<OrdenDetalleEntity,Integer>{
 
    @Query("SELECT o FROM OrdenDetalleEntity o WHERE o.orden.id = ?1")
    List<OrdenDetalleEntity> getOrdenDetalle(Integer ordenId);

    @Transactional
    @Modifying
    @Query("DELETE FROM OrdenDetalleEntity o WHERE o.orden.id = ?1")
    void deleteAll(Integer ordenId);
}

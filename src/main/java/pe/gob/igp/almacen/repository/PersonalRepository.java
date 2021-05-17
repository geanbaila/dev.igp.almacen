package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.igp.almacen.entity.PersonalEntity;

public interface PersonalRepository extends JpaRepository<PersonalEntity,Integer>{
    
}

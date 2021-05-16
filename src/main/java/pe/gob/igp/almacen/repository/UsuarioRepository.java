package pe.gob.igp.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.igp.almacen.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer>{
    
    @Query("SELECT u FROM UsuarioEntity u WHERE u.usuario = ?1")
    UsuarioEntity findUsuario(String usuario);

}

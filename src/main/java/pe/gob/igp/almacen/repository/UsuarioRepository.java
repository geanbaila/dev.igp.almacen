package pe.gob.igp.almacen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.igp.almacen.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>{
    
    @Query("SELECT u FROM UsuarioEntity u WHERE u.usuario = ?1")
    UsuarioEntity findUser(String usuario);

    
}

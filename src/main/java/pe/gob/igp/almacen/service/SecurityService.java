package pe.gob.igp.almacen.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.UsuarioEntity;
import pe.gob.igp.almacen.repository.UsuarioRepository;

@Service
public class SecurityService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    Logger logger = LoggerFactory.getLogger(SecurityService.class);

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        UsuarioEntity usuarioeEntity = usuarioRepository.findUsuario(usuario);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        UserDetails userDetails = new User(usuarioeEntity.getUsuario(), usuarioeEntity.getClave(), roles);
        return userDetails; 
    }

}

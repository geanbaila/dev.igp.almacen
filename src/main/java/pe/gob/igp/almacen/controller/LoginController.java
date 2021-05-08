package pe.gob.igp.almacen.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.igp.almacen.service.UsuarioService;


@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("")
    public String login(){
        return "login/login";
    }

    @PostMapping("/autenticar")
    public String autenticar(@PathParam("usuario") String usuario, @RequestParam("clave") String clave, @RequestParam(name="rol", required =false) Long rol ){
        return "redirect:/";
    }

    public String evaluar(){
        return "login/login";
    }

    @RequestMapping("/restablecer-accesos")
    public String restablecerAccesos(){
        return "login/restablecer";
    }

  
}

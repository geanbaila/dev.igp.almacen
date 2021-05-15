package pe.gob.igp.almacen.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.igp.almacen.service.UsuarioService;


@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping({""})
    public String login(){
        System.out.println("estoy en /login/");
        return "login/login";
    }

    @RequestMapping("autenticar")
    public ModelAndView loginConErrorMostrar(@RequestParam(value = "error", required = false, defaultValue = "True") boolean error) {
        System.out.println("acá hubo un error:"+error);
        return new ModelAndView("login/login", "error", error);
    }

    @RequestMapping("/restablecer-accesos")
    public String restablecerAccesos(){
        return "login/restablecer";
    }

  
}

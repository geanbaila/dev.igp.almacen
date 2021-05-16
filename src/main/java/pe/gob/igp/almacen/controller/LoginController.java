package pe.gob.igp.almacen.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @RequestMapping({""}) // login
    public ModelAndView login() {
        return new ModelAndView("login/login", "error", "");
    }


  
}

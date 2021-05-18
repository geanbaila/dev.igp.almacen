package pe.gob.igp.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/login")
@Controller
public class LoginController {    

    @RequestMapping("")
    public ModelAndView login(@RequestParam(value = "error", required = false, defaultValue = "0") String error) {        
        System.out.println("error:"+error);
        return new ModelAndView("login/login","error", error);
    }
  
    @RequestMapping("/restablecer-accesos")
    public String restablecerAccesos(){
        return "login/restablecer";
    }
    
}

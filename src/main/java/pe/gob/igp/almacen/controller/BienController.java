package pe.gob.igp.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bien")
public class BienController {

    @GetMapping({"","/"})
    public String index(){
        return "bien/listar";
    }

    @GetMapping("nuevo")
    public String nuevo(){
        return "bien/nuevo";
    }
    
    @GetMapping("listar")
    public String listar(){
        return "bien/listar";
    }
}

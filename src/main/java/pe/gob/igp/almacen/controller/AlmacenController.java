package pe.gob.igp.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("almacen")
public class AlmacenController {

    @GetMapping({"","listar"})
    public String index(){
        return "item/listar";
    }

    @GetMapping("nuevo")
    public String nuevo(){
        return "item/nuevo";
    }
    
   
}

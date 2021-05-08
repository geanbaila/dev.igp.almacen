package pe.gob.igp.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/salida")
@Controller
public class SalidaController {
    
    @GetMapping({"","listar"})
    public String home(){
        return "salida/listar";
    }

    @GetMapping("/nuevo")
    public String steps(){
        return "salida/nuevo";
    }

    @GetMapping("/editar/{id}")
    public String listar(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("autor", "gean");
        return "inventario";
    }

    @PostMapping("/guardar")
    public String guardar(){
        return "inventario";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(int id){
        return "inventario";
    }

    
}

package pe.gob.igp.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/orden-salida")
@Controller
public class OrdenSalidaController {
        
    @GetMapping("/steps")
    public String steps(){
        return "orden-salida/nuevo2";
    }

    @GetMapping("/listar")
    public String listar(){
        return "orden-salida/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(){
        return "orden-salida/nuevo";
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

    @GetMapping("")
    public String home(){
        return "layout";
    }
}

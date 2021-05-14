package pe.gob.igp.almacen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.igp.almacen.entity.OrdenEntity;
import pe.gob.igp.almacen.service.OrdenService;


@RequestMapping("/salida")
@Controller
public class SalidaController {

    @Autowired
    private OrdenService ordenService;
    
    @GetMapping({"","listar"})
    public ModelAndView home(){
        List<OrdenEntity> prg_orden = ordenService.getOrden();
        return new ModelAndView("salida/listar", "prg_orden", prg_orden);
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

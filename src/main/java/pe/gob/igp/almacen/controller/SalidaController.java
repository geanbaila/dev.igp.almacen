package pe.gob.igp.almacen.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.igp.almacen.entity.MotivoEntity;
import pe.gob.igp.almacen.entity.OrdenEntity;
import pe.gob.igp.almacen.service.MotivoService;
import pe.gob.igp.almacen.service.OrdenService;


@RequestMapping("/salida")
@Controller
public class SalidaController {
    Logger logger = LoggerFactory.getLogger(SalidaController.class);

    @Autowired
    private OrdenService ordenService;

    @Autowired
    private MotivoService motivoService;
    
    @GetMapping({"","listar"})
    public ModelAndView home(){
        List<OrdenEntity> prg_orden = ordenService.getOrden();
        logger.debug("Listando las órdenes de salida:"+prg_orden.toString());
        return new ModelAndView("salida/listar", "prg_orden", prg_orden);
    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo(){
        List<MotivoEntity> prg_motivo = motivoService.getMotivo();
        return new ModelAndView("salida/nuevo", "prg_motivo", prg_motivo);
    }

    @GetMapping("/editar/{id}")
    public String listar(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("autor", "gean");
        return "inventario";
    }

    @PostMapping("/guardar")
    public String guardar(){
        logger.info("Se ha registrado una orden de salida.");
        return "inventario";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(int id){
        logger.warn("Se ha eliminado un orden de salida (orden_id:"+id+").");
        return "inventario";
    }

    
}

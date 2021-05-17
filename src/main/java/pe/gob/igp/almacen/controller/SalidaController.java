package pe.gob.igp.almacen.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.igp.almacen.entity.MarcaEntity;
import pe.gob.igp.almacen.entity.ModeloEntity;
import pe.gob.igp.almacen.entity.MotivoEntity;
import pe.gob.igp.almacen.entity.OrdenEntity;
import pe.gob.igp.almacen.entity.OrigenEntity;
import pe.gob.igp.almacen.entity.PersonalEntity;
import pe.gob.igp.almacen.service.MarcaService;
import pe.gob.igp.almacen.service.ModeloService;
import pe.gob.igp.almacen.service.MotivoService;
import pe.gob.igp.almacen.service.OrdenService;
import pe.gob.igp.almacen.service.OrigenService;
import pe.gob.igp.almacen.service.PersonalService;


@RequestMapping("/salida")
@Controller
public class SalidaController {
    Logger logger = LoggerFactory.getLogger(SalidaController.class);

    @Autowired
    private OrdenService ordenService;

    @Autowired
    private MotivoService motivoService;

    @Autowired
    private OrigenService origenService;
   
    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModeloService modeloService;

    @Autowired
    private PersonalService personalService;
    
    @GetMapping({"","listar"})
    public ModelAndView home(){
        List<OrdenEntity> prg_orden = ordenService.getOrden();
        logger.debug("Listando las órdenes de salida:"+prg_orden.toString());
        return new ModelAndView("salida/listar", "prg_orden", prg_orden);
    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo(){
        List<MotivoEntity> prg_motivo = motivoService.getMotivo();
        List<OrigenEntity> prg_origen = origenService.getOrigen();
        List<MarcaEntity> prg_marca = marcaService.getMarca();
        List<ModeloEntity> prg_modelo = modeloService.getModelo();
        List<PersonalEntity> prg_personal = personalService.getPersonal();
        Map<String,List> data = new HashMap<>();
        data.put("prg_motivo", prg_motivo);
        data.put("prg_origen", prg_origen);
        data.put("prg_marca", prg_marca);
        data.put("prg_modelo", prg_modelo);
        data.put("prg_personal", prg_personal);
        return new ModelAndView("salida/nuevo", "data", data);
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

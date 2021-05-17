package pe.gob.igp.almacen.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.igp.almacen.entity.EstadoOrdenEntity;
import pe.gob.igp.almacen.entity.ItemEntity;
import pe.gob.igp.almacen.entity.MarcaEntity;
import pe.gob.igp.almacen.entity.ModeloEntity;
import pe.gob.igp.almacen.entity.MotivoEntity;
import pe.gob.igp.almacen.entity.OrdenEntity;
import pe.gob.igp.almacen.entity.OrigenEntity;
import pe.gob.igp.almacen.entity.PersonalEntity;
import pe.gob.igp.almacen.entity.TipoOrdenEntity;
import pe.gob.igp.almacen.entity.UsuarioEntity;
import pe.gob.igp.almacen.service.EstadoOrdenService;
import pe.gob.igp.almacen.service.MarcaService;
import pe.gob.igp.almacen.service.ModeloService;
import pe.gob.igp.almacen.service.MotivoService;
import pe.gob.igp.almacen.service.OrdenService;
import pe.gob.igp.almacen.service.OrigenService;
import pe.gob.igp.almacen.service.PersonalService;
import pe.gob.igp.almacen.service.TipoOrdenService;
import pe.gob.igp.almacen.service.UsuarioService;


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
    private TipoOrdenService tipoOrdenService;

    @Autowired
    private PersonalService personalService;

    @Autowired
    private UsuarioService usuarioService; 

    @Autowired
    private EstadoOrdenService estadoOrdenService;
    
    @GetMapping({"","listar"})
    public ModelAndView home(){
        List<OrdenEntity> prg_orden = ordenService.getOrden();
        logger.debug("Listando las órdenes de salida:"+prg_orden.toString());
        return new ModelAndView("salida/listar", "prg_orden", prg_orden);
    }

    @GetMapping("nuevo")
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

    @GetMapping("editar/{id}")
    public String listar(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("autor", "gean");
        return "salida/editar";
    }

    @RequestMapping("guardar")
    public String guardar(
        @RequestParam(name = "motivo_id", required = false) Integer motivoId, 
        @RequestParam(name = "origen_id", required = false) Integer origenId, 
        @RequestParam(name = "asignado_id", required = false) Integer asignadoId, 
        @RequestParam(name = "comisionado_id", required = false) Integer comisionadoId,
        @RequestParam(name = "destino", required = false) String destino,
        @RequestParam(name = "fecha_salida_prevista", required = false) Date fechaSalidaPrevista,
        @RequestParam(name = "fecha_retorno_prevista", required = false) Date fechaRetornoPrevista,
        @RequestParam(name = "numero_orden", required = false) String numeroOrden,
        @RequestParam(name = "observacion", required = false) String observacion,
        @RequestParam(name = "accesorio", required = false) String accesorio,
        @RequestParam(name = "item_id", required = false) String itemId[]
    ){
        ItemEntity item = new ItemEntity();

        String comisionadoDni = "";
        String comisionadoArea = "";
        String autorizaDni = "";
        String autorizaArea = "";
        String autoriza = "";
        int tipoOrdenId = 1;
        int usuarioId = 1;
        int estadoId = 1;
        MotivoEntity motivo = motivoService.findById(motivoId);
        OrigenEntity origen = origenService.findById(origenId);
        TipoOrdenEntity tipoOrden = tipoOrdenService.findById(tipoOrdenId);
        UsuarioEntity usuario = usuarioService.findById(usuarioId);
        EstadoOrdenEntity estadoOrden = estadoOrdenService.findById(estadoId);
        String comisionado = personalService.findById(comisionadoId).getNombre();
 

        OrdenEntity ordenEntity = new OrdenEntity(
            tipoOrden,
            motivo,
            estadoOrden,
            origen,
            usuario,
            destino,
            fechaSalidaPrevista,
            fechaRetornoPrevista,
            comisionado,
            comisionadoDni,
            comisionadoArea,
            autoriza,
            autorizaDni,
            autorizaArea,
            accesorio,
            observacion,
            numeroOrden);
        ordenService.save(ordenEntity);
        System.out.println(motivo);
        logger.info("Se ha registrado una orden de salida.");
        return "redirect:/salida";
    }

    @DeleteMapping("eliminar/{id}")
    public String eliminar(int id){
        logger.warn("Se ha eliminado un orden de salida (orden_id:"+id+").");
        return "salida/listar";
    }

    
}

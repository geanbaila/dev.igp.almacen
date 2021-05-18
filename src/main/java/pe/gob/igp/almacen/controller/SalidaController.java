package pe.gob.igp.almacen.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import pe.gob.igp.almacen.entity.OrdenDetalleEntity;
import pe.gob.igp.almacen.entity.OrdenEntity;
import pe.gob.igp.almacen.entity.OrigenEntity;
import pe.gob.igp.almacen.entity.PersonalEntity;
import pe.gob.igp.almacen.entity.TipoOrdenEntity;
import pe.gob.igp.almacen.entity.UsuarioEntity;
import pe.gob.igp.almacen.service.EstadoOrdenService;
import pe.gob.igp.almacen.service.ItemService;
import pe.gob.igp.almacen.service.MarcaService;
import pe.gob.igp.almacen.service.ModeloService;
import pe.gob.igp.almacen.service.MotivoService;
import pe.gob.igp.almacen.service.OrdenDetalleService;
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

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrdenDetalleService ordenDetalleService;
    
    @GetMapping({"","listar"})
    public ModelAndView home(){
        List<OrdenEntity> eanOrden = ordenService.getOrden();
        logger.debug("Listando las órdenes de salida:"+eanOrden.toString());
        return new ModelAndView("salida/listar", "eanOrden", eanOrden);
    }

    @GetMapping("nuevo")
    public ModelAndView nuevo(){
        List<MotivoEntity> prg_motivo = motivoService.getMotivo();
        List<OrigenEntity> prg_origen = origenService.getOrigen();
        List<MarcaEntity> prg_marca = marcaService.getMarca();
        List<ModeloEntity> prg_modelo = modeloService.getModelo();
        List<PersonalEntity> prg_personal = personalService.getPersonal();
        Map<String,List> data = new HashMap<>();
        data.put("eanMotivo", prg_motivo);
        data.put("eanOrigen", prg_origen);
        data.put("eanMarca", prg_marca);
        data.put("eanModelo", prg_modelo);
        data.put("eanPersonal", prg_personal);
        return new ModelAndView("salida/nuevo", "data", data);
    }

    @GetMapping("editar/{ordenId}")
    public ModelAndView listar(@PathVariable("ordenId") int ordenId){
        List<MotivoEntity> prg_motivo = motivoService.getMotivo();
        List<OrigenEntity> prg_origen = origenService.getOrigen();
        List<MarcaEntity> prg_marca = marcaService.getMarca();
        List<ModeloEntity> prg_modelo = modeloService.getModelo();
        List<PersonalEntity> prg_personal = personalService.getPersonal();
        List<OrdenDetalleEntity> eanOrdenDetalle = ordenDetalleService.getOrdenDetalle(ordenId);
        String itemIds = "";
        for(OrdenDetalleEntity ordenDetalle : eanOrdenDetalle){
            String comodin = (itemIds!="")?",":"";
            itemIds+= comodin+ordenDetalle.getItem().getId();
        }

        OrdenEntity orden = ordenService.findById(ordenId);
        Map<String,List> data = new HashMap<>();
        data.put("eanMotivo", prg_motivo);
        data.put("eanOrigen", prg_origen);
        data.put("eanMarca", prg_marca);
        data.put("eanModelo", prg_modelo);
        data.put("eanPersonal", prg_personal);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", data);
        modelAndView.addObject("orden", orden);
        modelAndView.addObject("eanOrdenDetalle", eanOrdenDetalle);
        modelAndView.addObject("itemIds", itemIds);
        modelAndView.setViewName("salida/editar");
        return modelAndView;
    }

    @RequestMapping("guardar")
    public String guardar(
        @RequestParam(name = "motivo_id", required = false) Integer motivoId, 
        @RequestParam(name = "origen_id", required = false) Integer origenId, 
        @RequestParam(name = "recibe_id", required = false) Integer recibeId, 
        @RequestParam(name = "recepciona_id", required = false) Integer recepcionaId,
        @RequestParam(name = "destino", required = false) String destino,
        @RequestParam(name = "fecha_salida_prevista", required = false) Date fechaSalidaPrevista,
        @RequestParam(name = "fecha_retorno_prevista", required = false) Date fechaRetornoPrevista,
        @RequestParam(name = "numero_orden", required = false) String numeroOrden,
        @RequestParam(name = "observacion", required = false) String observacion,
        @RequestParam(name = "accesorio", required = false) String accesorio,
        @RequestParam(name = "item_id", required = false) String itemIds
    ){
        ItemEntity item = new ItemEntity();

        String comisionadoDni = "";
        String comisionadoArea = "";
        String autorizaDni = "";
        String autorizaArea = "";
        
        int tipoOrdenId = 1;
        int usuarioId = 1;
        int estadoId = 1;
        MotivoEntity motivo = motivoService.findById(motivoId);
        OrigenEntity origen = origenService.findById(origenId);
        TipoOrdenEntity tipoOrden = tipoOrdenService.findById(tipoOrdenId);
        UsuarioEntity usuario = usuarioService.findById(usuarioId);
        EstadoOrdenEntity estadoOrden = estadoOrdenService.findById(estadoId);
        PersonalEntity recibe = personalService.findById(recibeId);
        PersonalEntity recepciona = personalService.findById(recepcionaId);

        OrdenEntity orden = new OrdenEntity(
            tipoOrden,
            motivo,
            estadoOrden,
            origen,
            usuario,
            destino,
            fechaSalidaPrevista,
            fechaRetornoPrevista,
            recepciona,
            comisionadoDni,
            comisionadoArea,
            recibe,
            autorizaDni,
            autorizaArea,
            accesorio,
            observacion,
            numeroOrden);
        orden = ordenService.save(orden);
        
        String[] eanItem = itemIds.split(",");
        if(eanItem.length>0){
            for(String itemId : eanItem){
                OrdenDetalleEntity ordenDetalle = new OrdenDetalleEntity();
                ordenDetalle.setItem(itemService.findById(Integer.parseInt(itemId)));
                ordenDetalle.setOrden(orden);
                ordenDetalleService.save(ordenDetalle);
            }
        }
        logger.info("Se ha registrado una orden de salida.");
        return "redirect:/salida";
    }

    @PostMapping("actualizar")
    public String actualizar(
        @RequestParam(name = "orden_id", required = false) Integer ordenId,    
        @RequestParam(name = "motivo_id", required = false) Integer motivoId, 
        @RequestParam(name = "origen_id", required = false) Integer origenId, 
        @RequestParam(name = "recibe_id", required = false) Integer recibeId, 
        @RequestParam(name = "recepciona_id", required = false) Integer recepcionaId,
        @RequestParam(name = "destino", required = false) String destino,
        @RequestParam(name = "fecha_salida_prevista", required = false) Date fechaSalidaPrevista,
        @RequestParam(name = "fecha_retorno_prevista", required = false) Date fechaRetornoPrevista,
        @RequestParam(name = "numero_orden", required = false) String numeroOrden,
        @RequestParam(name = "observacion", required = false) String observacion,
        @RequestParam(name = "accesorio", required = false) String accesorio,
        @RequestParam(name = "item_id", required = false) String itemIds
    ){
        
        String comisionadoDni = "";
        String comisionadoArea = "";
        String autorizaDni = "";
        String autorizaArea = "";
        
        int tipoOrdenId = 1;
        int usuarioId = 1;
        int estadoId = 1;
        MotivoEntity motivo = motivoService.findById(motivoId);
        OrigenEntity origen = origenService.findById(origenId);
        TipoOrdenEntity tipoOrden = tipoOrdenService.findById(tipoOrdenId);
        UsuarioEntity usuario = usuarioService.findById(usuarioId);
        EstadoOrdenEntity estadoOrden = estadoOrdenService.findById(estadoId);
        PersonalEntity recibe = personalService.findById(recibeId);
        PersonalEntity recepciona = personalService.findById(recepcionaId);

        OrdenEntity orden = new OrdenEntity(
            tipoOrden,
            motivo,
            estadoOrden,
            origen,
            usuario,
            destino,
            fechaSalidaPrevista,
            fechaRetornoPrevista,
            recepciona,
            comisionadoDni,
            comisionadoArea,
            recibe,
            autorizaDni,
            autorizaArea,
            accesorio,
            observacion,
            numeroOrden);
        orden.setId(ordenId);
        orden = ordenService.save(orden);
        
        String[] eanItem = itemIds.split(",");
        if(eanItem.length>0){
            ordenDetalleService.removeAll(ordenId);
            for(String itemId : eanItem){
                OrdenDetalleEntity ordenDetalle = new OrdenDetalleEntity();
                ordenDetalle.setItem(itemService.findById(Integer.parseInt(itemId)));
                ordenDetalle.setOrden(orden);
                ordenDetalleService.save(ordenDetalle);
            }
        }

        logger.info("Se ha registrado una orden de salida.");
        return "redirect:/salida";
    }

    @PostMapping("eliminar/{ordenId}")
    public String eliminar(@PathVariable("ordenId") Integer ordenId){
        ordenService.remove(ordenId);
        logger.warn("Se ha eliminado un orden de salida (ordenId:"+ordenId+").");
        return "salida/listar";
    }

    @PostMapping("ordendetalle/{ordenDetalleId}")
    public String eliminarOrdenDetalle(@PathVariable("ordenDetalleId") Integer ordenDetalleId){
        ordenDetalleService.remove(ordenDetalleId);
        logger.warn("Se ha eliminado un orden de salida (ordenDetalleId:"+ordenDetalleId+").");
        return "salida/listar";
    }

    
}

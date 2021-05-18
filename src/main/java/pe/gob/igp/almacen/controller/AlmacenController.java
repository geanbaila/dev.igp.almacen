package pe.gob.igp.almacen.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.igp.almacen.entity.EstadoItemEntity;
import pe.gob.igp.almacen.entity.ItemEntity;
import pe.gob.igp.almacen.entity.MarcaEntity;
import pe.gob.igp.almacen.entity.ModeloEntity;
import pe.gob.igp.almacen.entity.PersonalEntity;
import pe.gob.igp.almacen.entity.PuestoEntity;
import pe.gob.igp.almacen.service.EstadoItemService;
import pe.gob.igp.almacen.service.ItemService;
import pe.gob.igp.almacen.service.MarcaService;
import pe.gob.igp.almacen.service.ModeloService;
import pe.gob.igp.almacen.service.PersonalService;
import pe.gob.igp.almacen.service.PuestoService;



@Controller
@RequestMapping("almacen")
public class AlmacenController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModeloService modeloService;

    @Autowired
    private PuestoService puestoService;

    @Autowired
    private EstadoItemService estadoItemService;

    @Autowired
    private PersonalService personalService;

    @GetMapping({"","listar"})
    public ModelAndView index(){
        List<ItemEntity> eanItem = itemService.getItem();
        return new ModelAndView("item/listar", "eanItem", eanItem);
    }

    @GetMapping("nuevo")
    public ModelAndView nuevo(){
        List<MarcaEntity> eanMarca = marcaService.getMarca();
        List<ModeloEntity> eanModelo = modeloService.getModelo();
        List<PersonalEntity> eanPersonal = personalService.getPersonal();
        List<EstadoItemEntity> eanEstadoItem = estadoItemService.getEstadoItem();
        Map<String,List> data = new HashMap<>();
        data.put("eanMarca", eanMarca);
        data.put("eanModelo", eanModelo);
        data.put("eanPersonal", eanPersonal);
        data.put("endEstadoItem",eanEstadoItem);
        return new ModelAndView("item/nuevo", "data", data);
    }

    @GetMapping("editar/{itemId}")
    public ModelAndView editar(@PathVariable int itemId){
        List<MarcaEntity> eanMarca = marcaService.getMarca();
        List<ModeloEntity> eanModelo = modeloService.getModelo();
        List<PersonalEntity> eanPersonal = personalService.getPersonal();
        List<EstadoItemEntity> eanEstadoItem = estadoItemService.getEstadoItem();
        ItemEntity item = itemService.findById(itemId);       
        Map<String,List> data = new HashMap<>();
        data.put("eanMarca", eanMarca);
        data.put("eanModelo", eanModelo);
        data.put("eanPersonal", eanPersonal);
        data.put("endEstadoItem",eanEstadoItem);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", data);
        modelAndView.addObject("item", item);
        modelAndView.setViewName("item/editar");
		return modelAndView;
    }
    
    @PostMapping("guardar")
    public String guardar(
        @RequestParam(name = "codigoPatrimonial", required = false, defaultValue = "0000") String codigoPatrimonial,
        @RequestParam(name = "codigoInventario", required = false, defaultValue = "") String codigoInventario,
        @RequestParam(name = "codigoAmbiente", required = false, defaultValue = "") String codigoAmbiente,
        @RequestParam(name = "estadoItemId", required = false, defaultValue = "0") Integer estadoItemId,
        @RequestParam(name = "denominacion", required = false, defaultValue = "") String denominacion,
        @RequestParam(name = "marcaId", required = false, defaultValue = "0") Integer marcaId,
        @RequestParam(name = "modeloId", required = false, defaultValue = "0") Integer modeloId,
        @RequestParam(name = "serie", required = false, defaultValue = "") String serie,
        @RequestParam(name = "color", required = false, defaultValue = "") String color,
        @RequestParam(name = "asignadoId", required = false, defaultValue = "0") int asignadoId
        ){

        Integer PuestoId = 1;
        MarcaEntity marca = marcaService.findById(marcaId);
        PuestoEntity puesto = puestoService.findById(PuestoId);
        ModeloEntity modelo = modeloService.findById(modeloId);
        EstadoItemEntity estadoItem = estadoItemService.findById(estadoItemId);
        ItemEntity item = new ItemEntity(
            marca,
            puesto,
            modelo,
            estadoItem,
            denominacion,
            codigoPatrimonial,
            codigoAmbiente,
            codigoInventario,
            serie,
            color
        );
        itemService.save(item);
        return "redirect:/almacen"; 
    }

    @PostMapping("actualizar")
    public String actualizar(
        @RequestParam(name = "itemId", required = false, defaultValue = "0") Integer itemId,
        @RequestParam(name = "codigoPatrimonial", required = true, defaultValue = "0000") String codigoPatrimonial,
        @RequestParam(name = "codigoInventario", required = false, defaultValue = "") String codigoInventario,
        @RequestParam(name = "codigoAmbiente", required = false, defaultValue = "") String codigoAmbiente,
        @RequestParam(name = "estadoItemId", required = false, defaultValue = "0") Integer estadoItemId,
        @RequestParam(name = "denominacion", required = false, defaultValue = "") String denominacion,
        @RequestParam(name = "marcaId", required = false, defaultValue = "0") Integer marcaId,
        @RequestParam(name = "modeloId", required = false, defaultValue = "0") Integer modeloId,
        @RequestParam(name = "serie", required = false, defaultValue = "") String serie,
        @RequestParam(name = "color", required = false, defaultValue = "") String color,
        @RequestParam(name = "asignadoId", required = false, defaultValue = "0") int asignadoId
        ){

        MarcaEntity marca = marcaService.findById(marcaId);
        ModeloEntity modelo = modeloService.findById(modeloId);
        EstadoItemEntity estadoItem = estadoItemService.findById(estadoItemId);
        PersonalEntity personalEntity = personalService.findById(asignadoId);
        PuestoEntity puesto = personalEntity.getPuesto();
        ItemEntity item = new ItemEntity(
            marca,
            puesto,
            modelo,
            estadoItem,
            denominacion,
            codigoPatrimonial,
            codigoAmbiente,
            codigoInventario,
            serie,
            color
        );
        item.setId(itemId);
        itemService.save(item);
        return "redirect:/almacen"; 
    }
   
    @PostMapping(value = "/eliminar/{itemId}")
    public ResponseEntity<String> eliminar(@PathVariable("itemId") Integer itemId){
        itemService.remove(itemId);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}

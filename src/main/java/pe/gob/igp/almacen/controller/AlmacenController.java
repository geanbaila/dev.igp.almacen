package pe.gob.igp.almacen.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    Logger logger = LoggerFactory.getLogger(AlmacenController.class);
    
    @Value("${spring.application.paginaFilas:10}")
    Integer paginaFilas;

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
    public ModelAndView index(@RequestParam(name="pagina", defaultValue = "0") Integer pagina){
        Pageable pageable = PageRequest.of(pagina, paginaFilas, Sort.Direction.DESC, "id");
        Map<String,Object> data = itemService.getItem(pageable);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", data);
        modelAndView.setViewName("item/listar");
        //modelAndView.setViewName("item/ajax-client-side");
        logger.info("Listando los items.");
        return modelAndView;
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
        logger.info("En proceso de registro de un nuevo item.");
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
        logger.info("En proceso de edición de un item.");
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
        logger.info("Registro de un item.");
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
        logger.info("Actualización de un item (itemId:"+itemId+").");
        return "redirect:/almacen"; 
    }
   
    @PostMapping("eliminar/{itemId}")
    public ResponseEntity<String> eliminar(@PathVariable("itemId") Integer itemId){
        itemService.remove(itemId);
        logger.info("Eliminación de un item (itemId:"+itemId+").");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("buscar")
    public ResponseEntity<String> buscar(@PathParam("criterio") String criterio){
        List<ItemEntity> eanItem = itemService.buscar(criterio);
        String html = "";
        for (ItemEntity row : eanItem) {
            html+="<tr>";
            html+="<td>"+row.getId()+"</td>";
            html+="<td>"+row.getCodigoPatrimonial()+"</td>";
            html+="<td>"+row.getDenominacion()+"</td>";
            html+="<td>"+row.getMarca().getNombre()+"</td>";
            html+="<td>"+row.getModelo().getNombre()+"</td>";
            html+="<td>"+row.getSerie()+"</td>";
            html+="<td>"+row.getCodigoAmbiente()+"</td>";
            html+="<td></td>";
            html+="</tr>";
        } 
        return new ResponseEntity<>(html, HttpStatus.OK);
    }

    @GetMapping("importar")
    public ModelAndView importar(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item/importar");
        return modelAndView;
    }

}

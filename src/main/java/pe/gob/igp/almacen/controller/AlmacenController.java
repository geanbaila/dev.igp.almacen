package pe.gob.igp.almacen.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.igp.almacen.entity.EstadoItemEntity;
import pe.gob.igp.almacen.entity.ItemEntity;
import pe.gob.igp.almacen.entity.MarcaEntity;
import pe.gob.igp.almacen.entity.ModeloEntity;
import pe.gob.igp.almacen.entity.PuestoEntity;
import pe.gob.igp.almacen.service.EstadoItemService;
import pe.gob.igp.almacen.service.ItemService;
import pe.gob.igp.almacen.service.MarcaService;
import pe.gob.igp.almacen.service.ModeloService;
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

    @GetMapping({"","listar"})
    public ModelAndView index(){
        List<ItemEntity> prg_item = itemService.getItem();
        return new ModelAndView("item/listar", "prg_item", prg_item);
    }

    @GetMapping("nuevo")
    public String nuevo(){
        return "item/nuevo";
    }

    @GetMapping("editar/{item_id}")
    public ModelAndView editar(@PathVariable int item_id){
        ItemEntity item = itemService.findById(item_id);
        return new ModelAndView("item/editar","item",item);
    }
    
    @PostMapping("guardar")
    public String guardar(
        @RequestParam(name = "codigo_patrimonial", required = true, defaultValue = "0000") String codigoPatrimonial,
        @RequestParam(name = "codigo_inventario", required = false, defaultValue = "") String codigoInventario,
        @RequestParam(name = "codigo_ambiente", required = false, defaultValue = "") String codigoAmbiente,
        @RequestParam(name = "estado", required = false, defaultValue = "0") Integer estadoItemId,
        @RequestParam(name = "denominacion", required = false, defaultValue = "") String denominacion,
        @RequestParam(name = "marca", required = false, defaultValue = "0") Integer marcaId,
        @RequestParam(name = "modelo", required = false, defaultValue = "0") Integer modeloId,
        @RequestParam(name = "serie", required = false, defaultValue = "") String serie,
        @RequestParam(name = "color", required = false, defaultValue = "") String color,
        @RequestParam(name = "asignado", required = false, defaultValue = "0") int asignado
        ){

        String fechaInventario = "";
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
            fechaInventario,
            serie,
            color
        );
        
        Integer itemId = itemService.save(item);
        System.out.println("itemId: "+itemId);
        return "redirect:/almacen"; 
    }

    @PostMapping("actualizar")
    public String actualizar(
        @RequestParam(name = "item_id", required = false, defaultValue = "0") Integer itemId,
        @RequestParam(name = "codigo_patrimonial", required = true, defaultValue = "0000") String codigoPatrimonial,
        @RequestParam(name = "codigo_inventario", required = false, defaultValue = "") String codigoInventario,
        @RequestParam(name = "codigo_ambiente", required = false, defaultValue = "") String codigoAmbiente,
        @RequestParam(name = "estado", required = false, defaultValue = "0") Integer estadoItemId,
        @RequestParam(name = "denominacion", required = false, defaultValue = "") String denominacion,
        @RequestParam(name = "marca", required = false, defaultValue = "0") Integer marcaId,
        @RequestParam(name = "modelo", required = false, defaultValue = "0") Integer modeloId,
        @RequestParam(name = "serie", required = false, defaultValue = "") String serie,
        @RequestParam(name = "color", required = false, defaultValue = "") String color,
        @RequestParam(name = "asignado", required = false, defaultValue = "0") int asignado
        ){

        String fechaInventario = "";
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
            fechaInventario,
            serie,
            color
        );
        item.setId(itemId);
        
        itemId = itemService.save(item);
        System.out.println("itemId: "+itemId);
        return "redirect:/almacen"; 
    }
   
}

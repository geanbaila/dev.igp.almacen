package pe.gob.igp.almacen.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.igp.almacen.entity.ItemEntity;
import pe.gob.igp.almacen.service.ItemService;

@RestController
public class RESTfulController {
    
    @Autowired
    private ItemService itemService;

    //, method = RequestMethod.POST
    @RequestMapping(value = "/items/{codigoPatrimonial}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getItem(@PathVariable String codigoPatrimonial) {
        List<ItemEntity> eanItem = itemService.findLike(codigoPatrimonial);
        String html = "<ul id='item-list'>";
        for(ItemEntity item : eanItem){
            html+="<li onclick=\"agregarItem('"+item.getId()+"');\">"+item.getCodigoPatrimonial()+"</li>";
        }
        html+= "</ul>";
        List<String> data = new ArrayList();
        data.add(html);
        return data;
    }


        //, method = RequestMethod.POST
    @RequestMapping(value = "/item/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> getItem(@PathVariable Integer itemId) {
            ItemEntity item = itemService.findById(itemId);
            String html = "";
            html+= "<tr>";
            html+= "<td>"+item.getId()+"</td>";
            html+= "<td>"+item.getCodigoPatrimonial()+"</td>";
            html+= "<td>"+item.getCodigoInventario()+"</td>";
            html+= "<td>"+item.getDenominacion()+"</td>";
            html+= "<td>"+item.getMarca().getNombre()+"</td>";
            html+= "<td>"+item.getModelo().getNombre()+"</td>";
            html+= "<td>"+item.getSerie()+"</td>";
            html+= "<td>"+item.getColor()+"</td>";
            html+= "<td>"+item.getEstadoItem().getNombre()+"</td>";
            html+= "<td><input type='checkbox' checked /></td>";
            html+= "<td><a onclick='eliminar("+item.getId()+",this)'><svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round' class='feather feather-trash'><polyline points='3 6 5 6 21 6'></polyline><path d='M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2'></path></svg></a></td>";
            html+= "</tr>";
            Map<String,String> data = new HashMap();
            data.put("codigoPatrimonial", item.getCodigoPatrimonial());
            data.put("html", html);
            return data;
    }
 

    
    
}

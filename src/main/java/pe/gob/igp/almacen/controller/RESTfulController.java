package pe.gob.igp.almacen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.igp.almacen.entity.ItemEntity;
import pe.gob.igp.almacen.service.ItemService;

@RestController
public class RESTfulController {
    
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/items/{codigoPatrimonial}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemEntity> getItem(@PathVariable String codigoPatrimonial) {
        return itemService.findLike(codigoPatrimonial);
    }
    
}

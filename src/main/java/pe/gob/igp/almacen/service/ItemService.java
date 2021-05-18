package pe.gob.igp.almacen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.igp.almacen.entity.AuditoriaEntity;
import pe.gob.igp.almacen.entity.ItemEntity;
import pe.gob.igp.almacen.repository.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AuditoriaService auditoriaService;

    public List<ItemEntity> getItem(){
        return itemRepository.findAll();        
    }

    public Map<String,Object> getItem(Pageable page){
        Page<ItemEntity> i = itemRepository.findAll(page);
        int totalPagina = i.getTotalPages();
        List<ItemEntity> eanItem = i.getContent();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("totalPagina", totalPagina);
        map.put("eanItem", eanItem);
        return map;
    }

    public ItemEntity findById(int item_id){
        return itemRepository.getOne(item_id);
    }

    public List<ItemEntity> findLike(String codigoPatrimonial){
        return itemRepository.findLike(codigoPatrimonial);

    }

    public Integer save(ItemEntity item){
        String operacion = (item.getId()==null)?"insert":"update";
        Integer itemId = itemRepository.saveAndFlush(item).getId();
        callAuditor(itemId,operacion);
        return itemId;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void remove(Integer itemId){
        itemRepository.deleteById(itemId);
        callAuditor(itemId,"delete");
    }

    public void callAuditor(Integer itemId, String operacion){
        AuditoriaEntity auditoria = new AuditoriaEntity(
            new Date(System.currentTimeMillis()), 
            SecurityContextHolder.getContext().getAuthentication().getName(), 
            operacion+":ItemEntity:"+itemId+":"+getClass().getName());
        auditoriaService.save(auditoria);
    }

}

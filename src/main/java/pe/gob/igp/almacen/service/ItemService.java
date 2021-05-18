package pe.gob.igp.almacen.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

package pe.gob.igp.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.ItemEntity;
import pe.gob.igp.almacen.repository.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

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
        return itemRepository.saveAndFlush(item).getId();
    }

    public void remove(Integer itemId){
        itemRepository.deleteById(itemId);
    }

}

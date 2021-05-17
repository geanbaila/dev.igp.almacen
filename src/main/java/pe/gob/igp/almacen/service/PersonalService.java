package pe.gob.igp.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.PersonalEntity;
import pe.gob.igp.almacen.repository.PersonalRepository;

@Service
public class PersonalService {
    
    @Autowired
    private PersonalRepository personalRepository;

    public List<PersonalEntity> getPersonal(){
        return personalRepository.findAll();
    }

    public PersonalEntity findById(Integer personalId){
        return personalRepository.getOne(personalId);
    }
}

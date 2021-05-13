package pe.gob.igp.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.igp.almacen.entity.ModeloEntity;
import pe.gob.igp.almacen.repository.ModeloRepository;

@Service
public class ModeloService {
    
    @Autowired
    private ModeloRepository modeloRepository;

    public List<ModeloEntity> getModelo(){
        return modeloRepository.findAll();
    }

    public ModeloEntity findById(Integer modeloId){
        return modeloRepository.getOne(modeloId);
    }
}

package com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.repository.IAutorRepo;
import com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.repository.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements IAutorService {
    @Autowired
    private IAutorRepo iAutorRepo;
    public List<Autor> buscarNombre(String nombre){
        return this.iAutorRepo.findByNombre(nombre);
    }
    public void guardarAutor(Autor autor){
        this.iAutorRepo.saveAndFlush(autor);
    }
}

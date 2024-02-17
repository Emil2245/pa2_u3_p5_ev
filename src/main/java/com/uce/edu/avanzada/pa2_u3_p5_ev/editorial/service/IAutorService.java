package com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.repository.model.Autor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAutorService {
    List<Autor> buscarNombre(String nombre);
    void guardarAutor(Autor autor);
}

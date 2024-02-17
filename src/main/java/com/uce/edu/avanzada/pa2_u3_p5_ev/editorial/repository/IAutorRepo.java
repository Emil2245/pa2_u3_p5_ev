package com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.repository.model.Autor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface IAutorRepo extends JpaRepository<Autor,Integer> {
    List<Autor> findByNombre(String nombre);

}

package com.example.demo.repositories;

import com.example.demo.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //Método de Query
    public List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //JPQL parametros indexados
    //@Query(value = "SELECT p FROM Persona WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    //public List<Persona> searchJPQL(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    public List<Persona> searchNative(@Param("filtro") String filtro);
}

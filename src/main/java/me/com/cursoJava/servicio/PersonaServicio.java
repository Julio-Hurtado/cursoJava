package me.com.cursoJava.servicio;

import lombok.Getter;
import lombok.Setter;
import me.com.cursoJava.modelo.Persona;
import me.com.cursoJava.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class PersonaServicio {
    private PersonaRepositorio personaRepositorio;

    @Autowired
    public PersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    public Persona guardar(Persona persona) {
        return this.personaRepositorio.save(persona);
    }

    public Persona buscar(int id) {
        return personaRepositorio.findById(id).get();

    }

    public void eliminar(int id) {
         personaRepositorio.deleteById(id);
    }

    public List<Persona> obtenerTodo() {
        return personaRepositorio.findAll();
    }
}

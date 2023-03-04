package me.com.cursoJava.repositorio;

import me.com.cursoJava.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositorio extends JpaRepository<Persona,Integer> {
}

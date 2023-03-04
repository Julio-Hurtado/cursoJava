package me.com.cursoJava.estrategia;

import me.com.cursoJava.controlador.PersonaControlador;
import me.com.cursoJava.modelo.Persona;

import java.util.List;

public class PersonaAccion extends Accion<Persona> {
    private PersonaControlador personaControlador;

    @Override
    public Persona guardar() {
        return personaControlador.guardar();
    }

    @Override
    public Persona buscar() {
        return personaControlador.buscar();
    }

    @Override
    public void eliminar() {
        personaControlador.eliminar();
    }

    @Override
    public List<Persona> obtenerTodo() {
        return personaControlador.obtenerTodo();
    }

    @Override
    public void configurar() {
        personaControlador = (PersonaControlador) super.getContext().getBean("personaControlador");
    }
}

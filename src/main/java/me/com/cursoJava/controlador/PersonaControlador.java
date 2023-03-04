package me.com.cursoJava.controlador;

import me.com.cursoJava.modelo.Identificacion;
import me.com.cursoJava.modelo.Persona;
import me.com.cursoJava.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class PersonaControlador {

    private PersonaServicio personaServicio;

    @Autowired
    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    public Persona guardar() {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona();
        Identificacion identificacion = new Identificacion();

        System.out.println("Formulario registro de persona");
        System.out.println("Primer nombre");
        String value = scanner.nextLine();
        persona.setPrimerNombre(value);

        System.out.println("Segundo nombre");
        value = scanner.nextLine();
        persona.setSegundoNombre(value);

        System.out.println("Primer apellido");
        value = scanner.nextLine();
        persona.setPrimerApellido(value);

        System.out.println("Segundo apellido");
        value = scanner.nextLine();
        persona.setSegundoApellido(value);

        System.out.println("Identificacion");
        value = scanner.nextLine();
        identificacion.setIdentificacion(value);
        identificacion.setPersona(persona);

        List<Identificacion> identificacionList = new ArrayList<>();
        identificacionList.add(identificacion);

        persona.setIdentificacionList(identificacionList);

        return personaServicio.guardar(persona);
    }

    public Persona buscar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id Persona");
        int value = scanner.nextInt();
        try {
            return personaServicio.buscar(value);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id Persona");
        int value = scanner.nextInt();
        personaServicio.eliminar(value);
        System.out.println("Persona con id " + value + " Eliminado");
    }

    public List<Persona> obtenerTodo() {
        return personaServicio.obtenerTodo();
    }

}

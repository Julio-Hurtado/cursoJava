package me.com.cursoJava;

import me.com.cursoJava.estrategia.Context;
import me.com.cursoJava.estrategia.PersonaAccion;
import me.com.cursoJava.estrategia.ProductoAccion;
import me.com.cursoJava.modelo.Persona;
import me.com.cursoJava.modelo.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CursoJavaApplication {
    private static ApplicationContext Globalcontext;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CursoJavaApplication.class, args);
        CursoJavaApplication.Globalcontext = context;
        iniciarSuperAplicacion(CursoJavaApplication.Globalcontext);
    }

    public static void iniciarSuperAplicacion(ApplicationContext context) {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        mostrarMenuPrincipal();
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Context<Persona> contexto = new Context<>(new PersonaAccion(), context);
                realizarCrud(contexto, "Personas");
                break;
            case 2:
                Context<Producto> contextoProducto = new Context<>(new ProductoAccion(), context);
                realizarCrud(contextoProducto, "Productos");

                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Opcion ingresada no valida");
                break;
        }

    }

    public static void realizarCrud(Context contexto, String entidad) {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarMenuCrud(entidad);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(contexto.guardar());
                    break;
                case 2:
                    System.out.println(contexto.buscar());
                    break;
                case 3:
                    contexto.eliminar();
                    break;

                case 4:
                    System.out.println("Listado :" );
                    System.out.println(contexto.obtenerTodo());
                    break;

                case 5:
                    continuar = false;
                    iniciarSuperAplicacion(CursoJavaApplication.Globalcontext);
                default:
                    System.out.println("Opcion ingresada no valida");
                    break;

            }

        }

    }
    public static void mostrarMenuPrincipal() {
        System.out.println("*********************");
        System.out.println("Bienvenido al Menu principal");
        System.out.println("seleccione una opcion: ");
        System.out.println("*********************");
        System.out.println("1) Guardar Persona");
        System.out.println("2) Guardar Producto");
        System.out.println("3) Salir");
        System.out.println("*********************");
    }

    public static void mostrarMenuCrud(String entidad) {
        System.out.println("*********************");
        System.out.println("Menu de Registro de: " + entidad);
        System.out.println("*********************");
        System.out.println("1) guardar");
        System.out.println("2) buscar");
        System.out.println("3) eliminar");
        System.out.println("4) ver todo");
        System.out.println("5) Menu principal");
        System.out.println("*********************");
    }



}

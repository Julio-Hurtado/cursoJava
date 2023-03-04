package me.com.cursoJava.controlador;

import com.fasterxml.jackson.databind.util.Converter;
import me.com.cursoJava.modelo.Categoria;
import me.com.cursoJava.modelo.Producto;
import me.com.cursoJava.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class ProductoController {

    private ProductoServicio productoServicio;

    @Autowired
    public ProductoController(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public Producto guardar() {
        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();
        Categoria categoria = new Categoria();

        System.out.println("Nombre del producto: ");
        String value = scanner.nextLine();
        producto.setNombre(value);

        System.out.println("Precio: ");
        value = scanner.nextLine();
        float precio;
        try {
            precio = Float.valueOf(value);
        } catch (Exception e) {
            precio = 0;
        }
        producto.setPrecio(precio);

        System.out.println("Descripcion: ");
        value = scanner.nextLine();
        producto.setDescripcion(value);

        System.out.println("Nombre categoria: ");
        value = scanner.nextLine();
        categoria.setNombre(value);
        categoria.setProducto(producto);

        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(categoria);

        producto.setCategoriaList(categoriaList);

        return productoServicio.guardar(producto);

    }

    public Producto buscar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id Producto");
        int value = scanner.nextInt();
        try {
            return productoServicio.buscar(value);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id Producto");
        int value = scanner.nextInt();
        productoServicio.eliminar(value);
        System.out.println("Producto con id " + value + " Eliminado");
    }

    public List<Producto> obtenerTodo() {
        return productoServicio.obtenerTodo();
    }
}

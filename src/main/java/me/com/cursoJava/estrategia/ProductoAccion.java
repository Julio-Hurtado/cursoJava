package me.com.cursoJava.estrategia;

import me.com.cursoJava.controlador.ProductoController;
import me.com.cursoJava.modelo.Producto;

import java.util.List;

public class ProductoAccion extends Accion<Producto> {
    private ProductoController productoController;

    @Override
    public Producto guardar() {
        return productoController.guardar();
    }

    @Override
    public Producto buscar() {
        return productoController.buscar();
    }

    @Override
    public void eliminar() {
        productoController.eliminar();
    }

    @Override
    public List<Producto> obtenerTodo() {
        return productoController.obtenerTodo();
    }

    @Override
    public void configurar() {
        productoController = (ProductoController) super.getContext().getBean("productoController");
    }
}

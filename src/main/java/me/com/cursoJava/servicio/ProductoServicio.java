package me.com.cursoJava.servicio;

import lombok.Getter;
import lombok.Setter;
import me.com.cursoJava.modelo.Producto;
import me.com.cursoJava.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class ProductoServicio {

    private ProductoRepositorio productoRepositorio;

    @Autowired
    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    public Producto guardar(Producto producto) {
        return this.productoRepositorio.save(producto);
    }

    public Producto buscar(int id) {
        return productoRepositorio.findById(id).get();
    }

    public void eliminar(int id) {
        productoRepositorio.deleteById(id);
    }

    public List<Producto> obtenerTodo() {
        return productoRepositorio.findAll();
    }

}

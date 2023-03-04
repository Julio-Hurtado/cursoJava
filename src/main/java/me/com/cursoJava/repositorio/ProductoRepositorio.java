package me.com.cursoJava.repositorio;

import me.com.cursoJava.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {
}

package me.com.cursoJava.estrategia;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

import java.util.List;

@Getter
@Setter
public abstract class Accion<T> {
    private ApplicationContext context;

    public abstract T guardar();

    public abstract T buscar();
    public abstract void eliminar();

    public abstract List<T> obtenerTodo();

    public abstract void configurar();
}

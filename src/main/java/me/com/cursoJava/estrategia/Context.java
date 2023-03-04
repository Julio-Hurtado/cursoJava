package me.com.cursoJava.estrategia;

import org.springframework.context.ApplicationContext;

public class Context <T>{

    private Accion accion;

    public Context(Accion accion, ApplicationContext applicationContext) {
        this.accion = accion;
        this.accion.setContext(applicationContext);
        configurar();
    }

    public T guardar(){
        return (T) accion.guardar();
    }

    public T buscar(){
        return (T) accion.buscar();
    }

    public void eliminar(){
         accion.eliminar();
    }

    public T obtenerTodo(){
        return (T) accion.obtenerTodo();
    }

    public void configurar(){
        accion.configurar();
    }

}

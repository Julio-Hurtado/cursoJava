package me.com.cursoJava.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSONA")
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
    private List<Identificacion> identificacionList;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("id=").append(id);
        sb.append(", primerNombre='").append(primerNombre).append('\'');
        sb.append(", segundoNombre='").append(segundoNombre).append('\'');
        sb.append(", primerApellido='").append(primerApellido).append('\'');
        sb.append(", segundoApellido='").append(segundoApellido).append('\'');
        sb.append('}');
        return sb.toString();

    }
}

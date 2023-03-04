package me.com.cursoJava.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "IDENTIFICACION")
@Getter
@Setter
public class Identificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "identificacion")
    private String identificacion;

    @ManyToOne
    @JoinColumn(name = "ID_PERSONA")
    private Persona persona;
}


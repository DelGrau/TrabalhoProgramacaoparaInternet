package br.unipar.programacaointernet.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 24)
    private String nome;

    @Column(length = 20)
    private Integer cargo;
}

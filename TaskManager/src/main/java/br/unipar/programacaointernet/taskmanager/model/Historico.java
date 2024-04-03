package br.unipar.programacaointernet.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String descricao;

    @Column
    private Date data_alteracao;

    @Column(length = 120)
    private String observacao;

    @Column(length = 2)
    private String prioridade;

    @Column(length = 5)
    private String status;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Task task;
}

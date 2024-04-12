package br.unipar.programacaointernet.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String descricao;

    @Column(length = 120)
    private String observacao;

    @Column
    private Date data_previsao;

    @Column(length = 2)
    private Integer prioridade;

    @Column
    private boolean status;

    @Column
    private Date data_inicio;

    @Column
    private Date data_termino;

    @ManyToOne
    private Usuario usuario;
}

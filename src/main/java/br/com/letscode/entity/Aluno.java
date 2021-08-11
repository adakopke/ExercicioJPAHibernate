package br.com.letscode.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@ToString
public class Aluno {
    @Id
    @Getter @Setter private int ra;
    @Getter @Setter private String nome;
    @Getter @Setter private String sobrenome;
    @Column(name = "data_nascimento")
    @Getter @Setter private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")
    @Getter @Setter private Curso codigoCurso;

}


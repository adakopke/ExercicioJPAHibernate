package br.com.letscode.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @Column(name = "codigo_disciplina")
    @Getter @Setter private int codigoDisciplina;

    @Column(name = "nome_disciplina")
    @Getter @Setter private String nomeDisciplina;

    @Column(name = "carga_horaria_pratica")
    @Getter @Setter int cargaPratica;

    @Column(name = "carga_horaria_teorica")
    @Getter @Setter int cargaTeorica;
}

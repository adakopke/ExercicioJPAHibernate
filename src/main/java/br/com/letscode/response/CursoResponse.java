package br.com.letscode.response;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Curso;
import lombok.Getter;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CursoResponse {

    private int codigoCurso;
    private String nomeCurso;
    private int duracao;
    private int numeroAlunos;

    public CursoResponse(Curso curso) {
        this.codigoCurso = curso.getCodigoCurso();
        this.nomeCurso = curso.getNomeCurso();
        this.duracao = curso.getDuracao();
        this.numeroAlunos = curso.getNumeroAlunos();
    }

    public static List<CursoResponse> convert(List<Curso> cursos) {
        return cursos.stream().map(CursoResponse::new).collect(Collectors.toList());
    }

}

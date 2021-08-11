package br.com.letscode.controller;

import br.com.letscode.Repository.CursoRepository;
import br.com.letscode.request.AlunoRequest;
import br.com.letscode.request.AlunoRequestAtualizar;
import br.com.letscode.response.AlunoResponse;
import br.com.letscode.Repository.AlunoRepository;
import br.com.letscode.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/alunos")
@RestController
public class AlunoController {

    private AlunoRepository alunoRepository;

    private CursoRepository cursoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
       public ResponseEntity<AlunoResponse> adicionarAlunos(@RequestBody AlunoRequest alunoRequest,
                                                            UriComponentsBuilder uriComponentsBuilder) {
        Aluno aluno = alunoRequest.convert(cursoRepository);
        alunoRepository.save(aluno);
        URI uri = uriComponentsBuilder.path("/alunos/{id}").buildAndExpand(aluno.getRa()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponse(aluno));
    }

    @GetMapping
     public List<AlunoResponse> buscarAlunos() {
        List alunos = alunoRepository.findAll();
        return AlunoResponse.convert(alunos);
    }

    @GetMapping("{ra}")
    public AlunoResponse buscarAlunoPorRA (@PathVariable Integer ra) {
        Aluno aluno = alunoRepository.getById(ra);
        return new AlunoResponse(aluno);

    }

    @PutMapping("/atualizar/{ra}")
    public ResponseEntity<AlunoResponse> atualizarAluno (@PathVariable Integer ra, @RequestBody AlunoRequestAtualizar alunoRequestAtualizar) {
        Aluno aluno = alunoRequestAtualizar.convert(cursoRepository, ra);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(new AlunoResponse(aluno));
    }

    @DeleteMapping("/remover/{ra}")
    public ResponseEntity<String> removerAlunoPorId(@PathVariable Integer ra ) {
        try {
            alunoRepository.deleteById(ra);
            return new ResponseEntity<>("Removido com sucesso", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("ID: " + ra + " Não encontrado\n" + e, HttpStatus.NOT_FOUND);

        }
    }




}

package br.com.letscode.controller;

import br.com.letscode.Repository.ProfessorRepository;
import br.com.letscode.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/professores")
@RestController
public class ProfessorController {


    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @PostMapping
    public ResponseEntity<String> adicionarProfessor(@RequestBody Professor professor) {
        professorRepository.save(professor);
        return new ResponseEntity<>(professor.toString(), HttpStatus.OK);
    }

    @GetMapping
    public Iterable<Professor> buscarProfessores() {
        Iterable<Professor> professores = professorRepository.findAll();
        return professores;
    }

    @GetMapping("{id}")
    public ResponseEntity<String> buscarProfPorCodigo(@PathVariable(value = "id") Integer registro) {
        Optional<Professor> professor = professorRepository.findById(registro);
        if (professor.isPresent()) {
            return new ResponseEntity<>(professor.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ID: " + registro + " Não encontrado", HttpStatus.NOT_FOUND);

        }
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizaProfessor(@PathVariable(value = "id") Integer registro, @RequestBody Professor professor) {
        if (registro != professor.getRegistroProfessor()) {
            return new ResponseEntity<>("ID: " + registro + " não é o mesmo do professor a ser atualizado", HttpStatus.BAD_REQUEST);
        } else if (professorRepository.findById(registro).isPresent()) {
            professorRepository.save(professor);
            return new ResponseEntity<>(professor.toString(), HttpStatus.OK);
        } else

            return new ResponseEntity<>("ID: " + registro + " Não encontrado", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("remover/{id}")
    public ResponseEntity<String> deletaProfessorPorId(@PathVariable(value = "id") Integer registro) {
        try {
            professorRepository.deleteById(registro);
            return new ResponseEntity<>("Removido com sucesso", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>("ID: " + registro + " Não encontrado", HttpStatus.NOT_FOUND);
        }

    }

}

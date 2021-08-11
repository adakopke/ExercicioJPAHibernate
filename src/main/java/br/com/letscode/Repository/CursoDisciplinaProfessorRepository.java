package br.com.letscode.Repository;

import br.com.letscode.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDisciplinaProfessorRepository extends JpaRepository<Aluno, Integer> {

}

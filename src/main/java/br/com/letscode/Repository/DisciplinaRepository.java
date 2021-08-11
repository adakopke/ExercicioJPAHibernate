package br.com.letscode.Repository;

import br.com.letscode.entity.Aluno;
import br.com.letscode.entity.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>  {

}

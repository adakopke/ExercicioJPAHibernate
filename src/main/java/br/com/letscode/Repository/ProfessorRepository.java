package br.com.letscode.Repository;

import br.com.letscode.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository  extends CrudRepository<Professor, Integer>  {

}

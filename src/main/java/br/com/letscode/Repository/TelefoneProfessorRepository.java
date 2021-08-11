package br.com.letscode.Repository;

import br.com.letscode.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneProfessorRepository extends CrudRepository<Curso, Integer>  {

}

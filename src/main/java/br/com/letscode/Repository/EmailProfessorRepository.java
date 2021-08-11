package br.com.letscode.Repository;

import br.com.letscode.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmailProfessorRepository extends JpaRepository<Curso, Integer>  {

}

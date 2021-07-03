package br.ufrn.PDSgrupo5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufrn.PDSgrupo5.model.ProfissionalSaude;
import br.ufrn.PDSgrupo5.model.Usuario;

public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaude, Long> {
	ProfissionalSaude findByNumeroRegistro(Long numeroRegistro);
	
	@Query(value="SELECT p FROM ProfissionalSaude p WHERE p.pessoa.usuario=?1")
    ProfissionalSaude findByUsuario(Usuario usuario);
}

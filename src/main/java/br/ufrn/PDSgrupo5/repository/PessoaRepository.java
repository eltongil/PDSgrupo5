package br.ufrn.PDSgrupo5.repository;

import br.ufrn.PDSgrupo5.model.Pessoa;
import br.ufrn.PDSgrupo5.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);

    Pessoa findByEmail(String email);

    Pessoa findByUsuario(Usuario usuario);
}

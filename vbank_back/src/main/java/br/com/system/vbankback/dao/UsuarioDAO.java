package br.com.system.vbankback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.system.vbankback.model.TipoUsuario;
import br.com.system.vbankback.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>, QueryDslPredicateExecutor<Usuario> {

	Usuario findByLogin(String login);

	Usuario findByNome(String name);

	List<Usuario> findByTipo(TipoUsuario tipoUsuario);

	Usuario findByLoginAndSenha(String login, String senha);

}

package br.com.system.vbankback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.system.vbankback.model.TipoUsuario;
import br.com.system.vbankback.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>, QueryDslPredicateExecutor<Usuario> {

	public Usuario findByLogin(String login);
	public Usuario findByNome(String name);
	public List<Usuario> findByTipo(TipoUsuario tipoUsuario);
	public Usuario findByLoginAndSenha(String login, String senha);

}

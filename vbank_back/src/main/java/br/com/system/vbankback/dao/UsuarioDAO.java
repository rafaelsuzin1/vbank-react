package br.com.system.vbankback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.system.vbankback.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	public Usuario findByLogin(String login);
	public Usuario findByNome(String name);

}

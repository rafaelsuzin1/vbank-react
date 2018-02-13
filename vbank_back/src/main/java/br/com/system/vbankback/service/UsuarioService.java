package br.com.system.vbankback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.system.vbankback.dao.UsuarioDAO;
import br.com.system.vbankback.model.QUsuario;
import br.com.system.vbankback.model.TipoUsuario;
import br.com.system.vbankback.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO dao;

	public void save(Usuario usuario) {
		dao.save(usuario);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public Usuario getById(Long id) {
		return dao.findOne(id);
	}

	public List<Usuario> getAll() {
		return dao.findAll();
	}

	public Usuario getByNome(String name) {
		return dao.findByNome(name);
	}

	public Usuario getByLogin(String login) {
		return dao.findByLogin(login);
	}

	public boolean exists(Usuario usuario) {
		return getByLogin(usuario.getLogin()) != null;
	}

	public Usuario getByLoginAndSenha(String login, String senha) {
		return dao.findByLoginAndSenha(login, senha);
	}

	public List<Usuario> getByTipo(TipoUsuario tipoUsuario){
		return dao.findByTipo(tipoUsuario);
	}
	
	public Usuario getByLoginAndTipo(String login, TipoUsuario tipoUsuario) {
		QUsuario user = QUsuario.usuario;
		return dao.findOne(user.login.eq(login).and(user.tipo.eq(tipoUsuario)));
	}
	
	public List<Usuario> getByNomeContain(String nome) {
		QUsuario user = QUsuario.usuario;
		return (List<Usuario>) dao.findAll(user.nome.contains(nome));
	}
}

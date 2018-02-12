package br.com.system.vbankback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.vbankback.dao.UsuarioDAO;
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

	public Usuario findByNome(String name) {
		return dao.findByNome(name);
	}

	public Usuario findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public boolean exists(Usuario usuario) {
		return findByNome(usuario.getNome()) != null;
	}
}

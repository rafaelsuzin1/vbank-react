package br.com.system.vbankback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.vbankback.dao.BancoDAO;
import br.com.system.vbankback.model.Banco;

@Service
public class BancoService {

	@Autowired
	private BancoDAO dao;

	public void save(Banco usuario) {
		dao.save(usuario);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public Banco getById(Long id) {
		return dao.findOne(id);
	}

	public List<Banco> getAll() {
		return dao.findAll();
	}

	public Banco getByDescricao(String descricao) {
		return dao.findByDescricao(descricao);
	}

	public boolean exists(Banco banco) {
		return getByDescricao(banco.getDescricao()) != null;
	}

	public List<Banco> getByDescricaoContain(String descricao) {
		return dao.findByDescricaoContaining(descricao);
	}
}

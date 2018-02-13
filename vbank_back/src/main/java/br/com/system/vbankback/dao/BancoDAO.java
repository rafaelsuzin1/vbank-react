package br.com.system.vbankback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.system.vbankback.model.Banco;

@Repository
public interface BancoDAO extends JpaRepository<Banco, Long>, QueryDslPredicateExecutor<Banco> {

	List<Banco> findByDescricaoContaining(String descricao);

	Banco findByDescricao(String descricao);

}

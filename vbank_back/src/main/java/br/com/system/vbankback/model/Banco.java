package br.com.system.vbankback.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Banco")
@Entity
@Table(name = "banco")
public class Banco implements Serializable {

	private static final long serialVersionUID = -1282905443142951278L;
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value = "Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Descrição do banco")
	@Column(name = "descricao", nullable = false, length = 60)
	@Size(max = 60, message = "Campo 'descricao' pode ter aaté 60 caracteres.")
	@NotEmpty(message = "Campo 'descricao' obrigatório.")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	public Banco setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Long getId() {
		return id;
	}

	public Banco setId(Long id) {
		this.id = id;
		return this;
	}

	
	

}

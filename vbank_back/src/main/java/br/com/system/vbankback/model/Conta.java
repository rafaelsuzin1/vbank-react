package br.com.system.vbankback.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class Conta {

	@Id
	@Column(name = "id")
	@ApiModelProperty(value = "Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Descrição do banco")
	@Column(name = "nr_conta", length = 20, nullable = false)
	@Size(max = 20, message = "Campo 'descricao' pode ter até 20 caracteres.")
	@NotEmpty(message = "Campo 'nrConta' obrigatório.")
	private String nrConta;

	@ApiModelProperty(value = "Conta corrente")
	@Column(name = "is_contacorrente", length = 1, nullable = false, columnDefinition = "TINYINT(1)")
	@NotNull(message = "Campo 'isContaCorrente' obrigatorio.")
	private Boolean isContaCorrente;

	@ApiModelProperty(value = "Conta poupança")
	@Column(name = "is_contapoupanca", length = 1, nullable = false,  columnDefinition = "TINYINT(1)")
	@NotNull(message = "Campo 'isContaPoupanca' obrigatorio.")
	private Boolean isContaPoupanca;

	@ApiModelProperty(value = "Valor de saldo em conta poupança")
	@DecimalMax("9999999.0")
	@Column(name = "vl_saldo_conta_poupanca", precision = 14, scale = 2, nullable = true)
	private BigDecimal vlSaldoContaPoupanca;
	
	@ApiModelProperty(value = "Valor de saldo em conta corrente")
	@DecimalMax("9999999.0")
	@Column(name = "vl_saldo_conta_corrente", precision = 14, scale = 2, nullable = true)
	private BigDecimal vlSaldoContaCorrente;

	public Conta(Long id, String nrConta, Boolean isContaCorrente, Boolean isContaPoupanca,
			BigDecimal vlSaldoContaPoupanca, BigDecimal vlSaldoContaCorrente) {
		super();
		this.id = id;
		this.nrConta = nrConta;
		this.isContaCorrente = isContaCorrente;
		this.isContaPoupanca = isContaPoupanca;
		this.vlSaldoContaPoupanca = vlSaldoContaPoupanca;
		this.vlSaldoContaCorrente = vlSaldoContaCorrente;
	}

	public Long getId() {
		return id;
	}

	public Conta setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNrConta() {
		return nrConta;
	}

	public Conta setNrConta(String nrConta) {
		this.nrConta = nrConta;
		return this;
	}

	public Boolean getIsContaCorrente() {
		return isContaCorrente;
	}

	public Conta setIsContaCorrente(Boolean isContaCorrente) {
		this.isContaCorrente = isContaCorrente;
		return this;
	}

	public Boolean getIsContaPoupanca() {
		return isContaPoupanca;
	}

	public Conta setIsContaPoupanca(Boolean isContaPoupanca) {
		this.isContaPoupanca = isContaPoupanca;
		return this;
	}

	public BigDecimal getVlSaldoContaPoupanca() {
		return vlSaldoContaPoupanca;
	}

	public Conta setVlSaldoContaPoupanca(BigDecimal vlSaldoContaPoupanca) {
		this.vlSaldoContaPoupanca = vlSaldoContaPoupanca;
		return this;
	}

	public BigDecimal getVlSaldoContaCorrente() {
		return vlSaldoContaCorrente;
	}

	public Conta setVlSaldoContaCorrente(BigDecimal vlSaldoContaCorrente) {
		this.vlSaldoContaCorrente = vlSaldoContaCorrente;
		return this;
	}
	
	
	
}

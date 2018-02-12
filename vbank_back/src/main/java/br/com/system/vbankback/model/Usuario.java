package br.com.system.vbankback.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/***
 * 
 * @author Julio
 *
 */

@ApiModel(value = "Usuario")
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2477877980562473895L;

	// GenerationType.AUTO, gera uma tabela extra de sequência e atrapalha.
	@Id
	@ApiModelProperty(value = "Id do usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 11)
	private Long id;

	@ApiModelProperty(value = "Nome do usuario")
	@Column(name = "nome", nullable = false, length = 60)
	@Size(max = 60, message = "Campo 'nome' pode ter at� 60 caracteres.")
	@NotEmpty(message = "Campo 'nome' obrigatorio.")
	private String nome;

	@ApiModelProperty(value = "Email do Usuario")
	@Column(name = "email", nullable = true, length = 50)
	@Size(max = 50, message = "Campo 'email' pode ter ate 50 caracteres.")
	@Email(message = "Campo 'email' deve ser um email valido.")
	private String email;

	@ApiModelProperty(value = "Login do Usuario - Unique Key")
	@Column(name = "login", nullable = false, length = 20, unique = true)
	@Size(max = 20, message = "Campo 'login' pode ter ate 20 caracteres.")
	@NotEmpty(message = "Campo 'login' obrigatorio.")
	private String login;

	@ApiModelProperty(value = "Senha do Usuario")
	@Column(name = "senha", nullable = false, length = 100)
	@Size(max = 100, message = "Campo 'senha' pode ter ate 100 caracteres.")
	@NotEmpty(message = "Campo 'senha' obrigatorio.")
	private String senha;

	@ApiModelProperty(value = "Tipo de Usuario: USUARIO, SUPERVISOR, ADMINISTRADOR")
	@Column(name = "tipo", nullable = false, length = 11)
	@NotNull(message = "Campo 'tipo' obrigatorio.")
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;

	@ApiModelProperty(value = "Situacao do Usuario: ATIVO, INATIVO")
	@Column(name = "ativo", nullable = false, length = 11)
	@NotNull(message = "Campo 'ativo' obrigatorio.")
	@Enumerated(EnumType.STRING)
	private SituacaoUsuario situacaoUsuario;

	@ApiModelProperty(value = "Usuario Excluido")
	@Column(name = "excluido", nullable = false, length = 11, columnDefinition = "TINYINT(1)")
	@NotNull(message = "Campo 'excluido' obrigatorio.")
	private Boolean excluido;

	public Usuario() {

	}

	public Usuario(Long id, String nome, String email, String login, String senha, TipoUsuario tipo,
			SituacaoUsuario situacaoUsuario, Boolean excluido) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
		this.situacaoUsuario = situacaoUsuario;
		this.excluido = excluido;
	}

	public Long getId() {
		return id;
	}

	public Usuario setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Usuario setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Usuario setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public Usuario setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario setSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public Usuario setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
		return this;
	}

	public SituacaoUsuario getSituacaoUsuario() {
		return situacaoUsuario;
	}

	public Usuario setSituacaoUsuario(SituacaoUsuario situacaoUsuario) {
		this.situacaoUsuario = situacaoUsuario;
		return this;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public Usuario setExcluido(Boolean excluido) {
		this.excluido = excluido;
		return this;
	}

}

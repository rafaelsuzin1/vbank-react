package br.com.system.vbankback.controller;

import static br.com.system.vbankback.util.ResponseUtils.invalid;
import static br.com.system.vbankback.util.ResponseUtils.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.system.vbankback.model.TipoUsuario;
import br.com.system.vbankback.model.Usuario;
import br.com.system.vbankback.service.UsuarioService;
import br.com.system.vbankback.util.CustomResponse;
import br.com.system.vbankback.util.ICustomResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Classe que representa o controller de usuários.
 * 
 * @author Rafael Suzin
 *
 */

@Api(value = "Usuário")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@ApiOperation(value = "Consulta um Usuário pelo id", hidden = false)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Usuario usuarioGet(@PathVariable Long id) {
		return service.getById(id);
	}

	@ApiOperation(value = "Inserir um Usuário", hidden = false)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<? extends ICustomResponse> usuarioPost(@Validated @RequestBody Usuario usuario,
			BindingResult result) {

		if (result.hasErrors()) {
			return invalid(result.getAllErrors());
		}

		service.save(usuario);

		return ok("Registro adicionado com sucesso");

	}

	@ApiOperation(value = "Atualizar um Usuário", hidden = false)
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<? extends ICustomResponse> usuarioPut(@Validated @RequestBody Usuario usuario,
			BindingResult result) {

		if (result.hasErrors()) {
			return invalid(result.getAllErrors());
		}

		service.save(usuario);

		return ok("Registro atualizado com sucesso");

	}

	@ApiOperation(value = "Deletar um Usuário pelo id", hidden = false)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CustomResponse> usuarioDelete(@PathVariable Long id) {
		service.delete(id);

		return new ResponseEntity<CustomResponse>(new CustomResponse("Registro apagado com sucesso", true),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Consultar todos os Usuários", hidden = false)
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> getAll() {
		return service.getAll();
	}

	@ApiOperation(value = "Consultar usuário pelo login", hidden = false)
	@RequestMapping(value = "/getByLogin/{login}", method = RequestMethod.GET)
	public Usuario getByLogin(@PathVariable String login) {
		return service.getByLogin(login);
	}

	@ApiOperation(value = "Consultar usuário pelo login e senha", hidden = false)
	@RequestMapping(value = "/getByLoginAndSenha/{login}/{senha}", method = RequestMethod.GET)
	public Usuario getByLoginAndSenha(@PathVariable String login, @PathVariable String senha) {
		return service.getByLoginAndSenha(login, senha);
	}

	@ApiOperation(value = "Consultar usuário pelo login e tipo", hidden = false)
	@RequestMapping(value = "/getByLoginAndTipo/{login}/{tipoUsuario}", method = RequestMethod.GET)
	public Usuario getByLoginAndTipo(@PathVariable String login, @PathVariable TipoUsuario tipoUsuario) {
		return service.getByLoginAndTipo(login, tipoUsuario);
	}

	@ApiOperation(value = "Consultar usuário pelo nome", hidden = false)
	@RequestMapping(value = "/getByNome/{nome}", method = RequestMethod.GET)
	public Usuario getByNome(@PathVariable String nome) {
		return service.getByNome(nome);
	}

	@ApiOperation(value = "Consultar usuário pelo nome", hidden = false)
	@RequestMapping(value = "/getByNomeContain/{nome}", method = RequestMethod.GET)
	public List<Usuario> getByNomeContain(@PathVariable String nome) {
		return service.getByNomeContain(nome);
	}

	@ApiOperation(value = "Consultar usuário pelo nome", hidden = false)
	@RequestMapping(value = "/getByTipo/{tipoUsuario}", method = RequestMethod.GET)
	public List<Usuario> getByNomeContain(@PathVariable TipoUsuario tipoUsuario) {
		return service.getByTipo(tipoUsuario);
	}
}

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

import br.com.system.vbankback.model.Banco;
import br.com.system.vbankback.service.BancoService;
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

@Api(value = "Banco")
@RestController
@RequestMapping(value = "/bancos")
public class BancoController {

	@Autowired
	BancoService service;

	@ApiOperation(value = "Consulta um banco pelo id", hidden = false)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Banco usuarioGet(@PathVariable Long id) {
		return service.getById(id);
	}

	@ApiOperation(value = "Inserir um Banco", hidden = false)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<? extends ICustomResponse> bancoPost(@Validated @RequestBody Banco usuario,
			BindingResult result) {

		if (result.hasErrors()) {
			return invalid(result.getAllErrors());
		}

		service.save(usuario);

		return ok("Registro adicionado com sucesso");

	}

	@ApiOperation(value = "Atualizar um Banco", hidden = false)
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<? extends ICustomResponse> bancoPut(@Validated @RequestBody Banco usuario,
			BindingResult result) {

		if (result.hasErrors()) {
			return invalid(result.getAllErrors());
		}

		service.save(usuario);

		return ok("Registro atualizado com sucesso");

	}

	@ApiOperation(value = "Deletar um Banco pelo id", hidden = false)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CustomResponse> bancoDelete(@PathVariable Long id) {
		service.delete(id);

		return new ResponseEntity<CustomResponse>(new CustomResponse("Registro apagado com sucesso", true),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Consultar todos os Bancos", hidden = false)
	@RequestMapping(method = RequestMethod.GET)
	public List<Banco> getAll() {
		return service.getAll();
	}

	@ApiOperation(value = "Consultar banco pela descrição", hidden = false)
	@RequestMapping(value = "/getByDescricao/{descricao}", method = RequestMethod.GET)
	public Banco getByNome(@PathVariable String descricao) {
		return service.getByDescricao(descricao);
	}

	@ApiOperation(value = "Consultar usuário pelo nome", hidden = false)
	@RequestMapping(value = "/getByDescricaoContain/{descricao}", method = RequestMethod.GET)
	public List<Banco> getByNomeContain(@PathVariable String descricao) {
		return service.getByDescricaoContain(descricao);
	}
}

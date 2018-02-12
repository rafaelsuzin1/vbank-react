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

@Api
@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@ApiOperation(value="Consulta um Usuario pelo id",hidden = false)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Usuario usuarioGet(@PathVariable Long id){
		return service.getById(id);
	}
			
	@ApiOperation(value="Inserir um Usuario",hidden = false)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<? extends ICustomResponse> usuarioPost(@Validated @RequestBody Usuario usuario, BindingResult result){		
	
		if (result.hasErrors()){		
			return invalid(result.getAllErrors());
		}
		
		service.save(usuario);
		
		return ok("Registro adicionado com sucesso");
		
	}
	
	@ApiOperation(value="Atualizar um Usuario",hidden = false)
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<? extends ICustomResponse> usuarioPut(@Validated @RequestBody Usuario usuario, BindingResult result){
		
		if (result.hasErrors()){		
			return invalid(result.getAllErrors());
		}
		
		service.save(usuario);
		
		return ok("Registro atualizado com sucesso");
		
	}
	
	@ApiOperation(value="Deletar um Usuario pelo id",hidden = false)
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CustomResponse> usuarioDelete(@PathVariable Long id){
		service.delete(id);
		
		return new ResponseEntity<CustomResponse>(new CustomResponse("Registro apagado com sucesso", true), HttpStatus.OK);
	}
	
	@ApiOperation(value="Consultar todos Usuarios",hidden = false)
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> usuarioAll(){
		List<Usuario> lstUsuario = service.getAll();	
				
		/*for (Usuario usuario : lstUsuario) {
			System.out.println(usuario.getNome());			
		}*/
		
		return lstUsuario;
	}

}

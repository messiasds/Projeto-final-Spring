package br.gov.sp.fatec.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.service.DispositivoService;
import br.gov.sp.fatec.service.Usuario1service;
import br.gov.sp.fatec.view.View;


@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private Usuario1service usuarioServ;
	
	@Autowired
	private DispositivoService dispoServ;

	public void setUsuarioServ(Usuario1service usuarioServ) {
		this.usuarioServ = usuarioServ;
	}

	public void setDispoServ(DispositivoService dispoServ) {
		this.dispoServ = dispoServ;
	}
	
	@RequestMapping(value="/getById/{id}", method= RequestMethod.GET )
	@JsonView(View.Usuario.class)
	//@JsonView(View.Teste.class)
	public ResponseEntity<Usuario> pesquisarPorId(@PathVariable("id") int id) {
		return new ResponseEntity<Usuario>(usuarioServ.buscarUserPorId(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getByEmail/{email}", method= RequestMethod.GET )
	@JsonView(View.Usuario.class)
	//@JsonView(View.Teste.class)
	public ResponseEntity<Usuario> pesquisarPorEmail(@PathVariable("email") String emailUser) {
		return new ResponseEntity<Usuario>(usuarioServ.buscarUserPorEmail(emailUser), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/criar", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.Usuario.class)
	public ResponseEntity <Usuario> criarUsuario(@RequestBody Usuario usuario ) {
		Usuario usuario1 = usuarioServ.incluirUsuario(usuario);
		
		return new ResponseEntity(usuario1.getNome(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletar", method= RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.Usuario.class)
	public ResponseEntity <Usuario> apagarUsuario(@RequestBody Usuario usuario ) {
		usuarioServ.removerUsuario(usuario);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
	
	

}

package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepositorio;




@Service("usuarioService")
public class Usuario1serviceImp implements Usuario1service{

	@Autowired
	UsuarioRepositorio usuarioRepo;
	
	
	@Override
	public Usuario incluirUsuario(Usuario user) {
		
		return usuarioRepo.save(user);
		
	}

	public void setUsuarioRepo(UsuarioRepositorio usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public void removerUsuario(Usuario user) {
		usuarioRepo.delete(user);
	}

	@Override
	public void alterarUsuario(Usuario user) {
		usuarioRepo.save(user);
	}

	@Override
	public Usuario buscarUserPorEmail(String email) {
	    Usuario user = 	usuarioRepo.findByEmail(email);
		return user;
	}

	@Override
	public Usuario buscarUserPorId(int id) {
		Usuario user = usuarioRepo.findById(id);
		return user;
	}

}

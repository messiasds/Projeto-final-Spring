package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Dispositivo;
import br.gov.sp.fatec.model.Usuario;

public interface Usuario1service {
	
	public Usuario incluirUsuario(Usuario user);
	
	public void removerUsuario(Usuario user);
	
	public void alterarUsuario(Usuario user);
	
	public Usuario buscarUserPorEmail(String email);
	
	public Usuario buscarUserPorId(int id);
	
	
}

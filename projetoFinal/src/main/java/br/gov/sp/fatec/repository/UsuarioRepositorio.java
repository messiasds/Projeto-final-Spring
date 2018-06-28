package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Medicao;
import br.gov.sp.fatec.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository <Usuario, Long> {
	
	@Query("select u from Usuario u join u.dispositivos j where j.id = ?1" )
	public List<Usuario> usuarioPorIdDispositivo(int id);
	
	public Usuario findById(int id);
	
	public Usuario findByNome(String nome);

	public Usuario findByEmail(String email);

}

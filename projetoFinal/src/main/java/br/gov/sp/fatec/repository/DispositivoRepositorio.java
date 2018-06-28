package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Dispositivo;
import br.gov.sp.fatec.model.Medicao;

public interface DispositivoRepositorio extends CrudRepository<Dispositivo, Long> {
	

	
	@Query("select d from Dispositivo d join d.usuarios j where j.nome = ?1" )
	public List<Dispositivo> dispositivoPorUsuario(String nome);
	
	
	public Dispositivo findById(int id);

	public Dispositivo findByEndMAC(String endMAC);

	public Dispositivo findByNome(String nome);
	
	public List <Dispositivo> findByStatus(int status);
	
	public List <Dispositivo> findByValor(int valor);
	
}
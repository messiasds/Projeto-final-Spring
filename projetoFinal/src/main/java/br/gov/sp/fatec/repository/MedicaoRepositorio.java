package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Dispositivo;
import br.gov.sp.fatec.model.Medicao;
import br.gov.sp.fatec.model.Usuario;

public interface MedicaoRepositorio extends CrudRepository<Medicao, Long> {

	
	@Query("select m from Medicao m join m.dispositivos j where j.id = ?1" )
	public List<Medicao> dispositivoPorId(int id);
	
	public Medicao findById(int id);
	
	public Medicao findByValor(int valor);

}

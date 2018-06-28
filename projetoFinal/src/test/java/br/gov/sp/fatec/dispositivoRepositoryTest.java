package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Dispositivo;
import br.gov.sp.fatec.model.Medicao;
import br.gov.sp.fatec.repository.DispositivoRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/UsuarioRepositoryTest-context.xml" })
@Transactional
public class dispositivoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private DispositivoRepositorio  dispositivoRepo;

	public void setDispositivoRepo(DispositivoRepositorio dispositivoRepo) {
		this.dispositivoRepo = dispositivoRepo;
	}
	
	@Test
	public void mostrarTudo() {
		
		System.out.println("ENTROU NO TESTE");
		List<Dispositivo> lista;
		lista=(List<Dispositivo>) dispositivoRepo.findAll();
		System.out.println("tamanho  " + lista.size());
		boolean retorno=false;
		if(lista.size() > 0)
			retorno=true;
		
	assertTrue(retorno);
			
		
	}
	
	// join o usuario
	
	@Test
	public void testeJoin1() {
		
		String nome="Admin";
		List<Dispositivo> lista = dispositivoRepo.dispositivoPorUsuario(nome);
		System.out.println("Teste join, numero de dispositivos : " +lista.size());
		assertTrue(lista.size() > 0 );
		
		for(Dispositivo dispo:lista) {
			System.out.println("nome do dispositivo: " +dispo.getNome());
			
			
		}
	}
		
	
	
	

}

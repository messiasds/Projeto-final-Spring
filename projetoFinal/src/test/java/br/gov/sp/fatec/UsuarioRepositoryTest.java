package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.model.Medicao;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.MedicaoRepositorio;
import br.gov.sp.fatec.repository.UsuarioRepositorio;


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
import br.gov.sp.fatec.repository.MedicaoRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/UsuarioRepositoryTest-context.xml" })
@Transactional
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	public void setMedicaoRepo(UsuarioRepositorio usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}
	
	@Test
	public void testJoin2() {
		int idDispositivo = 10;
		List<Usuario> lista = usuarioRepo.usuarioPorIdDispositivo(idDispositivo);
        System.out.println("teste de usuarios por Id " +lista.size());
        assertTrue(lista.size() > 0);
        
        for(Usuario user:lista) {
            System.out.println("dados do usuario id: "+ user.getId()+ " nome "+ user.getNome());
            
            for(Dispositivo dispo:user.getDispositivos()) {
            	System.out.println("id do dispositivo: "+dispo.getId()+
            	" nome do dispositivo: "+dispo.getNome()
            			);
            	
            }
        }
	}
	
	@Test
	public void TesteFindById(){
		int idUser = 1;
		Usuario userExemplo = usuarioRepo.findById(idUser);
		System.out.println("teste user finbyid");
		System.out.println("Usuario nome: "+userExemplo.getNome());
		
		
		for(Dispositivo dispo:userExemplo.getDispositivos()) {
        	System.out.println("id do dispositivo: "+dispo.getId()+
        	" nome do dispositivo: "+dispo.getNome());
	}
  }
}

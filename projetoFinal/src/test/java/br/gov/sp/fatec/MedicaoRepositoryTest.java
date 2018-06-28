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
import br.gov.sp.fatec.repository.MedicaoRepositorio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/UsuarioRepositoryTest-context.xml" })
@Transactional
public class MedicaoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private MedicaoRepositorio medicaoRepo;
	
	public void setMedicaoRepo(MedicaoRepositorio medicaoRepo) {
		this.medicaoRepo = medicaoRepo;
	}
	
	@Test
	public void testJoin2() {
		int idDispositivo = 10;
		List<Medicao> lista = medicaoRepo.dispositivoPorId(idDispositivo);
        System.out.println("teste de medicoes" +lista.size());
        assertTrue(lista.size() > 0);
        
        for(Medicao medi:lista) {
            System.out.println("dados da medicao id: "+ medi.getId()+ " valor: "+ medi.getValor());
            				
        }
	}
}
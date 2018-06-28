package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Dispositivo;
import br.gov.sp.fatec.model.Medicao;

public interface DispositivoService {

		public void incluirDispo(Dispositivo dispo);
		
		public void removerDispo(Dispositivo dispo);
		
		public void alterarDispo(Dispositivo dispo);
		
		public Dispositivo buscarDispositivoId(int id);
		
		public Dispositivo buscarDispositivoNome(String nome);
	
		public Dispositivo buscarDispositivoMAC(String mac);
	
		public List <Dispositivo> buscarDispositivoStatus(int status);
		
		public List <Dispositivo> buscarDispositivoValor(int valor);
		
		public List <Medicao> buscarMedicaoDoDipositivo(int id);
	
}

package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Dispositivo;
import br.gov.sp.fatec.model.Medicao;
import br.gov.sp.fatec.repository.DispositivoRepositorio;
import br.gov.sp.fatec.repository.MedicaoRepositorio;


@Service("dispositivoService")
public class DispositivoServiceImp implements DispositivoService{

	@Autowired
	DispositivoRepositorio dispoRepo;
	
	@Autowired
	MedicaoRepositorio mediRepo;
	
	
	public void setMediRepo(MedicaoRepositorio mediRepo) {
		this.mediRepo = mediRepo;
	}

	@Override
	public void incluirDispo(Dispositivo dispo) {
		dispoRepo.save(dispo);
	}

	@Override
	public void removerDispo(Dispositivo dispo) {
		dispoRepo.delete(dispo);
	}

	@Override
	public void alterarDispo(Dispositivo dispo) {
		dispoRepo.save(dispo);
	}

	@Override
	public Dispositivo buscarDispositivoId(int id) {
		Dispositivo dispo = dispoRepo.findById(id);
		return dispo;
	}

	@Override
	public Dispositivo buscarDispositivoNome(String nome) {
	
		return dispoRepo.findByNome(nome);
		
	}

	@Override
	public Dispositivo buscarDispositivoMAC(String mac) {
		
		return dispoRepo.findByEndMAC(mac);

	}

	@Override
	public List<Dispositivo> buscarDispositivoStatus(int status) {
		
		return dispoRepo.findByStatus(status);
	}

	@Override
	public List<Dispositivo> buscarDispositivoValor(int valor) {
		return dispoRepo.findByValor(valor);
	}

	@Override
	public List<Medicao> buscarMedicaoDoDipositivo(int id) {
		
		return mediRepo.dispositivoPorId(id);
	}
	

}

package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name = "dispositivo_tbl")
public class Dispositivo {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, length = 11, nullable = false, name = "dispositivo_id")
	@JsonView(View.Dispositivo.class)
	private int id;
	
	@Column(length = 17, nullable = false, name = "dispositivo_endMAC")
	@JsonView(View.Dispositivo.class)
	private String endMAC;
	
	@Column(length = 50, nullable = false, name = "dispositivo_nome")
	@JsonView({View.Dispositivo.class,View.Usuario.class})
	private String nome;
	
	@Column(length = 1, nullable = false, name = "dispositivo_status")
	@JsonView(View.Dispositivo.class)
	private int status;
    
	@Column(length = 11, nullable = false, name = "dispositivo_valor")
	@JsonView({View.Dispositivo.class,View.Usuario.class})
	private int valor;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dispositivos")
	//@JsonView({View.Dispositivo.class,View.Usuario.class})
	@JsonView(View.Dispositivo.class)
	private List<Medicao> medicoes; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonView(View.Dispositivo.class)
	private Usuario usuarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndMAC() {
		return endMAC;
	}

	public void setEndMAC(String endMAC) {
		this.endMAC = endMAC;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public List<Medicao> getMedicoes() {
		return medicoes;
	}

	public void setMedicoes(List<Medicao> medicoes) {
		this.medicoes = medicoes;
	}
	
	

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

}

package br.gov.sp.fatec.model;

import java.sql.Date;

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
@Table(name = "medicao_tbl")
public class Medicao {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, length = 11, nullable = false,name = "medicao_id" )
	@JsonView(View.Medicao.class)
	private int id;
	
	@Column(nullable = false, name = "medicao_tempo")
	@JsonView(View.Medicao.class)
	private Date tempo;
	
	@Column(length = 50, nullable = false, name = "medicao_valor")
	@JsonView({View.Medicao.class,View.Usuario.class})
	private String valor;
	
	@ManyToOne(fetch = FetchType.LAZY ) 
	@JoinColumn(name = "dispositivo_id")
	@JsonView(View.Medicao.class)
	private Dispositivo dispositivos;

	public Dispositivo getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(Dispositivo dispositivos) {
		this.dispositivos = dispositivos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}

package br.gov.sp.fatec.model;
import java.util.ArrayList;
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
@Table(name = "usuario_tbl")
public class Usuario {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, length = 11, nullable = false, name = "usuario_id")
	@JsonView(View.Usuario.class)
	private int id;
	
	@JsonView(View.Teste.class)
	@Column(length = 100, nullable = false, name = "usuario_nome")
	//@JsonView(View.Usuario.class)
	private String nome;
	
	@Column(length = 50, nullable = false, name = "usuario_senha")
	@JsonView(View.Usuario.class)
	private String senha;
	
	@Column(length = 100, nullable = false, name = "usuario_email")
	@JsonView(View.Usuario.class)
	private String email;
	
	@Column(length = 1, nullable = false, name = "usuario_admin" )
	@JsonView(View.Usuario.class)
	private int admin;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarios")
	//@JsonView(View.Usuario.class)
	private List<Dispositivo> dispositivos; 
	
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}
	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
}

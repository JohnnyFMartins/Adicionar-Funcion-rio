package br.com.cadastrofuncionario.model;

import java.sql.Date;

public class Funcionario {

	// Long -> 2
	// long -> 2
	// double -> 2.0
	// int -> 4M
	private Long id;
	private String nome;
	private String cargo;
	private String email;
	private String telefone;
	private Date data;
	private String status; // 0 -> Aberto, 1 -> em andamento, 2 -> Concluido

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

package br.com.fiap.projetoibm.model.entities;


public class Usuario {
	private String rm;
	private String senha;
	
	
	public Usuario(String rm, String senha) {
		super();
		this.rm = rm;
		this.senha = senha;
	}
	
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}

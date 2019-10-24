package br.com.projetoibm.business;

import br.com.fiap.projetoibm.dao.UsuarioDAO;
import br.com.fiap.projetoibm.model.entities.Usuario;

public class UsuarioBO {
	public Usuario autenticar(Usuario u) {
		Usuario usuario = new UsuarioDAO().consultarPorRm(u.getRm());
		if(usuario == null) return null;
		if(!usuario.getSenha().equals(u.getSenha())) return null;
		return usuario;
	}
	
	public boolean validarUsuario(Usuario u) {
		return u.getRm() != null && 
				u.getSenha() != null; 
	}
	public Usuario validarLogin(String rm, String senha) {
		return new UsuarioDAO().consultarUsuario(rm, senha);
	}
}


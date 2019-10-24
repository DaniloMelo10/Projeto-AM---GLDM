package br.com.fiap.projetoibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.projetoibm.conexao.Conexao;
import br.com.fiap.projetoibm.model.entities.Usuario;

public class UsuarioDAO {
	private static ArrayList<Usuario> USUARIOS = new ArrayList<>();
	
	static {
		USUARIOS.add(new Usuario("1234", "1234"));
	}
	
	public void adicionar(Usuario u) {
		USUARIOS.add(u);
	}
	
	public ArrayList<Usuario> consultarTodos() {
		return USUARIOS;
	}
	
	public Usuario consultarPorRm(String rm) {
		for(Usuario u : USUARIOS) {
			if(u.getRm().equals(rm)) {
				return u;
			}
		}
		return null;
	}
	public Usuario consultarUsuario(String rm, String senha) {
		
		Usuario usuario = null;
		
		try(Connection conn = Conexao.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from usuario where rm = ? and senha = ?");
			
			stmt.setString(1, rm);
			stmt.setString(3, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				String rmBD = rs.getString("rm");
				String senhaBD = rs.getString("senha");
				usuario = new Usuario(rmBD, senhaBD);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

}

	



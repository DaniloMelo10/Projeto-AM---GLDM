package br.com.fiap.projetoibm.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectConteudo {
	public static void main(String[] args) {
		Connection conectar = null;
		Statement estrutura = null;
		ResultSet resultado = null;
		try {
			conectar = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL");
			estrutura = conectar.createStatement();
			resultado = estrutura.executeQuery("Select Titulo, Descrição from Conteudos");
			while (resultado.next()) {
				System.out.print("\nConteudos:" + resultado.getString("Titulo"));
				System.out.print("\nConteudos:" + resultado.getString("Descrição"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultado.close();
				estrutura.close();
				conectar.close();
			}catch (SQLException e ) {
				e.printStackTrace();
			}
		}
		
		}

}




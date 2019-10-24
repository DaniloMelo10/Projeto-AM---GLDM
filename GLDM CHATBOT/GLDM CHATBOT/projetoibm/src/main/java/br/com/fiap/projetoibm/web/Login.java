package br.com.fiap.projetoibm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.projetoibm.model.entities.Usuario;
import br.com.projetoibm.business.UsuarioBO;


public class Login {
	public String processarRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		String rm = req.getParameter("rm");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioBO().validarLogin(rm, senha);
		
		if(usuario != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
			return "index.html";
		} else {
			req.setAttribute("erro", "Usuário e/ou Senha não existem.");
			return "login.html";
		}
		
	}
}



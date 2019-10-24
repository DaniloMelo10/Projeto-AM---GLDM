package br.com.fiap.projetoibm.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.projetoibm.model.entities.Usuario;
import br.com.projetoibm.business.UsuarioBO;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

	
	private static final long serialVersionUID = -5830449157746043208L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String rm = req.getParameter("rm");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(rm, senha);
		
		out.println("<html><body>");
		
		usuario = new UsuarioBO().autenticar(usuario);
		
		if(usuario != null) {
			out.println("<h2>Usuário " + usuario.getRm() + " autenticado com sucesso.</h2>");
			Cookie cookie = new Cookie("usuario.logado", usuario.getRm());
			resp.addCookie(cookie);
		} else {
			out.println("<h2 style=\"color:red;\"> Algo está incorreto!</h2>");
		}
		
		out.println("<a href=\"login.html\">Voltar para Home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}
}
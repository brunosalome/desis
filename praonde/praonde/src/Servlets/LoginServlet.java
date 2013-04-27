package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.Usuario;
import Dao.UsuarioDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u = udao.getUsuario(usuario);
		
		
		out.println("<html>");
		out.println("<body>");
		
		if(u.getSenha()!=null){
			if(u.getSenha().equals(senha)){
				out.println("<meta http-equiv=\"refresh\" content=\"1; url=usuarioLogado.jsp?usuario="+usuario+"&idUsuario="+u.getIdUsuario()+"\">");	
			}else{
				out.println("<meta http-equiv=\"refresh\" content=\"1; url=erroLogin.jsp\">");	
			}
		}else{
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=erroLogin.jsp\">");	
		}
		
		
		
		
		out.println("</body>");
		out.println("</html>");
	}	
}

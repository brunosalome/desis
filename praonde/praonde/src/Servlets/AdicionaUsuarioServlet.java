package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Usuario;
import Dao.UsuarioDAO;

public class AdicionaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		// pegndo os parâmetros do request 
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nascimento = request.getParameter("nascimento");
		String pais = request.getParameter("pais");
		String cidade = request.getParameter("cidade");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setNome(nome);
		u.setEndereco(endereco);
		u.setCpf(cpf);
		u.setNascimento(nascimento);
		u.setPais(pais);
		u.setCidade(cidade);
		u.setSenha(senha);
		u.setTelefone(telefone);
		u.setCelular(celular);
			
		UsuarioDAO dao = new UsuarioDAO();
		dao.adiciona(u);

		UsuarioDAO dao2 = new UsuarioDAO();
		int idUsuario2 = dao2.getLast();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=usuarioLogado.jsp?idUsuario="+idUsuario2+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Contato;
import Dao_OLD.ContatoDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		int idContato = Integer.parseInt(request.getParameter("idContato"));
		String nome = request.getParameter("nome");
		String cargo = request.getParameter("cargo");
		String departamento = request.getParameter("departamento");
		String telefone_comercial = request.getParameter("telefone_comercial");
		String ramal = request.getParameter("ramal");
		String celular_comercial = request.getParameter("celular_comercial");
		String email_comercial = request.getParameter("email_comercial");
		String endereço_comercial = request.getParameter("endereço_comercial");
		String email_pessoal = request.getParameter("email_pessoal");
		String telefone_pessoal = request.getParameter("telefone_pessoal");
		String celular_pessoal = request.getParameter("celular_pessoal");
		String endereço_pessoal = request.getParameter("endereço_pessoal");
		String banco = request.getParameter("banco");
		String agencia = request.getParameter("agencia");
		String conta_corrente = request.getParameter("conta_corrente");
		String nascimento = request.getParameter("nascimento");
		
		Contato c = new Contato();
		c.setIdContato(idContato);
		c.setIdCliente(idCliente);
		c.setNome(nome);
		c.setCargo(cargo);
		c.setDepartamento(departamento);
		c.setTelefone_comercial(telefone_comercial);
		c.setRamal(ramal);
		c.setCelular_comercial(celular_comercial);
		c.setEmail_comercial(email_comercial);
		c.setEndereco_comercial(endereço_comercial);
		c.setEmail_pessoal(email_pessoal);
		c.setTelefone_pessoal(telefone_pessoal);
		c.setCelular_pessoal(celular_pessoal);
		c.setEndereco_pessoal(endereço_pessoal);
		c.setBanco(banco);
		c.setAgencia(agencia);
		c.setConta_corrente(conta_corrente);
		c.setNascimento(nascimento);
		
		// salva o contato
		ContatoDAO dao = new ContatoDAO();
		dao.atualiza(c);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_cliente.jsp?idCliente="+idCliente+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

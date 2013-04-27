package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Cliente;
import Dao_OLD.ClienteDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		String nome = request.getParameter("nome");
		String fantasia = request.getParameter("fantasia");
		String tipo = request.getParameter("tipo");
		String cnpj = request.getParameter("cnpj");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String ie = request.getParameter("inscricaoEstadual");
		String ccm = request.getParameter("ccm");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String municipio = request.getParameter("municipio");
		String estado = request.getParameter("estado");
		String telefone = request.getParameter("telefone");
		
		Cliente c = new Cliente();
		c.setIdCliente(idCliente);
		c.setNome(nome);
		c.setFantasia(fantasia);
		c.setTipo(tipo);
		c.setCnpj(cnpj);
		c.setRg(rg);
		c.setCnpj(cnpj);
		c.setRg(rg);
		c.setCpf(cpf);
		c.setIe(ie);
		c.setCcm(ccm);
		c.setCep(cep);
		c.setRua(rua);
		c.setNumero(numero);
		c.setComplemento(complemento);
		c.setBairro(bairro);
		c.setMunicipio(municipio);
		c.setEstado(estado);
		c.setTelefone(telefone);
		
		// salva o contato
		ClienteDAO dao = new ClienteDAO();
		dao.atualiza(c);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_cliente.jsp?idCliente="+idCliente+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

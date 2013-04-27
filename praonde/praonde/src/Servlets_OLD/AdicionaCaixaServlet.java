package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Caixa;
import Dao_OLD.CaixaDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaCaixaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		String caixa = request.getParameter("caixa");
		int cliente = Integer.parseInt(request.getParameter("cliente"));
		String patrimonio = request.getParameter("patrimonio");
		String patrimonioCliente = request.getParameter("patrimonioCliente");
		int idContato = Integer.parseInt(request.getParameter("idContato"));
		
		Caixa c = new Caixa();
		c.setCaixa(caixa);
		c.setIdCliente(cliente);
		c.setPatrimonio(patrimonio);
		c.setIdContato(idContato);
		
		CaixaDAO dao = new CaixaDAO();
		dao.adiciona(c);
		
		CaixaDAO dao2 = new CaixaDAO();
		int idCaixa = dao2.getLast();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_caixa_has_produtos.jsp?idCaixa="+idCaixa+"&patrimonioCliente="+patrimonioCliente+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

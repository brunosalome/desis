package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Caixa;
import Dao_OLD.CaixaDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaCaixaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		String caixa = request.getParameter("caixa");
		int idCliente = Integer.parseInt(request.getParameter("cliente"));
		String patrimonio = request.getParameter("patrimonio");
		int idCaixa = Integer.parseInt(request.getParameter("idCaixa"));
		int idContato = Integer.parseInt(request.getParameter("idContato"));
		
		Caixa c = new Caixa();
		c.setIdCaixa(idCaixa);
		c.setCaixa(caixa);
		c.setIdCliente(idCliente);
		c.setPatrimonio(patrimonio);
		c.setIdContato(idContato);
		
		CaixaDAO dao = new CaixaDAO();
		dao.atualiza(c);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_caixa.jsp?idCaixa="+idCaixa+"\">");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_cliente.jsp?idCliente="+idCliente+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

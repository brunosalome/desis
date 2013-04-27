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
public class RemoveContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idContato = Integer.parseInt(request.getParameter("idContato"));
		ContatoDAO cdao = new ContatoDAO();
		
		Contato c = cdao.getContato(idContato);
		int idCliente = c.getIdCliente();
		
		int array[] = new int[1];
		array[0] = idContato;
		cdao.remove(array);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_cliente.jsp?idCliente="+idCliente+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

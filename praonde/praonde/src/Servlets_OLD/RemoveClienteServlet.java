package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.ClienteDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class RemoveClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		ClienteDAO cdao = new ClienteDAO();
		
		int array[] = new int[1];
		array[0] = idCliente;
		cdao.remove(array);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=consultaCliente?valor=0&dimensao=maior&parametro=idCliente\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

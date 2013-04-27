package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.PatrimonioDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class RemovePatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idPatrimonio = Integer.parseInt(request.getParameter("idPatrimonio"));
		PatrimonioDAO pdao = new PatrimonioDAO();
		
		int array[] = new int[1];
		array[0] = idPatrimonio;
		pdao.remove(array);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=lista_patrimonios.jsp\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Patrimonio;
import Dao_OLD.PatrimonioDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		// pegndo os parâmetros do request
		String patrimonio = request.getParameter("patrimonio");
		
		Patrimonio p = new Patrimonio();
		p.setPatrimonio(patrimonio);
		
		// salva o contato
		PatrimonioDAO dao = new PatrimonioDAO();
		dao.adiciona(p);

		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_patrimonio.jsp\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

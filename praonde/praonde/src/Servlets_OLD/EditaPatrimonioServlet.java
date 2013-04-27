package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Patrimonio;
import Dao_OLD.PatrimonioDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idPatrimonio = Integer.parseInt(request.getParameter("idPatrimonio"));
		String descricao_patrimonio = request.getParameter("patrimonio");
		
		Patrimonio p = new Patrimonio();
		p.setIdPatrimonio(idPatrimonio);
		p.setPatrimonio(descricao_patrimonio);
		
		// salva o contato
		PatrimonioDAO dao = new PatrimonioDAO();
		dao.atualiza(p);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=lista_patrimonios.jsp\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Cor;
import Dao_OLD.CorDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaCorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		// pegndo os parâmetros do request
		String cor = request.getParameter("cor");
		
		Cor c = new Cor();
		c.setCor(cor);
		
		// salva o contato
		CorDAO dao = new CorDAO();
		dao.adiciona(c);

		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_cor.jsp\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

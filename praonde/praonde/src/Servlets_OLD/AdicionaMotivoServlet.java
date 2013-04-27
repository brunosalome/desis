package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Motivo;
import Dao_OLD.MotivoDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaMotivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		String motivo = request.getParameter("motivo");
		
		Motivo m = new Motivo();
		m.setMotivo(motivo);
		
		MotivoDAO dao = new MotivoDAO();
		dao.adiciona(m);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_motivo.jsp\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Motivo;
import Dao_OLD.MotivoDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaMotivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idMotivo = Integer.parseInt(request.getParameter("idMotivo"));
		String descricao_motivo = request.getParameter("motivo");
		
		Motivo m = new Motivo();
		m.setIdMotivo(idMotivo);
		m.setMotivo(descricao_motivo);
		
		// salva o contato
		MotivoDAO dao = new MotivoDAO();
		dao.atualiza(m);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=lista_motivos.jsp\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

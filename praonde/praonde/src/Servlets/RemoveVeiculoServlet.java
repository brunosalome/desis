package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class RemoveVeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idVeiculo = Integer.parseInt(request.getParameter("idVeiculo"));
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		VeiculoDAO vdao = new VeiculoDAO();
		
		int array[] = new int[1];
		array[0] = idVeiculo;
		vdao.remove(array);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_veiculo.jsp?idUsuario="+idUsuario+"&idVeiculo=0\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.CaixaDAO;

public class RemoveCaixaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idCaixa = Integer.parseInt(request.getParameter("idCaixa"));
		CaixaDAO cdao = new CaixaDAO();
		
		int array[] = new int[1];
		array[0] = idCaixa;
		cdao.remove(array);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=consultaCaixa?parametro=idCaixa&dimensao=maior&valor=0 \">");		
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

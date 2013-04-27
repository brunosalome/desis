package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Caixa_has_ProdutosDAO;

public class RemoveCaixa_has_ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idCaixa_has_Produtos = Integer.parseInt(request.getParameter("idCaixa_has_produtos"));
		int idCaixa = Integer.parseInt(request.getParameter("idCaixa"));
		Caixa_has_ProdutosDAO cdao = new Caixa_has_ProdutosDAO();
		
		int array[] = new int[1];
		array[0] = idCaixa_has_Produtos;
		cdao.remove(array);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_caixa.jsp?idCaixa="+idCaixa+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

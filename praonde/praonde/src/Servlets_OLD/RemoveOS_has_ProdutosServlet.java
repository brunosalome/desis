package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.OSDAO;
import Dao_OLD.OS_has_Produtos;
import Dao_OLD.OS_has_ProdutosDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class RemoveOS_has_ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idOS_has_Produtos = Integer.parseInt(request.getParameter("idOS_has_Produtos"));
		OS_has_ProdutosDAO cdao = new OS_has_ProdutosDAO();
		OS_has_Produtos ohp = cdao.getOHP(idOS_has_Produtos);
		
		int idOS = ohp.getIdOS();
		
		int array[] = new int[1];
		array[0] = idOS_has_Produtos;
		cdao.remove(array);
		
		OSDAO osdao = new OSDAO();
		osdao.ordenaPatrimonios(idOS);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_os.jsp?idOS="+idOS+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.OS_has_Produtos;
import Dao_OLD.OS_has_ProdutosDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaOS_has_ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idOS_has_produtos = Integer.parseInt(request.getParameter("idOS_has_produtos"));
		String observacao = request.getParameter("observacao");
		int quebrado_qtd = Integer.parseInt(request.getParameter("quebrado_qtd"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade")) - quebrado_qtd;
		String patrimonio = request.getParameter("patrimonio");
		int idOS = Integer.parseInt(request.getParameter("idOS"));
		int idMotivo = Integer.parseInt(request.getParameter("motivo"));
		String conserto = request.getParameter("conserto");
		
		OS_has_ProdutosDAO ohpdao = new OS_has_ProdutosDAO();
		OS_has_Produtos ohp = ohpdao.getOHP(idOS_has_produtos);
		ohp.setConserto(conserto);
		ohp.setIdMotivo(idMotivo);
		ohp.setIdOS(idOS);
		ohp.setIdOS_has_produtos(idOS_has_produtos);
		ohp.setObservacao(observacao);
		ohp.setPatrimonio(patrimonio);
		ohp.setQuantidade(quantidade);
		ohp.setQuebrado_qtd(quebrado_qtd);
		
		OS_has_ProdutosDAO dao = new OS_has_ProdutosDAO();
		dao.atualiza(ohp);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_os.jsp?idOS="+idOS+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	 
}

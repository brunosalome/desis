package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Caixa_has_Produtos;
import Dao_OLD.Caixa_has_ProdutosDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaCaixa_has_ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idProduto = Integer.parseInt(request.getParameter("produto"));
		int idCaixa_has_Produtos = Integer.parseInt(request.getParameter("idCaixa_has_Produtos"));
		String observacao = request.getParameter("observacao");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		String patrimonio = request.getParameter("sequencia_patrimonio");
		int idCaixa = Integer.parseInt(request.getParameter("idCaixa"));
		
		Caixa_has_Produtos chp = new Caixa_has_Produtos();
		chp.setIdCaixa(idCaixa);
		chp.setIdCaixa_has_Produtos(idCaixa_has_Produtos);
		chp.setIdProduto(idProduto);
		chp.setObservacao(observacao);
		chp.setPatrimonio(patrimonio);
		chp.setQuantidade(quantidade);
		
		Caixa_has_ProdutosDAO dao = new Caixa_has_ProdutosDAO();
		dao.atualiza(chp);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_caixa.jsp?idCaixa="+idCaixa+"\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	 
}

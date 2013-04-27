package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Caixa_has_Produtos;
import Dao_OLD.Caixa_has_ProdutosDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaCaixa_has_ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		int idCaixa = Integer.parseInt(request.getParameter("idCaixa"));
		int idProduto = Integer.parseInt(request.getParameter("produto"));
		int quantidade= Integer.parseInt(request.getParameter("quantidade"));
		String patrimonio = request.getParameter("patrimonio");
		String observacao = request.getParameter("observacao");
		boolean adiciona = false;
		if(request.getParameter("adiciona")!=null)
			adiciona = true;
		
		Caixa_has_Produtos chp = new Caixa_has_Produtos();
		chp.setIdCaixa(idCaixa);
		chp.setIdProduto(idProduto);
		chp.setObservacao(observacao);
		chp.setPatrimonio(patrimonio);
		chp.setQuantidade(quantidade);
		
		Caixa_has_ProdutosDAO chpdao = new Caixa_has_ProdutosDAO();
		chpdao.adiciona(chp);
		
		if(adiciona == true){
			out.println("<html>");
			out.println("<body>");
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_caixa_has_produtos.jsp?idCaixa="+idCaixa+"\">");
			out.println("</body>");
			out.println("</html>");
		}else{
			out.println("<html>");
			out.println("<body>");
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_caixa.jsp?idCaixa="+idCaixa+"\">");
			out.println("</body>");
			out.println("</html>");
		}
	}	
}

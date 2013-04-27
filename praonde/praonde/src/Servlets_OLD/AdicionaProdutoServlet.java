package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Produto;
import Dao_OLD.ProdutoDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		// pegndo os parâmetros do request
		String descricao = request.getParameter("descricao");
		int barras = Integer.parseInt(request.getParameter("barras"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		int duplo = 0;
		int ultimo = 0;
		if(request.getParameter("duplo")!=null)
			duplo = 1;		
		if(request.getParameter("ultimo")!=null)
			ultimo = 1;
		
		Produto p = new Produto();
		p.setDescricao(descricao);
		p.setBarras(barras);
		p.setValor(valor);
		p.setDuplo(duplo);
		p.setUltimo(ultimo);
		
		// salva o contato
		ProdutoDAO dao = new ProdutoDAO();
		dao.adiciona(p);

		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=consultaProduto?codigo=&descricao=\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

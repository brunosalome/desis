package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Condicao_Pagamento;
import Dao_OLD.Condicao_PagamentoDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaCondicaoPagamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		// pegndo os parâmetros do request
		String condPag = request.getParameter("condicao_pagamento");
		
		Condicao_Pagamento cp = new Condicao_Pagamento();
		cp.setCondicao_pagamento(condPag);
		
		Condicao_PagamentoDAO cpdao = new Condicao_PagamentoDAO();
		cpdao.adiciona(cp);
		
		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_condicaoPagamento.jsp\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

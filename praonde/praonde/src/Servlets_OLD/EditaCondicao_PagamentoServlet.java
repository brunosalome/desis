package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Condicao_Pagamento;
import Dao_OLD.Condicao_PagamentoDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaCondicao_PagamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		// pegndo os parâmetros do request
		int idCondicao_Pagamento = Integer.parseInt(request.getParameter("idCondicao_Pagamento"));
		String descricao_condicao = request.getParameter("condicao_pagamento");
		
		System.out.println("DESCRICAO CONDICAO:"+descricao_condicao);
		
		Condicao_Pagamento cp = new Condicao_Pagamento();
		cp.setIdCondicao_Pagamento(idCondicao_Pagamento);
		cp.setCondicao_pagamento(descricao_condicao);
		
		Condicao_PagamentoDAO dao = new Condicao_PagamentoDAO();
		dao.atualiza(cp);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=lista_condicoes.jsp\">");
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

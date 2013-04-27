package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.OS;
import Dao_OLD.OSDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class EditaOSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		int idOS = Integer.parseInt(request.getParameter("idOS"));
		
		int idCliente = Integer.parseInt(request.getParameter("cliente"));
		String dataLancamento = request.getParameter("dataLancamento");
		String dataEntrega = request.getParameter("dataEntrega");
		int idCondPag = Integer.parseInt(request.getParameter("condicao_pagamento"));
		String observacao = request.getParameter("observacao");
		String ordenar = request.getParameter("ordenar");
		int idSolicitante = Integer.parseInt(request.getParameter("idSolicitante"));
		String status = "";
		if(request.getParameter("status")!=null)
			status = request.getParameter("status");
				
		OSDAO osdao = new OSDAO();
		OS os = osdao.getOS(idOS);
		os.setIdCliente(idCliente);
		os.setDataLancamento(dataLancamento);
		os.setIdCondicao_Pagamento(idCondPag);
		os.setObservacao(observacao);
		os.setDataEntrega(dataEntrega);
		os.setOrdenar(ordenar);
		os.setIdSolicitante(idSolicitante);
		
		if(status!="")
			os.setStatus(status);
		else
			os.setStatus("Em Andamento");
		
		OSDAO osdao2 = new OSDAO();
		osdao2.atualiza(os);		
		
		out.println("<html>");
		out.println("<body>");
		if(status=="")
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=edita_os_has_caixas.jsp?idOS="+idOS+"&idCliente="+idCliente+"\">");
		else
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_os.jsp?idOS="+idOS+"&idCliente="+idCliente+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

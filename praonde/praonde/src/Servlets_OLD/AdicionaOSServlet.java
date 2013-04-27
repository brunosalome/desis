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
public class AdicionaOSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		int idCliente = Integer.parseInt(request.getParameter("cliente"));
		String dataLancamento = request.getParameter("data_lancamento");
		int idCondPag = Integer.parseInt(request.getParameter("condPag"));
		String observacao = request.getParameter("observacao");
		String ordenar = request.getParameter("ordenar");
		int idSolicitante = Integer.parseInt(request.getParameter("idSolicitante"));
		
		OS os = new OS();
		os.setIdCliente(idCliente);
		os.setDataLancamento(dataLancamento);
		os.setIdCondicao_Pagamento(idCondPag);
		os.setObservacao(observacao);
		os.setOrdenar(ordenar);
		os.setStatus("Em Andamento");
		os.setIdSolicitante(idSolicitante);
		
		OSDAO osdao = new OSDAO();
		osdao.adiciona(os);		
		
		OSDAO osdao2 = new OSDAO();
		int idOS = osdao2.getLast();
	
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_os_has_caixas.jsp?idOS="+idOS+"&idCliente="+idCliente+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

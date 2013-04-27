package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Cliente;
import Dao_OLD.ClienteDAO;
import Dao_OLD.OS;
import Dao_OLD.OSDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class MonitoraOSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		int cont = 0;

		GregorianCalendar calendar = new GregorianCalendar();  
		int diaAtual = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		String mes = Integer.toString(calendar.get(GregorianCalendar.MONTH)+1);
		if (mes.length()==1)
			mes = "0"+mes;
		
		String sql = "select * from os where dataEntrega like \"%/"+mes+"/%\"";
		
		System.out.println(sql);
		
		OSDAO osdao = new OSDAO();
		List<OS> oss = osdao.getConsulta(sql);
		
		out.println("<html>");
		out.println("<body>");
		out.println( " <script> "+  
							"function confirmExclusao(id) {"+  
							"if (confirm(\"Tem certeza que deseja excluir essa os?\")) {"+  
								"location.href=\"removeOS?idOS=\"+id;"+  
							"}"+  	
						"}"+  
						"</script>  ");		
		out.println("<table cellspacing=\"1\" cellpadding=\"1\" border=\"3\">");
		out.println("<tr><td>Código</td><td>Cliente</td><td>Lançamento</td><td>Entrega</td><td>Status</td></tr>");
		if (oss.isEmpty()){
			out.println("<h3> Não há oss cadastradas com essa especificação!</h3>");
		}else for(OS os : oss){
			ClienteDAO cdao = new ClienteDAO();
			Cliente c = cdao.getCliente(os.getIdCliente());
			int dia = Integer.parseInt(os.getDataEntrega().substring(0, 2));
			if(os.getStatus().equals("Aberta") || os.getStatus().equals("Em Andamento")){
				if(dia-diaAtual>3){
					out.println("<tr bgcolor=\"#009900\">");
				}else if(dia-diaAtual<3 && dia-diaAtual>0){ 
					out.println("<tr bgcolor=\"#FFFF00\">");
				}else if(dia-diaAtual<=0){
					out.println("<tr bgcolor=\"#FF0000\">");
				}
			}else{
				out.println("<tr>");
			}
			out.println(	
								"<td>"+os.getIdOS()+"</td>" +
								"<td>"+c.getFantasia()+"</td>" +
								"<td>"+os.getDataLancamento()+"</td>" +
								"<td>"+os.getDataEntrega()+"</td>" +
								"<td>"+os.getStatus()+"</td>" +
							"</tr>"
			);
			//"<a href=exibe_produto.jsp?idProduto="+p.getIdProduto()+">"+p.getDescricao()+"</a><br>");
			cont++;
		}
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

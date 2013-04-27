package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Caixa;
import Dao_OLD.CaixaDAO;
import Dao_OLD.Cliente;
import Dao_OLD.ClienteDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class ConsultaCaixaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		String sql;
		// pegndo os parâmetros do request
		String parametro = request.getParameter("parametro");
		String dimensao = request.getParameter("dimensao");
		String valor = request.getParameter("valor");
		if(dimensao.equals("igual")) dimensao="=";
		else if(dimensao.equals("maior")) dimensao=">";
		else if(dimensao.equals("menor")) dimensao="<";
		else if(dimensao.equals("contem")){
			dimensao = "like";
			valor = "%"+valor+"%";
		}
		else if(dimensao.equals("ncontem")){
			dimensao = "not like";
			valor = "%"+valor+"%";
		}
		
		
		if (dimensao == "like" || dimensao == "not like"){
			sql = "select * from caixas where "+parametro+" "+ dimensao + " " +"\""+valor+"\"";
			System.out.println("Sql %");
		}
		
		sql = "select * from caixas where "+parametro+" "+ dimensao + " " +"\""+valor+"\"";
		
		System.out.println(sql);
		
		CaixaDAO caixadao = new CaixaDAO();
		List<Caixa> caixas = caixadao.getConsulta(sql);
		
		out.println("<html>");
		out.println("<body>");
		out.println( " <script> "+  
							"function confirmExclusao(id) {"+  
							"if (confirm(\"Tem certeza que deseja excluir essa caixa?\")) {"+  
								"location.href=\"removeCaixa?idCaixa=\"+id;"+  
							"}"+  	
						"}"+  
						"</script>  ");		
		out.println("<center><table cellspacing=\"1\" cellpadding=\"1\" border=\"3\">");
		out.println("<tr><td>Código</td><td>Caixa</td><td>Cliente</td><td>Patrimônio</td></tr>");
		if (caixas.isEmpty()){
			out.println("<h3> Não há caixas cadastradas com essa especificação!</h3>");
		}else for(Caixa caixa : caixas){
			ClienteDAO cdao = new ClienteDAO();
			Cliente c = cdao.getCliente(caixa.getIdCliente());
			out.println("<tr><td>"+caixa.getIdCaixa()+"</td><td>"+caixa.getCaixa()+"</td>" +
						"<td>"+c.getFantasia()+"</td><td>"+caixa.getPatrimonio()+"</td>" +
						"<td><a href=exibe_caixa.jsp?idCaixa="+caixa.getIdCaixa()+">" +
						"Visualizar</a></td><td><a href=javascript:confirmExclusao("+caixa.getIdCaixa()+")>Remover</a>" +
						"</td></tr>");
		}
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

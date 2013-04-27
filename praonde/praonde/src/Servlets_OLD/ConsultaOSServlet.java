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
import Dao_OLD.OS;
import Dao_OLD.OSDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class ConsultaOSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		int cont = 0;

		String sql;
		
		String codigo = request.getParameter("codigo");
		String razao_social = request.getParameter("razao_social");
		String fantasia = request.getParameter("fantasia");
		String especialidade = request.getParameter("especialidade");
		String status = request.getParameter("status");
		//String mes = request.getParameter("mes");
		String patrimonio = request.getParameter("patrimonio");
		
		if(codigo.equals("")==false){
			codigo = " idOS = " + codigo;
		}else{
			codigo = "1";
		}
		
		if(status.equals("")==false){
			status = " status = \"" + status +"\"";
		}else{
			status = "1";
		}
		
		if(patrimonio.equals("")==false){
			String codigosCaixa = null;
			CaixaDAO cdao = new CaixaDAO();
			List<Caixa> caixas = cdao.getConsulta("select * from caixas where patrimonio like \"%"+fantasia+"%\"");
			for(Caixa c:caixas){
				if(codigosCaixa==null)
					codigosCaixa = Integer.toString(c.getIdCaixa());
				else
					codigosCaixa = codigosCaixa+ ", " + c.getIdCaixa();
			}
			patrimonio = " idCaixa in ("+codigosCaixa+")";
		}else{
			patrimonio = " 1 ";
		}	
		
		if(razao_social.equals("")==false){
			String codigosCliente = null;
			ClienteDAO cdao = new ClienteDAO();
			List<Cliente> cs = cdao.getConsulta("select * from clientes where nome like \"%"+razao_social+"%\"");
			for(Cliente c:cs){
				if(codigosCliente==null)
					codigosCliente = Integer.toString(c.getIdCliente());
				else
					codigosCliente = codigosCliente+ ", " + c.getIdCliente();
			}
			razao_social = " idCliente in ("+codigosCliente+")";
		}else{
			razao_social = " 1 ";
		}
			
		if(fantasia.equals("")==false){
			String codigosCliente = null;
			ClienteDAO cdao = new ClienteDAO();
			List<Cliente> cs = cdao.getConsulta("select * from clientes where fantasia like \"%"+fantasia+"%\"");
			for(Cliente c:cs){
				if(codigosCliente==null)
					codigosCliente = Integer.toString(c.getIdCliente());
				else
					codigosCliente = codigosCliente+ ", " + c.getIdCliente();
			}
			fantasia = " idCliente in (" + codigosCliente + ")";
		}else{
			fantasia = " 1 ";
		}
		
		if(especialidade.equals("")==false){
			String codigosCaixa = null;
			CaixaDAO cdao = new CaixaDAO();
			List<Caixa> caixas = cdao.getConsulta("select * from caixas where caixa like \"%"+fantasia+"%\"");
			for(Caixa c:caixas){
				if(codigosCaixa.equals(""))
					codigosCaixa = codigosCaixa + c.getIdCaixa();
				else
					codigosCaixa = codigosCaixa+ ", " + c.getIdCaixa();
			}
			especialidade = " idCaixa in ("+codigosCaixa+")";
		}else{
			especialidade = " 1 ";
		}
		
		sql = "select * from os where " + codigo + " and " + status + " and " + patrimonio + " and " + razao_social + " and " + 
		fantasia + " and " + especialidade;
		
		System.out.println("SQL: " + sql);
		
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
		out.println("<center><table cellspacing=\"1\" cellpadding=\"1\" border=\"3\">");
		out.println("<tr><td>Código</td><td>Cliente</td><td>Lançamento</td><td>Entrega</td><td>Status</td></tr>");
		if (oss.isEmpty()){
			out.println("<h3> Não há oss cadastradas com essa especificação!</h3>");
		}else for(OS os : oss){
			ClienteDAO cdao = new ClienteDAO();
			Cliente c = cdao.getCliente(os.getIdCliente());
			out.println("<tr><td>"+os.getIdOS()+"</td><td>"+c.getFantasia()+"</td><td>"+os.getDataLancamento()+"</td>" +
						"<td>"+os.getDataEntrega()+"</td><td>"+os.getStatus()+"</td>" +
						"<td><a href=exibe_os.jsp?idOS="+os.getIdOS()+">" +
						"Visualizar</a></td><td><a href=javascript:confirmExclusao("+os.getIdOS()+")>Remover</a>" +
						"</td></tr>");
			//"<a href=exibe_produto.jsp?idProduto="+p.getIdProduto()+">"+p.getDescricao()+"</a><br>");
			cont++;
		}
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

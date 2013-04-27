package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Cliente;
import Dao_OLD.ClienteDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class ConsultaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		int cont = 0;

		String sql;
		// pegndo os parâmetros do request
		
		String razao_social = request.getParameter("razao_social");
		String fantasia = request.getParameter("fantasia");
		String cnpj = request.getParameter("cnpj");
		String cpf = request.getParameter("cpf");
		
		if(razao_social.equals("")==false){
			razao_social = " nome like \"%" + razao_social +"%\"";
		}else{
			razao_social = "1";
		}
		
		if(fantasia.equals("")==false){
			fantasia = " fantasia like \"%" + fantasia + "%\"";
		}else{
			fantasia = " 1 ";
		}
		
		if(cnpj.equals("")==false){
			cnpj = " cnpj = \"" + cnpj + "\"";
		}else{
			cnpj = " 1 ";
		}
		
		if(cpf.equals("")==false){
			cpf = " cpf = \"" + cpf + "\"";
		}else{
			cpf = " 1 ";
		}
		
		sql = "select * from clientes where " + razao_social + " and " + fantasia + " and " + cnpj + " and " + cpf;

		System.out.println(sql);
		
		ClienteDAO cd = new ClienteDAO();
		List<Cliente> clientes = cd.getConsulta(sql);
		
		out.println("<html>");
		out.println("<body>");
		out.println( " <script> "+  
							"function confirmExclusao(id) {"+  
							"if (confirm(\"Tem certeza que deseja excluir esse cliente?\")) {"+  
								"location.href=\"removeCliente?idCliente=\"+id;"+  
							"}"+  	
						"}"+  
						"</script>  ");		
		out.println("<center><table cellspacing=\"1\" cellpadding=\"1\" border=\"3\">");
		out.println("<tr><td>Código</td><td>Nome</td><td>Fantasia</td><td>Telefone</td></tr>");
		if (clientes.isEmpty()){
			out.println("<h3> Não há clientes cadastradas com essa especificação!</h3>");
		}else for(Cliente cliente : clientes){
			ClienteDAO cdao = new ClienteDAO();
			Cliente c = cdao.getCliente(cliente.getIdCliente());
			out.println("<tr><td>"+c.getIdCliente()+"</td><td>"+c.getNome()+"</td><td>"+c.getFantasia()+"</td>" +
						"<td>"+c.getTelefone()+
						"<td><a href=exibe_cliente.jsp?idCliente="+cliente.getIdCliente()+">" +
						"Visualizar</a></td><td><a href=javascript:confirmExclusao("+cliente.getIdCliente()+")>Remover</a>" +
						"</td></tr>");
			//"<a href=exibe_produto.jsp?idProduto="+p.getIdProduto()+">"+p.getDescricao()+"</a><br>");
			cont++;
		}
		out.println("</body>");
		out.println("</html>");	
		
/**		
		out.println("<html>");
		out.println("<body>");
		if (clientes.isEmpty()){
			out.println("<h3> Não há clientes cadastrados com essa especificação!</h3>");
		}else for(Cliente cliente : clientes){
			ClienteDAO cdao = new ClienteDAO();
			Cliente c = cdao.getCliente(cliente.getIdCliente());
			out.println("<tr><td>"+cliente.getIdCliente()+"</td><td>"+cliente.getFantasia()+"</td><td>"+os.getDataLancamento()+"</td>" +
						"<td>"+os.getDataEntrega()+"</td><td>"+os.getStatus()+"</td>" +
						"<td><a href=exibe_os.jsp?idOS="+os.getIdOS()+">" +
						"Visualizar</a></td><td><a href=javascript:confirmExclusao("+os.getIdOS()+")>Remover</a>" +
						"</td></tr>");
			//"<a href=exibe_produto.jsp?idProduto="+p.getIdProduto()+">"+p.getDescricao()+"</a><br>");
			cont++;
		}
		
	/**	}else for(Cliente c : clientes){
			out.println("<a href=exibe_cliente.jsp?idCliente="+c.getIdCliente()+">"+c.getFantasia()+"</a><br>");
			cont++;
		}
	**/	
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

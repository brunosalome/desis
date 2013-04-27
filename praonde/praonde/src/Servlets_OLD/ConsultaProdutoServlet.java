package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Dao_OLD.Produto;
import Dao_OLD.ProdutoDAO;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class ConsultaProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		int cont = 0;

		String sql;
		// pegndo os parâmetros do request
		String descricao = request.getParameter("descricao");
		String codigo = request.getParameter("codigo");
		if(descricao!=null && descricao.equals("")==false){
			sql = "select * from produtos where descricao like \"%" + descricao +"%\"";	
		}else if (codigo!=null && codigo.equals("")==false){
			sql = "select * from produtos where idProduto = " + codigo;
		}else{
			sql = "select * from produtos";
		}
		
		ProdutoDAO pd = new ProdutoDAO();
		List<Produto> produtos = pd.getConsulta(sql);
		
		out.println("<html>");
		out.println("<body>");
		out.println( " <script> "+  
							"function confirmExclusao(id) {"+  
							"if (confirm(\"Tem certeza que deseja excluir esse produto?\")) {"+  
								"location.href=\"removeProduto?idProduto=\"+id;"+  
							"}"+  	
						"}"+  
						"</script>  ");		
		out.println("<center><table cellspacing=\"1\" cellpadding=\"1\" border=\"3\">");
		out.println("<tr><td>Código</td><td>Descrição</td><td>Barras</td><td>Valor</td></tr>");
		if (produtos.isEmpty()){
			out.println("<h3> Não há produtos cadastrados com essa especificação!</h3>");
		}else for(Produto p : produtos){
			out.println("<tr><td>"+p.getIdProduto()+"</td><td>"+p.getDescricao()+"</td><td>"+p.getBarras()+"</td>" +
						"<td>R$"+p.getValor()+"</td><td><a href=edita_produto.jsp?idProduto="+p.getIdProduto()+">" +
						"Alterar</a></td><td><a href=javascript:confirmExclusao("+p.getIdProduto()+")>Remover</a>" +
						"</td></tr>");
			//"<a href=exibe_produto.jsp?idProduto="+p.getIdProduto()+">"+p.getDescricao()+"</a><br>");
			cont++;
		}	
		out.println("</body>");
		out.println("</html>");	
		
	}	
}

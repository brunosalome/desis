<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     	<script>
	     	function confirmExclusao(id, idCaixa) {  
				if (confirm("Tem certeza que deseja excluir esse item da caixa?")) {  
					location.href="removeCaixa_has_Produtos?idCaixa_has_produtos="+id+"&idCaixa="+idCaixa;  
				}  	
			}  
	     	</script>
	     	<center>
	     	<form action="edita_caixa.jsp">
	     	<h2>Caixa:</h2>
	     	<table cellspacing="1" cellpadding="1" border="3"> 
	     	<tr>
	     	<%
	     	CaixaDAO dao = new CaixaDAO();
	     	Caixa caixa;
	     	int idCaixa = 0; 	
	     	if(request.getParameter("idCaixa") != null){
	     		idCaixa = Integer.parseInt(request.getParameter("idCaixa"));
	     	}
	     	caixa = dao.getCaixa(idCaixa);
	     	
	     	ClienteDAO cdao = new ClienteDAO();
	     	Cliente cliente;
	     	cliente = cdao.getCliente(caixa.getIdCliente());
	     	
			String patrimonio = caixa.getPatrimonio();
			int idContato = caixa.getIdContato();
			ContatoDAO contdao = new ContatoDAO();
			Contato contato = contdao.getContato(idContato);
			
	     	%>
	     	<td><center>Especialidade:</center></td>
	     	<td><%=idCaixa%> - <%=caixa.getCaixa()%></td>
	     	</tr>
	     	<tr>
	     	<td><center>Cliente:</center></td>
	     	<td><%=cliente.getIdCliente() + " - " + cliente.getFantasia()%> </td>
	     	</tr>
	     	<tr>
	     	<td><center>Sigla do patrimônio:</center> </td>
	     	<td> <%=patrimonio%> </td>
	     	</tr>
	     	<tr>
	     	<td><center>Responsável:</center> </td>
	     	<td> <%=contato.getNome()%> </td>
	     	</tr>
	     	</table>
	      	<br>
	      	<br>
			<input type="hidden" value="<%=idCaixa %>" name="idCaixa" />
	      	<input type="submit" value="Editar" />	
	      	</form>

			
			<form action="adiciona_caixa_has_produtos.jsp?idCaixa=<%=idCaixa%>">
	     	<h2>Itens:</h2>
	     	<table cellspacing="1" cellpadding="1" border="3"> 
	     	<tr>
	     	<td>
	     		Código
	     	</td>
	     	<td>
	     		Produto
	     	</td>
	     	<td>
	     		Quantidade
	     	</td>
	     	<td>
	     		Patrimônio do Item
	     	</td>
	     	</tr>
	     	<tr>
	     	<%
	     		Caixa_has_ProdutosDAO chpdao = new Caixa_has_ProdutosDAO();
	     		     	List<Caixa_has_Produtos> chps = chpdao.getCHPsOS(idCaixa);
	     		     	
	     		     	ProdutoDAO pdao = new ProdutoDAO();
	     		     	
	     		     	for(Caixa_has_Produtos chp : chps){
	     		     		Produto p = pdao.getProduto(chp.getIdProduto());
	     	%>
	     	<td><%= p.getIdProduto()%></td>
	     	<td><%= p.getDescricao()%></td>
	     	<td><%= chp.getQuantidade()%></td>
<!--     	<td>R$ <%= p.getValor()*chp.getQuantidade()%></td> !-->
	     	<%if(chp.getPatrimonio()!=null){%>
	     		<td><%= chp.getPatrimonio()%></td>
	     	<%}else{%>
	     		<td></td>
	     	<%}%>
	     	<td><a href="edita_caixa_has_produtos.jsp?idCaixa_has_Produtos=<%=chp.getIdCaixa_has_Produtos()%>">Editar</a></td>
	     	<td><a href=javascript:confirmExclusao(<%=chp.getIdCaixa_has_Produtos()%>,<%=idCaixa%>)>Remover</a></td>
	     	</tr>
	     	<%
	     	}
	     	%>
	     	</table>
	      	<br>
	      	<br>
	      	<input type="hidden" value="<%=idCaixa%>" name="idCaixa" />
	      	<input type="hidden" value="on" name="patrimonioCliente" />				
	      	<input type="submit" value="Adicionar" />		
			</form>
		    </center>         
	     	</body>
   </html>

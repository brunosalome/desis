<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	     	<%
	     	ProdutoDAO dao = new ProdutoDAO ();
	     	Produto produto;
	     	int idProduto = 0;
	     	if(request.getParameter("idProduto") != null)
	     		idProduto = Integer.parseInt(request.getParameter("idProduto"));

	     	produto = dao.getProduto(idProduto);
	     	
	     	String descricao = produto.getDescricao();	     		     	
	     	int barras = produto.getBarras();
	     	double valor = produto.getValor();
	     	
	     	ContatoDAO contatoDAO = new ContatoDAO();
	     	List<Contato> contatos = contatoDAO.getListaRelacionada(idProduto); 
	%>
	<html>
	     <body>
			<center>
	     	<form action="edita_produto.jsp">
		     	<h2>Informações do Produto:</h2>
		     	<table cellspacing="1" cellpadding="1" border="3"> 
			     	<% if(produto.getDescricao()!=null )if( produto.getDescricao().trim()!=""){%>
			     	<tr>
			     		<td><center>Descrição:</center></td>
			     		<td><%= produto.getDescricao()%></td>
			     	</tr>
			     	<%}%>
			     	<% if(produto.getBarras()!=0 ){%>
			     	<tr>
				     	<td><center>Código de Barras: </center></td>
				     	<td><%= produto.getBarras() %></td>
			     	</tr>
			     	<%}%>
<!-- 
			     	<% if(produto.getValor()!=0 ){%>
			     	<tr>
				     	<td><center>Valor:</center></td>
						<td> R$ <%=produto.getValor() %> </td>
					</tr>
					<%}%>
!-->
				</table>
		      	<br>
		      	<br>
		      	<input type="hidden" name="idProduto" value="<%=idProduto %>"/>
		      	<input type="submit" value="Editar" />		
				
			</form>
			</center>       
	     	</body>
   </html>

<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <%
	     CorDAO cd = new CorDAO();
	     List<Cor> cores = cd.getLista();
	     %>
		
		<script>
			function confirmExclusao(id) {  
				if (confirm("Tem certeza que deseja excluir essa cor?")) {  
					location.href="removeCor?idCor="+id;  
				}  	
			}  
		</script>	
		<center>	
		<table cellspacing="1" cellpadding="1" border="3">
		<tr>
		<td>
			Código
		</td>
		<td>
			Descrição
		</td>
		</tr>
		<% if (cores.isEmpty()){ %>
			<h3> Não há cores cadastradas com essa especificação!</h3>
		<% }else for(Cor c : cores){ %>
			<tr>
			<td>	
				<%=c.getIdCor()%>
			</td>
			<td>
				<%=c.getCor()%>
			</td>
			<td>
				<a href=edita_cor.jsp?idCor=<%=c.getIdCor()%>>Alterar</a>
			</td>
			<td>
				<a href=javascript:confirmExclusao(<%=c.getIdCor()%>)>Remover</a>
			</td>
			</tr>
			<%}%>
			</table>
          </center>         
	     </body>
   </html>

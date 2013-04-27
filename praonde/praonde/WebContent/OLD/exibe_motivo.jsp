<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	     	<%
	     	MotivoDAO dao = new MotivoDAO ();
	     	Motivo motivo;
	     	int idMotivo = 0;
	     	if(request.getParameter("idMotivo") != null)
	     		idMotivo = Integer.parseInt(request.getParameter("idMotivo"));

	     	motivo = dao.getMotivo(idMotivo);
	     	
	     	String descricao_motivo = motivo.getMotivo();
	%>
	<html>
	     <body>
			<center>
	     	<form action="edita_os.jsp">
		     	<h2>Ordem de serviço:</h2>
		     	<table cellspacing="1" cellpadding="1" border="3"> 
			     	<% if(motivo.getMotivo()!=null )if( motivo.getMotivo().trim()!=""){%>
			     	<tr>
			     		<td><center>Motivo:</center></td>
			     		<td><%= motivo.getMotivo()%></td>
			     	</tr>
			     	<%}%>
				</table>
		      	<br>
		      	<br>
		      	<input type="hidden" name="idMotivo" value="<%=idMotivo %>"/>
		      	<input type="submit" value="Editar" />		
				
			</form>
			</center>       
	     	</body>
   </html>

<%@ page import="java.util.*, Dao.*, Servlets.*" %>
<% 
	int quantidade = Integer.parseInt(request.getParameter("quantidade"));
	int idOS_has_Produtos = Integer.parseInt(request.getParameter("idOS_has_Produtos"));
%>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	 	function valida() {
	 		if(form1.quantidade.value><%=quantidade%>) {
	 			alert("Há mais produtos quebrados do que existentes na caixa!");
	 			document.form1.quantidade.focus();
	 			return false;
	 		}else if (form1.quantidade.value==""){
	 			alert("Informe a quantidade de peças sem conserto!");
	 			document.form1.quantidade.focus();
	 			return false;
	 		}else{
	 			return true;
	 		}
	 	}
	 	</script>
	     <center>
	     	<form name="form1" action="adiciona_sem_consertoServlet" onSubmit="return (valida())">
		     	<font color="blue"><b>Adicionar Sinalização de Não-Conserto</b></font>
			     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
			     	<tr >
			     		<td width="239">Dados gerais: </td>
			     	</tr>
			     	<tr >
			     		<td width="239">Motivos do não-conserto: </td>
			     	</tr>
			     	<tr valign="top">
			     		<td >
					     	<table cellspacing="1" cellpadding="1" border="0"> 
					     <% for (int contador = 1; contador<=quantidade; contador++){%>
					     	<tr>
					     		<td nowrap>
					     			Peça <%=contador%>:
					     		</td>
					     		<td>
						     		<select name="motivo1<%=contador%>">
						     			<option value=0></option>
							     	  	<%
							     		MotivoDAO mdao = new MotivoDAO();
							     		List<Motivo> motivos = mdao.getLista();
							     		for (Motivo m : motivos){
							     		%>
							     	    <option value=<%=m.getIdMotivo()%>><%=m.getMotivo()%></option>
								     	<%
								     		}
								     	%>	     	    
						     	    </select>
						     	</td>
						     	<td>
						     		<select name="motivo2<%=contador%>">
						     			<option value=0></option>
							     	  	<%
							     		for (Motivo m : motivos){
							     		%>
							     	    <option value=<%=m.getIdMotivo()%>><%=m.getMotivo()%></option>
								     	<%
								     		}
								     	%>	     	    
						     	    </select>
						     	</td>
						     	<td>
						     		<select name="motivo3<%=contador%>">
						     			<option value=0></option>
							     	  	<%
							     		for (Motivo m : motivos){
							     		%>
							     	    <option value=<%=m.getIdMotivo()%>><%=m.getMotivo()%></option>
								     	<%
								     		}
								     	%>	     	    
						     	    </select>
						     	</td>
					     	</tr>
					     	<%}%>
					     	</table>
				     	</td>
					</tr>
					</table>
				<br /><br />
				<input type="hidden" name="quantidade" value="<%=quantidade%>" />
				<input type="hidden" name="idOS_has_Produtos" value="<%=idOS_has_Produtos%>" />
				<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
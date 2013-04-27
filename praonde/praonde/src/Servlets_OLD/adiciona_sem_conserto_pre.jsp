<%@ page import="java.util.*, Dao.*, Servlets.*" %>
<% 
	int idOS_has_Produtos = Integer.parseInt(request.getParameter("idOsHasProdutos"));
	int quantidade_maxima = Integer.parseInt(request.getParameter("quantidade"));	
%>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	 	function valida() {
	 		if(form1.quantidade.value><%=quantidade_maxima%>) {
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
	     	<form name="form1" action="adiciona_sem_conserto.jsp" onSubmit="return (valida())">
		     	<font color="blue"><b>Adicionar Sinalização de Não-Conserto</b></font>
			     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
			     	<tr >
			     		<td width="239">Dados gerais: </td>
			     	</tr>
			     	<tr valign="top">
			     		<td >
					     	<table cellspacing="1" cellpadding="1" border="0"> 
					     	<tr>
					     		<td nowrap>
					     			Quantidade de peças sem conserto: 
					     		</td>
					     		<td>
					     	 		<input type="text" name="quantidade" size="3">
					     	 	</td>
					     	</tr>
					     	</table>
				     	</td>
					</tr>
					</table>
				<br /><br />
				<input type="hidden" name="idOS_has_Produtos" value="<%=idOS_has_Produtos%>" />
				<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
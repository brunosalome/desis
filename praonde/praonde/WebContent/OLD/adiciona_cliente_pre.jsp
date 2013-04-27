<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <center>
	     	<form name="form1" action="adiciona_cliente.jsp">
		     	<font color="blue"><b>Adicionar Cliente</b></font>
			     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
			     	<tr >
			     		<td width="239">Dados gerais: </td>
			     	</tr>
			     	<tr valign="top">
			     		<td >
					     	<table cellspacing="1" cellpadding="1" border="0"> 
					     	<tr>
					     		<td>Tipo: </td>
					     		<td><label for="tipo"></label>
					     	 	<select name="tipo" size="1" id="tipo">
					     	   		 <option>Pessoa Física</option>
					     	   		 <option>Pessoa Jurídica</option>
				     	      	</select></td>
					     	</tr>
					     	</table>
				     	</td>
					</tr>
					</table>
				<br /><br />
				<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
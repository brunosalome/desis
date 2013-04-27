<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	 	function valida() {
	 		patrimonio = document.form1.patrimonio.value;
	 		
	 		if(patrimonio=="") {
	 			alert("Insira ao menos a descrição!");
	 			document.form1.patrimonio.focus();
	 			return false;
	 		}else{
	 			return true;
	 		} 
	 	} 
	     </script>
	     	<center>
	     	<form name="form1" action="adicionaPatrimonio" onSubmit="return (valida())">
	     	<h3>Adicionar Patrimônio</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr > 
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0">
	     	<tr>
	     	<td>Patrimônio: </td>
	     	<td><input type="text" name="patrimonio" /></td>
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
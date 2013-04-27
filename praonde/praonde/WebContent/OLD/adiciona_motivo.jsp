<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		fantasia = document.form1.motivo.value;
	 		
	 		if(fantasia=="") {
	 			alert("Insira ao menos o motivo!");
	 			document.form1.motivo.focus();
	 			return false;
	 		}else{
	 			return true;
	 		} 
	 	} 
	     </script>
	     <center>
	     	<form name="form1" action="adicionaMotivo" onSubmit="return (valida())">
	     	<font color="green"><b>Adicionar Motivo de Negação</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr > 
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0">
	     	<tr>
	     	<td>Motivo: </td>
	     	<td><input type="text" name="motivo" onkeyup="javascript:alta(this);"/></td>
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
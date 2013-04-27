<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		cor = document.form1.cor.value;
	 		
	 		if(cor=="") {
	 			alert("Insira ao menos a cor!");
	 			document.form1.cor.focus();
	 			return false;
	 		}else{
	 			return true;
	 		} 
	 	} 
	     </script>
	     <center>
	     	<form name="form1" action="adicionaCor" onSubmit="return (valida())">
	     	<font color="orange"><b>Adicionar Cor</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr > 
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0">
	     	<tr>
	     	<td>Cor: </td>
	     	<td><input type="text" name="cor" onkeyup="javascript:alta(this);"/></td>
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
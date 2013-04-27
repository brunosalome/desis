<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		condicao_Pagamento = document.form1.condicao_Pagamento.value;
	 		
	 		if(condicao_Pagamento=="") {
	 			alert("Preencha os campos");
	 			document.form1.condicao_Pagamento.focus();
	 			return false;
	 		}else{
	 			return true;
	 		} 
	 	} 
	     </script>
	     <center>
	     	<form name="form1" action="adicionaCondicaoPagamento" onSubmit="return (valida())">
	     	<font color="black"><b>Adicionar Condição de Pagamento</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr > 
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0">
	     	<tr>
	     	<td>Condição de Pagamento: </td>
	     	<td><input type="text" name="condicao_pagamento" onkeyup="javascript:alta(this);" /></td>
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
<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
		 	function valida() {
		 		descricao = document.form1.descricao.value;
		 		
		 		if(descricao=="") {
		 			alert("Insira o nome do fornecedor!");
		 			document.form1.descricao.focus();
		 			return false;
		 		}else{
		 			return true;
		 		}
		 	}
	 	</script>
	 	<center>
	 		<form name="form1" action="adicionaFornecedor" onSubmit="return (valida())">
	     	<h3>Adicionar Fornecedor</h3>
	     	<table cellspacing="1" cellpadding="1" border="3"> 
	     	<tr >
	     	<td>Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Descrição: </td>
	     	<td><input type="text" name="descricao" onkeyup="javascript:alta(this);"/></td>
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
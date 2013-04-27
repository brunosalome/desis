<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		fantasia = document.form1.fantasia.value;
	 		
	 		if(fantasia=="") {
	 			alert("Insira ao menos o nome fantasia do cliente!");
	 			document.form1.fantasia.focus();
	 			return false;
	 		}else{
	 			return true;
	 		} 
	 	}
	 	function mascara(src, mask){
	 	var i = src.value.length;
	 	var saida = mask.substring(0,1);
	 	var texto = mask.substring(i);
	 	if (texto.substring(0,1) != saida)
	 	{
	 	src.value += texto.substring(0,1);
	 	}
	 	} 
	 	 function troca(c){
		     campo=c;
		     setTimeout("exec_troca()",1);
		 }
		 function exec_troca(){
			 campo.value=virgula(campo.value);
		 }
		 function virgula(texto){
			 texto=texto.replace(",",".");
			 return texto;
		 }
	 	
	     </script>     
	     	<center>
	     	<form name="form1" action="adicionaProduto" onSubmit="return (valida())">
	     	<font color="red"><b>Adicionar Instrumento</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr > 
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0">
	     	<tr>
	     	<td>Descrição: </td>
	     	<td><input type="text" name="descricao" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	  <td>Código de barras: </td>
	     	  <td><input type="text" name="barras" /></td>
	     	  </tr>
	     	<tr>
	     	  <td>Valor:</td>
	     	  <td><input type="text" name="valor"  onkeypress="troca(this)"/></td>
	     	</tr>
	     	<tr>
	     	  <td>Item duplo:</td>
	     	  <td><input type="checkbox" name="duplo" /></td>
	     	</tr>
	     	<tr>
	     	  <td>Último da OS:</td>
	     	  <td><input type="checkbox" name="ultimo" /></td>
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
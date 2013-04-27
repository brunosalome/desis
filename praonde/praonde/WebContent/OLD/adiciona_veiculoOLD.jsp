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
	     </script>
	     <% String tipo = request.getParameter("tipo");%>
	     <%System.out.println(tipo);%>
	     <center>
	     	<form name="form1" action="adicionaVeiculo" onSubmit="return (valida())">
	     	<font color="blue"><b>Adicionar Veículo</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Marca: </td>
	     	<td><input type="text" name="nome"/></td>
	     	</tr>
	     	<tr>
	     	<td>Modelo: </td>
	     	<td><input type="text" name="fantasia"/></td>
	     	</tr>
	     	<tr>
	     	<td>Cor: </td>
	     	<td><input type="text" name="senha"/></td>
	     	</tr>
	     	<tr>
	     	<td>Placa: </td> 
	     	<td><input type="text" name="cpf" onKeyPress="mascara(this, '###.###.###-##')" maxlength=14/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="tipo" size="1" id="tipo" value="<%=tipo%>">
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
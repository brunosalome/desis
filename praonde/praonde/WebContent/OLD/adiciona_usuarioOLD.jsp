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
	     	<form name="form1" action="adicionaUsuario" onSubmit="return (valida())">
	     	<font color="blue"><b>Adicionar Usuário</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Nome: </td>
	     	<td><input type="text" name="nome"/></td>
	     	</tr>
	     	<tr>
	     	<td>Email: </td>
	     	<td><input type="text" name="fantasia"/></td>
	     	</tr>
	     	<tr>
	     	<td>Senha: </td>
	     	<td><input type="text" name="senha"/></td>
	     	</tr>
	     	<tr>
	     	<td>CPF: </td> 
	     	<td><input type="text" name="cpf" onKeyPress="mascara(this, '###.###.###-##')" maxlength=14/></td>
	     	</tr>
	     	<tr>
	     	<td>Endereço: </td>
	     	<td><input type="text" name="endereco" /></td>
	     	</tr>
	     	<tr>
	     	<td>Cidade: </td>
	     	<td><input type="text" name="cidade" /></td>
	     	</tr>
	     	<tr>
	     	<td>País: </td>
	     	<td><input type="text" name="pais" /></td>
	     	</tr>
	     	<tr>
	     	<td>Celular: </td>
	     	<td><input type="text" name="celular" onKeyPress="mascara(this, '##.#####-####')" maxlength=12/></td>
	     	</tr>
	     	<tr>
	     	<td>Telefone: </td>
	     	<td><input type="text" name="telefone" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
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
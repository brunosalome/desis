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
	     	<form name="form1" action="adicionaCliente" onSubmit="return (valida())">
	     	<font color="blue"><b>Adicionar Cliente</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Nome: </td>
	     	<td><input type="text" name="nome" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Fantasia: </td>
	     	<td><input type="text" name="fantasia" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<%if (tipo.equals("Pessoa Jurídica")){%>
	     	<tr>
	     	<td>CNPJ: </td>
	     	<td><input type="text" name="cnpj" onKeyPress="mascara(this, '##.###.###/####-##')" maxlength=18 /></td>
	     	</tr>
	     	<%}%>
	     	<%if (tipo.equals("Pessoa Física")){%>
	     	<tr>
	     	  <td>RG:</td>
	     	  <td><input type="text" name="rg" onKeyPress="mascara(this, '##.###.###-##')" maxlength=18 /></td>
	     	  </tr>
	     	<tr>
	     	<td>CPF: </td> 
	     	<td><input type="text" name="cpf" onKeyPress="mascara(this, '###.###.###-##')" maxlength=14/></td>
	     	</tr>
	     	<tr>
	     	<%}%>
	     	<%if (tipo.equals("Pessoa Jurídica")){%>
	     	<td>Inscrição Estadual: </td>
	     	<td><input type="text" name="ie" /></td>
	     	</tr>
	     	<tr>
	     	  <td>CCM:</td>
	     	  <td><input type="text" name="ccm" /></td>
	     	  </tr>
	     	<tr>
	     	<%}%>
	     	<td>CEP: </td>
	     	<td><input type="text" name="cep" onKeyPress="mascara(this, '#####.###')" maxlength=9/></td>
	     	</tr>
	     	<tr>
	     	<td>Endereço: </td>
	     	<td><input type="text" name="rua" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Número: </td>
	     	<td><input type="text" name="numero" /></td>
	     	</tr>
	     	<tr>
	     	  <td>Complemento: </td>
	     	  <td><input type="text" name="complemento" onkeyup="javascript:alta(this);"/></td>
	     	  </tr>
	     	<tr>
	     	<td>Bairro: </td>
	     	<td><input type="text" name="bairro" onkeyup="javascript:alta(this);")/></td>
	     	</tr>
	     	<tr>
	     	  <td>Município: </td>
	     	  <td><input type="text" name="municipio" onkeyup="javascript:alta(this);"/></td>
	     	  </tr>
	     	<tr>
	     	  <td>Estado: </td>
	     	  <td><input type="text" name="estado" onkeyup="javascript:alta(this);" onkeyup="javascript:alta(this);"/></td>
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
<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		nome = document.form1.nome.value;
	 		
	 		if(nome=="") {
	 			alert("Insira ao menos o nome do contato!");
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
	     <%
	     	int idCliente = Integer.parseInt(request.getParameter("idCliente"));
	     	System.out.println("IdCliente:"+idCliente);
	     %>
	     <center>
	     	<form name="form1" action="adicionaContato" onSubmit="return (valida())">
	     	<font color="blue"><b>Adicionar Contato</b></font>
	     	<table width="320" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="308">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table width="312" border="0" cellpadding="1" cellspacing="1"> 
	     	<tr>
	     	<td width="157">Nome: </td>
	     	<td width="144"><input type="text" name="nome" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Cargo: </td>
	     	<td><input type="text" name="cargo" onkeyup="javascript:alta(this);" /></td>
	     	</tr>
	     	<tr>
	     	<td>Departamento: </td>
	     	<td><label for="tipo">
	     	  <input type="text" name="departamento" onkeyup="javascript:alta(this);" />
	     	</label></td>
	     	</tr>
	     	<tr>
	     	<td>Telefone Comercial: </td>
	     	<td><input type="text" name="tel_comercial" onKeyPress="mascara(this, '##.####-####')" maxlength=12 /></td>
	     	</tr>
	     	<tr>
	     	  <td>Ramal:</td>
	     	  <td><input type="text" name="ramal" /></td>
	     	  </tr>
	     	<tr>
	     	<td>Celular Comercial: </td> 
	     	<td><input type="text" name="celular_comercial" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
	     	</tr>
	     	<tr>
	     	<td>Email Comercial: </td>
	     	<td><input type="text" name="email_comercial" /></td>
	     	</tr>
	     	<tr>
	     	  <td>Endereço Comercial: </td>
	     	  <td><input type="text" name="endereço_comercial" onkeyup="javascript:alta(this);" /></td>
	     	  </tr>
	     	<tr>
	     	<td>Email Pessoal:</td>
	     	<td><input type="text" name="email_pessoal" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Telefone Pessoal:</td>
	     	<td><input type="text" name="telefone_pessoal" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
	     	</tr>
	     	<tr>
	     	<td>Celular Pessoal:</td>
	     	<td><input type="text" name="celular_pessoal" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
	     	</tr>
	     	<tr>
	     	  <td>Endereço Pessoal:</td>
	     	  <td><input type="text" name="endereço_pessoal" onkeyup="javascript:alta(this);" /></td>
	     	  </tr>
	     	<tr>
	     	<td>Banco:</td>
	     	<td><input type="text" name="banco" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	  <td>Agência:</td>
	     	  <td><input type="text" name="agencia" /></td>
	     	  </tr>
	     	<tr>
	     	  <td>Conta Corrente:</td>
	     	  <td><input type="text" name="conta" /></td>
	     	  </tr>
	     	<tr>
	     	<td>Data de Nascimento:</td>
	     	<td><input type="text" name="nascimento" onKeyPress="mascara(this, '##/##/####')" maxlength=10/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
	     	<br /><br />
	     	<input type="hidden" name="idCliente" value="<%=idCliente%>" />
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
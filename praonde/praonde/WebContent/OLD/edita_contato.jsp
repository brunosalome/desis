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
	     	int idCliente = 0;
	     	if(request.getParameter("idCliente") != null)
	     		idCliente = Integer.parseInt(request.getParameter("idCliente"));
	     		
	    	System.out.println("IDCliente:"+ idCliente);
	     	
	     	ContatoDAO dao = new ContatoDAO ();
	     	Contato contato;
	     	int idContato = 0;
	     	if(request.getParameter("idContato") != null)
	     		idContato = Integer.parseInt(request.getParameter("idContato"));

	     	contato = dao.getContato(idContato);
	     	
	     	String nome = contato.getNome();
	     	if(nome==null) nome="";
	     	String cargo = contato.getCargo();
	     	if(cargo==null) cargo="";
	     	String departamento = contato.getDepartamento();
	     	if(departamento==null) departamento="";
	     	String telefone_comercial = contato.getTelefone_comercial();
	     	if(telefone_comercial==null) telefone_comercial="";
	     	String ramal = contato.getRamal();
	     	if(ramal==null) ramal="";
	     	String celular_comercial = contato.getCelular_comercial();
	     	if(celular_comercial==null) celular_comercial="";
	     	String email_comercial = contato.getEmail_comercial();
	     	if(email_comercial==null) email_comercial="";
	     	String endereco_comercial = contato.getEndereco_comercial();
	     	if(endereco_comercial==null) endereco_comercial="";
	     	String email_pessoal = contato.getEmail_pessoal();
	     	if(email_pessoal==null) email_pessoal="";
	     	String telefone_pessoal = contato.getTelefone_pessoal();
	     	if(telefone_pessoal==null) telefone_pessoal="";
	     	String celular_pessoal = contato.getCelular_pessoal();
	     	if(celular_pessoal==null) celular_pessoal="";
	     	String endereço_pessoal = contato.getEndereco_pessoal();
	     	if(endereço_pessoal==null) endereço_pessoal="";
	     	String banco = contato.getBanco();
	     	if(banco==null) banco="";
	     	String agencia = contato.getAgencia();
	     	if(agencia==null) agencia="";
	     	String conta_corrente = contato.getConta_corrente();
	     	if(conta_corrente==null) conta_corrente="";
	     	String nascimento = contato.getNascimento();
	     	if(nascimento==null) nascimento="";	
	     	
	     %>
	     <center>
	     	<form name="form1" action="editaContato" onSubmit="return (valida())">
	     	<h3>Editar Contato</h3>
	     	<table width="320" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="308">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table width="312" border="0" cellpadding="1" cellspacing="1"> 
	     	<tr>
	     	<td width="157">Nome: </td>
	     	<td width="144"><input type="text" name="nome" value="<%=nome%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Cargo: </td>
	     	<td><input type="text" name="cargo" value="<%=cargo%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Departamento: </td>
	     	<td><label for="tipo">
	     	  <input type="text" name="departamento" value="<%=departamento%>" onkeyup="javascript:alta(this);"/>
	     	</label></td>
	     	</tr>
	     	<tr>
	     	<td>Telefone Comercial: </td>
	     	<td><input type="text" name="tel_comercial" value="<%=telefone_comercial%>" onKeyPress="mascara(this, '##.####-####')" maxlength=12 /></td>
	     	</tr>
	     	<tr>
	     	  <td>Ramal:</td>
	     	  <td><input type="text" name="ramal" value="<%=ramal%>"/></td>
	     	  </tr>
	     	<tr>
	     	<td>Celular Comercial: </td> 
	     	<td><input type="text" name="celular_comercial" value="<%=celular_comercial%>" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
	     	</tr>
	     	<tr>
	     	<td>Email Comercial: </td>
	     	<td><input type="text" name="email_comercial" value="<%=email_comercial%>" /></td>
	     	</tr>
	     	<tr>
	     	  <td>Endereço Comercial: </td>
	     	  <td><input type="text" name="endereço_comercial" value="<%=endereco_comercial%>" onkeyup="javascript:alta(this);"/></td>
	     	  </tr>
	     	<tr>
	     	<td>Email Pessoal:</td>
	     	<td><input type="text" name="email_pessoal" value="<%=email_pessoal%>"/></td>
	     	</tr>
	     	<tr>
	     	<td>Telefone Pessoal:</td>
	     	<td><input type="text" name="telefone_pessoal" value="<%=telefone_pessoal%>" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
	     	</tr>
	     	<tr>
	     	<td>Celular Pessoal:</td>
	     	<td><input type="text" name="celular_pessoal" value="<%=celular_pessoal%>" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
	     	</tr>
	     	<tr>
	     	  <td>Endereço Pessoal:</td>
	     	  <td><input type="text" name="endereço_pessoal" value="<%=endereço_pessoal%>" onkeyup="javascript:alta(this);"/></td>
	     	  </tr>
	     	<tr>
	     	<td>Banco:</td>
	     	<td><input type="text" name="banco" value="<%=banco%>"/></td>
	     	</tr>
	     	<tr>
	     	  <td>Agência:</td>
	     	  <td><input type="text" name="agencia" value="<%=agencia%>"/></td>
	     	  </tr>
	     	<tr>
	     	  <td>Conta Corrente:</td>
	     	  <td><input type="text" name="conta" value="<%=conta_corrente%>"/></td>
	     	  </tr>
	     	<tr>
	     	<td>Data de Nascimento:</td>
	     	<td><input type="text" name="nascimento" value="<%=nascimento%>" onKeyPress="mascara(this, '##/##/####')" maxlength=10/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
	     	<br /><br />
	     	<input type="hidden" name="idCliente" value="<%=idCliente%>" />
	     	<input type="hidden" name="idContato" value="<%=idContato%>" />
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
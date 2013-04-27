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
	    
	    <%
	    	
	    	ClienteDAO dao = new ClienteDAO ();
	     	Cliente cliente;
	     	int idCliente = 0;
	     	if(request.getParameter("idCliente") != null)
	     		idCliente = Integer.parseInt(request.getParameter("idCliente"));

	     	cliente = dao.getCliente(idCliente);
	     	
	     	String nome = cliente.getNome();
	     	if(nome==null) nome="";	     		     	
	     	String fantasia = cliente.getFantasia();
	     	if(fantasia==null) fantasia="";
	     	String tipo = cliente.getTipo();
	     	if(tipo==null) tipo="";
	     	String cnpj = cliente.getCnpj();
	     	if(cnpj==null) cnpj="";
	     	String rg = cliente.getRg();
	     	if(rg==null) rg="";
	     	String cpf = cliente.getCpf();
	     	if(cpf==null) cpf="";
	     	String ie = cliente.getIe();
	     	if(ie==null) ie="";
	     	String ccm = cliente.getCcm();
	     	if(ccm==null) ccm="";
	     	String cep = cliente.getCep();
	     	if(cep==null) cep="";
	     	String endereco = cliente.getRua();
	     	if(endereco==null) endereco="";
	     	String numero = cliente.getNumero();
	     	if(numero==null) numero="";	     	
	     	String complemento = cliente.getComplemento();
	     	if(complemento==null) complemento="";
	     	String bairro = cliente.getBairro();
	     	if(bairro==null) bairro="";
	     	String municipio = cliente.getMunicipio();
	     	if(municipio==null) municipio="";
	     	String estado = cliente.getEstado();
	     	if(estado==null) estado="";
	     	String telefone = cliente.getTelefone();
	     	if(telefone==null) telefone="";
	    
	    %> 
		<center>
	     	<form name="form1" action="editaCliente" onSubmit="return (valida())">
	     	<h3>Adicionar Cliente</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Nome: </td>
	     	<td><input type="text" name="nome" value="<%=nome%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Fantasia: </td>
	     	<td><input type="text" name="fantasia" value="<%=fantasia%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Tipo: </td>
	     	<%if (tipo.equals("Pessoa Física")){%>
	     	<td><label for="tipo"></label>
	     	  <select name="tipo" size="1" id="tipo">
	     	    <option selected>Pessoa F&iacute;sica</option>
	     	    <option>Pessoa Jur&iacute;dica</option>
     	      </select></td>
     	    <%}%>
     	    <%if (tipo.equals("Pessoa Jurídica")){%>
	     	<td><label for="tipo"></label>
	     	  <select name="tipo" size="1" id="tipo">
	     	    <option>Pessoa F&iacute;sica</option>
	     	    <option selected>Pessoa Jur&iacute;dica</option>
     	      </select></td>
     	    <%}%>
	     	</tr>
	     	<tr>
	     	<td>CNPJ: </td>
	     	<td><input type="text" name="cnpj" value="<%=cnpj%>" onKeyPress="mascara(this, '##.###.###/####-##')" maxlength=18 /></td>
	     	</tr>
	     	<tr>
	     	  <td>RG:</td>
	     	  <td><input type="text" name="rg" value="<%=rg%>" onKeyPress="mascara(this, '##.###.###-##')" maxlength=18 /></td>
	     	  </tr>
	     	<tr>
	     	<td>CPF: </td> 
	     	<td><input type="text" name="cpf" value="<%=cpf%>" onKeyPress="mascara(this, '###.###.###-##')" maxlength=14/></td>
	     	</tr>
	     	<tr>
	     	<td>Inscrição Estadual: </td>
	     	<td><input type="text" name="ie" value="<%=ie%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	  <td>CCM:</td>
	     	  <td><input type="text" name="ccm" value="<%=ccm%>"/></td>
	     	  </tr>
	     	<tr>
	     	<td>CEP: </td>
	     	<td><input type="text" name="cep" value="<%=cep%>" onKeyPress="mascara(this, '#####.###')" maxlength=9/></td>
	     	</tr>
	     	<tr>
	     	<td>Endereço: </td>
	     	<td><input type="text" name="rua" value="<%=endereco%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Número: </td>
	     	<td><input type="text" name="numero" value="<%=numero%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	  <td>Complemento: </td>
	     	  <td><input type="text" name="complemento" value="<%=complemento%>"></td>
	     	  </tr>
	     	<tr>
	     	<td>Bairro: </td>
	     	<td><input type="text" name="bairro" value="<%=bairro%>") onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	  <td>Munincípio: </td>
	     	  <td><input type="text" name="municipio" value="<%=municipio%>" onkeyup="javascript:alta(this);"/></td>
	     	  </tr>
	     	<tr>
	     	  <td>Estado: </td>
	     	  <td><input type="text" name="estado" value="<%=estado%>" onkeyup="javascript:alta(this);"/></td>
	     	  </tr>
	     	<tr>
	     	<td>Telefone: </td>
	     	<td><input type="text" name="telefone" value="<%=telefone%>" onKeyPress="mascara(this, '##.####-####')" maxlength=12/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idCliente" value="<%=idCliente%>"/>  
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
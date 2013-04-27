<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		caixa = document.form1.caixa.value;
	 		patrimonio = document.form1.patrimonio.value;
	 		
	 		if(caixa=="") {
	 			alert("Insira ao menos o nome da caixa!");
	 			document.form1.caixa.focus();
	 			return false;
	 		}else if(patrimonio==""){
	 			alert("Insira a sigla do patrimônio!");
	 			document.form1.caixa.focus();
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
	     <center>
	     	<form name="form2" action="adiciona_caixa.jsp">
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>
	     		Filtrar Clientes:
	     	</td>
	     	<td>
	     		<input type = "text" name = "buscaCli" onkeyup="java script:alta(this);"/>
	     	</td>
	     	<td>
	     		<input type = "submit" value= "Filtrar" />
	     	</td>
	     	</tr>
	     	</table>
	     	</form>
	     
	     	<form name="form1" action="adiciona_contato_caixa.jsp" onSubmit="return (valida())">
	     	<font color="brown"><b>Adicionar Especialidade</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Especialidade: </td>
	     	<td><input type="text" name="caixa" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Cliente: </td> 
	     	<td>
	     	  <select name="cliente" onchange="document.form1.patrimonioCliente.focus()">
	     	  <%
	     		
	     		ClienteDAO cdao = new ClienteDAO();
	     		String sql = "";
	     		System.out.println(request.getParameter("buscaCli"));
	     		if(request.getParameter("buscaCli")==null || request.getParameter("buscaCli").equals("null") || request.getParameter("buscaCli")=="" )
	     			sql = "select * from clientes";
	     		else
	     			sql = "select * from clientes where fantasia like '%"+request.getParameter("buscaCli")+"%'";
	     		System.out.println("SQL:" + sql);
	     		List<Cliente> clientes = cdao.getConsulta(sql);
	     		System.out.println("SIZE:" + clientes.size());
	     		for (Cliente c : clientes){
	     		
	     	  %>
	     	    <option value=<%=c.getIdCliente()%>><%=c.getFantasia()%></option>
	     	<%
	     		}
	     	%>	     	    
     	      </select></td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Patrimônio do cliente?
	     	</td>
	     	<td>
	     		<input type="checkbox" name="patrimonioCliente" onclick="document.form1.patrimonio.focus()"/>  
	     	</td> 
	     	</tr>
	     	<tr>
	     	<td>Sigla do Patrimônio: </td>
	     	<td>
	     		<input type="text" name="patrimonio" onkeyup="javascript:alta(this);"/>
	     	</td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>  
			<br /><br />
			<input type="submit" value="Próximo >>" />
			</form>
			</center>
      </body>
   </html>
<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		caixa = document.form1.caixa.value;
	 		
	 		if(caixa=="") {
	 			alert("Insira ao menos a caixa!");
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
	    
	    <%
	    	
	    	CaixaDAO dao = new CaixaDAO ();
	     	Caixa caixa;
	     	int idCaixa = 0;
	     	if(request.getParameter("idCaixa") != null)
	     		idCaixa = Integer.parseInt(request.getParameter("idCaixa"));

	     	caixa = dao.getCaixa(idCaixa);
	     	
	     	String caixa_descricao = caixa.getCaixa(); 
	
	     	  		     	    
	    %> 
			<center>
	     	<form name="form1" action="editaCaixa" onSubmit="return (valida())">
	     	<h3>Editar Especialidade</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>
	     		Especialidade: 
	     	</td>
	     	<td>
	     		<input type="text" name="caixa" value="<%=caixa_descricao%>" onkeyup="javascript:alta(this);"/>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Cliente:
	     	</td>
	     	<td>
	     		<select name="cliente">
		     	  	<%
		     			ClienteDAO cdao = new ClienteDAO();
		     			List<Cliente> clientes = cdao.getLista();
		     			for (Cliente c : clientes){
			     		%>
			     	    	<option value=<%=c.getIdCliente()%>><%=c.getFantasia()%></option>
			     		<%
		     			}
		     		%>	     	    
     	      </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Sigla do patrimônio:
	     	</td>
	     	<td>
	     		<input type="text" name="patrimonio" value="<%=caixa.getPatrimonio()%>" onkeyup="javascript:alta(this);"/>
	     	</td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idCaixa" value=<%=idCaixa%> />  
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
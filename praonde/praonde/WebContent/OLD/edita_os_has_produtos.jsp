<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	 	function valida() {
	 		cliente = document.form1.produto.value;
	 		
	 		if(cliente=="") {
	 			alert("Insira o produto!");
	 			document.form1.produto.focus();
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
	     
	     	int idOsHasProdutos = Integer.parseInt(request.getParameter("idOsHasProdutos"));
	     	int idCliente = Integer.parseInt(request.getParameter("idCliente"));
	     	
	     	OS_has_ProdutosDAO ohpdao = new OS_has_ProdutosDAO();
	     	OS_has_Produtos ohp = ohpdao.getOHP(idOsHasProdutos); 
	
	     
	     %>
	     <center>
	     	<form name="form1" action="editaOS_has_Produtos" onSubmit="return (valida())">
	     	<h3>Adicionar OS</h3>
	     	<table width="350" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="350">Instrumentos: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>
	     		Quantidade:
	     	</td>
	     	<td>
	     		<input type = "text" name = "quantidade" value="<%=ohp.getQuantidade()%>"/>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Possui conserto:
	     	</td>
	     	<td>
	     		<select name="conserto">
		     	  	<% 
		     	  	if(ohp.getConserto().equals("Sim")){
		     	  	%>
		     	  		<option value="Sim" selected>Sim</option>
	     				<option value="Não">Não</option>
		     	  	<%
		     	  	}else{	
		     	  	%>
		     	  		<option value="Sim">Sim</option>
	     				<option value="Não" selected>Não</option>
		     	  	<%
		     	  	}
		     	  	%>			     		     	    
	     	    </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Quantidade sem conserto:
	     	</td>
	     	<td>
	     		<input type="text" name="quebrado_qtd" value="<%=ohp.getQuebrado_qtd()%>"/>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Motivo:
	     	</td>
	     	<td>
	     		<select name="motivo">
		     	  	<option value=0></option>
		     	  	<%
		     		MotivoDAO motdao = new MotivoDAO();
		     		List<Motivo> motivos = motdao.getLista();
		     		for (Motivo m : motivos){
		     			if (ohp.getIdMotivo()==m.getIdMotivo()){
		     		%>
		     	    		<option value=<%=m.getIdMotivo()%> selected><%=m.getMotivo()%></option>
			     	<%
			     		}else{
			     	%>	
				     		<option value=<%=m.getIdMotivo()%>><%=m.getMotivo()%></option>
				    <%
				    	}
				    }
				    %>     	    
	     	    </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Patrimônio:
	     	</td>
	     	<td>
	     		<input type = "text" name = "patrimonio" value="<%=ohp.getPatrimonio()%>"/>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Observação:
	     	</td>
	     	<td>
	     		<input type = "text" name = "observacao" value="<%=ohp.getObservacao()%>"/>
	     	</td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>  
			<br /><br />
			<input type="submit" value="Concluir" />
			<input type="hidden" name="idOS_has_produtos" value="<%=ohp.getIdOS_has_produtos()%>" />
			<input type="hidden" name="idOS" value="<%=ohp.getIdOS()%>" />
			</form>
			</center>
      </body>
   </html>
<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <%
	    	
	    	Caixa_has_ProdutosDAO dao = new Caixa_has_ProdutosDAO ();
	     	Caixa_has_Produtos caixa_has_produtos;
	     	int idCaixa_has_Produtos = 0;
	     	if(request.getParameter("idCaixa_has_Produtos") != null)
	     		idCaixa_has_Produtos = Integer.parseInt(request.getParameter("idCaixa_has_Produtos"));

	     	Caixa_has_Produtos chp = dao.getCHP(idCaixa_has_Produtos);
	     	int idCaixa = chp.getIdCaixa();
	     	
	     	System.out.println("IDCaixa_HAS_PRODUTOS"+idCaixa_has_Produtos);  		     	   
	    %> 
	     <script language="javascript" type="text/javascript">
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
			 	if (texto.substring(0,1) != saida){
			 		src.value += texto.substring(0,1);
			 	}
			 } 
			 
			function bloquear(){
				<%
					String classificacao = chp.getPatrimonio();
					if(classificacao==null) classificacao="";
				%>
		    	if (document.getElementById('sequencia_patrimonio').disabled==false){
		    		document.getElementById('sequencia_patrimonio').value = "";
					document.getElementById('sequencia_patrimonio').disabled = true;
				}else{
					document.getElementById('sequencia_patrimonio').value = "<%=classificacao %>";
					document.getElementById('sequencia_patrimonio').disabled = false;
		 		} 
			}
		</script>
		<center>
	     	<form name="form1" action="editaCaixa_has_Produtos" onSubmit="return (valida())">
	     	<h3>Editar Instrumento da Caixa</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>
	     		Instrumento: 
	     	</td>
	     	<td>
	     		<select name="produto">
		     	  	<%
		     			ProdutoDAO pdao = new ProdutoDAO();
		     			List<Produto> produtos = pdao.getLista();
		     			for (Produto p : produtos){
			     		%>
			     	    	<option value=<%=p.getIdProduto()%>><%=p.getDescricao()%></option>
			     		<%
		     			}
		     		%>	     	    
     	     	</select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Quantidade:
	     	</td>
	     	<td>
				<input type="text" name="quantidade" value="<%=chp.getQuantidade()%>"/>
	     	</td>
	     	</tr>
	     		     	<tr>
	     	<td>
	     		Patrimônio do cliente?
	     	</td>
	     	<%if(chp.getPatrimonio()==null || chp.getPatrimonio()==""){%>
		     	<td>
		     		<input type="checkbox" name="patrimonioCliente" onclick = "bloquear();"/>  
		     	</td> 
	     	<%}else{%>
	     	 	<td>
		     		<input type="checkbox" name="patrimonioCliente" checked  onclick = "bloquear();"/>  
		     	</td> 
		    <%}%> 
	     	</tr>
	     	<tr>
	     	<td>
	     		Patrimônio do Instrumento:
	     	</td>
	     	<%if(chp.getPatrimonio()==null || chp.getPatrimonio()==""){%>
	     	<td>
	     		<input type = "text" name = "sequencia_patrimonio" disabled / >
	     	</td>
	     	<%}else{%>
	     	<td>
	     		<input type = "text" name = "sequencia_patrimonio" value="<%=chp.getPatrimonio()%>" />
	     	</td>
	     	<%}%>
	     	</tr>
	     	<tr>
	     	<td>
	     		Observação:
	     	</td>
	     	<td>
	     		<input type = "text" name = "observacao" value="<%=chp.getObservacao()%>"/>
	     	</td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idCaixa_has_Produtos" value="<%=idCaixa_has_Produtos%>" />
			<input type="hidden" name="idCaixa" value="<%=idCaixa%>" />    
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
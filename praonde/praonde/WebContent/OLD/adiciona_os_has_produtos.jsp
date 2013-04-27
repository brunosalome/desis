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
	     
	     	int idOS = Integer.parseInt(request.getParameter("idOS"));
	     	int idCliente = Integer.parseInt(request.getParameter("idCliente"));
	     
	     %>
	     	<center>
	     	<form name="form1" action="adicionaOS_has_Produtos" onSubmit="return (valida())">
	     	<font color="purple"><b>Adicionar OS</b></font>
	     	<table width="350" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="350">Instrumentos: </td>
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
		     	  	<option value=0></option>
		     	  	<%
		     		ProdutoDAO proddao = new ProdutoDAO();
		     		List<Produto> produtos = proddao.getLista();
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
	     		<input type = "text" name = "quantidade" />
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Possui conserto:
	     	</td>
	     	<td>
	     		<select name="conserto">
		     	  	<option value="Sim">Sim</option>
		     	  	<option value="Não">Não</option>			     		     	    
	     	    </select>
	     	</td>
	     	<td>
	     		Quantidade sem conserto:
	     	</td>
	     	<td>
	     		<input type = "text" name = "quebrado_qtd" />
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
		     		%>
		     	    <option value=<%=m.getIdMotivo()%>><%=m.getMotivo()%></option>
			     	<%
			     		}
			     	%>	     	    
	     	    </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	</tr>
	     	<tr>
	     	<td>
	     		Patrimônio:
	     	</td>
	     	<td>
	     		<input type = "text" name = "patrimonio" />
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Observação:
	     	</td>
	     	<td>
	     		<input type = "text" name = "observacao" />
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Continuar adicionando:
	     	</td>
	     	<td>
	     		<input type = "checkbox" name = "adiciona" />
	     	</td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>  
			<br /><br />
			<input type="hidden" name="idOS" value="<%=idOS%>" />
			<input type="submit" value="Concluir" />
			</form>
			</center>
      </body>
   </html>
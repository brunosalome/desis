<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	      function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		produto = document.form1.produto.value;
	 		quantidade = document.form1.quantidade.value; 
	 		if(produto=="") {
	 			alert("Insira o produto!");
	 			document.form1.produto.focus();
	 			return false;
	 		}else if(quantidade==""){
	 			alert("Insira a quantidade!");
	 			document.form1.quantidade.focus();
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
	 	function bloquear(){
		    	if (document.getElementById('sequencia_patrimonio').disabled==false){
		    		document.getElementById('sequencia_patrimonio').value = "";
					document.getElementById('sequencia_patrimonio').disabled = true;
				}else{
					document.getElementById('sequencia_patrimonio').value = "";
					document.getElementById('sequencia_patrimonio').disabled = false;
		 		} 
		} 
	     </script>
	     <% 
	     
	     	int idCaixa = Integer.parseInt(request.getParameter("idCaixa"));
	     	String patrimonioCliente = request.getParameter("patrimonioCliente");
	     
	     %>
	     	<center>
	     	<font color="brown"><b>Adicionar Caixa</b></font>
	     
	     	<form name="form2" action="adiciona_caixa_has_produtos.jsp">
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>
	     		Filtro:
	     	</td>
	     	<td>
	     		<input type = "text" name = "buscaProd" onkeyup="javascript:alta(this);"/>
	     	</td>
	     	<td>
	     		<input type = "submit" value= "Filtrar" />
	     		<input type="hidden" value=<%=idCaixa%> name="idCaixa" />
	     	</td>
	     	</tr>
	     	</table>
	     	</form>
	     
	     	<form name="form1" action="adicionaCaixa_has_Produtos" onSubmit="return (valida())">
	     	
	     	<table width="350" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="350">Instrumentos: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Instrumento: </td>
	     	<td>
	     	  <select name="produto" onchange="document.form1.quantidade.focus()">
	     	  <%
	     		ProdutoDAO cdao = new ProdutoDAO();
	     		String sql = "";
	     		System.out.println(request.getParameter("buscaProd"));
	     		if(request.getParameter("buscaProd")==null || request.getParameter("buscaProd").equals("null") || request.getParameter("buscaProd")=="" )
	     			sql = "select * from produtos";
	     		else
	     			sql = "select * from produtos where descricao like '%"+request.getParameter("buscaProd")+"%'";
	     		System.out.println("SQL:" + sql);
	     		List<Produto> produtos = cdao.getConsulta(sql);
	     		System.out.println("SIZE:" + produtos.size());
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
	     		<input type = "text" name = "quantidade" size=3/>
	     	</td>
	     	</tr>
	     	<tr>
	     	<%System.out.println("PATR:"+patrimonioCliente);%>
	     	<%if(patrimonioCliente!=null && patrimonioCliente.equals("on")){%>
	     	<td>
	     		Patrimônio do instrumento:
	     	</td>
	     	<td>
	     		<input type = "text" name = "sequencia_patrimonio" onkeyup="javascript:alta(this);"/>
	     	</td>
	     	</tr>
	     	<%}%>
	     	<tr>
	     	<td>
	     		Continuar adicionando:
	     	</td>
	     	<td>
	     		<input type = "checkbox" name = "adiciona" onclick="this.form.submit()"/>
	     	</td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>  
			<br /><br />
			<input type="submit" value="Concluir" />
			<input type="hidden" name="idCaixa" value="<%=idCaixa%>" />
			<input type="hidden" name="patrimonioCliente" value="<%=patrimonioCliente%>" />
			</form>
			</center>
      </body>
   </html>
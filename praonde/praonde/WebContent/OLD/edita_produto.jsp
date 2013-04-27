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
	 			alert("Insira ao menos o nome fantasia do produto!");
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
	    	
	    	ProdutoDAO dao = new ProdutoDAO ();
	     	Produto produto;
	     	int idProduto = 0;
	     	if(request.getParameter("idProduto") != null)
	     		idProduto = Integer.parseInt(request.getParameter("idProduto"));

	     	produto = dao.getProduto(idProduto);
	     	
	     	String descricao = produto.getDescricao();
	     	if(descricao==null) descricao="";	   
	     	double valor = produto.getValor();
	     	int barras = produto.getBarras();
	     	int duplo = produto.getDuplo();
	     	int ultimo = produto.getUltimo();
	     	  		     	    
	    %> 
		<center>
	     	<form name="form1" action="editaProduto" onSubmit="return (valida())">
	     	<h3>Editar Instrumento</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Descrição: </td>
	     	<td><input type="text" name="descricao" value="<%=descricao%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	<tr>
	     	<td>Valor: </td>
	     	<td><input type="text" name="valor" value="<%=valor%>" /></td>
	     	</tr>
	     	<tr>
	     	<td>Código de Barras: </td>
     	    <td><input type="text" name="barras" value="<%=barras%>"/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
	     	<tr>
	     	  <td>Item duplo:</td>
	     	  <%if(duplo==1){%>
	     	  	<td><input type="checkbox" name="duplo" checked/></td>
	     	  <%}else{%>
	     	  	<td><input type="checkbox" name="duplo" /></td>
	     	  <%}%>
	     	</tr>
	     	<tr>
	     	  <td>Último da OS:</td>
	     	  <%if(ultimo==1){%>
	     	  	<td><input type="checkbox" name="ultimo" checked/></td>
	     	  <%}else{%>
	     	  	<td><input type="checkbox" name="ultimo" /></td>
	     	  <%}%>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idProduto" value="<%=idProduto%>"/>  
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
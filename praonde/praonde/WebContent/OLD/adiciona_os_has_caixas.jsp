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
	     	<form name="form1" action="adicionaOS_has_Caixas" onSubmit="return (valida())">
	     	<font color="purple"><b>Adicionar OS</b></font>
	     	<table width="350" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="350">Produtos: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Solicitante: </td>
	     	<td>
	     	  <select name="idSolicitante">
	     	  <%
	     		ContatoDAO contdao = new ContatoDAO();
	     		List<Contato> contatos = contdao.getLista();
	     		for (Contato c : contatos){
	     		 if(c.getIdCliente() == idCliente){	
	     		%>
	     	    <option value=<%=c.getIdContato()%>><%=c.getNome()%></option>
	     	<%
	     		 }
	     	    }
	     	%>	     	    
     	      </select>
     	    </td>
	     	</tr>
	     	<tr>
	     	<td>Especialidade: </td>
	     	<td>
	     	  <select name="caixa" onchange="document.form1.numero_caixa.focus()">
	     	  <%
	     		CaixaDAO cdao = new CaixaDAO();
	     		List<Caixa> caixas = cdao.getListaDe(idCliente);
	     		for (Caixa c : caixas){
	     		%>
	     	    <option value=<%=c.getIdCaixa()%>><%=c.getCaixa()%></option>
	     	<%
	     		}
	     	%>	     	    
     	      </select>
     	    </td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Número da Caixa:
	     	</td>
	     	<td>
	     		<input type = "text" name = "numero_caixa" />
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Cor 1:
	     	</td>
	     	<td>
	     		<select name="cor1">
	     		<option value=0></option>
		     	  	<%
		     		CorDAO cordao = new CorDAO();
		     		List<Cor> cores = cordao.getLista();
		     		for (Cor cor : cores){
		     		%>
		     	    <option value=<%=cor.getIdCor()%>><%=cor.getCor()%></option>
			     	<%
			     		}
			     	%>	     	    
	     	    </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Cor 2:
	     	</td>
	     	<td>
	     		<select name="cor2">
		     	  	<option value=0></option>
		     	  	<%
		     		for (Cor cor : cores){
		     		%>
		     	    <option value=<%=cor.getIdCor()%>><%=cor.getCor()%></option>
			     	<%
			     		}
			     	%>	     	    
	     	    </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Cor 3:
	     	</td>
	     	<td>
	     		<select name="cor3">
		     	  	<option value=0></option>
		     	  	<%
		     		for (Cor cor : cores){
		     		%>
		     	    <option value=<%=cor.getIdCor()%>><%=cor.getCor()%></option>
			     	<%
			     		}
			     	%>	     	    
	     	    </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>  
			<br /><br />
			<input type="submit" value="Concluir" />
			<input type="hidden" name="idOS" value="<%=idOS%>" />
			</form>
			</center>
      </body>
   </html>
<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body onload="return dataAtual()">
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		cliente = document.form1.cliente.value;
	 		
	 		if(cliente=="") {
	 			alert("Insira ao menos o nome fantasia do cliente!");
	 			document.form1.cliente.focus();
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
	 	function dataAtual(){
	 		var d=new Date();  
            var monthname=new Array("01","02","03","04","05","06","07","08","09","10","11","12");  
            var TODAY = d.getDate() + "/" +monthname[d.getMonth()] +  "/" + d.getFullYear();  
	 		form1.data_lancamento.value = TODAY;
	 	} 
	     </script>
	     	<center>
	     	<form name="form1" action="adicionaOS" onSubmit="return (valida())">
	     	<font color="purple"><b>Adicionar OS</b></font>
	     	<table width="350" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="350">Lançamento de OS: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Cliente: </td>
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
	     		Data de lançamento:
	     	</td>
	     	<td>
	     		<input type = "text" name = "data_lancamento"  onKeyPress="mascara(this, '##/##/####')" maxlength=10  />
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Condição de Pagamento:
	     	</td>
	     	<td>
	     		<select name="condPag">
		     	  	<%
		     		Condicao_PagamentoDAO cpdao = new Condicao_PagamentoDAO();
		     		List<Condicao_Pagamento> condicoes = cpdao.getLista();
		     		for (Condicao_Pagamento cp : condicoes){
		     		%>
		     	    <option value=<%=cp.getIdCondicao_Pagamento()%>><%=cp.getCondicao_pagamento()%></option>
			     	<%
			     		}
			     	%>	     	    
	     	    </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>Ordenar por: </td>
	     	<td>
	     	  <select name="ordenar">
	     	  <option value="lanc">Por Lançamento</option>
	     	  <option value="instr_c">Por Instrumento - Crescente</option>
	     	  <option value="instr_d">Por Instrumento - Decrescente</option>
	     	  <option value="patr_c">Por Patrimônio - Crescente</option>
	     	  <option value="patr_d">Por Patrimônio - Decrescente</option>
	     	  </select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Observação:
	     	</td>
	     	<td>
	     		<input type = "text" name = "observacao" onkeyup="javascript:alta(this);"/>
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
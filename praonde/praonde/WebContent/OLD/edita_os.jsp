<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <%
	    	
	    	OSDAO dao = new OSDAO ();
	     	int idOS = 0;
	     	if(request.getParameter("idOS") != null)
	     		idOS = Integer.parseInt(request.getParameter("idOS"));

	     	OS os = dao.getOS(idOS);
	     	  		     	   
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
		</script>
		<center>
	     	<form name="form1" action="editaOS" onSubmit="return (valida())">
	     	<h3>Editar Ordem de Serviço</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
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
		     				if(c.getIdCliente()==os.getIdCliente()){
			     		%>
			     	    	<option value=<%=c.getIdCliente()%> selected><%=c.getFantasia()%></option>
			     		<%
		     				}else{
		     			%>	     	    
		     				<option value=<%=c.getIdCliente()%>><%=c.getFantasia()%></option>
		     			<%
		     				}
		     			}
		     		%>
     	     	</select>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Data de Lançamento:
	     	</td>
	     	<td>
				<input type="text" name="dataLancamento" value="<%=os.getDataLancamento()%>" onKeyPress="mascara(this, '##/##/####')" maxlength=10/>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Data de Entrega:
	     	</td>
	     	<td>
				<input type="text" name="dataEntrega" value="<%=os.getDataEntrega()%>" onKeyPress="mascara(this, '##/##/####')" maxlength=10/>
	     	</td>
	     	</tr>
	     	<tr>
	     	<td>
	     		Condição de Pagamento: 
	     	</td>
	     	<td>
	     		<select name="condicao_pagamento">
		     	  	<%
		     			Condicao_PagamentoDAO cpdao = new Condicao_PagamentoDAO();
		     			List<Condicao_Pagamento> conds = cpdao.getLista();
		     			for (Condicao_Pagamento c : conds){
		     				if(c.getIdCondicao_Pagamento()==os.getIdCondicao_Pagamento()){
			     		%>
			     	    		<option value=<%=c.getIdCondicao_Pagamento()%> selected><%=c.getCondicao_pagamento()%></option>
			     		<%
		     				}else{
		     			%>
		     					<option value=<%=c.getIdCondicao_Pagamento()%>><%=c.getCondicao_pagamento()%></option>
		     			<%	
		     				}
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
				<input type="text" name="observacao" value="<%=os.getObservacao()%>"/>
	     	</td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idOS" value="<%=os.getIdOS()%>" />
			<input type="hidden" name="idCliente" value="<%=os.getIdCliente()%>" />    
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
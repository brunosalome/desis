<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		condicao = document.form1.condicao.value;
	 		
	 		if(condicao=="") {
	 			alert("Insira ao menos a condição de pagamento!");
	 			document.form1.condicao.focus();
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
	    	
	    	Condicao_PagamentoDAO dao = new Condicao_PagamentoDAO ();
	     	Condicao_Pagamento cond;
	     	int idCondicaoPagamento = 0;
	     	if(request.getParameter("idCondicao_Pagamento") != null)
	     		idCondicaoPagamento = Integer.parseInt(request.getParameter("idCondicao_Pagamento"));

			System.out.println("idCondicao:"+idCondicaoPagamento);
	     	cond = dao.getCond(idCondicaoPagamento);
	     	
	     	String condicao_descricao = cond.getCondicao_pagamento(); 
	     	  		     	    
	    %> 
		<center>
	     	<form name="form1" action="editaCondicao_Pagamento" onSubmit="return (valida())">
	     	<h3>Editar Condição de Pagamento</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Descrição: </td>
	     	<td><input type="text" name="condicao_pagamento" value="<%=condicao_descricao%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idCondicao_Pagamento" value="<%=idCondicaoPagamento%>" onkeyup="javascript:alta(this);"/>  
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
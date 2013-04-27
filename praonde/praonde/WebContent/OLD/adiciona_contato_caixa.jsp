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
	 			alert("Insira ao menos o nome da caixa!");
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
	     <center>
	     	
	     	<form name="form1" action="adicionaCaixa" onSubmit="return (valida())">
		     	<font color="brown"><b>Adicionar Especialidade</b></font>
		     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
		     	<tr >
		     	<td width="239">Dados gerais: </td>
		     	</tr>
		     	<tr valign="top">
		     	<td >
		     	<table cellspacing="1" cellpadding="1" border="0"> 
		     	<tr>
		     	<td>Escolha o contato responsável: </td> 
		     	<td>
		     	  <select name="idContato">
		     	  <%
		     	  
		     	  	int cliente = Integer.parseInt(request.getParameter("cliente"));
		     	  	String caixa = request.getParameter("caixa");
		     	  	String patrimonioCliente = request.getParameter("patrimonioCliente");
		     	  	String patrimonio = request.getParameter("patrimonio");
		     		
		     		ContatoDAO contdao = new ContatoDAO();
		     		List<Contato> contatos = contdao.getListaRelacionada(cliente);
		     		for (Contato c : contatos){
		     		
		     	  %>
		     	    <option value=<%=c.getIdContato()%>><%=c.getNome()%></option>
		     	<%
		     		}
		     	%>	     	    
	     	      </select></td>
		     	</tr>
		     	</table>  
		     	</table>
				<br /><br />
				<input type="hidden" value=<%=cliente%> name="cliente" />
				<input type="hidden" value=<%=caixa%> name="caixa" />
				<input type="hidden" value=<%=patrimonioCliente%> name="patrimonioCliente" />
				<input type="hidden" value=<%=patrimonio%> name="patrimonio" />
				<input type="submit" value="Próximo >>" />
			</form>
			
		</center>
      </body>
   </html>
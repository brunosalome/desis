<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		cor = document.form1.cor.value;
	 		
	 		if(cor=="") {
	 			alert("Insira ao menos a cor!");
	 			document.form1.cor.focus();
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
	    	
	    	CorDAO dao = new CorDAO ();
	     	Cor cor;
	     	int idCor = 0;
	     	if(request.getParameter("idCor") != null)
	     		idCor = Integer.parseInt(request.getParameter("idCor"));

	     	cor = dao.getCor(idCor);
	     	
	     	String cor_descricao = cor.getCor(); 
	     	  		     	    
	    %> 
		<center>
	     	<form name="form1" action="editaCor" onSubmit="return (valida())">
	     	<h3>Editar Cor</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Cor: </td>
	     	<td><input type="text" name="cor" value="<%=cor_descricao%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idCor" value="<%=idCor%>"/>  
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
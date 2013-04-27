<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	function valida() {
	 		patrimonio = document.form1.patrimonio.value;
	 		
	 		if(patrimonio=="") {
	 			alert("Insira ao menos o Patrimônio!");
	 			document.form1.patrimonio.focus();
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
	    	
	    	PatrimonioDAO dao = new PatrimonioDAO ();
	     	Patrimonio patrimonio;
	     	int idPatrimonio = 0;
	     	if(request.getParameter("idPatrimonio") != null)
	     		idPatrimonio = Integer.parseInt(request.getParameter("idPatrimonio"));

	     	patrimonio = dao.getPatrimonio(idPatrimonio);
	     	
	     	String patrimonio_descricao = patrimonio.getPatrimonio(); 
	     	  		     	    
	    %> 
		<center>
	     	<form name="form1" action="editaPatrimonio" onSubmit="return (valida())">
	     	<h3>Editar Patrimônio</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Patrimônio: </td>
	     	<td><input type="text" name="patrimonio" value="<%=patrimonio_descricao%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idPatrimonio" value="<%=idPatrimonio%>"/>  
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
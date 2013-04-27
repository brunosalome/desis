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
	    	
	    	MotivoDAO dao = new MotivoDAO ();
	     	Motivo motivo;
	     	int idMotivo = 0;
	     	if(request.getParameter("idMotivo") != null)
	     		idMotivo = Integer.parseInt(request.getParameter("idMotivo"));

	     	motivo = dao.getMotivo(idMotivo);
	     	
	     	String motivo_descricao = motivo.getMotivo(); 
	     	  		     	    
	    %> 
		<center>
	     	<form name="form1" action="editaMotivo" onSubmit="return (valida())">
	     	<h3>Editar Produto</h3>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr >
	     	<td width="239">Dados gerais: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0"> 
	     	<tr>
	     	<td>Motivo: </td>
	     	<td><input type="text" name="motivo" value="<%=motivo_descricao%>" onkeyup="javascript:alta(this);"/></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="hidden" name="idMotivo" value="<%=idMotivo%>"/>  
			<input type="submit" value="Gravar" />
			</form>
			</center>
      </body>
   </html>
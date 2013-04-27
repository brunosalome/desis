<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
		 	function valida() {
		 		cliente = document.form1.idCliente.value;
		 		
		 		if(cliente=="") {
		 			alert("Insira o número do cliente!");
		 			document.form1.idCliente.focus();
		 			return false;
		 		}else{
		 			return true;
		 		}
		 	}
	 	</script>	  
	 	<center>   
	     	<form name="form1" action="edita_cliente.jsp" onSubmit="return (valida())">
			<h3>Edição de clientes</h3>
				     	
	      	Insira o número do cliente a editar:   <input type="text" name="idCliente" size="3"/>
	      	<br>
	      	<br>
	      	<input type="submit" value="Editar" />
			
			</form>
        </center>           
	     	</body>
   </html>

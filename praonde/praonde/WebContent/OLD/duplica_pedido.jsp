<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
		 	function valida() {
		 		pedido = document.form1.pedido.value;
		 		
		 		if(pedido=="") {
		 			alert("Insira o número do pedido!");
		 			document.form1.pedido.focus();
		 			return false;
		 		}else{
		 			return true;
		 		}
		 	}
	 	</script>	
	 	<center>     
	     	<form name="form1" action="duplicaPedidoServlet" onSubmit="return (valida())">
			<h3>Duplicação de pedidos</h3>
				     	
	      	Insira o número do pedido a duplicar:   <input type="text" name="pedido" size="3"/>
	      	<br>
	      	<br>
	      	<input type="submit" value="Duplicar Pedido" />
			
			</form>
          </center>         
	     	</body>
   </html>

<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	<script language="javascript" type="text/javascript">
	 	function mascara(src, mask){
		 	var i = src.value.length;
		 	var saida = mask.substring(0,1);
		 	var texto = mask.substring(i);
		 	if (texto.substring(0,1) != saida){
	 			src.value += texto.substring(0,1);
	 		}
	 	} 
	     </script>
	     <body>
	     	<center>
	     	<form action="consultaClienteServlet">
			<h3><font color="blue">Consulta de clientes</font></h3>
				     	
			Razão Social: <input type="text" name="razao_social" />
			<br><br>
			Nome Fantasia: <input type="text" name="fantasia"/>
			<br><br>
			CNPJ: <input type="text" name="cnpj" onKeyPress="mascara(this, '##.###.###/####-##')" maxlength=18 />
		 	<br><br> 
			CPF: <input type="text" name="cpf" onKeyPress="mascara(this, '###.###.###-##')" maxlength=14/>
			<br><br>							     	
				     	
	      		
	      	<input type="submit" value="Buscar" />
			
			</form>
            </center>       
	     	</body>
   </html>

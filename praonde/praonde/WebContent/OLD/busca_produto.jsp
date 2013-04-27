<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     
	    <script language="javascript" type="text/javascript">
	 	function valida() {
	 		codigo = document.form1.codigo.value;
	 		descricao = document.form1.descricao.value;
	 		
	 		if(codigo=="") {
	 			if(descricao==""){
	 				alert("Digite um campo para a busca!");
	 				document.form1.codigo.focus();
	 				return false;
	 			}
	 		}else{
	 			return true;
	 		}
	 	}
	 	</script>
	 		<center>
	     	<form name="form1" action="consultaProduto" ">
			<h3><font color="red">Consulta de produtos</font></h3>
				     	
			Código:   <input type="text" name="codigo" size="3" />				     	
		
	      	<br>
	      	<br>
	      	
		
	      	Descrição:   <input type="text" name="descricao" />
	      	
	      	<br>
	      	<br>  
	      	
	      	<input type="submit" value="Buscar" />
			
			</form>
            </center>       
	     	</body>
   </html>

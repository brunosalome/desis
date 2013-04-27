<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     	<center>
	     	<form action="consultaOS">
			<h3><font color="purple">Consulta de OS's</font></h3>
				 
			Código: <input type="text" size="3" name="codigo"/> <br><br>
			Razão Social: <input type="text" name="razao_social"/><br><br>
			Fantasia: <input type="text" name="fantasia"/><br><br>
			Especialidade: <input type="text" name="especialidade"/><br><br>
			Status:  
			<select size="1" name="status">
				<option value="" />
				<option value="Aberta">Aberta</option>
				<option value="Em Andamento">Em Andamento</option>
				<option value="Concluída">Concluída</option>
			</select><br><br>
			<!--
			Mês:  
			<select size="1" name="mes">
				<option value="" />
				<option value="1">Janeiro</option>
				<option value="2">Fevereiro</option>
				<option value="3">Março</option>
				<option value="4">Abril</option>
				<option value="5">Maio</option>				
				<option value="6">Junho</option>
				<option value="7">Julho</option>
				<option value="8">Agosto</option>
				<option value="9">Setembro</option>
				<option value="10">Outubro</option>
				<option value="11">Novembro</option>
				<option value="12">Dezembro</option>
			</select><br><br>!
			-->
			Patrimônio: <input type="text" name="patrimonio"/>    <br><br>
	      	
	      	<input type="submit" value="Buscar" />
			
			</form>
            </center>       
	     	</body>
   </html>

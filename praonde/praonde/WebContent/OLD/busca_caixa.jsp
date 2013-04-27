<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     	<center>
	     	<form action="consultaCaixa">
			<h3><font color="brown">Consulta de Caixas</font></h3>
				     	
	      	Parâmetro para a consulta:   <select size="1" name="parametro">
	      	<option value="idCaixa">Código</option>
	      	<option value="idCliente">Cliente</option>
	      	<option value="patrimonio">Patrimônio</option>
	      	</select>
	      	<br>
	      	<br>
	      	
	      	Dimensão para a consulta:   <select size="1" name="dimensao">
	      	<option value="maior">Maior que</option>
	      	<option value="igual">Igual a</option>
	      	<option value="menor">Menor que</option>
	      	<option value="contem">Contém</option>
	      	<option value="ncontem">Não contém</option>
	      	</select>
	      	<br>
	      	<br>
	      	
	      	Valor da consulta: <input type="text" name="valor"></input>
	      	<br>
	      	<br>
	      
	      	
	      	<input type="submit" value="Buscar" />
			
			</form>
            </center>       
	     	</body>
   </html>

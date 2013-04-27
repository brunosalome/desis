<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>
	     <script language="javascript" type="text/javascript">
	     </script>     
	     	<center>
	     	<form name="form1" action="login" onSubmit="return (valida())">
	     	<font color="red"><b>Efetuar Login</b></font>
	     	<table width="278" border="3" cellpadding="1" cellspacing="1"> 
	     	<tr > 
	     	<td width="239">Informações: </td>
	     	</tr>
	     	<tr valign="top">
	     	<td >
	     	<table cellspacing="1" cellpadding="1" border="0">
	     	<tr>
	     	  <td>Usuário: </td>
	     	  <td><input type="text" name="usuario" /></td>
	     	</tr>
	     	<tr>
	     	  <td>Senha: </td>
	     	  <td><input type="password" name="senha" /></td>
	     	</tr>
	     	</table>
	     	</td>
	     	</tr>
			</table>
			<br /><br />
			<input type="submit" value="Login" />
			</form>
			</center>
      </body>
   </html>
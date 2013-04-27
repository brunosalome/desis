<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>     
	     	<center>
	     	<form name="form1" action="login" onSubmit="return (valida())">
	     	<font color="red"><b>Seja bem vindo, <%=request.getParameter("usuario")%>!</b></font>
	     	<%
	     		session.putValue("nome", request.getParameter("usuario"));	
	     	%>
			<br /><br />
			</form>
			</center>
      </body>
   </html>
<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	     <body>     
	     	<%
	     		String acheiSessao = (String)session.getValue("nome");
	     		String pagina = request.getParameter("pagina");
	     		//session.invalidate();
	     		if(acheiSessao==null){
	     			out.println("Sessão não localizada");
	     			out.println("<meta http-equiv=\"refresh\" content=\"1; url=login.jsp\">");
	     		}else{
  					out.println("<meta http-equiv=\"refresh\" content=\"1; url="+pagina+".jsp\">");	     					
	     		}
	     %>
      </body>
   </html>
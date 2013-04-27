<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	     	<%
	     	
	     	int idCliente = 0;
	     	if(request.getParameter("idCliente") != null)
	     		idCliente = Integer.parseInt(request.getParameter("idCliente"));
	     		
	     	ContatoDAO dao = new ContatoDAO ();
	     	Contato contato;
	     	int idContato = 0;
	     	if(request.getParameter("idContato") != null)
	     		idContato = Integer.parseInt(request.getParameter("idContato"));

	     	contato = dao.getContato(idContato);
	     	
	     	String nome = contato.getNome();
	     	String cargo = contato.getCargo();
	     	String departamento = contato.getDepartamento();
	     	String telefone_comercial = contato.getTelefone_comercial();
	     	String ramal = contato.getRamal();
	     	String celular_comercial = contato.getCelular_comercial();
	     	String email_comercial = contato.getEmail_comercial();
	     	String endereco_comercial = contato.getEndereco_comercial();
	     	String email_pessoal = contato.getEmail_pessoal();
	     	String telefone_pessoal = contato.getTelefone_pessoal();
	     	String celular_pessoal = contato.getCelular_pessoal();
	     	String endereço_pessoal = contato.getEndereco_pessoal();
	     	String banco = contato.getBanco();
	     	String agencia = contato.getAgencia();
	     	String conta_corrente = contato.getConta_corrente();
	     	String nascimento = contato.getNascimento();	     	
	%>
	<html>
	     <body>
			<center>
	     	<form action="edita_contato.jsp">
		     	<h2>Informações do Contato:</h2>
		     	<table cellspacing="1" cellpadding="1" border="3"> 
			     	<% if(contato.getNome()!=null )if( contato.getNome().replaceAll(" ","")!=""){%>
			     	<tr>
			     		<td><center>Nome:</center></td>
			     		<td><%= contato.getNome()%></td>
			     	</tr>
			     	<%}%>
			     	<% if(contato.getCargo()!=null )if( contato.getCargo().replaceAll(" ","")!=""){%>
			     	<tr>
				     	<td><center>Cargo: </center></td>
				     	<td><%= contato.getCargo() %></td>
			     	</tr>
			     	<%}%>
			     	<% if(contato.getDepartamento()!=null )if( contato.getDepartamento().replaceAll(" ","")!=""){%>
			     	<tr>
				     	<td><center>Departamento:</center></td>
						<td> <%=contato.getDepartamento() %> </td>
					</tr>
					<%}%>
					<% if(contato.getTelefone_comercial()!=null )if( contato.getTelefone_comercial().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Telefone Comercial:</center></td>
						<td> <%=contato.getTelefone_comercial() %> </td>
					</tr>
					<%}%>
					<% if(contato.getRamal()!=null )if( contato.getRamal().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Ramal:</center></td>
						<td> <%=contato.getRamal() %> </td>
					</tr>
					<%}%>
					<% if(contato.getCelular_comercial()!=null )if( contato.getCelular_comercial().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Celular Comercial:</center></td>
						<td> <%=contato.getCelular_comercial() %> </td>
					</tr>
					<%}%>
					<% if(contato.getEmail_comercial()!=null )if( contato.getEmail_comercial().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Email Comercial:</center></td>
						<td> <%=contato.getEmail_comercial() %> </td>
					</tr>
					<%}%>
					<% if(contato.getEndereco_comercial()!=null )if( contato.getEndereco_comercial().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Endereço Comercial:</center></td>
						<td> <%=contato.getEndereco_comercial() %> </td>
					</tr>
					<%}%>
					<% if(contato.getEmail_pessoal()!=null )if( contato.getEmail_pessoal().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Email Pessoal:</center></td>
						<td> <%=contato.getEmail_pessoal() %> </td>
					</tr>
					<%}%>
					<% if(contato.getTelefone_pessoal()!=null )if( contato.getTelefone_pessoal().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Telefone Pessoal:</center></td>
						<td> <%=contato.getTelefone_pessoal() %> </td>
					</tr>
					<%}%>
					<% if(contato.getCelular_pessoal()!=null )if( contato.getCelular_pessoal().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Celular Pessoal:</center></td>
						<td> <%=contato.getCelular_pessoal() %> </td>
					</tr>
					<%}%>
					<% if(contato.getEndereco_pessoal()!=null )if( contato.getEndereco_pessoal().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Endereço Pessoal:</center></td>
						<td> <%=contato.getEndereco_pessoal() %> </td>
					</tr>
					<%}%>
					<% if(contato.getBanco()!=null )if( contato.getBanco().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Banco:</center></td>
						<td> <%=contato.getBanco() %> </td>
					</tr>
					<%}%>
					<% if(contato.getAgencia()!=null )if( contato.getAgencia().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Agência:</center></td>
						<td> <%=contato.getAgencia() %> </td>
					</tr>
					<%}%>
					<% if(contato.getConta_corrente()!=null )if( contato.getConta_corrente().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Conta Corrente:</center></td>
						<td> <%=contato.getConta_corrente() %> </td>
					</tr>
					<%}%>
					<% if(contato.getNascimento()!=null )if( contato.getNascimento().replaceAll(" ","")!=""){%>
					<tr>
				     	<td><center>Data de Nascimento:</center></td>
						<td> <%=contato.getNascimento() %> </td>
					</tr>
					<%}%>
				</table>
		      	<br>
		      	<br>
		      	<input type="hidden" name="idContato" value="<%=idContato %>"/>
		      	<input type="hidden" name="idCliente" value="<%=idCliente %>"/>
		      	<input type="submit" value="Editar" />		
				
			</form>
			 </center>      
	     	</body>
   </html>

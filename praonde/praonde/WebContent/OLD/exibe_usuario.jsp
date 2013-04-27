<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	     	<%
	     	ClienteDAO dao = new ClienteDAO ();
	     	Cliente cliente;
	     	int idCliente = 0;
	     	if(request.getParameter("idCliente") != null)
	     		idCliente = Integer.parseInt(request.getParameter("idCliente"));

	     	cliente = dao.getCliente(idCliente);
	     	
	     	String nome = cliente.getNome();	     		     	
	     	String fantasia = cliente.getFantasia();
	     	String tipo = cliente.getTipo();
	     	String cnpj = cliente.getCnpj();
	     	String rg = cliente.getRg();
	     	String cpf = cliente.getCpf();
	     	String ie = cliente.getIe();
	     	String ccm = cliente.getCcm();
	     	String cep = cliente.getCep();
	     	String endereco = cliente.getRua();
	     	String numero = cliente.getNumero();	     	
	     	String complemento = cliente.getComplemento();
	     	String bairro = cliente.getBairro();
	     	String municipio = cliente.getMunicipio();
	     	String estado = cliente.getEstado();
	     	String telefone = cliente.getTelefone();
	     	
	     	ContatoDAO contatoDAO = new ContatoDAO();
	     	List<Contato> contatos = contatoDAO.getListaRelacionada(idCliente); 
	%>
	<html>
	     <body>
		 <script>
		 	function confirmExclusao(id) {  
				if (confirm("Tem certeza que deseja excluir esse contato do cliente?")) {  
					location.href="removeContato?idContato="+id;  
				}  	
			} 
		 </script>	
		 <center>
	     	<form action="edita_cliente.jsp">
		     	<h2>Informações do Cliente:</h2>
		     	<table cellspacing="1" cellpadding="1" border="3"> 
			     	<% if(cliente.getNome()!=null )if( cliente.getNome().trim()!=""){%>
			     	<tr>
			     		<td><center>Nome:</center></td>
			     		<td><%= cliente.getNome()%></td>
			     	</tr>
			     	<%}%>
			     	<% if(cliente.getFantasia()!=null )if( cliente.getFantasia().trim()!=""){%>
			     	<tr>
				     	<td><center>Fantasia: </center></td>
				     	<td><%= cliente.getFantasia() %></td>
			     	</tr>
			     	<%}%>
			     	<% if(cliente.getTipo()!=null )if( cliente.getTipo().trim()!=""){%>
			     	<tr>
				     	<td><center>Tipo:</center></td>
						<td> <%=cliente.getTipo() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getCnpj()!=null )if( cliente.getCnpj().trim()!=""){%>
					<tr>
				     	<td><center>CNPJ:</center></td>
						<td> <%=cliente.getCnpj() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getRg()!=null )if( cliente.getRg().trim()!=""){%>
					<tr>
				     	<td><center>RG:</center></td>
						<td> <%=cliente.getRg() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getCpf()!=null )if( cliente.getCpf().trim()!=""){%>
					<tr>
				     	<td><center>CPF:</center></td>
						<td> <%=cliente.getCpf() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getIe()!=null )if( cliente.getIe().trim()!=""){%>
					<tr>
				     	<td><center>Inscrição Estadual:</center></td>
						<td> <%=cliente.getIe() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getCcm()!=null)if( cliente.getCcm()!=cliente.getCcm()){%>
					<tr>
				     	<td><center>CCM:</center></td>
						<td> <%=cliente.getCcm() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getCep()!=null )if( cliente.getCep().trim()!=""){%>
					<tr>
				     	<td><center>CEP:</center></td>
						<td> <%=cliente.getCep() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getRua()!=null )if( cliente.getRua().trim()!=""){%>
					<tr>
				     	<td><center>Endereço:</center></td>
						<td> <%=cliente.getRua() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getNumero()!=null )if( cliente.getNumero().trim()!=""){%>
					<tr>
				     	<td><center>Número:</center></td>
						<td> <%=cliente.getNumero() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getComplemento()!=null )if( cliente.getComplemento().trim()!=""){%>
					<tr>
				     	<td><center>Complemento:</center></td>
						<td> <%=cliente.getComplemento() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getBairro()!=null )if( cliente.getBairro().trim()!=""){%>
					<tr>
				     	<td><center>Bairro:</center></td>
						<td> <%=cliente.getBairro() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getMunicipio()!=null )if( cliente.getMunicipio().trim()!=""){%>
					<tr>
				     	<td><center>Município:</center></td>
						<td> <%=cliente.getMunicipio() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getEstado()!=null )if( cliente.getEstado().trim()!=""){%>
					<tr>
				     	<td><center>Estado:</center></td>
						<td> <%=cliente.getEstado() %> </td>
					</tr>
					<%}%>
					<% if(cliente.getTelefone()!=null )if( cliente.getTelefone().trim()!=""){%>
					<tr>
				     	<td><center>Telefone:</center></td>
						<td> <%=cliente.getTelefone() %> </td>
					</tr>
					<%}%>
				</table>
		      	<br>
		      	<br>
		      	<input type="hidden" name="idCliente" value="<%=idCliente %>"/>
		      	<input type="submit" value="Editar" />		
				
			</form>
			
			<form action="adiciona_contato.jsp">
		     	<h2>Contatos:</h2>
		     	<table cellspacing="1" cellpadding="1" border="3"> 			
		     	<%
		     	for(Contato c : contatos){	     	
		     	%>
			     	<tr>
			     	<td><a href="exibe_contato.jsp?idContato=<%=c.getIdContato()%>&idCliente=<%=idCliente%>"><%= c.getNome()%></a></td>
			     	<td><a href="edita_contato.jsp?idContato=<%=c.getIdContato()%>&idCliente=<%=c.getIdCliente()%>">Editar</a></td>
	     			<td><a href=javascript:confirmExclusao(<%=c.getIdContato()%>)>Remover</a></td>
			     	</tr>
		     	<%
		     	}
		     	%>
		     	</table>
		      	<br>
		      	<%System.out.println(idCliente);%>
		      	<input type="hidden" name="idCliente" value="<%=idCliente %>"/>
		      	<input type="submit" value="Adicionar" />		
				
			</form>
			      </center> 
	     	</body>
   </html>

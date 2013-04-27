<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
<style type="text/css">
#apDiv1 {
	position:absolute;
	width:152px;
	height:92px;
	z-index:1;
	left: 15px;
	top: 18px;
	text-align: center;
}
#apDiv2 {
	position:absolute;
	width:153px;
	height:106px;
	z-index:2;
	left: 530px;
	top: 18px;
	text-align: center;
}
#apDiv2 p {
	font-size: 12px;
	color: #FFF;
}
#apDiv1 p {
	font-weight: bold;
	font-size: 12px;
}
#apDiv3 {
	position:absolute;
	width:153px;
	height:106px;
	z-index:2;
	left: 363px;
	top: 17px;
	text-align: center;
	font-weight: bold;
}
.H {
	color: #FFF;
}
#apDiv3 p a {
	font-size: 12px;
}
#apDiv2 p a {
	font-weight: bold;
}
#apDiv4 {
	position:absolute;
	width:153px;
	height:106px;
	z-index:2;
	left: 699px;
	top: 18px;
	text-align: center;
}
#apDiv4 p a {
	font-size: 12px;
	font-weight: bold;
}
#apDiv5 {
	position:absolute;
	width:153px;
	height:106px;
	z-index:2;
	left: 871px;
	top: 18px;
	text-align: center;
}
#apDiv5 p a {
	font-size: 12px;
	font-weight: bold;
}
#apDiv6 {
	position:absolute;
	width:138px;
	height:110px;
	z-index:2;
	left: 1041px;
	top: 17px;
	text-align: center;
}
#apDiv6 p a {
	font-size: 12px;
	font-weight: bold;
}
#apDiv7 {
	position:absolute;
	width:153px;
	height:106px;
	z-index:2;
	left: 191px;
	top: 12px;
	text-align: center;
	font-weight: bold;
}
</style>
 
	     <body>

	     <p>
	       <script>
	     	function confirmExclusao(id) {  
				if (confirm("Tem certeza que deseja excluir esse item da OS?")) {  
					location.href="removeOS_has_Produtos?idOS_has_Produtos="+id;  
				}  	
			} 
	     	</script>
		      <%
	     	OSDAO dao = new OSDAO();
	     	OS os;
	     	int idOS = 0;
	     	System.out.println(request.getParameter("idOS"));
	     	if(request.getParameter("idOS") != null){
	     		idOS = Integer.parseInt(request.getParameter("idOS"));
	     	}
	     	os = dao.getOS(idOS);
	     	
	     	ClienteDAO cdao = new ClienteDAO();
	     	Cliente cliente;
	     	cliente = cdao.getCliente(os.getIdCliente());
	     	
			Condicao_PagamentoDAO cpdao = new Condicao_PagamentoDAO();
			Condicao_Pagamento cp = cpdao.getCond(os.getIdCondicao_Pagamento());
			
			CaixaDAO cadao = new CaixaDAO();
			Caixa caixa = cadao.getCaixa(os.getIdCaixa());
			
			CorDAO cordao = new CorDAO();
			Cor cor1 = cordao.getCor(os.getIdCor1());
			Cor cor2 = cordao.getCor(os.getIdCor2());
			Cor cor3 = cordao.getCor(os.getIdCor3());
			
			String dataLancamento = os.getDataLancamento();
			String dataEntrega = os.getDataEntrega();
			String observacao = os.getObservacao();
			String status = os.getStatus();
			
	     	%>
<center>
	     </p>
	     <div id="apDiv3">
	       <p><a href="imprime_os.jsp?idOS=<%=idOS%>" target="_blank"><img src="imprimantcleansze.jpg" alt="" width="65" height="65" border="0"></a></p>
	       <p><a href="imprime_os.jsp?idOS=<%=idOS%>" target="_blank">IMPRIMIR OS</a></p>
         </div>
	     <p>&nbsp;</p>
		 <%if(os.getStatus().equals("Concluída")==true){%>	    
	     <div id="apDiv6">
	       <p> 
	       		<a href="editaOS?idOS=<%=os.getIdOS()%>&cliente=<%=os.getIdCliente()%>&dataLancamento=<%=os.getDataLancamento()%>&dataEntrega=<%=os.getDataEntrega()%>&condicao_pagamento=<%=os.getIdCondicao_Pagamento()%>&observacao=<%=os.getObservacao()%>&ordenar=<%=os.getOrdenar()%>&status=Em Andamento"> <img src="reload.png" alt=" " width="78" height="78" border="0"><br>
	         		<br>
           			REABRIR OS
           		</a>
           </p>
		</div>
		<%}%>
	     <p>&nbsp;</p>
	     <a href="imprime_protocolo.jsp?idOS=<%=idOS%>" target="_blank">
      		<div id="apDiv1">
	    	<p>
	    		<img src="IMAGEM DOCUMENTO.png" width="54" height="54" border="0"></p>
	     	<p>PROTOCOLO DE ENTREGA</p>
	    	</div>
	    </a>
	    <%if(os.getStatus().equals("Aguardando Aprovação") && os.getStatus().equals("Concluída")==false){%>
	     <div id="apDiv4">
	       <p>
		       <a href="editaOS?idOS=<%=os.getIdOS()%>&cliente=<%=os.getIdCliente()%>&dataLancamento=<%=os.getDataLancamento()%>&dataEntrega=<%=os.getDataEntrega()%>&condicao_pagamento=<%=os.getIdCondicao_Pagamento()%>&observacao=<%=os.getObservacao()%>&ordenar=<%=os.getOrdenar()%>&status=Em Andamento">
		       	  <img src="aprovado.jpg" alt=" " width="56" height="67" border="0">
	       </p>
	       <p>
	       		APROVAR
	       		</a>
	       	</p>
         </div>
        <%}%>
        <%if (os.getStatus().equals("Concluída")==false){%> 
	     <div id="apDiv5">
	       <p>
			<a href="editaOS?idOS=<%=os.getIdOS()%>&cliente=<%=os.getIdCliente()%>&dataLancamento=<%=os.getDataLancamento()%>&dataEntrega=<%=os.getDataEntrega()%>&condicao_pagamento=<%=os.getIdCondicao_Pagamento()%>&observacao=<%=os.getObservacao()%>&ordenar=<%=os.getOrdenar()%>&status=Concluída">
				<img src="concluir.png" alt=" " width="71" height="71" border="0">
		   </p>
	       <p>CONCLUIR OS
	       </a>
	       </p>
         </div>
         <%}%>
         <%if(os.getStatus().equals("Aguardando Aprovação")==false && os.getStatus().equals("Concluída")==false){%>
         <div id="apDiv2">
         <a href="editaOS?idOS=<%=os.getIdOS()%>&cliente=<%=os.getIdCliente()%>&dataLancamento=<%=os.getDataLancamento()%>&dataEntrega=<%=os.getDataEntrega()%>&condicao_pagamento=<%=os.getIdCondicao_Pagamento()%>&observacao=<%=os.getObservacao()%>&ordenar=<%=os.getOrdenar()%>&status=Aguardando Aprovação">
   			<p>
				<img src="hb.png" width="65" height="65" border="0">
			</p>
    		<p>AGUARDAR APROVAÇÃO</p></a>
    	</a>
		</div>
	 	<%}%>
	 	<div id="apDiv7">
	 	  <p><img src="laudo-avaliacao.jpg" width="105" height="90"></p>
	 	  <p><a href="exibe_laudo.jsp?idOS=<%=idOS%>" target="_blank">IMPRIMIR LAUDO</a></p>
 	     </div>
<p>&nbsp;</p>
	     <p>&nbsp; </p>
		    <form action="edita_os.jsp">
	     	<h2>Ordem de Serviço:</h2>
	     	<table cellspacing="1" cellpadding="1" border="3"> 
	     	<tr>
	     	<td><center>Código da OS:</center></td>
	     	<td><%=idOS%></td>
	     	</tr>
	     	<tr>
	     	<td><center>Status:</center></td>
	     	<td><%=status%></td>
	     	</tr>
	     	<tr>
	     	<td><center>Cliente:</center></td>
	     	<td> <%=cliente.getIdCliente() + "-" + cliente.getFantasia()%> </td>
	     	</tr>
	     	<tr>
	     	<td><center>Data de Lançamento:</center> </td>
	     	<td> <%=dataLancamento%> </td>
	     	</tr>
	     	<tr>
	     	<td><center>Data de Entrega: </center></td>
	     	<td><%=dataEntrega %></td>
	     	</tr>
	     	<tr>
	     	<td><center>Condição de Pagamento: </center></td>
	     	<td><%=cp.getCondicao_pagamento()%></td>
	     	</tr>
	     	<tr>
	     	<td><center>Especialidade: </center></td>
	     	<td><%=caixa.getCaixa() %></td>
	     	</tr>
	     	<tr>
	     	<td><center>Patrimônio: </center></td>
	     	<td><%=caixa.getPatrimonio() %></td>
	     	</tr>
	     	<%if (cor1.getCor()!=null && cor1.getCor().equals("")==false){%>
		     	<tr>
		     	<td><center>Cor 1: </center></td>
		     	<td><%=cor1.getCor() %></td>
		     	</tr>
		    <%}%>
<%if (cor2.getCor()!=null && cor2.getCor().equals("")==false){%>
		     	<tr>
		     	<td><center>Cor 2: </center></td>
		     	<td><%=cor2.getCor() %></td>
		     	</tr>
		    <%}%>
<%if (cor3.getCor()!=null && cor3.getCor().equals("")==false){%>
		     	<tr>
		     	<td><center>Cor 3: </center></td>
		     	<td><%=cor3.getCor() %></td>
		     	</tr>
		    <%}%>
<%if (observacao!=null && observacao.equals("")==false){%>
		     	<tr>
		     	<td><center>Observação:</center></td>
				<td> <%=observacao%> </td>
				</tr>
			<%}%>
			</table>

			<input type="hidden" value="<%=idOS %>" name="idOS" />
			<% if (os.getStatus().equals("Concluída")==false){%>
	      		<input type="submit" value="Editar" />	
	      	<%}%>
      	 </form>
			
			<br>
	      	<br>
			<form action="adiciona_os_has_produtos.jsp?idOS=1&idCliente=1">
	     	<h2>Itens:</h2>
	     	<table cellspacing="1" cellpadding="1" border="3"> 
	     	<tr>
	     	<td>
	     		Código
	     	</td>
	     	<td>
	     		Instrumento
	     	</td>
	     	<td>
	     		Quantidade
	     	</td>
<!--     	
			<td>
	     		Valor
	     	</td> 
!-->
	     	<td>
	     		Patrimônio
	     	</td>
<!--	     	<td>
	     		Conserto
	     	</td>
!-->	     	<td>
	     		Quantidade sem conserto
	     	</td>
<!--
	     	<td>
	     		Motivos
	     	</td>
!-->
	     	</tr>
	     	<tr>
	     	<%
	     	OS_has_ProdutosDAO hhsdao = new OS_has_ProdutosDAO();
	     	List<OS_has_Produtos> ohps = hhsdao.getOHPsOS(idOS);
	     	
	     	ProdutoDAO pdao = new ProdutoDAO();
	     	MotivoDAO mdao = new MotivoDAO();
	     	
	     	List<OS_has_Produtos> ohpsOrd = ohps;
			if(os.getOrdenar().equals("instr_c")){
		     	Collections.sort (ohpsOrd, new Comparator() {  
					public int compare(final Object o1, final Object o2) {
						final ProdutoDAO pdao = new ProdutoDAO();
						final OS_has_Produtos ohp1 = (OS_has_Produtos) o1; 
						final OS_has_Produtos ohp2 = (OS_has_Produtos) o2; 
						final String nomeP1 = pdao.getProduto(ohp1.getIdProduto()).getDescricao();
						final String nomeP2 = pdao.getProduto(ohp2.getIdProduto()).getDescricao();
						if(nomeP1!=null & nomeP2!=null)
							return nomeP1.compareTo(nomeP2);
						else
							return 0;
					}
				}
				);
			}else if(os.getOrdenar().equals("instr_d")){
		     	Collections.sort (ohpsOrd, new Comparator() {  
					public int compare(final Object o1, final Object o2) {
						final ProdutoDAO pdao = new ProdutoDAO();
						final OS_has_Produtos ohp1 = (OS_has_Produtos) o1; 
						final OS_has_Produtos ohp2 = (OS_has_Produtos) o2; 
						final String nomeP1 = pdao.getProduto(ohp1.getIdProduto()).getDescricao();
						final String nomeP2 = pdao.getProduto(ohp2.getIdProduto()).getDescricao();
						if(nomeP1!=null & nomeP2!=null)
							return nomeP2.compareTo(nomeP1);
						else
							return 0;
					}
				}
				);
			}else if(os.getOrdenar().equals("patr_c")){
		     	Collections.sort (ohpsOrd, new Comparator() {  
					public int compare(final Object o1, final Object o2) {
						final ProdutoDAO pdao = new ProdutoDAO();
						final OS_has_Produtos ohp1 = (OS_has_Produtos) o1; 
						final OS_has_Produtos ohp2 = (OS_has_Produtos) o2; 
						final String nomeP1 = ohp1.getPatrimonio();
						final String nomeP2 = ohp2.getPatrimonio();
						if(nomeP1!=null & nomeP2!=null)
							return nomeP1.compareTo(nomeP2);
						else
							return 0;
					}
				}
				);
			}else if(os.getOrdenar().equals("patr_d")){
		     	Collections.sort (ohpsOrd, new Comparator() {  
					public int compare(final Object o1, final Object o2) {
						final ProdutoDAO pdao = new ProdutoDAO();
						final OS_has_Produtos ohp1 = (OS_has_Produtos) o1; 
						final OS_has_Produtos ohp2 = (OS_has_Produtos) o2; 
						final String nomeP1 = ohp1.getPatrimonio();
						final String nomeP2 = ohp2.getPatrimonio();
						if(nomeP1!=null & nomeP2!=null)
							return nomeP2.compareTo(nomeP1);
						else
							return 0;
					}
				}
				);			
			}
	     	
	     	for(OS_has_Produtos ohp : ohpsOrd){
	     		ProdutoDAO proddao = new ProdutoDAO();
	     		Produto p = proddao.getProduto(ohp.getIdProduto());
	     		if(p.getUltimo()==1)
	     			Collections.swap(ohpsOrd, ohpsOrd.indexOf(ohp), ohpsOrd.size()-1); 
	     	}
	     	
	     	for(OS_has_Produtos ohp : ohpsOrd){
	     		Produto p = pdao.getProduto(ohp.getIdProduto());
	     		Motivo m = mdao.getMotivo(ohp.getIdMotivo());
	     		System.out.println("OS has Produtos: " + ohps.size());	     	
	     	%>
	     	<td><%= p.getIdProduto()%></td>
	     	<td><%= p.getDescricao()%></td>
	     	<td><%= ohp.getQuantidade()%></td>
<!-- 	     	
	     	<td>R$ <%= p.getValor()*ohp.getQuantidade()%></td>
!--> 
	     	<td><%= ohp.getPatrimonio()%></td>
<!--	     	<td><%= ohp.getConserto()%></td> !-->
	     	<td><%= ohp.getQuebrado_qtd()%></td>
<!--	     	
			<% if (m != null && m.getMotivo()!=null){ %>
	     		<td><%= m.getMotivo()%></td>
	     	<% }else { %>
	     		<td></td>
	     	<% }%>
!--> 	     	
	     	<td><a href="edita_os_has_produtos.jsp?idOsHasProdutos=<%=ohp.getIdOS_has_produtos()%>&idCliente=<%=os.getIdCliente()%>">Editar</a></td>
	     	<td><a href=javascript:confirmExclusao(<%=ohp.getIdOS_has_produtos()%>)>Remover</a></td>
	     	<td><a href="adiciona_sem_conserto_pre.jsp?idOsHasProdutos=<%=ohp.getIdOS_has_produtos()%>&quantidade=<%=ohp.getQuantidade()%>">Sem conserto</a></td>
	     	</tr>
	     	<%
	     	}
	     	%>
	     	</table>		
	      	<input type="hidden" value="<%=idOS%>" name="idOS" />
	      	<input type="hidden" value="<%=os.getIdCliente()%>" name="idCliente" />
	      	<% if (os.getStatus().equals("Concluída")==false) {%>
	      		<input type="submit" value="Adicionar" />		
	      	<%}%>
			</form>
</center>			                   
   	</body>
   </html>

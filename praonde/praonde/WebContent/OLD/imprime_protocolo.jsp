	<%@ page import="java.util.*, Dao.*, Servlets.*" %>
	<html>
	<head>
	<title>Protocolo de Entrega</title>
	</head>
	
	<%
	
		int idOS = Integer.parseInt(request.getParameter("idOS"));
		
		OSDAO osdao = new OSDAO();
		OS os = osdao.getOS(idOS);
		
		ClienteDAO clidao = new ClienteDAO();
		Cliente cli = clidao.getCliente(os.getIdCliente());
		
		CaixaDAO caidao = new CaixaDAO();
		Caixa caixa = caidao.getCaixa(os.getIdCaixa());
		
		CorDAO cordao = new CorDAO();
		Cor cor1 = cordao.getCor(os.getIdCor1());
		Cor cor2 = cordao.getCor(os.getIdCor2());
		Cor cor3 = cordao.getCor(os.getIdCor3());
		
		OS_has_ProdutosDAO ohpdao = new OS_has_ProdutosDAO();
		List<OS_has_Produtos> ohps = ohpdao.getOHPsOS(idOS);
		
		Caixa_has_ProdutosDAO chpdao = new Caixa_has_ProdutosDAO();
		
	    List<OS_has_Produtos> ohpsOrd = ohps;
				if(os.getOrdenar().equals("Por Instrumento - Crescente")){
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
				}else if(os.getOrdenar().equals("Por Instrumento - Decrescente")){
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
				}else if(os.getOrdenar().equals("Por Patrimônio - Crescente")){
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
				}else if(os.getOrdenar().equals("Por Patrimônio - Decrescente")){
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
		
		int sequenciaPecas = 0;
		int totalPecas = 0;
		
	 	for(OS_has_Produtos ohp : ohpsOrd){
	 		ProdutoDAO proddao = new ProdutoDAO();
	 		Produto p = proddao.getProduto(ohp.getIdProduto());
	 		if(p.getUltimo()==1)
	 			Collections.swap(ohpsOrd, ohpsOrd.indexOf(ohp), ohpsOrd.size()-1); 
	 		if(p.getDuplo()==1)
	 			totalPecas = totalPecas + ohp.getQuantidade();
	 	}
		
	%>
	
	<body>
	<table width="1093" border="1" bordercolor="WHITE">
	  <tr>
	    <td width="721">
	    	<img src="logo.png" width="90" height="90" />
	    </td>
	    <td width="472" align="center" valign="baseline" >
	    	<h4>
	    		<%=os.getIdOS()%> - Data: <%=os.getDataLancamento()%>
	    	</h4>
	    </td>
	  </tr>
	  <tr>
	    <td height="20"><h3>HOSPITAL DOS INSTRUMENTOS CIRÚRGICOS</h3></td>
	    <td align="center"><div>Protocolo de entrega de serviço</div>
	  </tr>
	</table>
	<p>&nbsp;</p>
	<table width="999" border="1" bordercolor="#000000" align="center">
	  <tr>
	    <td width="999" align="center" valign="middle" bordercolor="#000000"><center><strong>DADOS DO CLIENTE</strong></center></td>
	  </tr>
	</table>
	<br />
	<table width="1092" border="1" bordercolor="#FFFFFF" align="center"> 
	  <tr>
	    <td width="570" align="left"> CLIENTE: <%=cli.getFantasia()%></td>
	  </tr>
	  <tr>
	  <%
	  	String endereco = "";
	  	if(cli.getRua()!=null){
	  		endereco = cli.getRua();
		  	if(cli.getNumero()!=null)
		  		endereco = endereco + ", " + cli.getNumero();
		}
	  	if(cli.getBairro()!=null)
	  		endereco = endereco + ", " + cli.getBairro();
	  	if(cli.getMunicipio()!=null)
	  		endereco = endereco + ", " + cli.getMunicipio();
	  %>
	    <td align="left"> ENDEREÇO: <%=endereco%></td>
	  </tr>
	  <tr>
	    <td align="left"> TELEFONE: <%=cli.getTelefone()%></td>
	  </tr>
	</table>
	<br />
	<div></div>
	<div></div>
	<div></div>
	<div></div>
	<br />
	<br />
	<table width="1156" border="1" bordercolor="#FFFFFF" align="center">
	  <tr>
	    <td width="1146" align="center" valign="middle" bordercolor="#FFFFFF"> <strong><%=caixa.getCaixa() + " " + os.getNumero_Caixa()%> - <%=cor1.getCor() + " " + cor2.getCor() + " " + cor3.getCor()%></strong></td>
	  </tr>
	</table>
	<p>&nbsp;</p>
	<table width="1054" border="1" bordercolor="#000000" align="center">
	  <tr>	
	    <td width="1054" align="center" valign="middle" bordercolor="#000000"><center><strong>DADOS DO SERVIÇO</strong></center></td>
	  </tr>
	</table>
	<br>
	<table width="1072" border="1" bordercolor="#000000" align="center">
	  <tr>
	    <td width="57" align="center">Item</td>
	    <td width="71" align="center">Quant</td>
	    <td width="602" align="center">Descrição das Peças</td>
	    <td width="386" align="center">Observação</td>
	  </tr>
	    <tr>
	      <td height="20" colspan="4" align="center">&nbsp;</td>
	    </tr>
	  <%
	  	for (OS_has_Produtos ohp : ohpsOrd){
	  		for(int i = 0; i<ohp.getQuantidade(); i ++){
	    		totalPecas++;
	    		sequenciaPecas++;
	    		ProdutoDAO pdao = new ProdutoDAO();
	    		Produto p = pdao.getProduto(ohp.getIdProduto());
	  %>
	    <tr>
	    <td width="57" align="center" height="20">
	    	<%=sequenciaPecas%>
	    </td>
	    <td width="71" align="center">
	    	1
	    </td>
	    <td width="602" align="center">
	    	<%=p.getDescricao()%>
	    </td>
	    <td width="386" align="center">
	    <%
	    	boolean patrCli = false;
	    	List<Caixa_has_Produtos> chps = chpdao.getCHPsOS(os.getIdCaixa());    
	    	if(patrCli==false){
	    		for (Caixa_has_Produtos chp : chps){
	    			if (chp.getPatrimonio()!=null && chp.getPatrimonio().equals("")==false){
	    				patrCli  = true;
	    			}
	    		}
	    	}
	    	
	    	String strTotalPecas = Integer.toString(totalPecas);
	    	if(strTotalPecas.length()==1){
	    		strTotalPecas = "0"+strTotalPecas;
	    	}
	    	
	    	if (patrCli==false){
		%>
		    	<%=caixa.getPatrimonio() + " " + os.getNumero_Caixa()+"-"+strTotalPecas %>
		<%	
			}else{
		%>
	<%=caixa.getPatrimonio() + " " + os.getNumero_Caixa()+"-"+ohp.getPatrimonio() %>
		    <%
		    }
		%>
	    </td>
	  	</tr>
	  <%		
	  		}
	 	}
	  %>
	</table>
	<table width="1083" border="1" bordercolor="white" align="center">
	  <tr>
	    <td width="57" align="center" height="20"></td>
	    <td width="71" align="center"><%=totalPecas%></td>
	    <td width="602" align="left">Total de Peças</td>
	    <td width="386" align="center"> Assinatura e Identifica&ccedil;&atilde;o do Recebedor </td>
	  </tr>
	</table>
	<table width="1087" border="1" bordercolor="#FFFFFF" align="center">
	  <tr>
	<!--    <td width="273">Hospital dos Instrumentos Cirúrgicos</td> !-->
	    <td width="1300" align="right"><p><br>
	    		___________________________________________</p></td>
	  </tr>
	</table>
	<p>&nbsp;</p>
	</body>
	</html>

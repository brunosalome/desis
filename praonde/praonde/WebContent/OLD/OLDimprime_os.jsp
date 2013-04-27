<%@ page import="java.util.*, Dao.*, Servlets.*" %>
<html>
<head>
<title>Ordem de Serviço</title>
</head>
<%
	int idOS = Integer.parseInt(request.getParameter("idOS"));
	String sCor = "";
	
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
	
    List<OS_has_Produtos> ohpsOrd = ohps;
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
	
	int sequenciaPecas = 0;
	int totalPecas = 0;
%>
<body>
<table width="1309" border="1" bordercolor="WHITE">
  <tr>
    <td width="721"><img src="logo.png" width="90" height="90" /></td>
    <td width="572" align="center" valign="baseline" ><h3>ENTRADA  </h3></td>
  </tr>
  <tr>
    <td height="20"><h3>HOSPITAL DOS INSTRUMENTOS CIRÚRGICOS</h3></td>
    <td align="center"><div><%=os.getIdOS()%> -  Data: <%=os.getDataLancamento()%></div></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="1145" border="1" bordercolor="#000000" align="center">
  <tr>
    <td width="489" align="center" valign="middle" bordercolor="#000000"><strong>DADOS DO CLIENTE</strong></td>
  </tr>
</table>
<br />
<table width="1145" border="1" bordercolor="#FFFFFF" align="center"> 
  <tr>
    <td width="570" align="left">
		CLIENTE: <%=cli.getFantasia()%>
	</td>
  </tr>
</table>

<br />
<div></div>
<div></div>
<div></div>
<div></div>
<br />
<br />

  <table width="1140" border="1" bordercolor="white" align="center">
  <tr>
    <td width="285">1º__________________________________</td>
    <td width="285">2º__________________________________</td>
    <td width="285">3º__________________________________</td>
    <td width="257">4º_______________________________</td>
  </tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr>
    <td>5º__________________________________</td>
    <td>6º__________________________________</td>
    <td>7º__________________________________</td>
    <td>8º_______________________________</td>
  </tr>
</table>

</table>
<br />
<br />
<table width="500" border="1" bordercolor="black" align="center">
  <tr>
  <%
  	if (cor1.getCor()!=null){
  		sCor = sCor + cor1.getCor();
  	}
  	if (cor2.getCor()!=null){
  		sCor = sCor + " " + cor2.getCor();
  	}
  	if (cor3.getCor()!=null){
  		sCor = sCor + " " + cor3.getCor();
  	}
  %>
    <td width="500" align="center" valign="middle" bordercolor="black"> <strong><%=caixa.getCaixa() + " " + os.getNumero_Caixa()%> - <%=sCor %></strong></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="1145" border="1" bordercolor="#000000" align="center">
  <tr>
    <td width="489" align="center" valign="middle" bordercolor="#000000"><strong>DADOS DO SERVIÇO</strong></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="1144" border="1" bordercolor="#000000" align="center">
  <tr>
    <td width="57" align="center">Item</td>
    <td width="71" align="center">Quant</td>
    <td width="602" align="center">Descrição das Peças</td>
    <td width="386" align="center">Observação</td>
  </tr>
  <%
  	for (OS_has_Produtos ohp : ohpsOrd){
		ProdutoDAO pdao = new ProdutoDAO();
		Produto p = pdao.getProduto(ohp.getIdProduto());
		sequenciaPecas++;
		totalPecas = totalPecas + ohp.getQuantidade();
  %>
  <tr>
    <td width="57" align="center" height="20">
    	<%=sequenciaPecas%>
    </td>
    <td width="71" align="center">
    	<%=ohp.getQuantidade()%>    
    </td>
    <td width="602" align="center">
		<%=p.getDescricao()%>
    </td>
    <td width="386" align="center">
    	<%=ohp.getObservacao() %>
    </td>
  </tr>
  <%
 	}
  %>
</table>

<table width="1144" border="1" bordercolor="white" align="center">
  <tr>
    <td width="57" align="center" height="20"></td>
    <td width="71" align="center"><%=totalPecas%></td>
    <td width="602" align="left">Total de Peças</td>
    <td width="386" align="center"></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="1146" border="1" bordercolor="#FFFFFF" align="center">
  <tr>
    <td width="273">Hospital dos Instrumentos Cirúrgicos</td>
    <td width="821" align="right"> Assinatura e Identificação do Recebedor </td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>

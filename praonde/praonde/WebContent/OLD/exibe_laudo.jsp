<%@ page import="java.util.*, Dao.*, Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Laudo</title>
</head>

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
	     	
	     	ContatoDAO contdao = new ContatoDAO();
	     	Contato contato;
	     	contato = contdao.getContato(os.getIdSolicitante());
		
			String dataLancamento = os.getDataLancamento();
			String dataEntrega = os.getDataEntrega();
			String observacao = os.getObservacao();
			String status = os.getStatus();
			
			OS_has_ProdutosDAO ohpdao = new OS_has_ProdutosDAO();
			List<OS_has_Produtos> oshp = ohpdao.getOHPsOS(idOS);
			
			Sem_ConsertoDAO scdao = new Sem_ConsertoDAO();
			List<Sem_Conserto> scs;
			
	%>

<body>
<p><img src="laudo_header.jpg" alt="" width="609" height="136" />
</p>
<p>Ao</p>
<p><%=cliente.getNome()%></p>
<p>A/C</p>
<p><%=contato.getNome()%></p>
<p>Referente ao laudo de instrumento cirúrgico:</p>
<ul>
<% 
	String motivos;
	int contMot;
	ProdutoDAO pdao = new ProdutoDAO();
	MotivoDAO mdao = new MotivoDAO();
	Produto prod = new Produto();
	Motivo mot;
	for (OS_has_Produtos ohp : oshp){
		motivos = "";
		contMot = 0; 
		scs = scdao.getSemConsertoPorItem(ohp.getIdOS_has_produtos());
		if(scs.size()>0){
			prod = pdao.getProduto(ohp.getIdProduto());
			for(Sem_Conserto sc : scs){
				contMot++;
				if(sc.getIdMotivo1()!=0){
					mot = mdao.getMotivo(sc.getIdMotivo1());
					motivos = mot.getMotivo() + ", " + motivos;
				}
				if(sc.getIdMotivo2()!=0){
					mot = mdao.getMotivo(sc.getIdMotivo2());
					motivos = mot.getMotivo() + ", " + motivos;
				}
				if(sc.getIdMotivo3()!=0){
					mot = mdao.getMotivo(sc.getIdMotivo3());
					motivos = mot.getMotivo() + ", " + motivos;
				}
			}
%>
  <li><%=prod.getDescricao()%> - <%=motivos%></li> <% if (contMot >= 3){ %> VIDA ÚTIL COMPROMETIDA! <%}%>
<%
		}
}
%>
</ul>
<p>&nbsp;</p>
<p>Atenciosamente,</p>
<p>Eduardo Gandolfi</p>
<p>F: 8555-7474 / 9633-2233</p>
<p>&nbsp;</p>
<p><img src="laudo_footer.jpg" alt=" " width="675" height="98" /></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>

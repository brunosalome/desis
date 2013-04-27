<%@ page import="java.util.*, Dao.*, Servlets.*,java.io.*,java.sql.*"%>



<%

	System.out.println("TESTE DE ADICIONA VEI");
	int idUsuario=0;
	idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
	int idVeiculo = Integer.parseInt(request.getParameter("idVeiculo"));
	
	System.out.println("idVeiculo:" + idVeiculo);
	System.out.println("idUsuario:" + idUsuario);
	
	VeiculoDAO vdao = new VeiculoDAO();
	ArrayList<Veiculo> veiculos = vdao.getListaVeiculos(idUsuario);
	Veiculo vei = new Veiculo();
	
	if (idVeiculo==0){
		if(veiculos.isEmpty()==false){
			System.out.println("Entrei");
			idVeiculo = veiculos.get(0).getIdVeiculo();
			vei = vdao.getVeiculo(idVeiculo);
		}
	}else{
		vei = vdao.getVeiculo(idVeiculo);
	}
	
%>

<!DOCTYPE html>
<html lang="pt">
<head>
<title>Contacts</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.6.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Didact_Gothic_400.font.js"></script>
<script type="text/javascript" src="js/Shanti_400.font.js"></script>
<script src="js/roundabout.js" type="text/javascript"></script>
<script src="js/roundabout_shapes.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/script.js"></script>

</head>
<body id="page5">
	     <script language="javascript" type="text/javascript">
	     function alta(valor) {
				valor.value=valor.value.toUpperCase();	
		 }
	 	
	 	 function valida() {
	 		fantasia = document.form1.fantasia.value;
	 		
	 		if(fantasia=="") {
	 			alert("Insira ao menos o nome fantasia do cliente!");
	 			document.form1.fantasia.focus();
	 			return false;
	 		}else{
	 			return true;
	 		}
	 	}
	 	function mascara(src, mask){
	 	var i = src.value.length;
	 	var saida = mask.substring(0,1);
	 	var texto = mask.substring(i);
	 	if (texto.substring(0,1) != saida)
	 	{
	 	src.value += texto.substring(0,1);
	 	}
	 	} 
	 	function confirmExclusao(idVeiculo, idUsuario) {  
			if (confirm("Tem certeza que deseja excluir este veiculo?")) {
					location.href="removeVeiculo?idVeiculo="+idVeiculo+"&idUsuario="+idUsuario;  
				}
		}  
	     </script>
<div class="body1">
	<div class="main">
		<header>
			<div class="wrapper">
				<nav>
					<ul id="top_nav">
						<li><a href="Support.html">Support</a></li>
						<li><a href="#">FAQs</a></li>
						<li class="end"><a href="#">Sitemap</a></li>
					</ul>
				</nav>
				<span class="date">Segunda, Junho 6, 2011  &nbsp; &nbsp; 17:19</span>
			</div>
			<div class="wrapper">
				<h1><a href="index.html" id="logo">Pro Soft</a></h1>
				<nav>
					<ul id="menu">
						<li id="menu_active"><a href="usuarioLogado.jsp?idUsuario=<%=idUsuario%>"><span><span>Painel</span></span></a></li>
						<li ><a href="#"><span><span>Cadastrar veículo</span></span></a></li>
						<li class="nav3"><a href="usuarioLogado.jsp?idUsuario=<%=idUsuario%>"><span><span>Oferecer Carona</span></span></a></li>
						<li class="nav4"><a href="busca_carona.jsp"><span><span>Buscar Carona</span></span></a></li>
						<li class="nav5"><a href="amigos.jsp"><span><span>Amigos</span></span></a></li>
					</ul>
				</nav>
			</div>
		</header><div class="ic">More Website Templates  at TemplateMonster.com!</div>

		<article id="content">
			<% if (idVeiculo!=0){%>
			<section class="col1">
				<h2>Seus veículos</h2>
					<% for(Veiculo veiculo : veiculos){ %>
						<div class="wrapper pad_bot2">
							<figure class="left marg_right1">
								<img src="fotos/veiculos/<%=veiculo.getFoto()%>" width=50/>
							</figure>
							<p class="pad_bot1 pad_top1">
		                    	<span class="color1">
		                        	<a href="exibe_veiculo.jsp?idUsuario=<%=veiculo.getIdUsuario()%>&idVeiculo=<%=veiculo.getIdVeiculo()%>">
		                        		<%=veiculo.getPlaca()%>
		                        	</a>
								</span>
							</p>
							<p><%=veiculo.getMarca()%></p>
						</div>
	                <% } %>
	       		</section>
	       		<%}else{%>
	       			<section class="col1">
	       			</section>
	       		<%}%>
	       		<% if (idVeiculo!=0){%>
				<section class="col2">
					<h2 class="pad_bot1"><%=vei.getMarca()%> - <%=vei.getModelo()%></h2>
					<div class="wrapper">
						<figure class="left marg_right1"><img src="fotos/veiculos/<%=vei.getFoto()%>" width=100/></figure>
						<p class="pad_top1 pad_bot1"><strong class="color1"><%=vei.getCor()%></strong></p>
						<p class="pad_top1 pad_bot1"><strong class="color1"><%=vei.getPlaca()%></strong></p>
						<p class="pad_top1 pad_bot1"><strong class="color1"><%=vei.getAno()%></strong></p>
						<br /><br /><br /><br />
						<a href="altera_veiculo.jsp?idUsuario=<%=idUsuario%>&idVeiculo=<%=idVeiculo%>" class="button left">Editar</a>
						<a href=javascript:confirmExclusao(<%=idVeiculo%>,<%=idUsuario%>) class="button right">Remover</a>
					</div>
				<%}else{%>
					<section class="col2">
					<h2 class="pad_bot1">Sem cadastros!</h2>
					</section>
				<%}%>
       		</section>
		</article>
	</div>
</div>
<div class="body2">
	<div class="main">
		<article id="content2">
			<section class="col1">
				<h3>Newsletter</h3>
				<form id="newsletter">
					<div>
						<div class="bg">
							<input class="input" type="text" value="Type Your Email Here"  onblur="if(this.value=='') this.value='Type Your Email Here'" onfocus="if(this.value =='Type Your Email Here' ) this.value=''">
						</div>
						<a href="#" class="button" onclick="document.getElementById('ContactForm').submit()">Subscribe</a>
					</div>
				</form>
        	</section>
			<section class="col_1">
				<h3>Why Us?</h3>
				<ul class="list1">
					<li><a href="#">Sed ut perspiciatis</a></li>
					<li><a href="#">Unde oiste natus erturor</a></li>
					<li><a href="#">Sit voluptatem accusa</a></li>
				</ul>
        	</section>
			<section class="col_2">
				<h3>Follow Us</h3>
				<ul id="icons">
					<li><a href="#"><img src="images/icon1.jpg" alt="">Facebook</a></li>
					<li><a href="#"><img src="images/icon2.jpg" alt="">Twitter</a></li>
					<li><a href="#"><img src="images/icon3.jpg" alt="">LinkedIn</a></li>
				</ul>
        	</section>
			<section class="col_1">
				<h3>Address</h3>
				<p class="address">
					<span>
						Country:<br>
						City:<br>
						Email:
					</span>
					USA<br>
					San Diego<br>
					<a href="mailto:">prosoft@mail.com</a>
					
				</p>
       		</section>
		</article>
<!-- / content -->
	</div>
</div>
<div class="main">
<!-- footer -->
	<footer>
		<a rel="nofollow" href="http://www.templatemonster.com/" target="_blank">Website Template</a> by TemplateMonster.com | <a rel="nofollow" href="http://www.html5xcss3.com/" target="_blank">html5xcss3.com</a><br>
		<a href="http://www.templates.com/product/3d-models/" target="_blank">3D Models</a> provided by Templates.com
		<!-- {%FOOTER_LINK} -->
	</footer>
<!-- / footer -->
</div>
<script type="text/javascript"> Cufon.now();</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myRoundabout').roundabout({
			 shape: 'square',
        	 minScale: 0.89, // tiny!
        	 maxScale: 1, // tiny!
			 easing:'easeOutExpo',
			 clickToFocus:'true',
			 focusBearing:'0',
			 duration:800,
			 reflect:true
		});
	});
</script>
</body>
</html>

<%
		

%>
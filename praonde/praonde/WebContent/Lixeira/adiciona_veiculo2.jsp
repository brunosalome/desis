<%@ page import="java.util.*, Dao.*, Servlets.*, javazoom.upload.*"%>

<jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
  <jsp:setProperty name="upBean" property="folderstore" value="c:/uploads" />
</jsp:useBean>

<%

	System.out.println("TESTE DE ADICIONA VEI");
	int idUsuario=0;
	idUsuario = Integer.parseInt(request.getParameter("idUsuario"));


%>

<%
      if (MultipartFormDataRequest.isMultipartFormData(request))
      {
         // Uses MultipartFormDataRequest to parse the HTTP request.
         MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
         String todo = null;
         if (mrequest != null) todo = mrequest.getParameter("todo");
	     if ( (todo != null) && (todo.equalsIgnoreCase("upload")) )
	     {
                Hashtable files = mrequest.getFiles();
                if ( (files != null) && (!files.isEmpty()) )
                {
                    UploadFile file = (UploadFile) files.get("uploadfile");
                    if (file != null) out.println("<li>Form field : uploadfile"+"<BR> Uploaded file : "+file.getFileName()+" ("+file.getFileSize()+" bytes)"+"<BR> Content Type : "+file.getContentType());
                    // Uses the bean now to store specified by jsp:setProperty at the top.
                    upBean.store(mrequest, "uploadfile");
                }
                else
                {
                  out.println("<li>No uploaded files");
                }
	     }
         else out.println("<BR> todo="+todo);
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
						<li ><a href="usuarioLogado.jsp?idUsuario=<%=idUsuario%>"><span><span>Painel</span></span></a></li>
						<li id="menu_active"><a href="#"><span><span>Cadastrar veículo</span></span></a></li>
						<li class="nav3"><a href="usuarioLogado.jsp?idUsuario=<%=idUsuario%>"><span><span>Oferecer Carona</span></span></a></li>
						<li class="nav4"><a href="busca_carona.jsp"><span><span>Buscar Carona</span></span></a></li>
						<li class="nav5"><a href="amigos.jsp"><span><span>Amigos</span></span></a></li>
					</ul>
				</nav>
			</div>
		</header><div class="ic">More Website Templates  at TemplateMonster.com!</div>

		<article id="content">
		  <section class="col1">
				<h2 class="pad_bot1"><img src="images/car.png" width="259" height="194"></h2>
				<p class="pad_top1 pad_bot1"></p>
                <p class="pad_top1 pad_bot1"></p>
				<p>&nbsp;</p>
		  </section>
			<section class="col2">
				<h2 class="pad_bot1">Cadastro de veículo</h2>
				<form id="ContactForm" name="form1" action="adicionaVeiculo" onSubmit="return (valida())">
					<div>						
						<div  class="wrapper">
							<span>Marca:</span>
							<div class="bg"><input type="text" class="input" name="marca"></div>
						</div>
                        <div  class="wrapper">
							<span>Modelo:</span>
							<div class="bg"><input type="text" class="input" name="modelo"></div>
						</div>
                        <div  class="wrapper">
							<span>Ano:</span>
							<div class="bg"><input type="text" class="input" name="ano" maxlength=4/></div>
						</div>                        
						<div  class="wrapper">
							<span>Cor:</span>
							<div class="bg"><input type="text" class="input" name="cor" ></div>
						</div>
						<div  class="wrapper">
							<span>Placa:</span>
							<div class="bg"><input type="text" class="input" name="placa" onKeyPress="mascara(this, '###-####')" maxlength=8></div>
						</div>
						<form method="post" action="SimpleUpload.jsp" name="upform" enctype="multipart/form-data">
						  <table width="60%" border="0" cellspacing="1" cellpadding="1" align="center" class="style1">
						    <tr>
						      <td align="left"><b>Select a file to upload :</b></td>
						    </tr>
						    <tr>
						      <td align="left">
						        <input type="file" name="uploadfile" size="50">
						        </td>
						    </tr>
						    <tr>
						      <td align="left">
								<input type="hidden" name="todo" value="upload">
						        <input type="submit" name="Submit" value="Upload">
						        </td>
						    </tr>
						  </table>
						  </form>
						<input type="hidden" name="todo" value="upload">
                        <input type="hidden" value=<%=idUsuario%> name="idUsuario" >
                        </div>
						<a href="#" class="button" onClick="document.getElementById('ContactForm').submit()">Enviar</a>
						<a href="#" class="button" onClick="document.getElementById('ContactForm').reset()">Limpar</a>
					</div>
				</form>
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
							<input class="input" type="text" value="Type Your Email Here"  onblur="if(this.value=='') this.value='Type Your Email Here'" onFocus="if(this.value =='Type Your Email Here' ) this.value=''">
						</div>
						<a href="#" class="button" onClick="document.getElementById('ContactForm').submit()">Subscribe</a>
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
	</div>
</div>
<div class="main">
	<footer>
		<a rel="nofollow" href="http://www.templatemonster.com/" target="_blank">Website Template</a> by TemplateMonster.com | <a rel="nofollow" href="http://www.html5xcss3.com/" target="_blank">html5xcss3.com</a><br>
		<a href="http://www.templates.com/product/3d-models/" target="_blank">3D Models</a> provided by Templates.com

	</footer>

</div>
<script type="text/javascript"> Cufon.now();</script>
</body>
</html>
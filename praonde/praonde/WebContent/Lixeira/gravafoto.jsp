<%@ page language="java" import="org.apache.commons.fileupload.*, java.util.*, java.sql.*, Dao.*" %>
<html>
<body bgcolor="#FFFFFF">
<%
	
	// Verificando se o form possui campo(s) com dados binários
	if (FileUpload.isMultipartContent(request)) {
		// criando o objeto para cuidar do upload
		DiskFileUpload fu = new DiskFileUpload();
		// setando o tamanho maximo em bytes para upload
		fu.setSizeMax(800000);
		try {
			// parseando a requisição e retornando uma lista com os campos
			// encontrando, tanto textos, quanto dados binários (arquivos binários)
			List items = fu.parseRequest(request);
			Iterator i = items.iterator();
			FileItem fi;
			String cmt=null;
			// laço para pegar todos os campos do form
			while (i.hasNext()) {
				fi = (FileItem)i.next();
				// teste para ver se o campo em questão é campo do formulario
				// ou um arquivo
				if (fi.isFormField()) {
					// pegando o valor do campo do formulário (comentário)
					cmt = fi.getString();
				}else{
					// obtendo o tamanho da foto
					int size = (int) fi.getSize();
					// array de byte para armazenar a foto
					byte [] imagem = new byte[size];
					// carregando a foto no array
					upload.read(imagem, 0, size);
					//bd
					Connection con = new ConnectionFactory().getConnection();	
					// onde tem “?”, será substituído por valores posteriormente.
					PreparedStatement pstm = con.prepareStatement("INSERT INTO foto (comentario, foto) VALUES (?, ?)");
					// inserindo o comentário no lugar da primeira interrogação
					pstm.setString(1, cmt);
					// inserindo a foto no lugar da segunda interrogação
					pstm.setBytes(2, imagem);
					// executando a query
					pstm.executeUpdate();
				}
			}
		} catch (FileUploadException e) {
		out.print("Erro no upload do arquivo");
		} catch (SQLException e) {
		out.print("Erro na consulta com o banco de dados");
		} catch (Exception e) {
		out.print(e.getMessage());
		}
	}else {
		out.print("O Formulario nao possui dados binários");
	}
%>
<h2>Fonto inserida com sucesso no banco de dados!</h2>
</body>
</html>
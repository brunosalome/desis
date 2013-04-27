<%@ page language="java" import="java.lang.*,Dao.*,java.util.*,java.sql.*,com.sun.image.codec.jpeg.*,Servlets.*" %>
<%
	try {
		// criando a conexao com o banco de dados
		Connection con = new ConnectionFactory().getConnection();
		
		int codigo;
		// pegando o codigo da foto a ser exibida
		if (request.getParameter("numero") == null)
			codigo = 1;
		else
			codigo = Integer.parseInt(request.getParameter("numero"));
		// procurando pela foto na tabela
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM foto WHERE idFoto = "+codigo);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			// pegando o conteudo do campo foto (BLOB, binario)
			Blob blob = rs.getBlob("foto");
			// Codificando para JPG e enviando para o browser, através do Output do servlet
			JPGManager.encodeJPG(response.getOutputStream(), blob.getBytes(1, (int)blob.length()) );
		}
	}catch (Exception e){
// erro
%>Erro encontrado<%
}
%>
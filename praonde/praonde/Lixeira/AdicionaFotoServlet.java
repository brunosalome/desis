

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.*;
import  java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionFactory;
import org.apache.commons.fileupload.FileItem; 
import org.apache.commons.fileupload.FileUploadException; 
import org.apache.commons.io.output.DeferredFileOutputStream;
import org.apache.tomcat.util.http.fileupload.FileUpload; 


public class AdicionaFotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		// Verificando se o form possui campo(s) com dados binários
		if (FileUpload.isMultipartContent(request)) {
			// criando o objeto para cuidar do upload
			@SuppressWarnings("deprecation")
			DiskFileUpload fu = new DiskFileUpload();
			// setando o tamanho maximo em bytes para upload
			fu.setSizeMax(800000);
			System.out.println("1");
			try {
				// parseando a requisição e retornando uma lista com os campos
				// encontrando, tanto textos, quanto dados binários (arquivos binários)
				@SuppressWarnings("deprecation")
				List<FileItem> items = fu.parseRequest(request);
				System.out.println("2");
				Iterator<FileItem> i = items.iterator();
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
						InputStream upload = fi.getInputStream(); 
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
			System.out.println("Erro no upload do arquivo");
			} catch (SQLException e) {
				System.out.println("Erro na consulta com o banco de dados");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("O Formulario nao possui dados binários");
		}
	}
}

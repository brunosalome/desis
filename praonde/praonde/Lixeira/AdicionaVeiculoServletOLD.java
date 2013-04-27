

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javazoom.upload.*;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Blob;

import Dao.Upload;
import Dao.Veiculo;
import Dao.VeiculoDAO;

import org.apache.commons.fileupload.FileItem; 
import org.apache.commons.fileupload.FileItemFactory; 
import org.apache.commons.fileupload.FileUploadException; 
import org.apache.commons.fileupload.disk.DiskFileItemFactory; 
import org.apache.commons.fileupload.servlet.ServletFileUpload; 
import org.apache.tomcat.util.http.fileupload.FileUpload; 

public class AdicionaVeiculoServletOLD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	    public AdicionaVeiculoServletOLD() {
	        super();
	    }
		
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 
	    	
		PrintWriter out = response.getWriter();
		

		UploadBean upBean = new UploadBean();
		try {
			upBean.setFolderstore("C:/uploads");
		} catch (UploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		// pegndo os parâmetros do request
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		System.out.println("modleo:" + request.getParameter("modelo"));
		String cor = request.getParameter("cor");
		System.out.println("ANO: "+request.getParameter("ano"));
		int ano = Integer.parseInt(request.getParameter("ano"));
		String placa = request.getParameter("placa");
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String arquivo = "";
//		Blob logo = request.getParameter("imagem");  
		
		 
		try {
			arquivo = new Upload().anexos(request, response); 
			if (arquivo!="erro") {
				System.out.println(arquivo);
				out.print("Arquivo enviado!");
			} else {
				out.print("Arquivo não enviado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
	    }
	
		Veiculo v = new Veiculo();
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setCor(cor);
		v.setAno(ano);
		v.setPlaca(placa);
		v.setIdUsuario(idUsuario);
		v.setFoto(arquivo);
		
		System.out.println("Passei AQUI2");
		VeiculoDAO dao = new VeiculoDAO();
		dao.adiciona(v);

		VeiculoDAO dao2 = new VeiculoDAO();
		int idVeiculo2 = dao2.getLast();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_veiculo.jsp?idUsuario="+idUsuario+"&idVeiculo="+idVeiculo2+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

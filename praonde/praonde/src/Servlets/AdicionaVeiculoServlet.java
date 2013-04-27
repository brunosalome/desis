package Servlets;
 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
 
import Dao.Upload;
import Dao.Veiculo;
import Dao.VeiculoDAO;
 
/**
 * Servlet implementation class ServletUpload
 */
//@WebServlet("/upload")
public class AdicionaVeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaVeiculoServlet() {
        super();
    }
 
    /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	PrintWriter out = response.getWriter();
	
	String teste = request.getParameter("idUsuario");
	System.out.println("testeId:"+teste);
	
	if (ServletFileUpload.isMultipartContent(request)) {
		String arquivo="";
		int cont = 0;
		int idUsuario = 0;
		Veiculo vei = new Veiculo();
		ServletFileUpload servletFileUpload = new ServletFileUpload(
					new DiskFileItemFactory());
 
		List fileItemsList = null;
 
		try {
			fileItemsList = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
 
		String optionalFileName = "";
		FileItem fileItem = null;
 
		Iterator it = fileItemsList.iterator();
 
		while (it.hasNext()) {
 
			cont++;
 
			FileItem fileItemTemp = (FileItem) it.next();
			
			if (fileItemTemp.isFormField()) {
				if (fileItemTemp.getFieldName().equals("filename")) {
					optionalFileName = fileItemTemp.getString();
				}else if (fileItemTemp.getFieldName().equals("idUsuario")){
					idUsuario = Integer.parseInt(fileItemTemp.getString());
					vei.setIdUsuario(idUsuario);
					System.out.println("CAMPO AQUI:"+idUsuario);
				}else if (fileItemTemp.getFieldName().equals("marca")){
					vei.setMarca(fileItemTemp.getString());
				}else if (fileItemTemp.getFieldName().equals("modelo")){
					vei.setModelo(fileItemTemp.getString());
				}else if (fileItemTemp.getFieldName().equals("cor")){
					vei.setCor(fileItemTemp.getString());
				}else if (fileItemTemp.getFieldName().equals("ano")){
					vei.setAno(Integer.parseInt(fileItemTemp.getString()));
				}else if (fileItemTemp.getFieldName().equals("placa")){
					vei.setPlaca(fileItemTemp.getString());
				}
			}else{
				fileItem = fileItemTemp;
			}
 
			if (cont != (fileItemsList.size())) {
				if (fileItem != null) {
 
					String fileName = fileItem.getName();
					
					if (fileItem.getSize() > 0) {
 
						if (optionalFileName.trim().equals("")) {
							fileName = FilenameUtils.getName(fileName);
						} else {
							fileName = optionalFileName;
						}
 
						String dirName = "C:\\Users\\Bruno\\Desktop\\DESIS\\praonde\\praonde\\WebContent\\fotos\\veiculos\\"; //caminho para o projeto
 
						File saveTo = new File(dirName + fileName);
						arquivo=fileName;
						try {
							fileItem.write(saveTo);
							vei.setFoto(arquivo);
						} catch (Exception e) {
 
						}
 
					}
				}
			}
		} 
		
		VeiculoDAO dao = new VeiculoDAO();
		dao.adiciona(vei);

		VeiculoDAO dao2 = new VeiculoDAO();
		int idVeiculo2 = dao2.getLast();
		
		System.out.println(arquivo);
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_veiculo.jsp?idUsuario="+idUsuario+"&idVeiculo="+idVeiculo2+"\">");
		out.println("</body>");
		out.println("</html>");
	} else {
		out.print("Arquivo não enviado!");
	}
    }
}
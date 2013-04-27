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

import Dao.Veiculo;
import Dao.VeiculoDAO;
 
/**
 * Servlet implementation class ServletUpload
 */
//@WebServlet("/upload")
public class AlteraVeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraVeiculoServlet() {
        super();
    }
 
    /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	PrintWriter out = response.getWriter();
	
	String teste = request.getParameter("idUsuario");
	
	if (ServletFileUpload.isMultipartContent(request)) {
		String arquivo="";
		int cont = 0;
		int idUsuario = 0;
		int idVeiculo = 0;
		String cor = "";
		String placa = "";
		String modelo = "";
		String marca = "";
		int ano = 0;
		
		VeiculoDAO vdao = new VeiculoDAO();
		
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
				}else if (fileItemTemp.getFieldName().equals("marca")){
					 marca = fileItemTemp.getString();
				}else if (fileItemTemp.getFieldName().equals("modelo")){
					 modelo = fileItemTemp.getString();
				}else if (fileItemTemp.getFieldName().equals("cor")){
					 cor = fileItemTemp.getString();
				}else if (fileItemTemp.getFieldName().equals("ano")){
					 ano = Integer.parseInt(fileItemTemp.getString());
				}else if (fileItemTemp.getFieldName().equals("placa")){
					 placa = fileItemTemp.getString();
				}else if (fileItemTemp.getFieldName().equals("idVeiculo")){
					idVeiculo = Integer.parseInt(fileItemTemp.getString());
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
						} catch (Exception e) {
 
						}
 
					}
				}
			}
		} 
		
		Veiculo vei = vdao.getVeiculo(idVeiculo);
		
		if(arquivo.equals("")){
			arquivo=vei.getFoto();
		}
		
		
		vei.setAno(ano);
		vei.setCor(cor);
		vei.setPlaca(placa);
		vei.setIdUsuario(idUsuario);
		vei.setIdVeiculo(idVeiculo);
		vei.setMarca(marca);
		vei.setModelo(modelo);
		vei.setFoto(arquivo);
		
		VeiculoDAO dao2 = new VeiculoDAO();
		dao2.update(vei);

		VeiculoDAO dao3 = new VeiculoDAO();
		int idVeiculo2 = dao3.getLast();
		
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
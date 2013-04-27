package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.OS_has_Produtos;
import Dao_OLD.OS_has_ProdutosDAO;
import Dao_OLD.Sem_Conserto;
import Dao_OLD.Sem_ConsertoDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaSem_ConsertoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		int comprometidas = 0;
		
		for(int cont = 1; cont<=quantidade; cont++){
			Sem_ConsertoDAO scdao = new Sem_ConsertoDAO();
			Sem_Conserto sc = new Sem_Conserto();
			sc.setIdOs_Has_Produtos(Integer.parseInt(request.getParameter("idOS_has_Produtos")));
			if(request.getParameter("motivo1"+cont)!=null && request.getParameter("motivo1"+cont).equals(0)==false){
				sc.setIdMotivo1(Integer.parseInt(request.getParameter("motivo1"+cont)));
				comprometidas++;
			}
			if(request.getParameter("motivo2"+cont)!=null && request.getParameter("motivo2"+cont).equals(0)==false){
				sc.setIdMotivo2(Integer.parseInt(request.getParameter("motivo2"+cont)));
				comprometidas++;
			}
			if(request.getParameter("motivo3"+cont)!=null && request.getParameter("motivo3"+cont).equals(0)==false){
				sc.setIdMotivo3(Integer.parseInt(request.getParameter("motivo3"+cont)));
				comprometidas++;
			}
			System.out.println("COMPROMEIDAS:" +comprometidas);
			if(comprometidas==3){
				sc.setComprometida(1);
			}else{
				sc.setComprometida(0);
			}
			scdao.adiciona(sc);
		}
		
		OS_has_ProdutosDAO ohpdao = new OS_has_ProdutosDAO();
		OS_has_Produtos ohp = new OS_has_Produtos();
		ohp = ohpdao.getOHP(Integer.parseInt(request.getParameter("idOS_has_Produtos")));
		ohp.setQuantidade(ohp.getQuantidade()-quantidade);
		ohp.setQuebrado_qtd(ohp.getQuebrado_qtd()+quantidade);
		ohpdao.atualiza(ohp);
		
		int idOS = ohp.getIdOS();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_os.jsp?idOS="+idOS+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

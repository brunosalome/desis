package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.OSDAO;
import Dao_OLD.OS_has_Produtos;
import Dao_OLD.OS_has_ProdutosDAO;
import Dao_OLD.Producao;
import Dao_OLD.ProducaoDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaOS_has_ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		int idProduto = Integer.parseInt(request.getParameter("produto"));
		int idOS = Integer.parseInt(request.getParameter("idOS"));
		int quebrado_qtd = Integer.parseInt(request.getParameter("quebrado_qtd"));
		int quantidade= Integer.parseInt(request.getParameter("quantidade")) - quebrado_qtd ;
		String conserto = request.getParameter("conserto");
		int idMotivo = Integer.parseInt(request.getParameter("motivo"));
		String patrimonio = request.getParameter("patrimonio");
		String observacao = request.getParameter("observacao");
		boolean adiciona = false;
		if(request.getParameter("adiciona")!=null)
			adiciona = true;
		
		OS_has_Produtos oshp = new OS_has_Produtos();
		oshp.setIdProduto(idProduto);
		oshp.setConserto(conserto);
		oshp.setIdMotivo(idMotivo);
		oshp.setIdOS(idOS);
		oshp.setPatrimonio(patrimonio);
		oshp.setObservacao(observacao);
		oshp.setQuantidade(quantidade);
		oshp.setQuebrado_qtd(quebrado_qtd);
		
		OS_has_ProdutosDAO oshpdao = new OS_has_ProdutosDAO();
		oshpdao.adiciona(oshp);
		
		OSDAO osdao = new OSDAO();
		
		boolean produzindo = false;
		String dataProducao = osdao.getOS(idOS).getDataLancamento();
		
		while(!produzindo){  
			
			ProducaoDAO pdao = new ProducaoDAO();
			Producao prod = pdao.getProducao(dataProducao);
			
			System.out.println("PROD.GETIDPROD:"+prod.getIdProducao());
			if(prod.getIdProducao()==0){
				prod = new Producao();
				prod.setData(dataProducao);
				if(quantidade<=150){
					prod.setQuantidade(quantidade);
					produzindo = true;
				}else{
					quantidade = quantidade - 150;
					prod.setQuantidade(150);
				}
				pdao.adiciona(prod);
			}else{
				if(prod.getQuantidade()+quantidade<=150){
					prod.setQuantidade(prod.getQuantidade()+quantidade);
					produzindo=true;
				}else{
					quantidade = quantidade - (150 - prod.getQuantidade());
					prod.setQuantidade(150);
				}
				pdao.atualiza(prod);				
			}
		
			int dia = Integer.parseInt(dataProducao.substring(0, 2));
			System.out.println("DIA:"+dia);
			int mes = Integer.parseInt(dataProducao.substring(3, 5));
			System.out.println("MÊS:"+mes);
			int ano = Integer.parseInt(dataProducao.substring(6, 10));
			System.out.println("ANO:"+ano);
			
			if(dia==30){
				mes++;
				dia=1;
			}else{
				dia++;
			}
			
			String sdia = Integer.toString(dia);
			if(sdia.length()==1)
				sdia="0"+sdia;
			
			String smes = Integer.toString(mes);
			if(smes.length()==1)
				smes="0"+smes;
			
			dataProducao = sdia + smes + Integer.toString(ano);
			System.out.println("SEMI DATA FINAL:"+dataProducao);
			SimpleDateFormat formato1 = new SimpleDateFormat("ddMMyyyy");  
			SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");  
			try {
				dataProducao = formato2.format(formato1.parse(dataProducao));
				System.out.println("DATA FINAL:"+dataProducao);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		Dao_OLD.OS os = osdao.getOS(idOS);
		System.out.println("DataProducao: " + dataProducao);
		os.setDataEntrega(dataProducao);
		osdao.atualiza(os);
		
		osdao.ordenaPatrimonios(idOS);
		
		if(adiciona == true){
			out.println("<html>");
			out.println("<body>");
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=adiciona_os_has_produtos.jsp?idOS="+idOS+"\">");
			out.println("</body>");
			out.println("</html>");
		}else{
			out.println("<html>");
			out.println("<body>");
			out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_os.jsp?idOS="+idOS+"\">");
			out.println("</body>");
			out.println("</html>");
		}
	}	
}

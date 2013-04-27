package Servlets_OLD;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao_OLD.Caixa_has_Produtos;
import Dao_OLD.Caixa_has_ProdutosDAO;
import Dao_OLD.OS;
import Dao_OLD.OSDAO;
import Dao_OLD.OS_has_Produtos;
import Dao_OLD.OS_has_ProdutosDAO;
import Dao_OLD.Producao;
import Dao_OLD.ProducaoDAO;
/**
 * Servlet implementation class AdicionaContatoServlet
 */
public class AdicionaOS_has_CaixasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		int idOS = Integer.parseInt(request.getParameter("idOS"));
		int idCor1= Integer.parseInt(request.getParameter("cor1"));
		int idCor2= Integer.parseInt(request.getParameter("cor2"));
		int idCor3= Integer.parseInt(request.getParameter("cor3"));
		int idCaixa= Integer.parseInt(request.getParameter("caixa"));
		String numero_Caixa = request.getParameter("numero_caixa");
		
		OSDAO osDAO = new OSDAO();
		OS OS = osDAO.getOS(idOS);
		OS.setIdCaixa(idCaixa);
		OS.setIdCor1(idCor1);
		OS.setIdCor2(idCor2);
		OS.setIdCor3(idCor3);
		OS.setNumero_Caixa(numero_Caixa);
		osDAO.atualiza(OS);
		
		Caixa_has_ProdutosDAO chpdao = new Caixa_has_ProdutosDAO();
		List<Caixa_has_Produtos> chps = chpdao.getCHPsOS(idCaixa);
		
		OSDAO osdao2 = new OSDAO();
		
		for(Caixa_has_Produtos chp : chps){
			
			OSDAO osdao = new OSDAO();
			
			int quantidade = chp.getQuantidade();
			
			OS_has_Produtos oshp = new OS_has_Produtos();
			oshp.setIdOS(idOS);
			oshp.setIdProduto(chp.getIdProduto());
			oshp.setObservacao(chp.getObservacao());
			oshp.setQuantidade(quantidade);
			oshp.setConserto("Sim");
			
			OS_has_ProdutosDAO oshpdao = new OS_has_ProdutosDAO();
			oshpdao.adiciona(oshp);
			
			boolean produzindo = false;
			String dataProducao = osdao.getOS(idOS).getDataLancamento();
			
			while(!produzindo){  
				
				ProducaoDAO pdao = new ProducaoDAO();
				Producao prod = pdao.getProducao(dataProducao);
				
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
			
		}
		
		osdao2.ordenaPatrimonios(idOS);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_os.jsp?idOS="+idOS+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

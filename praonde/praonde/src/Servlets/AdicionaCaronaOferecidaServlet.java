package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CaronaOferecida;
import Dao.CaronaOferecidaDAO;

public class AdicionaCaronaOferecidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();

		// pegndo os parâmetros do request
		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");
		String parada1 = request.getParameter("parada1");
		String parada2 = request.getParameter("parada2");
		String parada3 = request.getParameter("parada3");
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
	    String horaSaida = request.getParameter("horaSaida");
	    String horaChegada = request.getParameter("parada3");
	    int vagas = Integer.parseInt(request.getParameter("parada3"));
	    double kgBagagem = Double.parseDouble(request.getParameter("parada3"));
	    double preco = Double.parseDouble(request.getParameter("parada3"));
	    int tempoEspera = Integer.parseInt(request.getParameter("parada3"));
	    String observacoes = request.getParameter("parada3");
		
		CaronaOferecida carona = new CaronaOferecida();
		carona.setOrigem(origem);
		carona.setDestino(destino);
		carona.setParada1(parada1);
		carona.setParada2(parada2);
		carona.setParada3(parada3);
		carona.setIdUsuario(idUsuario);
		carona.setHoraSaida(horaSaida);
		carona.setHoraChegada(horaChegada);
		carona.setVagas(vagas);
		carona.setKgBagagem(kgBagagem);
		carona.setPreco(preco);
		carona.setTempoEspera(tempoEspera);
		carona.setObservacoes(observacoes);
		
		CaronaOferecidaDAO dao = new CaronaOferecidaDAO();
		dao.adiciona(carona);

		CaronaOferecidaDAO dao2 = new CaronaOferecidaDAO();
		int idCarona2 = dao2.getLast();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1; url=exibe_caronaOferecida.jsp?idCarona ="+idCarona2+"\">");
		out.println("</body>");
		out.println("</html>");
	}	
}

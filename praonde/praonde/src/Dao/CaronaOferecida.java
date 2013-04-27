
package Dao;

public class CaronaOferecida {
    private Integer idCaronaOferecida;
    private String origem;
    private String destino;
    private String parada1;
    private String parada2;
    private String parada3;
    private int idUsuario;
    private String horaSaida;
    private String horaChegada;
    private int vagas;
    private double kgBagagem;
    private double preco;
    private int tempoEspera;
    private String observacoes;
    
    
	public Integer getIdCaronaOferecida() {
		return idCaronaOferecida;
	}
	public void setIdCaronaOferecida(Integer idCarona) {
		this.idCaronaOferecida = idCarona;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getParada1() {
		return parada1;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setParada1(String parada1) {
		this.parada1 = parada1;
	}
	public String getParada2() {
		return parada2;
	}
	public void setParada2(String parada2) {
		this.parada2 = parada2;
	}
	public String getParada3() {
		return parada3;
	}
	public void setParada3(String parada3) {
		this.parada3 = parada3;
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	public String getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	public double getKgBagagem() {
		return kgBagagem;
	}
	public void setKgBagagem(double kgBagagem) {
		this.kgBagagem = kgBagagem;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getTempoEspera() {
		return tempoEspera;
	}
	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
        

    
}

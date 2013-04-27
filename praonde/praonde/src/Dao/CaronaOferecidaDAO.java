package Dao;

import java.sql.*;
import java.util.ArrayList;

import Utilities.Conexao;

public class CaronaOferecidaDAO {
    private static PreparedStatement pstmt = null;
    
    private static ResultSet rs = null;
	private Connection connection;
    public ConnectionFactory conexta;
	
	public CaronaOferecidaDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
    public void adiciona(CaronaOferecida carona) {
		String sql = "INSERT INTO caronas (idCaronaOferecida, origem, chegada, parada1, parada2, parada3, idUsuario, horaSaida," +
				"horaChegada, vagas, kgBagagem, preco, tempoEspera, observacoes)" +
				" VALUES (?,?,?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,carona.getIdCaronaOferecida());
			stmt.setString(2, carona.getOrigem());
			stmt.setString(3, carona.getDestino());
			stmt.setString(4, carona.getParada1());
			stmt.setString(5, carona.getParada2());
			stmt.setString(6, carona.getParada3());
			stmt.setInt(7, carona.getIdUsuario());
			stmt.setString(8,carona.getHoraSaida());
			stmt.setString(9,carona.getHoraChegada());
			stmt.setInt(10, carona.getVagas());
			stmt.setDouble(11, carona.getKgBagagem());
			stmt.setDouble(12, carona.getPreco());
			stmt.setInt(13, carona.getTempoEspera());
			stmt.setString(14, carona.getObservacoes());
			
			// executa
			stmt.execute();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
    
    public static boolean update(CaronaOferecida carona) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update caronas Set origem=?, destino=?, parada1=?, parada2=?, parada3=?, idUsuario=?, " +
                    "horaSaida=?, horaChegada=?, vagas=?, kgBagagem=?, preco=?, tempoEspera=?, observacoes=? " +
                    "where idCaronaOferecida = ?");
            pstmt.setString(1, carona.getOrigem());            
            pstmt.setString(2, carona.getDestino());
            pstmt.setString(3, carona.getParada1());
            pstmt.setString(5, carona.getParada2());
            pstmt.setString(6, carona.getParada3());
            pstmt.setInt(7, carona.getIdUsuario());
			pstmt.setString(8,carona.getHoraSaida());
			pstmt.setString(9,carona.getHoraChegada());
			pstmt.setInt(10, carona.getVagas());
			pstmt.setDouble(11, carona.getKgBagagem());
			pstmt.setDouble(12, carona.getPreco());
			pstmt.setInt(13, carona.getTempoEspera());
			pstmt.setString(14, carona.getObservacoes());
			
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(CaronaOferecida carona) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From caronas Where idCaronaOferecida = ?");
            pstmt.setInt(1, carona.getIdCaronaOferecida());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<CaronaOferecida> getAll() {
        try {
            ArrayList<CaronaOferecida> listAll = null;
            CaronaOferecida carona = new CaronaOferecida();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From caronas Order By origem");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<CaronaOferecida>();
                do {
                    carona = new CaronaOferecida();
                    carona.setIdCaronaOferecida(rs.getInt("idCaronaOferecida"));
                    carona.setOrigem(rs.getString("origem"));
                    carona.setDestino(rs.getString("destino"));
                    carona.setParada1(rs.getString("parada1"));
                    carona.setParada2(rs.getString("parada2"));
                    carona.setParada3(rs.getString("parada3"));
                    carona.setPreco(rs.getDouble("preco"));
                    carona.setTempoEspera(rs.getInt("tempoEspera"));
                    carona.setVagas(rs.getInt("vagas"));
                    carona.setHoraChegada(rs.getString("horaChegada"));
                    carona.setHoraSaida(rs.getString("horaSaida"));
                    carona.setKgBagagem(rs.getDouble("kgBagagem"));
                    carona.setObservacoes(rs.getString("observacoes"));
                    listAll.add(carona);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static CaronaOferecida getById(int Id) {
        try {
            CaronaOferecida carona = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From caronas Where idCaronaOferecida = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                carona = new CaronaOferecida();
                carona.setIdCaronaOferecida(rs.getInt("idCaronaOferecida"));
                carona.setOrigem(rs.getString("origem"));
                carona.setDestino(rs.getString("destino"));
                carona.setParada1(rs.getString("parada1"));
                carona.setParada2(rs.getString("parada2"));
                carona.setParada3(rs.getString("parada3"));
                carona.setPreco(rs.getDouble("preco"));
                carona.setTempoEspera(rs.getInt("tempoEspera"));
                carona.setVagas(rs.getInt("vagas"));
                carona.setHoraChegada(rs.getString("horaChegada"));
                carona.setHoraSaida(rs.getString("horaSaida"));
                carona.setKgBagagem(rs.getDouble("kgBagagem"));
                carona.setObservacoes(rs.getString("observacoes"));
            }
            rs.close();
            pstmt.close();
            return carona;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
            
	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idCarona ) as idCaronaOferecida FROM caronas");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idCaronaOferecida");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}   
    
}
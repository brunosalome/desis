	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class MotivoDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public MotivoDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Motivo mot) {
		String sql = "INSERT INTO motivos (idMotivo, motivo) " +
				"VALUES (?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,mot.getIdMotivo());
			stmt.setString(2, mot.getMotivo());
			
			
			// executa
			stmt.execute();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public void remove (int ids[]){
		String auxiliar="";
		for (int i=0; i<ids.length; i++){
			if(auxiliar=="" && ids[i]!=0){
				auxiliar= Integer.toString(ids[i]);
			}else if (ids[i]!=0){
				auxiliar=auxiliar+ ", " + Integer.toString(ids[i]);
			}
		}
		System.out.println("Auxiliar: " + auxiliar);
		String sql = "delete from motivos where idMotivo in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Motivo> getLista(){
		try{
			List<Motivo> motivos = new ArrayList<Motivo>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from motivos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Motivo mot = new Motivo();
				mot.setIdMotivo(rs.getInt("idMotivo"));
				mot.setMotivo(rs.getString("motivo"));
				motivos.add(mot);
			}
			rs.close();
			stmt.close();
			return motivos;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idMotivo ) as idMotivo FROM motivos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idMotivo");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Motivo getMotivo(int idMotivo){
		try{
			Motivo mot = new Motivo();
			PreparedStatement stmt = this.connection.prepareStatement("select * from motivos where idMotivo = " + idMotivo);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				mot.setIdMotivo(idMotivo);
				mot.setMotivo(rs.getString("motivo"));
			}
			rs.close();
			stmt.close();
			return mot;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Motivo> getConsulta(String sql){
		try{
			List<Motivo> motivos = new ArrayList<Motivo>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Motivo m = new Motivo();
				m.setIdMotivo(rs.getInt("idMotivo"));
				m.setMotivo(rs.getString("motivo"));
				motivos.add(m);
			}
			rs.close();
			stmt.close();
			return motivos;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Motivo mot) {
		String sql = "update motivos set idMotivo=?, motivo=? " +
				"where idMotivo = " + mot.getIdMotivo();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,mot.getIdMotivo());
			stmt.setString(2, mot.getMotivo());
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

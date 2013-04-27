	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class CorDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public CorDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Cor cor) {
		String sql = "INSERT INTO cores (idCor, cor) " +
				"VALUES (?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,cor.getIdCor());
			stmt.setString(2, cor.getCor());
			
			
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
		String sql = "delete from cores where idCor in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Cor> getLista(){
		try{
			List<Cor> cores = new ArrayList<Cor>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from cores");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Cor cor = new Cor();
				cor.setIdCor(rs.getInt("idCor"));
				cor.setCor(rs.getString("cor"));
				cores.add(cor);
			}
			rs.close();
			stmt.close();
			return cores;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idCor ) as idCor FROM cores");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idCor");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Cor getCor(int idCor){
		try{
			Cor cor = new Cor();
			PreparedStatement stmt = this.connection.prepareStatement("select * from cores where idCor = " + idCor);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				cor.setIdCor(idCor);
				cor.setCor(rs.getString("cor"));
			}
			rs.close();
			stmt.close();
			return cor;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Cor> getConsulta(String sql){
		try{
			List<Cor> Cores = new ArrayList<Cor>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Cor c = new Cor();
				c.setIdCor(rs.getInt("idCor"));
				c.setCor(rs.getString("cor"));
				Cores.add(c);
			}
			rs.close();
			stmt.close();
			return Cores;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Cor mot) {
		String sql = "update Cores set idCor=?, cor=? " +
				"where idCor = " + mot.getIdCor();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,mot.getIdCor());
			stmt.setString(2, mot.getCor());
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

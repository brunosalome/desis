	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class PatrimonioDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public PatrimonioDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Patrimonio patrimonio) {
		String sql = "INSERT INTO patrimonios (idPatrimonio, patrimonio) " +
				"VALUES (?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,patrimonio.getIdPatrimonio());
			stmt.setString(2, patrimonio.getPatrimonio());
			
			
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
		String sql = "delete from patrimonios where idPatrimonio in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Patrimonio> getLista(){
		try{
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from patrimonios");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setIdPatrimonio(rs.getInt("idPatrimonio"));
				patrimonio.setPatrimonio(rs.getString("patrimonio"));
				patrimonios.add(patrimonio);
			}
			rs.close();
			stmt.close();
			return patrimonios;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idPatrimonio ) as idPatrimonio FROM patrimonios");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idPatrimonio");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Patrimonio getPatrimonio(int idPatrimonio){
		try{
			Patrimonio patrimonio = new Patrimonio();
			PreparedStatement stmt = this.connection.prepareStatement("select * from patrimonios where idPatrimonio = " + idPatrimonio);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				patrimonio.setIdPatrimonio(idPatrimonio);
				patrimonio.setPatrimonio(rs.getString("patrimonio"));
			}
			rs.close();
			stmt.close();
			return patrimonio;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Patrimonio> getConsulta(String sql){
		try{
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Patrimonio p = new Patrimonio();
				p.setIdPatrimonio(rs.getInt("idPatrimonio"));
				p.setPatrimonio(rs.getString("patrimonio"));
				patrimonios.add(p);
			}
			rs.close();
			stmt.close();
			return patrimonios;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Patrimonio p) {
		String sql = "update patrimonios set idPatrimonio=?, patrimonio=? " +
				"where idPatrimonio = " + p.getIdPatrimonio();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,p.getIdPatrimonio());
			stmt.setString(2, p.getPatrimonio());
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

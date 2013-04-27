	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class ProducaoDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public ProducaoDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Producao prod) {
		String sql = "INSERT INTO producao (idProducao, data, quantidade) " +
				"VALUES (?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,prod.getIdProducao());
			stmt.setString(2, prod.getData());
			stmt.setInt(3, prod.getQuantidade());
			
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
		String sql = "delete from producao where idProducao sin("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Producao> getLista(){
		try{
			List<Producao> prods = new ArrayList<Producao>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from producao");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Producao prod = new Producao();
				prod.setIdProducao(rs.getInt("idProducao"));
				prod.setData(rs.getString("data"));
				prod.setQuantidade(rs.getInt("quantidade"));
				prods.add(prod);
			}
			rs.close();
			stmt.close();
			return prods;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Producao getProducao(String data){
		try{
			Producao prod = new Producao();
			PreparedStatement stmt = this.connection.prepareStatement("select * from producao where data = '" + data +"'");
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				prod.setIdProducao(rs.getInt("idProducao"));
				prod.setData(rs.getString("data"));
				prod.setQuantidade(rs.getInt("quantidade"));
			}
			rs.close();
			stmt.close();
			return prod;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Producao prod) {
		String sql = "update producao set idProducao=?, data=?, quantidade=? " +
				"where idProducao  = " + prod.getIdProducao();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,prod.getIdProducao());
			stmt.setString(2, prod.getData());
			stmt.setInt(3, prod.getQuantidade());
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

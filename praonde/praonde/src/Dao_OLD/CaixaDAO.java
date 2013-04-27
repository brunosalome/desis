	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class CaixaDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public CaixaDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Caixa caixa) {
		String sql = "INSERT INTO caixas (idCaixa, caixa, patrimonio, idCliente, idContato) " +
				"VALUES (?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,caixa.getIdCaixa());
			stmt.setString(2, caixa.getCaixa());
			stmt.setString(3, caixa.getPatrimonio());
			stmt.setInt(4, caixa.getIdCliente());
			stmt.setInt(5, caixa.getIdContato());
			
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
		String sql = "delete from caixas where idCaixa in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Caixa> getLista(){
		try{
			List<Caixa> caixas = new ArrayList<Caixa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from caixas");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Caixa caixa = new Caixa();
				caixa.setIdCaixa(rs.getInt("idCaixa"));
				caixa.setCaixa(rs.getString("caixa"));
				caixa.setIdCliente(rs.getInt("idCliente"));
				caixa.setPatrimonio(rs.getString("patrimonio"));
				caixa.setIdContato(rs.getInt("idContato"));
				caixas.add(caixa);
			}
			rs.close();
			stmt.close();
			return caixas;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Caixa> getListaDe(int idCliente){
		try{
			List<Caixa> caixas = new ArrayList<Caixa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from caixas where idCliente = "+idCliente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Caixa caixa = new Caixa();
				caixa.setIdCaixa(rs.getInt("idCaixa"));
				caixa.setCaixa(rs.getString("caixa"));
				caixa.setIdCliente(rs.getInt("idCliente"));
				caixa.setPatrimonio(rs.getString("patrimonio"));
				caixa.setIdContato(rs.getInt("idContato"));
				caixas.add(caixa);
			}
			rs.close();
			stmt.close();
			return caixas;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idCaixa ) as idCaixa FROM caixas");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idCaixa");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Caixa getCaixa(int idCaixa){
		try{
			Caixa caixa = new Caixa();
			PreparedStatement stmt = this.connection.prepareStatement("select * from caixas where idCaixa = " + idCaixa);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				caixa.setIdCaixa(idCaixa);
				caixa.setCaixa(rs.getString("caixa"));
				caixa.setIdCliente(rs.getInt("idCliente"));
				caixa.setPatrimonio(rs.getString("patrimonio"));
				caixa.setIdContato(rs.getInt("idContato"));
			}
			rs.close();
			stmt.close();
			return caixa;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Caixa> getConsulta(String sql){
		try{
			List<Caixa> caixas = new ArrayList<Caixa>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Caixa c = new Caixa();
				c.setIdCaixa(rs.getInt("idCaixa"));
				c.setCaixa(rs.getString("caixa"));
				c.setIdCliente(rs.getInt("idCliente"));
				c.setPatrimonio(rs.getString("patrimonio"));
				c.setIdContato(rs.getInt("idContato"));
				caixas.add(c);
			}
			rs.close();
			stmt.close();
			return caixas;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Caixa c) {
		String sql = "update caixas set caixa=?, idCliente=?, patrimonio=?, idContato=? " +
				"where idCaixa = " + c.getIdCaixa();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			System.out.println("ATUALIZANDO ID:"+c.getIdCaixa());
			stmt.setString(1, c.getCaixa());
			stmt.setInt(2, c.getIdCliente());
			stmt.setString(3, c.getPatrimonio());
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

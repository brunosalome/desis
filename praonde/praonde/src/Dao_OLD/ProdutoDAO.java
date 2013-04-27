	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class ProdutoDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public ProdutoDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Produto prod) {
		String sql = "INSERT INTO produtos (idProduto, descricao, barras, valor, duplo, ultimo) " +
				"VALUES (?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,prod.getIdProduto());
			stmt.setString(2, prod.getDescricao());
			stmt.setInt(3, prod.getBarras());
			stmt.setDouble(4, prod.getValor());
			stmt.setInt(5, prod.getDuplo());
			stmt.setInt(6, prod.getUltimo());
			
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
		String sql = "delete from produtos where idProduto in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> getLista(){
		try{
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Produto prod = new Produto();
				prod.setIdProduto(rs.getInt("idProduto"));
				prod.setBarras(rs.getInt("barras"));
				prod.setValor(rs.getDouble("valor"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setUltimo(rs.getInt("ultimo"));
				prod.setDuplo(rs.getInt("duplo"));
				produtos.add(prod);
			}
			rs.close();
			stmt.close();
			return produtos;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idProduto ) as idProduto FROM produtos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idProduto");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Produto getProduto(int idProduto){
		try{
			Produto prod = new Produto();
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos where idProduto = " + idProduto);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				prod.setIdProduto(rs.getInt("idProduto"));
				prod.setBarras(rs.getInt("barras"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setValor(rs.getDouble("valor"));
				prod.setDuplo(rs.getInt("duplo"));
				prod.setUltimo(rs.getInt("ultimo"));
			}
			rs.close();
			stmt.close();
			return prod;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Produto> getConsulta(String sql){
		try{
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Produto prod = new Produto();
				prod.setIdProduto(rs.getInt("idProduto"));
				prod.setBarras(rs.getInt("barras"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setValor(rs.getDouble("valor"));
				prod.setUltimo(rs.getInt("ultimo"));
				prod.setDuplo(rs.getInt("duplo"));
				produtos.add(prod);
			}
			rs.close();
			stmt.close();
			return produtos;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Produto prod) {
		String sql = "update produtos set idProduto=?, descricao=?, barras=?, valor=?, duplo=?, ultimo=? " +
				"where idProduto = " + prod.getIdProduto();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,prod.getIdProduto());
			stmt.setString(2, prod.getDescricao());
			stmt.setInt(3, prod.getBarras());
			stmt.setDouble(4, prod.getValor());
			stmt.setInt(5, prod.getDuplo());
			stmt.setInt(6, prod.getUltimo());
			
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

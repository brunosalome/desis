	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class Caixa_has_ProdutosDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public Caixa_has_ProdutosDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Caixa_has_Produtos chp) {
		String sql = "INSERT INTO caixa_has_produtos (idCaixaHasProdutos, idCaixa, idProduto, quantidade, patrimonio, " +
				"observacao) " +
				"VALUES (?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,chp.getIdCaixa_has_Produtos());
			stmt.setInt(2, chp.getIdCaixa());
			stmt.setInt(3, chp.getIdProduto());
			stmt.setInt(4, chp.getQuantidade());
			stmt.setString(5, chp.getPatrimonio());
			stmt.setString(6, chp.getObservacao());		
			
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
		String sql = "delete from caixa_has_produtos where idCaixaHasProdutos in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Caixa_has_Produtos> getLista(){
		try{
			List<Caixa_has_Produtos> ohps = new ArrayList<Caixa_has_Produtos>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from caixa_has_produtos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Caixa_has_Produtos chp = new Caixa_has_Produtos();
				chp.setIdCaixa_has_Produtos(rs.getInt("idCaixaHasProdutos"));
				chp.setIdCaixa(rs.getInt("idCaixa"));
				chp.setIdProduto(rs.getInt("idProduto"));
				chp.setObservacao(rs.getString("observacao"));
				chp.setPatrimonio(rs.getString("patrimonio"));
				chp.setQuantidade(rs.getInt("quantidade"));
				ohps.add(chp);
			}
			rs.close();
			stmt.close();
			return ohps;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Caixa_has_Produtos getCHP(int idCHP){
		try{
			Caixa_has_Produtos chp = new Caixa_has_Produtos();
			PreparedStatement stmt = this.connection.prepareStatement("select * from caixa_has_Produtos where idCaixaHasProdutos = " + idCHP);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				chp.setIdCaixa_has_Produtos(rs.getInt("idCaixaHasProdutos"));
				chp.setIdCaixa(rs.getInt("idCaixa"));
				chp.setIdProduto(rs.getInt("idProduto"));
				chp.setObservacao(rs.getString("observacao"));
				chp.setPatrimonio(rs.getString("patrimonio"));
				chp.setQuantidade(rs.getInt("quantidade"));
			}
			rs.close();
			stmt.close();
			return chp;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Caixa_has_Produtos> getCHPsOS (int idCaixa){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from caixa_has_Produtos where idCaixa = " + idCaixa);
			ResultSet rs = stmt.executeQuery();
			List<Caixa_has_Produtos> ohps = new ArrayList<Caixa_has_Produtos>();
			while(rs.next()){
				Caixa_has_Produtos chp = new Caixa_has_Produtos();
				chp.setIdCaixa_has_Produtos(rs.getInt("idCaixaHasProdutos"));
				chp.setIdCaixa(rs.getInt("idCaixa"));
				chp.setIdProduto(rs.getInt("idProduto"));
				chp.setObservacao(rs.getString("observacao"));
				chp.setPatrimonio(rs.getString("patrimonio"));
				chp.setQuantidade(rs.getInt("quantidade"));
				ohps.add(chp);
			}
			rs.close();
			stmt.close();
			return ohps;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza(Caixa_has_Produtos chp) {
		String sql = "update caixa_has_produtos set idCaixaHasProdutos=?, idCaixa=?, idProduto=?, observacao=?," +
				"patrimonio=?, quantidade=? " +
				"where idCaixaHasProdutos = " + chp.getIdCaixa_has_Produtos();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, chp.getIdCaixa_has_Produtos());
			stmt.setInt(2, chp.getIdCaixa());
			stmt.setInt(3, chp.getIdProduto());
			stmt.setString(4, chp.getObservacao());
			stmt.setString(5, chp.getPatrimonio());
			stmt.setInt(6, chp.getQuantidade());
			

			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	public Caixa_has_Produtos getProdutoDaCaixa (int idCaixa, int idProduto){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from caixa_has_Produtos where idCaixa = " + idCaixa + " and idProduto = " + idProduto);
			ResultSet rs = stmt.executeQuery();
			Caixa_has_Produtos chp = new Caixa_has_Produtos();
			if(rs.next()){
				chp.setIdCaixa_has_Produtos(rs.getInt("idCaixaHasProdutos"));
				chp.setIdCaixa(rs.getInt("idCaixa"));
				chp.setIdProduto(rs.getInt("idProduto"));
				chp.setObservacao(rs.getString("observacao"));
				chp.setPatrimonio(rs.getString("patrimonio"));
				chp.setQuantidade(rs.getInt("quantidade"));
			}
			rs.close();
			stmt.close();
			return chp;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}	
	
	
}

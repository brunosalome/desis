	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class OS_has_ProdutosDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public OS_has_ProdutosDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(OS_has_Produtos ohp) {
		String sql = "INSERT INTO os_has_produtos (idOSHasProdutos, idOS, idProduto, qtd, patrimonio, " +
				"conserto, idMotivo, observacao, quebrado_qtd) " +
				"VALUES (?,?,?,?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,ohp.getIdOS_has_produtos());
			stmt.setInt(2, ohp.getIdOS());
			stmt.setInt(3, ohp.getIdProduto());
			stmt.setInt(4, ohp.getQuantidade());
			stmt.setString(5, ohp.getPatrimonio());
			stmt.setString(6, ohp.getConserto());
			stmt.setInt(7, ohp.getIdMotivo());
			stmt.setString(8, ohp.getObservacao());
			stmt.setInt(9, ohp.getQuebrado_qtd());
			
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
		String sql = "delete from os_has_produtos where idOSHasProdutos in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void removeDaOs (int idOS){
		String sql = "delete from os_has_produtos where idOS = "+idOS;
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}	
	
	public List<OS_has_Produtos> getLista(){
		try{
			List<OS_has_Produtos> ohps = new ArrayList<OS_has_Produtos>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from os_has_produtos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				OS_has_Produtos ohp = new OS_has_Produtos();
				ohp.setIdOS_has_produtos(rs.getInt("idOShasProdutos"));
				ohp.setIdOS(rs.getInt("idOS"));
				ohp.setPatrimonio(rs.getString("patrimonio"));
				ohp.setIdProduto(rs.getInt("idProduto"));
				ohp.setQuantidade(rs.getInt("qtd"));
				ohp.setConserto(rs.getString("conserto"));
				ohp.setIdMotivo(rs.getInt("idMotivo"));
				ohp.setObservacao(rs.getString("observacao"));
				ohp.setQuebrado_qtd(rs.getInt("quebrado_qtd"));
				ohps.add(ohp);
			}
			rs.close();
			stmt.close();
			return ohps;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public OS_has_Produtos getOHP(int idOHP){
		try{
			OS_has_Produtos ohp = new OS_has_Produtos();
			PreparedStatement stmt = this.connection.prepareStatement("select * from OS_has_Produtos where idOShasProdutos = " + idOHP);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				ohp.setIdOS_has_produtos(rs.getInt("idOShasProdutos"));
				ohp.setIdOS(rs.getInt("idOS"));
				ohp.setPatrimonio(rs.getString("patrimonio"));
				ohp.setIdProduto(rs.getInt("idProduto"));
				ohp.setQuantidade(rs.getInt("qtd"));
				ohp.setConserto(rs.getString("conserto"));
				ohp.setIdMotivo(rs.getInt("idMotivo"));
				ohp.setObservacao(rs.getString("observacao"));
				ohp.setQuebrado_qtd(rs.getInt("quebrado_qtd"));
			}
			rs.close();
			stmt.close();
			return ohp;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<OS_has_Produtos> getOHPsOS (int idOS){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from OS_has_Produtos where idOS = " + idOS);
			ResultSet rs = stmt.executeQuery();
			List<OS_has_Produtos> ohps = new ArrayList<OS_has_Produtos>();
			while(rs.next()){
				OS_has_Produtos ohp = new OS_has_Produtos();
				ohp.setIdOS_has_produtos(rs.getInt("idOShasProdutos"));
				ohp.setIdOS(rs.getInt("idOS"));
				ohp.setPatrimonio(rs.getString("patrimonio"));
				ohp.setIdProduto(rs.getInt("idProduto"));
				ohp.setQuantidade(rs.getInt("qtd"));
				ohp.setConserto(rs.getString("conserto"));
				ohp.setIdMotivo(rs.getInt("idMotivo"));
				ohp.setObservacao(rs.getString("observacao"));
				ohp.setQuebrado_qtd(rs.getInt("quebrado_qtd"));
				ohps.add(ohp);
			}
			rs.close();
			stmt.close();
			return ohps;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza(OS_has_Produtos ohp) {
		String sql = "update os_has_produtos set idOsHasProdutos=?, idOS=?, idProduto=?," +
				"qtd=?, patrimonio=?, conserto=?," +
				"idMotivo=?, observacao=?, quebrado_qtd=? " +
				"where idOSHasProdutos = " + ohp.getIdOS_has_produtos();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1,ohp.getIdOS_has_produtos());
			stmt.setInt(2, ohp.getIdOS());
			stmt.setInt(3, ohp.getIdProduto());
			stmt.setInt(4, ohp.getQuantidade());
			stmt.setString(5, ohp.getPatrimonio());
			stmt.setString(6, ohp.getConserto());
			stmt.setInt(7, ohp.getIdMotivo());
			stmt.setString(8, ohp.getObservacao());
			stmt.setInt(9, ohp.getQuebrado_qtd());

			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

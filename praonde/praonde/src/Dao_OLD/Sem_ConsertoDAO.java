	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class Sem_ConsertoDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public Sem_ConsertoDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Sem_Conserto sc) {
		String sql = "INSERT INTO sem_conserto (idSem_Conserto, idOs_Has_Produtos, idMotivo1, idMotivo2, idMotivo3, comprometida) " +
				"VALUES (?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,sc.getIdSem_Conserto());
			stmt.setInt(2, sc.getIdOs_Has_Produtos());
			stmt.setInt(3, sc.getIdMotivo1());
			stmt.setInt(4, sc.getIdMotivo2());
			stmt.setInt(5, sc.getIdMotivo3());
			stmt.setInt(6, sc.getComprometida());
			
			
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
		String sql = "delete from sem_conserto where idSem_Conserto in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Sem_Conserto> getLista(){
		try{
			List<Sem_Conserto> scs = new ArrayList<Sem_Conserto>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from sem_conserto");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Sem_Conserto sc = new Sem_Conserto();
				sc.setIdOs_Has_Produtos(rs.getInt("idOs_Has_Produtos"));
				sc.setIdMotivo1(rs.getInt("idMotivo1"));
				sc.setIdMotivo2(rs.getInt("idMotivo2"));
				sc.setIdMotivo3(rs.getInt("idMotivo3"));
				sc.setComprometida(rs.getInt("Comprometida"));
				scs.add(sc);
			}
			rs.close();
			stmt.close();
			return scs;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idSem_Conserto ) as idSem_Conserto FROM sem_conserto");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idSem_Conserto");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Sem_Conserto getSem_Conserto (int idSem_Conserto){
		try{
			Sem_Conserto sc = new Sem_Conserto();
			PreparedStatement stmt = this.connection.prepareStatement("select * from sem_conserto where idSem_Conserto = " + idSem_Conserto);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				sc.setIdSem_Conserto(idSem_Conserto);
				sc.setIdOs_Has_Produtos(rs.getInt("idOs_Has_Produtos"));
				sc.setIdMotivo1(rs.getInt("idMotivo1"));
				sc.setIdMotivo2(rs.getInt("idMotivo2"));
				sc.setIdMotivo3(rs.getInt("idMotivo3"));
				sc.setComprometida(rs.getInt("comprometida"));
			}
			rs.close();
			stmt.close();
			return sc;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Sem_Conserto> getConsulta(String sql){
		try{
			List<Sem_Conserto> scs = new ArrayList<Sem_Conserto>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Sem_Conserto sc = new Sem_Conserto();
				sc.setIdSem_Conserto(rs.getInt("idSem_Conserto"));
				sc.setIdOs_Has_Produtos(rs.getInt("idOs_Has_Produtos"));
				sc.setIdMotivo1(rs.getInt("idMotivo1"));
				sc.setIdMotivo2(rs.getInt("idMotivo2"));
				sc.setIdMotivo3(rs.getInt("idMotivo3"));
				sc.setComprometida(rs.getInt("comprometida"));
				scs.add(sc);
			}
			rs.close();
			stmt.close();
			return scs;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Sem_Conserto sc) {
		String sql = "update sem_conserto set idSem_Conserto=?, idOs_Has_Produtos=?, idMotivo1, idMotivo2, idMotivo3, comprometida=? " +
				"where idSem_Conserto = " + sc.getIdSem_Conserto();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,sc.getIdSem_Conserto());
			stmt.setInt(2,sc.getIdOs_Has_Produtos());
			stmt.setInt(3,sc.getIdMotivo1());
			stmt.setInt(4,sc.getIdMotivo2());
			stmt.setInt(4,sc.getIdMotivo3());
			stmt.setInt(5, sc.getComprometida());
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	public List<Sem_Conserto> getSemConsertoPorItem(int idOS_has_Produtos){
		try{
			List<Sem_Conserto> scs = new ArrayList<Sem_Conserto>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from sem_conserto where idOs_Has_Produtos = " + idOS_has_Produtos);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Sem_Conserto sc = new Sem_Conserto();
				sc.setIdOs_Has_Produtos(rs.getInt("idOs_Has_Produtos"));
				sc.setIdMotivo1(rs.getInt("idMotivo1"));
				sc.setIdMotivo2(rs.getInt("idMotivo2"));
				sc.setIdMotivo3(rs.getInt("idMotivo3"));
				sc.setComprometida(rs.getInt("Comprometida"));
				scs.add(sc);
			}
			rs.close();
			stmt.close();
			return scs;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}	
	
	
}

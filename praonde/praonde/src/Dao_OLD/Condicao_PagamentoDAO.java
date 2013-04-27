	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class Condicao_PagamentoDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public Condicao_PagamentoDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Condicao_Pagamento cp) {
		String sql = "INSERT INTO condicao_pagamento (idCondicao_Pagamento, condicao_pagamento) " +
				"VALUES (?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,cp.getIdCondicao_Pagamento());
			stmt.setString(2, cp.getCondicao_pagamento());
			
			
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
		String sql = "delete from condicao_pagamento where idCondicao_Pagamento in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Condicao_Pagamento> getLista(){
		try{
			List<Condicao_Pagamento> cps = new ArrayList<Condicao_Pagamento>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from condicao_pagamento");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Condicao_Pagamento cp = new Condicao_Pagamento();
				cp.setIdCondicao_Pagamento(rs.getInt("idCondicao_Pagamento"));
				cp.setCondicao_pagamento(rs.getString("condicao_pagamento"));
				cps.add(cp);
			}
			rs.close();
			stmt.close();
			return cps;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Condicao_Pagamento getCond(int idCond){
		try{
			Condicao_Pagamento cond = new Condicao_Pagamento();
			PreparedStatement stmt = this.connection.prepareStatement("select * from condicao_pagamento where idCondicao_Pagamento = " + idCond);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				cond.setIdCondicao_Pagamento(idCond);
				cond.setCondicao_pagamento(rs.getString("condicao_pagamento"));
			}
			rs.close();
			stmt.close();
			return cond;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Condicao_Pagamento> getConsulta(String sql){
		try{
			List<Condicao_Pagamento> cps = new ArrayList<Condicao_Pagamento>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Condicao_Pagamento c = new Condicao_Pagamento();
				c.setIdCondicao_Pagamento(rs.getInt("idCondicao_Pagamento"));
				c.setCondicao_pagamento(rs.getString("condicao_pagamento"));
				cps.add(c);
			}
			rs.close();
			stmt.close();
			return cps;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Condicao_Pagamento cp) {
		String sql = "update condicao_pagamento set idCondicao_Pagamento=?, condicao_pagamento=? " +
				"where idCondicao_Pagamento = " + cp.getIdCondicao_Pagamento();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,cp.getIdCondicao_Pagamento());
			stmt.setString(2, cp.getCondicao_pagamento());
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

package Dao;

import java.sql.*;
import java.util.ArrayList;

import Utilities.Conexao;

public class PreferenciaDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
	private Connection connection;
    public ConnectionFactory conexta;
	
	public PreferenciaDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
    public void adiciona(Preferencia pref) {
		String sql = "INSERT INTO preferencias (idPreferencia, descricao) "+
                    "Values(?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1, pref.getIdPreferencia());
            stmt.setString(2, pref.getDescricao());
          
			// executa
			stmt.execute();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
    
    public static boolean update(Preferencia pref) {
        try {
        	pstmt = Conexao.getConnection().prepareStatement(
                    "Update preferencias Set idPreferencia=?, descricao=? where idPreferencia = ?");
            pstmt.setInt(1, pref.getIdPreferencia());            
            pstmt.setString(2, pref.getDescricao());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Preferencia pref) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From usuarios Where idPreferencia= ?");
            pstmt.setInt(1, pref.getIdPreferencia());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Preferencia> getAll() {
        try {
            ArrayList<Preferencia> listAll = null;
            Preferencia pref = new Preferencia();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From preferencias Order By idPreferencia");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Preferencia>();
                do {
                    pref = new Preferencia();
                    pref.setIdPreferencia(rs.getInt("idPreferencia"));
                    pref.setDescricao(rs.getString("descricao"));
                    listAll.add(pref);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Preferencia getById(int Id) {
        try {
            Preferencia pref = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From preferencias Where idPreferencia = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                pref = new Preferencia();
                pref.setIdPreferencia(rs.getInt("idPreferencia"));
                pref.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            pstmt.close();
            return pref;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idPreferencia ) as idPreferencia FROM preferencias");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idPreferencia");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}   
    
}
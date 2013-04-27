package Dao;

import java.sql.*;
import java.util.ArrayList;

import Utilities.Conexao;

public class PreferenciaUsuarioDAO {
    private static PreparedStatement pstmt = null;
    
    private static ResultSet rs = null;
	private Connection connection;
    public ConnectionFactory conexta;
	
	public PreferenciaUsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
    public void adiciona(PreferenciaUsuario prefusu) {
		String sql = "INSERT INTO caronas (idPreferenciaUsuario, idPreferencia, idUsuario) " +
				" VALUES (?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,prefusu.getIdPreferenciaUsuario());
			stmt.setInt(2,prefusu.getIdPreferencia());
			stmt.setInt(3, prefusu.getIdUsuario());
			
			// executa
			stmt.execute();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
    
    public static boolean update(PreferenciaUsuario prefusu) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update caronas Set idPreferenciaUsuario=?, idPreferencia=?, idUsuario=? where idPreferenciaUsuario = ?");
            pstmt.setInt(1, prefusu.getIdPreferenciaUsuario());
            pstmt.setInt(2, prefusu.getIdPreferencia());
            pstmt.setInt(3, prefusu.getIdUsuario());
            
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(PreferenciaUsuario prefusu) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From preferenciasUsuarios Where idPreferenciaUsuario = ?");
            pstmt.setInt(1, prefusu.getIdPreferenciaUsuario());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<PreferenciaUsuario> getAll() {
        try {
            ArrayList<PreferenciaUsuario> listAll = null;
            PreferenciaUsuario prefusu = new PreferenciaUsuario();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From preferenciasUsuarios Order By idPreferenciaUsuario");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<PreferenciaUsuario>();
                do {
                    prefusu = new PreferenciaUsuario();
                    prefusu.setIdPreferenciaUsuario(rs.getInt("idPreferenciaUsuario"));
                    prefusu.setIdPreferencia(rs.getInt("idPreferencia"));
                    prefusu.setIdUsuario(rs.getInt("idUsuario"));
                    listAll.add(prefusu);
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
    
    public static PreferenciaUsuario getById(int Id) {
        try {
            PreferenciaUsuario prefusu = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From preferenciasUsuarios Where idPreferenciaUsuario = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            	prefusu = new PreferenciaUsuario();
            	prefusu.setIdPreferenciaUsuario(rs.getInt("idPreferenciaUsuario"));
            	prefusu.setIdPreferencia(rs.getInt("idPreferencia"));
            	prefusu.setIdUsuario(rs.getInt("idUsuario"));
            }
            rs.close();
            pstmt.close();
            return prefusu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
            
	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idPreferenciaUsuario ) as idPreferenciaUsuario FROM preferenciasUsuarios");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idPreferenciaUsuario");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}   
    
}
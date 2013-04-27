package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

import Utilities.Conexao;
import Dao.Usuario;

public class VeiculoDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
 /**   
    public static boolean create(Usuario usuario) {
        try {
            usuario.setIdUsuario(Conexao.getAutoInc("usuarios"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into usuarios(idUsuario, email, nome, endereco, cpf, nascimento, pais, " +
                    "cidade, usualter, dtalter, senha, telefone, celular) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, usuario.getIdUsuario());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3,usuario.getNome());
            pstmt.setString(4, usuario.getEndereco());
            pstmt.setInt(5, usuario.getCpf());
            pstmt.setString(6, usuario.getNascimento());
            pstmt.setString(6, usuario.getPais());
            pstmt.setString(6, usuario.getCidade());
            pstmt.setInt(6, usuario.getUsualter());
            pstmt.setString(6, usuario.getDtalter());
            pstmt.setString(6, usuario.getSenha());
            pstmt.setString(6, usuario.getTelefone());
            pstmt.setString(6, usuario.getCelular());
            
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
  **/  
    
	private Connection connection;
    public ConnectionFactory conexta;
	
	public VeiculoDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
    public void adiciona(Veiculo vei) {
		String sql = "INSERT INTO veiculos (idVeiculo, marca, modelo, cor, placa, ano, idUsuario,foto) " +
				"VALUES (?,?,?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			FileInputStream fis = null;
			// seta os valores
			
/**			File file = new File("myPhoto.png");
		    
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
**/			
			stmt.setInt(1,vei.getIdVeiculo());
			stmt.setString(2, vei.getMarca());
			stmt.setString(3, vei.getModelo());
			stmt.setString(4, vei.getCor());
			stmt.setString(5, vei.getPlaca());
			stmt.setInt(6, vei.getAno());
			stmt.setInt(7, vei.getIdUsuario());
			stmt.setString(8, vei.getFoto());
			
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
		String sql = "delete from veiculos where idVeiculo in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
    
    public boolean update(Veiculo veiculo) {
        try {
        	String sql = "UPDATE veiculos SET marca=?, modelo=?, cor=?, placa=?, ano=?, foto=? WHERE idVeiculo = " + veiculo.getIdVeiculo();
        	PreparedStatement stmt = connection.prepareStatement(sql);		
        	
            stmt.setString(1, veiculo.getMarca());            
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getCor());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setInt(5, veiculo.getAno());
            stmt.setString(6,veiculo.getFoto());
            stmt.executeUpdate();
            stmt.close();
            
            stmt.execute();
			stmt.close();
			connection.close();
			
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Usuario usuario) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From veiculos Where idVeiculo = ?");
            pstmt.setInt(1, usuario.getIdUsuario());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Veiculo> getAll() {
        try {
            ArrayList<Veiculo> listAll = null;
            Veiculo veiculo = new Veiculo();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From veiculos Order By marca");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Veiculo>();
                do {
                    veiculo = new Veiculo();
                    veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                    veiculo.setCor(rs.getString("cor"));
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setAno(rs.getInt("ano"));
                    listAll.add(veiculo);
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

    public ArrayList<Veiculo> getListaVeiculos(int idUsuario) {
        try {
            ArrayList<Veiculo> listAll = new ArrayList<Veiculo>();
            Veiculo veiculo = new Veiculo();
            String sql = "SELECT * FROM veiculos WHERE idUsuario = " + idUsuario;
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Veiculo>();
                do {
                    veiculo = new Veiculo();
                    veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                    veiculo.setCor(rs.getString("cor"));
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setAno(rs.getInt("ano"));
                    veiculo.setIdUsuario(rs.getInt("idUsuario"));
                    veiculo.setFoto(rs.getString("foto"));
                    listAll.add(veiculo);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
    public Veiculo getVeiculo(int idVeiculo) {
        try {
            Veiculo veiculo = null;
            String sql = "SELECT * FROM veiculos WHERE idVeiculo =" + idVeiculo;
        	PreparedStatement stmt = connection.prepareStatement(sql);	
        	
            rs = stmt.executeQuery();
            if (rs.next()) {
            	veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setFoto(rs.getString("foto"));
            }
            rs.close();
            stmt.close();
            return veiculo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idVeiculo ) as idVeiculo FROM veiculos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idVeiculo");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}   
    
}
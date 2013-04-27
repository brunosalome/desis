package Dao;

import java.sql.*;
import java.util.ArrayList;

import Utilities.Conexao;
import Dao.Usuario;
import Dao.ConnectionFactory;

public class UsuarioDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
 /**   
    public static boolean create(Usuario usuario) {
        try {
            usuario.setIdUsuario(Conexao.getAutoInc("usuarios"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into usuarios(idUsuario, email, nome, endereco, cpf, nascimento, pais, " +
                    "cidade, senha, telefone, celular, foto, rating, pergunta, resposta) "+
                    "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, usuario.getIdUsuario());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3,usuario.getNome());
            pstmt.setString(4, usuario.getEndereco());
            pstmt.setInt(5, usuario.getCpf());
            pstmt.setString(6, usuario.getNascimento());
            pstmt.setString(7, usuario.getPais());
            pstmt.setString(8, usuario.getCidade());
            pstmt.setString(9, usuario.getSenha());
            pstmt.setString(10, usuario.getTelefone());
            pstmt.setString(11, usuario.getCelular());
            pstmt.setString(12, usuario.getFoto());
            pstmt.setString(13, usuario.getRating());
            pstmt.setString(14, usuario.getPergunta());
            pstmt.setString(15, usuario.getResposta());
            
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
	
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
    public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO usuarios ( email, nome, endereco, cpf, nascimento, pais, " +
                    "cidade, senha, telefone, celular, foto, rating, pergunta, resposta) "+
                    "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2,usuario.getNome());
            stmt.setString(3, usuario.getEndereco());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getNascimento());
            stmt.setString(6, usuario.getPais());
            stmt.setString(7, usuario.getCidade());
            stmt.setString(8, usuario.getSenha());
            stmt.setString(9, usuario.getTelefone());
            stmt.setString(10, usuario.getCelular());
            stmt.setString(11, usuario.getFoto());
            stmt.setInt(12, usuario.getRating());
            stmt.setString(13, usuario.getPergunta());
            stmt.setString(14, usuario.getResposta());
            
			
			// executa
			stmt.execute();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
    
    public boolean update(Usuario usuario) {
        try {
        	pstmt = Conexao.getConnection().prepareStatement(
                    "Update usuarios Set email=?, nome=?, endereco=?, cpf=?, nascimento=?," +
                    "pais=?,cidade=?,senha=?,telefone=?,celular=?,foto=?,rating=?,pergunta=?,resposta=?" +
                    " where idUsuario = ?");
            pstmt.setString(1, usuario.getEmail());            
            pstmt.setString(2, usuario.getNome());
            pstmt.setString(3, usuario.getEndereco());
            pstmt.setString(4, usuario.getCpf());
            pstmt.setString(5, usuario.getNascimento());
            pstmt.setString(6, usuario.getPais());
            pstmt.setString(7, usuario.getCidade());
            pstmt.setString(8, usuario.getSenha());
            pstmt.setString(9, usuario.getTelefone());
            pstmt.setString(10, usuario.getCelular());
            pstmt.setString(11, usuario.getFoto());
            pstmt.setInt(12, usuario.getRating());
            pstmt.setString(13, usuario.getPergunta());
            pstmt.setString(14, usuario.getResposta());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(Usuario usuario) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From usuarios Where idUsuario = ?");
            pstmt.setInt(1, usuario.getIdUsuario());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Usuario> getAll() {
        try {
            ArrayList<Usuario> listAll = null;
            Usuario usuario = new Usuario();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From usuarios Order By email");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Usuario>();
                do {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setSenha(rs.getString("Senha"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEndereco(rs.getString("endereco"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setNascimento(rs.getString("nascimento"));
                    usuario.setPais(rs.getString("pais"));
                    usuario.setCidade(rs.getString("cidade"));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setCelular(rs.getString("celular"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setRating(rs.getInt("rating"));
                    usuario.setPergunta(rs.getString("pergunta"));
                    usuario.setResposta(rs.getString("resposta"));
                    usuario.setFoto(rs.getString("foto"));
                    listAll.add(usuario);
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
    
    public Usuario getById(int Id) {
        try {
            Usuario usuario = null;
            String sql="SELECT * FROM usuarios WHERE idUsuario = " + Id;
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNascimento(rs.getString("nascimento"));
                usuario.setPais(rs.getString("pais"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRating(rs.getInt("rating"));
                usuario.setPergunta(rs.getString("pergunta"));
                usuario.setResposta(rs.getString("resposta"));
                usuario.setFoto(rs.getString("foto"));
            }
            rs.close();
            stmt.close();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Usuario getUserLogin(String email, String senha){
        try {
            Usuario usuario = null;
            String sql="SELECT * FROM usuarios WHERE email=\'"+email+"\' AND senha=\'"+senha+"\'";
            System.out.println(sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if(rs.next()){
            	usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNascimento(rs.getString("nascimento"));
                usuario.setPais(rs.getString("pais"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRating(rs.getInt("rating"));
                usuario.setPergunta(rs.getString("pergunta"));
                usuario.setResposta(rs.getString("resposta"));
                usuario.setFoto(rs.getString("foto"));
            }
            stmt.close();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
  
    public Usuario getUsuario(String email){
        try {
            
            String sql = "SELECT * FROM usuarios WHERE email = \'" + email+"\'";
            PreparedStatement stmt = connection.prepareStatement(sql);						
            Usuario usuario = new Usuario();
            rs = stmt.executeQuery();
            if(rs.next()){
            	usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNascimento(rs.getString("nascimento"));
                usuario.setPais(rs.getString("pais"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRating(rs.getInt("rating"));
                usuario.setPergunta(rs.getString("pergunta"));
                usuario.setResposta(rs.getString("resposta"));
                usuario.setFoto(rs.getString("foto"));
            }
            
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }    
    
	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idUsuario ) as idUsuario FROM usuarios");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idUsuario");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}   
    
}
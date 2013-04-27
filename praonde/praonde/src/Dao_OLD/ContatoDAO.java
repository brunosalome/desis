	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class ContatoDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Contato cont) {
		String sql = "INSERT INTO contatos (idContato, nome, cargo, departamento, telefone_comercial, ramal, " +
				"celular_comercial, email_comercial, endereco_comercial, telefone_pessoal, celular_pessoal, " +
				"email_pessoal, endereco_pessoal, banco, agencia, conta_corrente, nascimento, idCliente) " +
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,cont.getIdContato());
			stmt.setString(2, cont.getNome());
			stmt.setString(3, cont.getCargo());
			stmt.setString(4, cont.getDepartamento());
			stmt.setString(5, cont.getTelefone_comercial());
			stmt.setString(6, cont.getRamal());
			stmt.setString(7, cont.getCelular_comercial());
			stmt.setString(8, cont.getEmail_comercial());
			stmt.setString(9, cont.getEndereco_comercial());
			stmt.setString(10, cont.getTelefone_pessoal());
			stmt.setString(11, cont.getCelular_pessoal());
			stmt.setString(12, cont.getEmail_pessoal());
			stmt.setString(13, cont.getEndereco_pessoal());
			stmt.setString(14, cont.getBanco());
			stmt.setString(15, cont.getAgencia());
			stmt.setString(16, cont.getConta_corrente());
			stmt.setString(17, cont.getNascimento());
			stmt.setInt(18, cont.getIdCliente());
			
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
		String sql = "delete from contatos where idContato in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		try{
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Contato cont = new Contato();
				cont.setAgencia(rs.getString("agencia"));
				cont.setBanco(rs.getString("banco"));
				cont.setCargo(rs.getString("cargo"));
				cont.setCelular_comercial(rs.getString("celular_comercial"));
				cont.setCelular_pessoal(rs.getString("celular_pessoal"));
				cont.setConta_corrente(rs.getString("conta_corrente"));
				cont.setDepartamento(rs.getString("departamento"));
				cont.setEmail_comercial(rs.getString("email_comercial"));
				cont.setEmail_pessoal(rs.getString("email_pessoal"));
				cont.setEndereco_comercial(rs.getString("endereco_comercial"));
				cont.setEndereco_pessoal(rs.getString("endereco_pessoal"));
				cont.setIdContato(rs.getInt("idContato"));
				cont.setNascimento(rs.getString("nascimento"));
				cont.setNome(rs.getString("nome"));
				cont.setRamal(rs.getString("ramal"));
				cont.setTelefone_comercial(rs.getString("telefone_comercial"));
				cont.setTelefone_pessoal(rs.getString("telefone_pessoal"));
				cont.setIdCliente(rs.getInt("idCliente"));
				contatos.add(cont);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idContato ) as idContato FROM contatos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idContato");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Contato getContato(int idContato){
		try{
			Contato cont = new Contato();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where idContato = " + idContato);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				cont.setAgencia(rs.getString("agencia"));
				cont.setBanco(rs.getString("banco"));
				cont.setCargo(rs.getString("cargo"));
				cont.setCelular_comercial(rs.getString("celular_comercial"));
				cont.setCelular_pessoal(rs.getString("celular_pessoal"));
				cont.setConta_corrente(rs.getString("conta_corrente"));
				cont.setDepartamento(rs.getString("departamento"));
				cont.setEmail_comercial(rs.getString("email_comercial"));
				cont.setEmail_pessoal(rs.getString("email_pessoal"));
				cont.setEndereco_comercial(rs.getString("endereco_comercial"));
				cont.setEndereco_pessoal(rs.getString("endereco_pessoal"));
				cont.setIdContato(rs.getInt("idContato"));
				cont.setNascimento(rs.getString("nascimento"));
				cont.setNome(rs.getString("nome"));
				cont.setRamal(rs.getString("ramal"));
				cont.setTelefone_comercial(rs.getString("telefone_comercial"));
				cont.setTelefone_pessoal(rs.getString("telefone_pessoal"));
				cont.setIdCliente(rs.getInt("idCliente"));
			}
			rs.close();
			stmt.close();
			return cont;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getListaRelacionada(int idCliente){
		try{
			ArrayList<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where idCliente = " + idCliente);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Contato cont = new Contato();
				cont.setAgencia(rs.getString("agencia"));
				cont.setBanco(rs.getString("banco"));
				cont.setCargo(rs.getString("cargo"));
				cont.setCelular_comercial(rs.getString("celular_comercial"));
				cont.setCelular_pessoal(rs.getString("celular_pessoal"));
				cont.setConta_corrente(rs.getString("conta_corrente"));
				cont.setDepartamento(rs.getString("departamento"));
				cont.setEmail_comercial(rs.getString("email_comercial"));
				cont.setEmail_pessoal(rs.getString("email_pessoal"));
				cont.setEndereco_comercial(rs.getString("endereco_comercial"));
				cont.setEndereco_pessoal(rs.getString("endereco_pessoal"));
				cont.setIdContato(rs.getInt("idContato"));
				cont.setNascimento(rs.getString("nascimento"));
				cont.setNome(rs.getString("nome"));
				cont.setRamal(rs.getString("ramal"));
				cont.setTelefone_comercial(rs.getString("telefone_comercial"));
				cont.setTelefone_pessoal(rs.getString("telefone_pessoal"));
				cont.setIdCliente(rs.getInt("idCliente"));
				contatos.add(cont);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getConsulta(String sql){
		try{
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Contato c = new Contato();
				c.setNome(rs.getString("nome"));
				c.setIdContato(rs.getInt("idContato"));
				contatos.add(c);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Contato cont) {
		String sql = "update contatos set idContato=?, nome=?, cargo=?, departamento=?, telefone_comercial=?, " +
				"ramal=?, celular_comercial=?, email_comercial=?,endereco_comercial=?,telefone_pessoal=?," +
				"celular_pessoal=?,email_pessoal=?,endereco_pessoal=?,banco=?, agencia=?, conta_corrente=?," +
				"nascimento=?, idCliente=? " +
				"where idContato = " + cont.getIdContato();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,cont.getIdContato());
			stmt.setString(2, cont.getNome());
			stmt.setString(3, cont.getCargo());
			stmt.setString(4, cont.getDepartamento());
			stmt.setString(5, cont.getTelefone_comercial());
			stmt.setString(6, cont.getRamal());
			stmt.setString(7, cont.getCelular_comercial());
			stmt.setString(8, cont.getEmail_comercial());
			stmt.setString(9, cont.getEndereco_comercial());
			stmt.setString(10, cont.getTelefone_pessoal());
			stmt.setString(11, cont.getCelular_pessoal());
			stmt.setString(12, cont.getEmail_pessoal());
			stmt.setString(13, cont.getEndereco_pessoal());
			stmt.setString(14, cont.getBanco());
			stmt.setString(15, cont.getAgencia());
			stmt.setString(16, cont.getConta_corrente());
			stmt.setString(17, cont.getNascimento());
			stmt.setInt(18, cont.getIdCliente());
			
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

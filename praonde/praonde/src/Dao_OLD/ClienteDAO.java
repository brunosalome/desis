	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionFactory;


public class ClienteDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(Cliente cli) {
		String sql = "INSERT INTO clientes (idCliente, nome, fantasia, tipo, documento, ie, cep, municipio, rua," +
				"numero, bairro, complemento, telefone) " +
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1,cli.getIdCliente());
			stmt.setString(2, cli.getNome());
			stmt.setString(3, cli.getFantasia());
			stmt.setString(4, cli.getTipo());
			stmt.setString(5, cli.getDocumento());
			stmt.setString(6, cli.getIe());
			stmt.setString(7, cli.getCep());
			stmt.setString(8, cli.getMunicipio());
			stmt.setString(9, cli.getRua());
			stmt.setString(10, cli.getNumero());
			stmt.setString(11, cli.getBairro());
			stmt.setString(12, cli.getComplemento());
			stmt.setString(13, cli.getTelefone());
			
			
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
		String sql = "delete from clientes where idCliente in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> getLista(){
		try{
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Cliente cli = new Cliente();
				cli.setIdCliente(rs.getInt("idCliente"));
				cli.setBairro(rs.getString("bairro"));
				cli.setCep(rs.getString("cep"));
				cli.setComplemento(rs.getString("complemento"));
				cli.setDocumento(rs.getString("documento"));
				cli.setFantasia(rs.getString("fantasia"));
				cli.setIe(rs.getString("ie"));
				cli.setMunicipio(rs.getString("municipio"));
				cli.setNome(rs.getString("nome"));
				cli.setNumero(rs.getString("numero"));
				cli.setRua(rs.getString("rua"));
				cli.setTelefone(rs.getString("telefone"));
				cli.setTipo(rs.getString("tipo"));
				cli.setCnpj(rs.getString("cnpj"));
				cli.setRg(rs.getString("rg"));
				cli.setCpf(rs.getString("cpf"));
				cli.setCcm(rs.getString("ccm"));
				cli.setEstado(rs.getString("estado"));
				clientes.add(cli);
			}
			rs.close();
			stmt.close();
			return clientes;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idCliente ) as idCliente FROM clientes");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idCliente");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public Cliente getCliente(int idCliente){
		try{
			Cliente cli = new Cliente();
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where idCliente = " + idCliente);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				cli.setIdCliente(rs.getInt("idCliente"));
				cli.setBairro(rs.getString("bairro"));
				cli.setCep(rs.getString("cep"));
				cli.setComplemento(rs.getString("complemento"));
				cli.setDocumento(rs.getString("documento"));
				cli.setFantasia(rs.getString("fantasia"));
				cli.setIe(rs.getString("ie"));
				cli.setMunicipio(rs.getString("municipio"));
				cli.setNome(rs.getString("nome"));
				cli.setNumero(rs.getString("numero"));
				cli.setRua(rs.getString("rua"));
				cli.setTelefone(rs.getString("telefone"));
				cli.setTipo(rs.getString("tipo"));
				cli.setCnpj(rs.getString("cnpj"));
				cli.setRg(rs.getString("rg"));
				cli.setCpf(rs.getString("cpf"));
				cli.setCcm(rs.getString("ccm"));
				cli.setEstado(rs.getString("estado"));
			}
			rs.close();
			stmt.close();
			return cli;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> getConsulta(String sql){
		try{
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Cliente c = new Cliente();
				c.setFantasia(rs.getString("fantasia"));
				c.setIdCliente(rs.getInt("idCliente"));
				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Cliente cli) {
		String sql = "update clientes set idCliente=?, nome=?, fantasia=?, tipo=?, documento=?, ie=?, cep=?," +
				"municipio=?,rua=?,numero=?,bairro=?,complemento=?,telefone=?, cnpj=?, rg=?, cpf=?, ccm=?, estado=? " +
				"where idCliente = " + cli.getIdCliente();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,cli.getIdCliente());
			stmt.setString(2, cli.getNome());
			stmt.setString(3, cli.getFantasia());
			stmt.setString(4, cli.getTipo());
			stmt.setString(5, cli.getDocumento());
			stmt.setString(6, cli.getIe());
			stmt.setString(7, cli.getCep());
			stmt.setString(8, cli.getMunicipio());
			stmt.setString(9, cli.getRua());
			stmt.setString(10, cli.getNumero());
			stmt.setString(11, cli.getBairro());
			stmt.setString(12, cli.getComplemento());
			stmt.setString(13, cli.getTelefone());
			stmt.setString(14, cli.getCnpj());
			stmt.setString(15, cli.getRg());
			stmt.setString(16, cli.getCpf());
			stmt.setString(17, cli.getCcm());
			stmt.setString(18, cli.getEstado());
			
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	
	
	
}

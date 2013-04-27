	package Dao_OLD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Dao.ConnectionFactory;


public class OSDAO {
	// a conexão com o banco de dados
	private Connection connection;
    public ConnectionFactory conexta;
	
	public OSDAO() {
		this.connection = new ConnectionFactory().getConnection();	
	}
	
	public void adiciona(OS os) {
		String sql = "INSERT INTO os (idCliente, dataLancamento, dataEntrega, idCondicao_Pagamento, " +
				" observacao, status, idCor1, idCor2, idCor3, numero_Caixa, idCaixa, ordenar, idSolicitante) " +
				" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);						
			// seta os valores
			stmt.setInt(1, os.getIdCliente());
			stmt.setString(2, os.getDataLancamento());
			stmt.setString(3, os.getDataEntrega());
			stmt.setInt(4, os.getIdCondicao_Pagamento());
			stmt.setString(5, os.getObservacao());
			stmt.setString(6, os.getStatus());
			stmt.setInt(7, os.getIdCor1());
			stmt.setInt(8, os.getIdCor2());
			stmt.setInt(9, os.getIdCor3());
			stmt.setString(10, os.getNumero_Caixa());
			stmt.setInt(11, os.getIdCaixa());
			stmt.setString(12, os.getOrdenar());
			stmt.setInt(13, os.getIdSolicitante());
			
			
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
		String sql = "delete from os where idOS in("+auxiliar+")";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);			
			stmt.execute();
			stmt.close();
			connection.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<OS> getLista(){
		try{
			List<OS> oss = new ArrayList<OS>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from os");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				OS os = new OS();
				os.setIdOS(rs.getInt("idOS"));
				os.setIdCliente(rs.getInt("idCliente"));
				os.setDataLancamento(rs.getString("dataLancamento"));
				os.setDataEntrega(rs.getString("dataEntrega"));
				os.setIdCondicao_Pagamento(rs.getInt("idCondicao_Pagamento"));
				os.setObservacao(rs.getString("observacao"));
				os.setStatus(rs.getString("status"));
				os.setIdCor1(rs.getInt("cor1"));
				os.setIdCor2(rs.getInt("cor2"));
				os.setIdCor3(rs.getInt("cor3"));
				os.setNumero_Caixa(rs.getString("numero_Caixa"));
				os.setIdCaixa(rs.getInt("idCaixa"));
				os.setOrdenar(rs.getString("ordenar"));
				os.setIdSolicitante(rs.getInt("idSolicitante"));
				oss.add(os);
			}
			rs.close();
			stmt.close();
			return oss;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int getLast() {
		try{
			int id = 0;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT MAX( idOS ) as idOS FROM os");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			id = rs.getInt("idOS");
			rs.close();
			stmt.close();
			return id;
		}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}

	public OS getOS(int idOS){
		try{
			OS os = new OS();
			PreparedStatement stmt = this.connection.prepareStatement("select * from os where idOS = " + idOS);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				os.setIdOS(rs.getInt("idOS"));
				os.setIdCliente(rs.getInt("idCliente"));
				os.setDataLancamento(rs.getString("dataLancamento"));
				os.setDataEntrega(rs.getString("dataEntrega"));
				os.setIdCondicao_Pagamento(rs.getInt("idCondicao_Pagamento"));
				os.setObservacao(rs.getString("observacao"));
				os.setStatus(rs.getString("status"));
				os.setIdCor1(rs.getInt("idCor1"));
				os.setIdCor2(rs.getInt("idCor2"));
				os.setIdCor3(rs.getInt("idCor3"));
				os.setNumero_Caixa(rs.getString("numero_Caixa"));	
				os.setIdCaixa(rs.getInt("idCaixa"));
				os.setOrdenar(rs.getString("ordenar"));
				os.setIdSolicitante(rs.getInt("idSolicitante"));
			}
			rs.close();
			stmt.close();
			return os;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<OS> getConsulta(String sql){
		try{
			List<OS> oss = new ArrayList<OS>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				OS os = new OS();
				os.setIdCliente(rs.getInt("idCliente"));
				os.setDataEntrega(rs.getString("dataEntrega"));
				os.setDataLancamento(rs.getString("dataLancamento"));
				os.setIdCondicao_Pagamento(rs.getInt("idCondicao_Pagamento"));
				os.setObservacao(rs.getString("observacao"));
				os.setStatus(rs.getString("status"));
				os.setIdOS(rs.getInt("idOS"));
				os.setIdCor1(rs.getInt("idCor1"));
				os.setIdCor2(rs.getInt("idCor2"));
				os.setIdCor3(rs.getInt("idCor3"));
				os.setNumero_Caixa(rs.getString("numero_Caixa"));		
				os.setIdCaixa(rs.getInt("idCaixa"));
				os.setOrdenar(rs.getString("ordenar"));
				os.setIdSolicitante(rs.getInt("idSolicitante"));
				oss.add(os);
			}
			rs.close();
			stmt.close();
			return oss;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void atualiza(OS os) {
		String sql = "update os set idOS=?, idCliente=?, dataLancamento=?, dataEntrega=?, idCondicao_Pagamento=?, " +
				"observacao=?,status=?,idCor1=?, idCor2=?, idCor3=?, numero_Caixa=?, idCaixa=?, ordenar=?, idSolicitante=? " +
				"where idOS = " + os.getIdOS();
		try {	
			// prepared statement para inserção		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setInt(1,os.getIdOS());
			stmt.setInt(2, os.getIdCliente());
			stmt.setString(3, os.getDataLancamento());
			stmt.setString(4, os.getDataEntrega());
			stmt.setInt(5, os.getIdCondicao_Pagamento());
			stmt.setString(6, os.getObservacao());
			stmt.setString(7, os.getStatus());		
			stmt.setInt(8, os.getIdCor1());
			stmt.setInt(9, os.getIdCor2());
			stmt.setInt(10, os.getIdCor3());
			stmt.setString(11, os.getNumero_Caixa());
			stmt.setInt(12, os.getIdCaixa());
			stmt.setString(13, os.getOrdenar());
			stmt.setInt(14, os.getIdSolicitante());
			
			// executa
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
 	
	public void ordenaPatrimonios(int idOS) {	
	
		boolean patrimonioCliente = false;
		
		OS_has_ProdutosDAO ohpdao = new OS_has_ProdutosDAO();
		List <OS_has_Produtos> ohps = ohpdao.getOHPsOS(idOS);
		
		OSDAO osdao = new OSDAO();
		OS os = osdao.getOS(idOS);
		
		Caixa_has_ProdutosDAO chpdao2 = new Caixa_has_ProdutosDAO();
		List<Caixa_has_Produtos> chps2 = chpdao2.getCHPsOS(os.getIdCaixa());
		
		for(Caixa_has_Produtos chp2 : chps2){
			if(chp2.getPatrimonio()!=null)
				if(chp2.getPatrimonio().equals("")==false && chp2.getPatrimonio().equals("0")==false)
					patrimonioCliente = true;
		}
		
/*		if(patrimonioCliente)
		for (OS_has_Produtos ohp : ohps){
			Caixa_has_ProdutosDAO chpdao = new Caixa_has_ProdutosDAO();
			Caixa_has_Produtos chp = chpdao.getProdutoDaCaixa(os.getIdCaixa(), ohp.getIdProduto());
			if(chp!=null){
				Caixa_has_ProdutosDAO chpdao2 = new Caixa_has_ProdutosDAO();
				List<Caixa_has_Produtos> chps2 = chpdao2.getCHPsOS(os.getIdCaixa());
				for(Caixa_has_Produtos chp2 : chps2)
					if(chp2.getPatrimonio().equals("")==false && chp2.getPatrimonio().equals("0")==false){
						patrimonioCliente = true;
						break;
					}else{
						patrimonioCliente = true;
					}
			}else{
				if(ohp.getPatrimonio().equals("")==false && ohp.getPatrimonio().equals("0"))
					patrimonioCliente = true;
			}
		}
*/		
		System.out.println("Tamanho da lista do erro: " + ohps.size());
		
		List<OS_has_Produtos> ohpsOrd = ohps;
		
		Collections.sort (
			ohpsOrd, new Comparator() {  
				public int compare(final Object o1, final Object o2) {
					final ProdutoDAO pdao = new ProdutoDAO();
					final OS_has_Produtos ohp1 = (OS_has_Produtos) o1; 
					final OS_has_Produtos ohp2 = (OS_has_Produtos) o2; 
					final String nomeP1 = pdao.getProduto(ohp1.getIdProduto()).getDescricao();
					final String nomeP2 = pdao.getProduto(ohp2.getIdProduto()).getDescricao();
					if(nomeP1!=null & nomeP2!=null)
						return nomeP1.compareTo(nomeP2);
					else
						return 0;
				}
			}
		); 
		
     	for(OS_has_Produtos ohp : ohpsOrd){
     		ProdutoDAO proddao = new ProdutoDAO();
     		Produto p = proddao.getProduto(ohp.getIdProduto());
     		if(p.getUltimo()==1)
     			Collections.swap(ohpsOrd, ohpsOrd.indexOf(ohp), ohpsOrd.size()-1); 
     	}
		
		int patrimonio = 1;
		
		if(patrimonioCliente==false){
			for (OS_has_Produtos ohp : ohpsOrd){
				OS_has_ProdutosDAO ohpdao2 = new OS_has_ProdutosDAO();
				ohp.setPatrimonio(Integer.toString(patrimonio));
				ohpdao2.atualiza(ohp);
				patrimonio = patrimonio + ohp.getQuantidade();
			}
		}
		
	}
}

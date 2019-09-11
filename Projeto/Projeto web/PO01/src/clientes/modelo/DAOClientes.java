package clientes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locacao.modelo.Locacao;
import modelo.Conexao;

public class DAOClientes {

	
	
	public void adicionarCliente(Clientes c ){
		try {
			Connection con = Conexao.getConexao();
		
			String sql = "INSERT INTO clientes(nome_clientes,cpf_clientes,cnh_clientes,tel_clientes,end_clientes) VALUES(?,?,?,?,?)";
		
			PreparedStatement pstm = con.prepareStatement(sql);
		
			
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getCPF());
			pstm.setString(3, c.getCNH());
			pstm.setString(4, c.getTel());
			pstm.setString(5, c.getEnd());
		
			pstm.execute();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	public Clientes buscarDetalhesCliente(int id) {
		
		Clientes c = new Clientes();
		
		Connection con = Conexao.getConexao();
		
		String sql = "SELECT * FROM clientes WHERE idClientes = ?;";
		
		try {
			
			PreparedStatement pstm1 = con.prepareStatement(sql);
			
			pstm1.setInt(1, id);
			
			ResultSet rs = pstm1.executeQuery();
			
			if(rs.next()) {
				c.setId(rs.getInt("idClientes"));
				c.setNome(rs.getString("nome_clientes"));
				c.setCPF(rs.getString("cpf_clientes"));
				c.setCNH(rs.getString("cnh_clientes"));
				c.setEnd(rs.getString("end_clientes"));
				c.setTel(rs.getString("tel_clientes"));
				
				return c;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void editarCliente(Clientes c) {
		Connection con = Conexao.getConexao();
		
		String sql = "UPDATE clientes SET nome_clientes = ?, cpf_clientes = ?,"+
		"cnh_clientes = ?, tel_clientes = ?, end_clientes = ? WHERE idClientes = ?;";
		
		PreparedStatement pstm;
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getCPF());
			pstm.setString(3, c.getCNH());
			pstm.setString(4, c.getTel());
			pstm.setString(5, c.getEnd());
			pstm.setInt(6, c.getId());
			
			
			pstm.execute();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	
	}
	
	public void deletarCliente(int id) {
		try {
    		Connection con = Conexao.getConexao();
    		String sql = "DELETE FROM locacoes WHERE cliente_locacoes = ?";
    		
    		PreparedStatement pstm = con.prepareStatement(sql);
    		
    		pstm.setInt(1,id);
    		
    		pstm.execute();
    		
    		String sql2 = "DELETE FROM clientes WHERE idClientes = ?;";
    		
    		PreparedStatement pstm2 = con.prepareStatement(sql2);
    		
    		pstm2.setInt(1, id);
    		
    		pstm2.execute();
    		
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
	}
	
	public List<Clientes> listarClientes(){
		
		Connection con = Conexao.getConexao();
    	
    	String sql = "SELECT * FROM clientes;";
    	List<Clientes> cl = new ArrayList<Clientes>();
    	
    	try {
    		PreparedStatement pstm = con.prepareStatement(sql);
    		
    		ResultSet rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			Clientes c = new Clientes();
    			c.setId(rs.getInt("idClientes"));
    			c.setNome(rs.getString("nome_clientes"));
    			c.setCPF(rs.getString("cpf_clientes"));
    			c.setCNH(rs.getString("cnh_clientes"));
    			c.setTel(rs.getString("tel_clientes"));
    			c.setEnd(rs.getString("end_clientes"));
    			
    			cl.add(c);
    			
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    
    	return cl;
	
	}
}

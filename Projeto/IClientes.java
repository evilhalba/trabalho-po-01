import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface que permite a manipulação de um conjunto de clientes.
 * @author Aline
 */
public class DAOClientes {
    /**
     * Adiciona um cliente na relação de clientes.
     * @param c Cliente a ser inserido.
     * foi tambem inserido um teste de pesquisa para caso o cpf ja exista
     * sendo assim foi desconsiderado o uso do atributo existecpf
     */
	// foi trocado de interface para class e trocado o nome de iclientes para daoclientes
    public void AdcionarCliente(Cliente c) { 
    	
    	if() {
    		
    	}else {
    	
    	
    		try {
    			Connection con = Conexao.getConexao();
    		
    			String sql = "INSERT INTO clientes(nome_clientes,cpf_clientes,cnh_clientes,tel_clientes,end_clientes) VALUES(?,?,?,?,?);";
    		
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
    	
    	
    	
    /**
     * Captura o cliente com o CPF informado por parâmetro.
     * @param CPF CPF do cliente a ser capturado.
     * @return Cliente com o CPF informado ou null caso o CPF não for encontrado.
     */
    }
    public Cliente buscarclientepcpf(String CPF) {
    	
    Cliente c = new Cliente();
    	Connection con = Conexao.getConexao();
    	
    	String sql = "SELECT * FROM clientes WHERE cpf_clientes = ?;";
    	
    	try {
    		
    		PreparedStatement pstm = con.prepareStatement(sql);
    		
    		pstm.setString(1, CPF);
    		
    		ResultSet rs = pstm.executeQuery();
    		
    		if(rs.next()) {
    			c.setId(rs.getInt("idClientes"));
    			c.setNome(rs.getString("nome_clientes"));
    			c.setCPF(rs.getString("cpf_clientes"));
    			c.setTel(rs.getString("tel_clientes"));
    			c.setCNH(rs.getString("cnh_clientes"));
    			c.setEnd(rs.getString("end_clientes"));
    			
    			
    		}
    	return c;
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	/**
     * Captura uma String com as informaçoes do cliente com CPF informado por parâmetro.
     * @param CPF CPF, do cliente a ser capturado.
     * @return String com as informaçoes do cliente com o CPF informado por parâmetro 
     * ou null caso o CPF não for encontrado.
     */
    }
    public List<Cliente> listarTudoClientes(){
    	
    	Connection con = Conexao.getConexao();
    	
    	String sql = "SELECT * FROM clientes;";
    	List<Cliente> cl = new ArrayList<Cliente>();
    	
    	try {
    		PreparedStatement pstm = con.prepareStatement(sql);
    		
    		ResultSet rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			Cliente c = new Cliente();
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
    /**
     * FOI TROCADO DE GETINFO PARA LISTAR CLIENTES
     * E TROCADO PARA LIST
     * Captura uma String com as informaçoes de todos os clientes.
     * @return String com as informaçoes de todos os clientes
     * ou null caso não exista nenhum cliente.
     */
    public String getInfo();
    
    /**
     * Captura uma String com o CPF e o nome de todos os clientes.
     * @return String com o CPF e o nome de todos os clientes
     * ou null caso não exista nenhum cliente.
     */
    public String getResumoInfo();
    
    /**
     * Modifica as informações do cliente com o CPF informado por parâmetro.
     * @param CPF CPD do cliente a ser modificado.
     * @param c Cliente com as modificações.
     * @return True se o cliente com o CPF informado por parâmetro for modificado ou
     * false caso não exista nenhum cliente com o CPF informado.
     */
    public Cliente editar(int id) {
    	
    	
    }
    
    /**
     * Remove o cliente com o CPF igual ao informado por parâmetro.
     * @param CPF CPF do cliente a ser capturado.
     * @return True se o cliente com o CPF informado por parâmetro for removido ou
     * false caso não exista nenhum cliente com o CPF informado. 
     * foi trocado o parametro de filtro para remoção para o id
     */
    public void remove(int id) {
    	
    	
    	try {
    		Connection con = Conexao.getConexao();
    		String sql = "DELETE * FROM locacoes WHERE cliente_locacoes = ?";
    		
    		PreparedStatement pstm = con.prepareStatement(sql);
    		
    		pstm.setInt(1,id);
    		
    		pstm.execute();
    		
    		String sql2 = "DELETE * FROM clientes WHERE idClientes = ?;";
    		
    		PreparedStatement pstm2 = con.prepareStatement(sql2);
    		
    		pstm2.setInt(1, id);
    		
    		pstm2.execute();
    		
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	
    }
    
    
    
    
    
   
}
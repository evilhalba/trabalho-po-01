import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface que permite a manipula��o de um conjunto de clientes.
 * @author Aline
 */
public class DAOClientes {
    /**
     * Adiciona um cliente na rela��o de clientes.
     * @param c Cliente a ser inserido.
     */
	// foi trocado de interface para class e trocado o nome de iclientes para daoclientes
    public void AdcionarCliente(Cliente c) { 
    	
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
    	
    	
    	
    	
    /**
     * Captura o cliente com o CPF informado por par�metro.
     * @param CPF CPF do cliente a ser capturado.
     * @return Cliente com o CPF informado ou null caso o CPF n�o for encontrado.
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
     * Captura uma String com as informa�oes do cliente com CPF informado por par�metro.
     * @param CPF CPF, do cliente a ser capturado.
     * @return String com as informa�oes do cliente com o CPF informado por par�metro 
     * ou null caso o CPF n�o for encontrado.
     */
    }
    public String getInfo(String CPF);
    
    /**
     * Captura uma String com as informa�oes de todos os clientes.
     * @return String com as informa�oes de todos os clientes
     * ou null caso n�o exista nenhum cliente.
     */
    public String getInfo();
    
    /**
     * Captura uma String com o CPF e o nome de todos os clientes.
     * @return String com o CPF e o nome de todos os clientes
     * ou null caso n�o exista nenhum cliente.
     */
    public String getResumoInfo();
    
    /**
     * Modifica as informa��es do cliente com o CPF informado por par�metro.
     * @param CPF CPD do cliente a ser modificado.
     * @param c Cliente com as modifica��es.
     * @return True se o cliente com o CPF informado por par�metro for modificado ou
     * false caso n�o exista nenhum cliente com o CPF informado.
     */
    public boolean set(String CPF, Cliente c);
    
    /**
     * Remove o cliente com o CPF igual ao informado por par�metro.
     * @param CPF CPF do cliente a ser capturado.
     * @return True se o cliente com o CPF informado por par�metro for removido ou
     * false caso n�o exista nenhum cliente com o CPF informado. 
     */
    public boolean remove(String CPF);
    
    /**
     * Verifica se existe um cliente com o CPF informado por par�metro.
     * @param CPF CPF do cliente a ser verificado.
     * @return True se um cliente com o CPF informado for encontrado ou 
     * false caso n�o exista nenhum cliente com o CPF informado.
     */
    public boolean existe(String CPF);
}
package veiculos.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.Conexao;

public class DAOVeiculos {
	
	public void adicionarVeiculo(Veiculo v){
		
		
		// TRY PRINCIPAL INSERE APENAS O VEICULO
		try {
			
			
			Connection con = Conexao.getConexao();
		
			String sql = "INSERT INTO veiculos(placa_veiculos,ano_veiculos,vdiaria_veiculos,tipo_veiculos) VALUES(?,?,?,?) ";
			PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, v.getPlaca_veiculos());
			pstm.setString(2, v.getAno_veiculos());
			pstm.setString(3, v.getVdiaria_veiculos());
			pstm.setString(4, v.getTipo_veiculos());
		
		
			pstm.executeUpdate();
			
			ResultSet rs = pstm.getGeneratedKeys();
			
			
			if (rs.next()) {
			   int id;
				id = rs.getInt(1);
				v.setIdVeiculos(id);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		if(v.getTipo_veiculos() == "CARRO") {
			//INSERE NA TABELA CARROS E NA TABELA VEICULOS HAS CARROS
			
			
			
			
			try {
			
			
				Connection con = Conexao.getConexao();
			
				String sql1 = "INSERT INTO carros npassageiros_carros, nportas_carros,"
						+ "mkm_carros, ar_carros VALUES(?,?,?,?)";
				PreparedStatement pstm1 = con.prepareStatement(sql1,PreparedStatement.RETURN_GENERATED_KEYS);
				
				
				
				pstm1.setInt(1, v.getCarro().getNpassageiros_carros());
				pstm1.setInt(2, v.getCarro().getNportas_carros());
				pstm1.setDouble(3, v.getCarro().getMkm_carros());
				pstm1.setInt(4, v.getCarro().getAr_carros());
				
			
				pstm1.executeUpdate();
				
				ResultSet rs = pstm1.getGeneratedKeys();
				
				
				if (rs.next()) {
				   int id;
					id = rs.getInt(1);
					v.getCarro().setCarros_idCarros(id);
				}
				
				
				
				
				String sql2 = "INSERT INTO veiculos_has_carros veiculos_idVeiculos, carros_idCarros VALUES (?,?)";
				PreparedStatement pstm2 = con.prepareStatement(sql2);
				
				pstm2.setInt(1, v.getIdVeiculos());
				pstm2.setInt(1, v.getCarro().getCarros_idCarros());
				pstm2.execute();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			if(v.getTipo_veiculos() == "ONIBUS") {
			////INSERE NA TABELA ONIBUS E NA TABELA VEICULOS HAS ONIBUS
			
				Connection con = Conexao.getConexao();
				
				String sql1 = "INSERT INTO onibus npassageiros_onibus, wifi_onibus, ar_onibus, cat_onibus VALUES(?,?,?,?)";
				
				
				
				try {
					PreparedStatement pstm1 = con.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
					pstm1.setInt(1, v.getOnibus().getNpassageiros_onibus());
					pstm1.setInt(2, v.getOnibus().getWifi_onibus());
					pstm1.setInt(3, v.getOnibus().getAr_onibus());
					pstm1.setInt(4, v.getOnibus().getCat_onibus());
					
					
					
					
					pstm1.executeUpdate();
					
					ResultSet rs = pstm1.getGeneratedKeys();
					
					
					if (rs.next()) {
					   int id;
						id = rs.getInt(1);
						v.getOnibus().setOnibus_idOnibus(id);
					}
					
					
					String sql2 = "INSERT INTO veiculos_has_onibus veiculos_idVeiculos, onibus_idOnibus VALUES(?,?)";
					
					PreparedStatement pstm2 = con.prepareStatement(sql2, PreparedStatement.RETURN_GENERATED_KEYS);
					pstm2.setInt(1, v.getIdVeiculos());
					pstm2.setInt(2, v.getOnibus().getOnibus_idOnibus());
					
					pstm2.execute();
					
				}catch(SQLException e ) {
					e.printStackTrace();
				}
				
				
			}else {
				
			////INSERE NA TABELA CAMINHAO E NA TABELA VEICULOS HAS CAMINHAO
				try {
					Connection con = Conexao.getConexao();
					
					
					String sql1 = "INSERT INTO caminhao neixos_caminhao,cmax_caminhao VALUES(?,?)";
					
					PreparedStatement pstm1 = con.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS);
					
					pstm1.setInt(1, v.getCaminhao().getNeixos_caminhao());
					pstm1.setDouble(2, v.getCaminhao().getCmax_caminhao());
					
					pstm1.executeUpdate();
					
					
					ResultSet rs = pstm1.getGeneratedKeys();
					
					
					if (rs.next()) {
					   int id;
						id = rs.getInt(1);
						v.getCaminhao().setIdCaminhao(id);
					}
					
					
					String sql2 = "INSERT INTO veiculos_has_caminhao veiculos_idVeiculos, caminhao_idCaminhao VALUES(?,?)";
					
					PreparedStatement pstm2 = con.prepareStatement(sql2);
					
					pstm2.setInt(1, v.getIdVeiculos());
					pstm2.setInt(2, v.getCaminhao().getIdCaminhao());
					
					
					pstm2.execute();
				}catch(SQLException e){
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	
	public void adicionarCatOnibus(Onibus o) {
		//ADICIONA UMA CATEGORIA AO ONIBUS NA TABELA
			try {
				Connection con = Conexao.getConexao();
				
				String sql = "INSERT INTO cat_onibus desc_cat_onibus VALUES(?)";
				
				PreparedStatement pstm = con.prepareStatement(sql);
				
				pstm.setInt(1, o.getDesc_cat_onibus());
				
				pstm.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	
	public void deletarVeiculo(int id, String tipo) {
		
		try {
			//deleta locaçoes do veiculo 
			
			
			
			
			if(tipo == "CARRO") {
				//delete carro
			}else {
				if(tipo == "ONIBUS") {
					//delete onibus
				}else {
					//delete caminhao
				}
			}
			
			
		}catch(SQLException e ){
			e.printStackTrace();
		}
		
		
	}
	
	public void editarVeiculo() {
		
	}
	
	public Veiculo buscarVeiculo() {
		
		
		return null;
	}
	
	public List<Veiculo> listarVeiculos(){
		
		
		return null;
	}
}

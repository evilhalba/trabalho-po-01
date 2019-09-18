package veiculos.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		Veiculo v = new Veiculo();
		try {
			//deleta locaçoes do veiculo 
			
			Connection con = Conexao.getConexao();
			
			String sql1 = "DELETE FROM locacoes WHERE veiculo_locacoes = ?";
			
			PreparedStatement pstm1 = con.prepareStatement(sql1);
			
			pstm1.setInt(1, id);
			
			pstm1.execute();
			
			if(tipo == "CARRO") {
				
				//busca ids e delete carro
				
				
				String sql2 =  "SELECT * FROM veiculos_has_carros WHERE veiculos_idVeiculos = ?";
				
				PreparedStatement pstm2 = con.prepareStatement(sql2);
				
				pstm2.setInt(1, id);
				
				ResultSet rs1 = pstm2.executeQuery();
				v.setIdVeiculos(rs1.getInt("veiculos_idVeiculos"));
				v.getCarro().setCarros_idCarros(rs1.getInt("carros_idCarros"));
				
				String sql3 = "DELETE FROM veiculos_has_carros WHERE  veiculos_idVeiculos = ?";
				
				PreparedStatement pstm3 = con.prepareStatement(sql3);
				
				
				pstm3.setInt(1, v.getIdVeiculos());
				
				pstm3.execute();
				
				
				String sql4 = "DELETE FROM carros WHERE idCarros = ?";
			
				
				PreparedStatement pstm4 = con.prepareStatement(sql4);
				
				pstm4.setInt(1, v.getCarro().getCarros_idCarros());
				
				
				pstm4.execute();
				
				String sql5 = "DELETE FROM veiculos WHERE idVeiculos = ?";
				
				PreparedStatement pstm5 = con.prepareStatement(sql5);
				
				pstm5.setInt(1, v.getIdVeiculos());
				
				pstm5.execute();
				
				
			}else {
				if(tipo == "ONIBUS") {
					//busca ids e delete onibus
					
					
					
					String sql6 =  "SELECT * FROM veiculos_has_onibus WHERE veiculos_idVeiculos = ?";
					
					PreparedStatement pstm6 = con.prepareStatement(sql6);
					
					pstm6.setInt(1, id);
					
					ResultSet rs2 = pstm6.executeQuery();
					v.setIdVeiculos(rs2.getInt("veiculos_idVeiculos"));
					v.getOnibus().setOnibus_idOnibus(rs2.getInt("onibus_idOnibus"));
					
					String sql7 = "DELETE FROM veiculos_has_onibus WHERE  veiculos_idVeiculos = ?";
					
					PreparedStatement pstm7 = con.prepareStatement(sql7);
					
					
					pstm7.setInt(1, v.getIdVeiculos());
					
					pstm7.execute();
					
					
					String sql8 = "DELETE FROM onibus WHERE idOnibus = ?";
				
					
					PreparedStatement pstm8 = con.prepareStatement(sql8);
					
					pstm8.setInt(1, v.getOnibus().getOnibus_idOnibus());
					
					
					pstm8.execute();
					
					String sql9 = "DELETE FROM veiculos WHERE idVeiculos = ?";
					
					PreparedStatement pstm9 = con.prepareStatement(sql9);
					
					pstm9.setInt(1, v.getIdVeiculos());
					
					pstm9.execute();
				}else {
					//busca ids e delete caminhao
					
					
					
					String sql10 =  "SELECT * FROM veiculos_has_onibus WHERE veiculos_idVeiculos = ?";
					
					PreparedStatement pstm10 = con.prepareStatement(sql10);
					
					pstm10.setInt(1, id);
					
					ResultSet rs3 = pstm10.executeQuery();
					v.setIdVeiculos(rs3.getInt("veiculos_idVeiculos"));
					v.getOnibus().setOnibus_idOnibus(rs3.getInt("caminhao_idCaminhao"));
					
					String sql7 = "DELETE FROM veiculos_has_onibus WHERE  veiculos_idVeiculos = ?";
					
					PreparedStatement pstm7 = con.prepareStatement(sql7);
					
					
					pstm7.setInt(1, v.getIdVeiculos());
					
					pstm7.execute();
					
					
					String sql8 = "DELETE FROM onibus WHERE idOnibus = ?";
				
					
					PreparedStatement pstm8 = con.prepareStatement(sql8);
					
					pstm8.setInt(1, v.getOnibus().getOnibus_idOnibus());
					
					
					pstm8.execute();
					
					String sql9 = "DELETE FROM veiculos WHERE idVeiculos = ?";
					
					PreparedStatement pstm9 = con.prepareStatement(sql9);
					
					pstm9.setInt(1, v.getIdVeiculos());
					
					pstm9.execute();
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
		
		Connection con = Conexao.getConexao();
		
		String sql = "SELECT * FROM veiculos";
		List<Veiculo> vl = new ArrayList<Veiculo>();
		
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Veiculo v = new Veiculo();
				v.setIdVeiculos(rs.getInt("idVeiculos"));
				v.setPlaca_veiculos(rs.getString("placa_veiculos"));
				v.setAno_veiculos(rs.getString("ano_veiculos"));
				v.setVdiaria_veiculos(rs.getString("vdiaria_veiculos"));
				v.setTipo_veiculos(rs.getString("tipo_veiculos"));
				
				
				vl.add(v);
			}
			
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		return vl;
	}
}

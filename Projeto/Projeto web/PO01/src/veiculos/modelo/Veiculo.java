package veiculos.modelo;

public class Veiculo {
	private int idVeiculos;
	private String placa_veiculos;
	private String ano_veiculos;
	private String vdiaria_veiculos;
	private String tipo_veiculos;
	private Carro carro;
	private Onibus onibus;
	private Caminhao caminhao;
	
	public int getIdVeiculos() {
		return idVeiculos;
	}
	public void setIdVeiculos(int idVeiculos) {
		this.idVeiculos = idVeiculos;
	}
	public String getPlaca_veiculos() {
		return placa_veiculos;
	}
	public void setPlaca_veiculos(String placa_veiculos) {
		this.placa_veiculos = placa_veiculos;
	}
	public String getAno_veiculos() {
		return ano_veiculos;
	}
	public void setAno_veiculos(String ano_veiculos) {
		this.ano_veiculos = ano_veiculos;
	}
	public String getVdiaria_veiculos() {
		return vdiaria_veiculos;
	}
	public void setVdiaria_veiculos(String vdiaria_veiculos) {
		this.vdiaria_veiculos = vdiaria_veiculos;
	}

	public String getTipo_veiculos() {
		return tipo_veiculos;
	}
	public void setTipo_veiculos(String tipo_veiculos) {
		this.tipo_veiculos = tipo_veiculos;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Onibus getOnibus() {
		return onibus;
	}
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	public Caminhao getCaminhao() {
		return caminhao;
	}
	public void setCaminhao(Caminhao caminhao) {
		this.caminhao = caminhao;
	}
	
	
}

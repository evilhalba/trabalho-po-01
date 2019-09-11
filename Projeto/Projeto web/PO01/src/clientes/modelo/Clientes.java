package clientes.modelo;

import java.util.List;

import locacao.modelo.Locacao;

public class Clientes {
	private int id;
	private String nome;
	private String CPF;
	private String CNH;
	private String end;
	private String tel;
	private List<Locacao> listlocacoescli;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getCNH() {
		return CNH;
	}
	public void setCNH(String cNH) {
		CNH = cNH;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Locacao> getListlocacoescli() {
		return listlocacoescli;
	}
	public void setListlocacoescli(List<Locacao> listlocacoescli) {
		this.listlocacoescli = listlocacoescli;
	}
	
	
}

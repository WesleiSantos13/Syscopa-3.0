package app.model;

import java.util.ArrayList;
/** Classe responsavel pela instancia do objeto grupo
 * 
 * @author Weslei Silva Santos
 *
 */
public class Grupo {
	
	
	private int id; //Id do grupo
	private String letraGrupo; // Nome/Letra do grupo, ex:A,B...
	private  ArrayList<Integer>selecoes = new ArrayList<>(); //Lista contendo o id das selecoes
	private String selecao1; // nome da Selecao 1
	private String selecao2; // nome da Selecao 2
	private String selecao3; // nome da Selecao 3
	private String selecao4; // nome da Selecao 4
	
	
	
	
	
	public ArrayList<Integer> getSelecoes() {
		return selecoes;
	}
	public void setSelecoes(ArrayList<Integer> selecoes) {
		this.selecoes = selecoes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLetraGrupo() {
		return letraGrupo;
	}
	public void setLetraGrupo(String letraGrupo) {
		this.letraGrupo = letraGrupo;
	}

	public String getSelecao1() {
		return selecao1;
	}
	public void setSelecao1(String selecao1) {
		this.selecao1 = selecao1;
	}
	public String getSelecao2() {
		return selecao2;
	}
	public void setSelecao2(String selecao2) {
		this.selecao2 = selecao2;
	}
	public String getSelecao3() {
		return selecao3;
	}
	public void setSelecao3(String selecao3) {
		this.selecao3 = selecao3;
	}
	public String getSelecao4() {
		return selecao4;
	}
	public void setSelecao4(String selecao4) {
		this.selecao4 = selecao4;
	}
	
	public Grupo(int id, String letraGrupo, ArrayList<Integer> selecoes, String selecao1, String selecao2,
			String selecao3, String selecao4) {
		super();
		this.id = id;
		this.letraGrupo = letraGrupo;
		this.selecoes = selecoes;
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		this.selecao3 = selecao3;
		this.selecao4 = selecao4;
	}
	
	

}

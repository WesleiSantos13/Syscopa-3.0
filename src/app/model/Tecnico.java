package app.model;
/** Classe responsavel pela instancia do objeto Tecnico
 * 
 * @author Weslei Silva Santos
 *
 */
public class Tecnico {
	
	private int id; // Id do tecnico
	private String nome; // Nome do tecnico
	private int idSelecao; // Id da selecao que o tecnico esta
	private String Selecao; // Nome da Selecao
	
	
	public Tecnico(int id, String nome, int idSelecao, String Selecao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idSelecao = idSelecao;
		this.Selecao = Selecao;
	}
	
	
	public int getId() {
		return id;
	}
	
	public int getIdSelecao() {
		return idSelecao;
	}
	public void setIdSelecao(int idSelecao) {
		this.idSelecao = idSelecao;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSelecao() {
		return Selecao;
	}
	public void setSelecao(String selecao) {
		Selecao = selecao;
	}

}

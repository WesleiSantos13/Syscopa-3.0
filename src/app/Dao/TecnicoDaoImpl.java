package app.Dao;

import java.util.ArrayList;    
import java.util.List;
import app.model.Tecnico;

/** Classe responsavel pelo gerenciamento de tecnicos
 * 
 * @author Weslei Silva Santos
 *
 */
public class TecnicoDaoImpl implements TecnicoDao {

	/**
	 * Lista de tecnicos
	 */
	private  static ArrayList<Tecnico>tecnicos = new ArrayList<Tecnico>();
	private  static int Ultimoid=1; 
	
		
	 
	
	@Override
	/** Adiciona um tecnico na lista de tecnico
	 * 
	 * @param t1 Objeto do tipo tecnico a ser adicionado
	 */
	public void CreateTec(Tecnico t1) {
		setUltimoid(getUltimoid()+1);
		tecnicos.add(t1);
		
	}

	@Override
	/** Atualiza um tecnico na lista, a partir do id e do objeto passado como parametro.
	 * 
	 * @param t1 Novos dados que irao substituir os do tecnico.
	 * @param id Id do tecnico a ser atualizado
	 */
	public void UpdateTec(Tecnico t1, int id) {
		int idTecnico;
		for (int i = 0; i <tecnicos.size(); i++) {
			idTecnico = tecnicos.get(i).getId();
			if (idTecnico == id) {
				tecnicos.get(i).setNome(t1.getNome());
				tecnicos.get(i).setSelecao(t1.getSelecao());
				}}
	}

	@Override
	/** Deleta um tecnico da lista, a partir do id passado como parametro.
	 * Se o id passado não estiver na lista, nada acontece.
	 * 
	 * @param id Id do tecnico a ser deletado
	 */
	public void DeleteTec(int id) {
		for (int i = 0; i < tecnicos.size(); i++) {
			// Se achar o id na lista
			if(id == tecnicos.get(i).getId()) {
				tecnicos.remove(i);
				}}}

	@Override
	/**Devolve a lista de tecnicos, para listagem e carregamento de dados
	 * 
	 * @return A lista de tecnicos
	 */
	public ArrayList<Tecnico> ListTec() {
		return tecnicos;
	}

	@Override
	/** Metodo responsavel pela pesquisa de tecnicos,
	 * a partir do nome passado por parametro
	 * 
	 * @param nome Nome do tecnico
	 * @return a lista com os tecnicos pesquisados (caso existam)
	 */
	public List<Tecnico> SearchTec(String nome) {
		//Lista com os ids dos tecnicos
		ArrayList<Tecnico>tecs = new ArrayList<>(); 
		for (Tecnico tec : tecnicos) {
			String nameTec= tec.getNome();
			if(nome.length()<=nameTec.length()) {
				//Transforma "nameTec" para o mesmo tamanho do nome passado por parametro
				String compara= (String) nameTec.subSequence(0, nome.length());
				// Comparando os dois nomes
				if(compara.equals(nome)) {
					tecs.add(tec);}}}
		return tecs;
	}

	public  int getUltimoid() {
		return Ultimoid; 
	}

	public  void setUltimoid(int ultimoid) {
		Ultimoid = ultimoid;
	}
	
}

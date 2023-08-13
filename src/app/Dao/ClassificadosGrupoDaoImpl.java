package app.Dao;

import java.util.ArrayList; 
import java.util.List;

import app.model.ClassificadosGrupo;


public class ClassificadosGrupoDaoImpl implements  ClassificadosGrupoDao{
	//
	private static ArrayList<ClassificadosGrupo> rankings = new ArrayList<ClassificadosGrupo>();
	private  static int Ultimoid=1;
	
	/** Adiciona uma classificacao na lista de Classificados
	 * 
	 * @param ranking Objeto do tipo classificacao a ser adicionado
	 */
	@Override
	public void CreateClassGrupo(ClassificadosGrupo ranking) {
		setUltimoid(getUltimoid()+1);	
		rankings.add(ranking);
		
	}
	/** Deleta a classificacao apartir do id passado por parametro
	 * 
	 * @param id id a ser removido
	 */
	@Override
	public void DeleteClassGrupo(int id) {
		for (int i = 0; i < rankings.size(); i++) {
			// Se achar o id na lista
			if(id == rankings.get(i).getId()) {
				rankings.remove(i);
			}}
		
	}
	
	
	/** Devolve a lista de classificados, para listagem e carregamento de dados
	 * 
	 * @return  A lista de classificados
	 */
	@Override
	public List<ClassificadosGrupo> ListClassGrupo() {
		return rankings;
	}
	
	
	
	public int getUltimoid() {
		return Ultimoid;
	}

	public void setUltimoid(int ultimoid) {
		Ultimoid = ultimoid;
	}

}

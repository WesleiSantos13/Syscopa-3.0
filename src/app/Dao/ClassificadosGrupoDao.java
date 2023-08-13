package app.Dao;

import java.util.List; 

import app.model.ClassificadosGrupo;
/** Interface responsavel pelo CRUD da classificacao da fase de grupos para as oitavas
 * 
 * @author Weslei Silva Santos
 *
 */
public interface ClassificadosGrupoDao {
	public void CreateClassGrupo(ClassificadosGrupo ranking);
	public void DeleteClassGrupo(int id);
	public List<ClassificadosGrupo> ListClassGrupo();
}

package app.Dao;

import java.util.List; 

import app.model.Tecnico;
/** Interface responsavel pelo CRUD do tecnico
 * 
 * @author Weslei Silva Santos
 *
 */
public interface TecnicoDao {
	
	public void CreateTec(Tecnico t1);
	public void UpdateTec(Tecnico t1, int id);
	public void DeleteTec(int id);
	public List<Tecnico> ListTec();
	public List<Tecnico> SearchTec(String nome);
}

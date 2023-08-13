package app.Dao;

import java.util.ArrayList; 
import java.util.List; 

import app.model.Selecao;

/** Interface responsavel pelo CRUD da selecao
 * 
 * @author Weslei Silva Santos
 *
 */
public interface SelecaoDao {
	
	public void CreateSelecao(Selecao s1);
	public void UpdateSelecao(Selecao s1, int id);
	public void DeleteSelecao(int id);
	public ArrayList<Selecao> ListSelecao();
	public  List<Selecao> SearchSelec(String nome);
	
}

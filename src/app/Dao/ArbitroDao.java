package app.Dao;

import java.util.List; 

import app.model.Arbitro;
/** Interface responsavel pelo CRUD do arbitro
 * 
 * @author Weslei Silva Santos
 */
public interface ArbitroDao {
		
	public void Create(Arbitro a1);
	public void UpdateArb(Arbitro a1, int id);
	public void DeleteArb(int id);
	public List<Arbitro> ListArb();
	public List<Arbitro> SearchArb(String nome);
}

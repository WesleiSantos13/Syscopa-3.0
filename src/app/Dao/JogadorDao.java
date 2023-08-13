package app.Dao;
import java.util.List; 

import app.model.Jogador;


/** Interface responsavel pelo CRUD do jogador
 * 
 * @author Weslei Silva Santos
 *
 */
public interface JogadorDao {
	
	public void Create(Jogador j1);
	public void UpdateJog(Jogador j1, int id);
	public void DeleteJog(int id);
	public List<Jogador> ListarJog();
	public List<Jogador> SearchJog(String nome);
	 
	 
}

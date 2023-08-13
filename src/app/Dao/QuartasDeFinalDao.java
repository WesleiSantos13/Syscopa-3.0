package app.Dao;

import java.util.List;

import app.model.Partida;
/** Interface responsavel pelo CRUD das partidas das quartas de final
 * 
 * @author Weslei Silva Santos
 *
 */
public interface QuartasDeFinalDao {
	public void CreatePart(Partida partida);
	public void UpdatePart(Partida partida, int id);
	public void DeletePart(int id);
	public List<Partida> ListPart();
	public List<Partida> SearchPart(String nome);
}

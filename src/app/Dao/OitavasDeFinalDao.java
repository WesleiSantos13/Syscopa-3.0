package app.Dao;

import java.util.List;

import app.model.Partida;

/** Interface responsavel pelo CRUD das partidas das oitavas 
 * 
 * @author Weslei Silva Santos
 *
 */

public interface OitavasDeFinalDao {
	public void CreateOitavFinal(Partida partida);
	public void UpdateOitavFinal(Partida partida, int id);
	public void DeleteOitavFinal(int id);
	public List<Partida> ListOitavFinal();
	public List<Partida> SearchOitavFinal(String nome);
}

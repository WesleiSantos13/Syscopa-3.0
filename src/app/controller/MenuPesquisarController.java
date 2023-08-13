package app.controller;

import java.io.IOException;

import app.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
/** Classe controle responsavel pela pesquisa
 * 
 * @author Weslei Silva Santos
 */
public class MenuPesquisarController {

    @FXML
    private Button PesquisarArbitros;

    @FXML
    private Button PesquisarJogadores;

    @FXML
    private Button PesquisarPartidas;

    @FXML
    private Button PesquisarSelecoes;

    @FXML
    private Button PesquisarTecnicos;

    @FXML
    private Button voltar;

    
    /** Opcao de pesquisa de arbitros
     * 
     * @param event
     */
    @FXML
    void PesquisarArbitrosAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/PesquisaArbitro.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

   
    /** Opcao de pesquisa de Jogadores
     * 
     * @param event
     */
    @FXML
    void PesquisarJogadoresAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/PesquisaJogador.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    /** Opcao de pesquisa de partidas
     * 
     * @param event
     */
    @FXML
    void PesquisarPartidasAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/PesquisaPartida.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    /** Opcao de pesquisa de selecoes
     * 
     * @param event
     */
    @FXML
    void PesquisarSelecoesAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/PesquisaSelecao.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    /** Opcao de pesquisa de tecnicos
     * 
     * @param event
     */
    @FXML
    void PesquisarTecnicosAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/PesquisaTecnico.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /** Opcao de voltar ao menu inicial
     * 
     * @param event
     */
    @FXML
    void voltarAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/TelaPrincipal.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}

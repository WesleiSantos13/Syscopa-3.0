package app.controller;

import java.io.IOException;

import app.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
/** Classe controle responsavel pelas grupo
* 
* @author Weslei Silva Santos
*
*/
public class CRUDGrupoController {

    @FXML
    private Button EditarExcluir;

    @FXML
    private Button Inserir;

  

    @FXML
    private Button Voltar;

    @FXML
    void EditarExcluirAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/EditarGrupo.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void InserirAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/InserirGrupo.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

  
    @FXML
    void VoltarAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/TelaPrincipal.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}

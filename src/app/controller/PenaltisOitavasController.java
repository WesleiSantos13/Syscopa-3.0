package app.controller;

import java.io.IOException; 

import app.Principal;
import app.Dao.OitavasDeFinalDaoImpl;
import app.model.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/** Classe controle responsavel pelos penaltis das oitavas de final
 * 
 * @author Weslei Silva Santos
 *
 */
public class PenaltisOitavasController {
	OitavasDeFinalDaoImpl oitavasDao = new OitavasDeFinalDaoImpl();
	private Partida partida = CRUDOitavasController.getEmpates().get(0);
	
	@FXML
    private TextField Penalti1;

    @FXML
    private TextField Penalti2;

    @FXML
    private Label golsSelecao1;

    @FXML
    private Label golsSelecao2;

    @FXML
    private Button registrar;

    @FXML
    private Label selecao1;

    @FXML
    private Label selecao2;
    
    @FXML
    private Label LabelError;

    /** Opcao de registro de penaltis
     * 
     * @param event
     */
    @FXML
    void registrarAction(ActionEvent event) {
    	try {
    		int penalti1 = Integer.parseInt(this.Penalti1.getText());
	    	int penalti2 = Integer.parseInt(this.Penalti2.getText());
	    	//os penaltis nao podem ser iguais
	    	if(penalti1!=penalti2) {
		    	partida.setGolsSelecao1(penalti1);
		    	partida.setGolsSelecao2(penalti2);
		    	oitavasDao.UpdateOitavFinal(partida, partida.getId());
		    	CRUDOitavasController.getEmpates().remove(0);
		    	try {
					Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDOitavas.fxml"));
					Scene cena = new Scene(root);
					Principal.setScene(cena);
				} catch (IOException e) {
					e.printStackTrace();
				}	
	    	}
	    	else {
	    		this.LabelError.setText("A QUANTIDADE DE PENALTIS NÃO PODEM SER IGUAIS");}}
    		
    		
    	catch(Exception erro) {
    		this.LabelError.setText("DADOS INVALIDOS");
    	}}
    	
    /** Inicializacao da tabela
     * 	
     */
	@FXML
	void initialize() {
		
		this.golsSelecao1.setText(String.valueOf(partida.getGolsSelecao1()));
    	this.golsSelecao2.setText(String.valueOf(partida.getGolsSelecao2()));
    	this.selecao1.setText(partida.getNomeSelecao1());
    	this.selecao2.setText(partida.getNomeSelecao2());
	}
}



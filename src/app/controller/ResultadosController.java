package app.controller;

import java.io.IOException;

import app.Principal;
import app.Dao.FinalDaoImpl;
import app.Dao.TerceiroLugarDaoImpl;
import app.model.Funcoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/** Classe controle responsavel pela exibicao dos finalistas da copa
 * 
 * @author Weslei Silva Santos
 *
 */
public class ResultadosController {
	TerceiroLugarDaoImpl tercLugarDao = new TerceiroLugarDaoImpl();
	FinalDaoImpl finalDao = new FinalDaoImpl();
	
	
    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Button podio;
    
    @FXML
    private Label labelError;

    @FXML
    private Button voltar;

    /** Opcao para fazer o podio de colacacoes
     * 
     * @param event
     */
    @FXML
    void podioAction(ActionEvent event) {
    	Boolean Verificar = Funcoes.verificarEstadoPart(finalDao.ListPart());
    	Boolean Verificar2 = Funcoes.verificarEstadoPart(tercLugarDao.ListPart());
    	//Se a final for criada e realizada
    	if(finalDao.ListPart().size()== 1 && Verificar) {
    		//Se a disputa pelo terceiro for criada e realizada
    		if(tercLugarDao.ListPart().size()== 1 && Verificar2) {
		    	int golsSelecao1 =finalDao.ListPart().get(0).getGolsSelecao1();
		    	int golsSelecao2 =finalDao.ListPart().get(0).getGolsSelecao2();
		    	//Colocacoes
		    	String primeiro;
				String segundo;
				String terceiro;
		    	//Se o numero de gols da selecao 1 for maior que o da selecao2
				if(golsSelecao1>golsSelecao2) {
		    		primeiro = finalDao.ListPart().get(0).getNomeSelecao1();
		    		segundo = finalDao.ListPart().get(0).getNomeSelecao2();}
		    	else {
		    		primeiro = finalDao.ListPart().get(0).getNomeSelecao2();
		    		segundo = finalDao.ListPart().get(0).getNomeSelecao1();
		    	}
		    	// Resultados da disputa pelo 3 lugar
		    	int golsSelecao3 = tercLugarDao.ListPart().get(0).getGolsSelecao1();
		    	int golsSelecao4 = tercLugarDao.ListPart().get(0).getGolsSelecao2();
		    	
		    	//Se o numero de gols da selecao 3 for maior que o da selecao 4
		    	if(golsSelecao3>golsSelecao4) {
		    		terceiro = tercLugarDao.ListPart().get(0).getNomeSelecao1();}
		    	else {
		    		terceiro = tercLugarDao.ListPart().get(0).getNomeSelecao2();}
		    	
		    	this.label1.setText(primeiro);
		    	this.label2.setText(segundo);
		    	this.label3.setText(terceiro);}
			else {
				this.labelError.setText("É necessário ter os dados da disputa pelo terceiro lugar");}
			}
    	else {
			this.labelError.setText("É necessário ter os dados da partida final");}
    	
    }

    
    /** Opcao de voltar para o menu inicial
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
    		e.printStackTrace();}}

}

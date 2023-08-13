package app.controller;

import java.io.IOException;

import app.Principal;
import app.Dao.SelecaoDaoImpl;
import app.Dao.TecnicoDaoImpl;
import app.model.Selecao;
import app.model.Tecnico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/** Classe controle responsavel pelos tecnicos
 * 
 * @author Weslei Silva Santos
 *
 */
public class CRUDTecnicoController {
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl();
	ObservableList<Tecnico> tecnicosData;
   
	@FXML
    private Button Editar;

    @FXML
    private Button Excluir; 

    @FXML
    private Label LabelError;

    @FXML
    private TableView<Tecnico> Tabela;

    @FXML
    private Button Voltar;

    @FXML
    private TextField nomeTecnico;

    @FXML
    void EditarAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	
		if(i>=0) {
	    	try {
	        	// Se o nome do tecnico for vazio
	    		if(this.nomeTecnico.getText().toUpperCase().strip()!="".strip()) {
		    		int id = tecnicoDao.ListTec().get(i).getId();
		        	String selecao = tecnicoDao.ListTec().get(i).getSelecao();
		        	int IdSelecao =tecnicoDao.ListTec().get(i).getIdSelecao();
		        	Tecnico novoTecnico = new Tecnico(id, this.nomeTecnico.getText().toUpperCase(), IdSelecao,selecao);
		    		tecnicoDao.UpdateTec(novoTecnico, id);
		    		this.tecnicosData.set(i, novoTecnico);
		    		this.LabelError.setText(" Técnico Atualizado ");
		    		this.nomeTecnico.clear();}
	        	else {
	        		this.LabelError.setText(" Dados inválidos ");}
	    
	    	}
	    	catch(Exception erro) {
	    		this.LabelError.setText(" Dados inválidos ");
	    	}
    	
    	
    }
    }
    /** Opcao de excluir arbitros
     * 
     * @param event
     */
    @FXML
    void ExcluirAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	if(i>=0) {
    		this.tecnicosData.remove(i);
    		int id = tecnicoDao.ListTec().get(i).getId();
    		 //Deletando do Dao
			tecnicoDao.DeleteTec(id);		
			//Deletando dentro da Selecao
			for (Selecao selecao : selecaoDao.ListSelecao()) {
				for(int z=0;z<selecao.getTecnico().size();z++) {
					if(selecao.getTecnico().get(0)==id) {
						selecao.getTecnico().remove(0);											
						}}}			
    		this.LabelError.setText(" Técnico Deletado ");
    	}
    }

    /** Opcao de voltar ao menu inicial
     * 
     * @param event
     */
    @FXML
    void VoltarAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/TelaPrincipal.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}
    

    // Inicializacao da tabela
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    void initialize() {

      	this.tecnicosData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn nomeCol = new TableColumn("     Nome     ");
    	TableColumn selecaoCol = new TableColumn("    Seleção    ");
    	
	    IDCol.setCellValueFactory(new PropertyValueFactory<Tecnico, Integer>("id"));
	    nomeCol.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("nome"));
	    selecaoCol.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("Selecao"));
	    
	    
	    
	    this.Tabela.getColumns().addAll(IDCol,nomeCol,selecaoCol);
     
      	tecnicosData.addAll(tecnicoDao.ListTec());
      	
      	this.Tabela.setItems(tecnicosData);
    }
}

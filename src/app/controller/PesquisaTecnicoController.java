package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.Principal;
import app.Dao.TecnicoDaoImpl;
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

public class PesquisaTecnicoController {
	TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl();
	private ObservableList<Tecnico> tecnicosData;
	private List<Tecnico> tecnicos = new ArrayList<>();
	
	
	
    @FXML
    private Label LabelError;

    @FXML
    private Button Pesquisar;

    @FXML
    private TableView<Tecnico> Tabela;

    @FXML
    private TextField nome;

    @FXML
    private Button voltar;

   
    
    /** Opcao de pesquisa
    * 
    * @param event
    */
    @FXML
    void PesquisarAction(ActionEvent event) {
    	tecnicosData.clear();
    	String nome =this.nome.getText().toUpperCase().strip();
    	//Se o nome nao for vazio
    	if(nome!=" ".strip()) {
    		for(Tecnico tecnico: tecnicoDao.SearchTec(nome)){
	    		this.tecnicos.add(tecnico);}
    		// Se a lista temporaria nao estiver vazia
    		if(tecnicos.size()!=0) {
    			tecnicos = tecnicoDao.SearchTec(nome);
		    	for(Tecnico tecnico: tecnicos){
		    		this.tecnicosData.add(tecnico);
		    		this.LabelError.setText("Pesquisa Realizada");
		    		this.nome.clear();}}
    		else{this.LabelError.setText("Técnico não encontrado");}}
    	else {
    		this.LabelError.setText("Dados inválidos");}
    }

    
    
    /** Opcao de voltar ao menu inicial
     * 
     * @param event
     */
    @FXML
    void voltarAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/MenuPesquisar.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}}
    
    
    
    
    /** Inicializacao da tabela
     * 
     */    
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
     
      	tecnicosData.addAll(tecnicos);
      	
      	this.Tabela.setItems(tecnicosData);
    }
    
    
}

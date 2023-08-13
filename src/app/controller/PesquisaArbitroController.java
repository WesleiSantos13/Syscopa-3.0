package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.Principal;
import app.Dao.ArbitroDaoImpl;
import app.model.Arbitro;
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
/** Classe controle responsavel por pesquisar arbitros
 * 
 * @author Weslei Silva Santos
 *
 */
public class PesquisaArbitroController {
	ArbitroDaoImpl arbitroDao = new ArbitroDaoImpl();
	ObservableList<Arbitro> arbitrosData;
	//Lista temporarea de arbitros pesquisados
	private List<Arbitro> arbitros = new ArrayList<>();
	
	
    @FXML
    private Label LabelError;

    @FXML
    private Button Pesquisar;

    @FXML
    private TableView<Arbitro> Tabela;

    @FXML
    private TextField nome;

    @FXML
    private Button voltar;

    
    /** Opcao de pesquisar 
     * 
     * @param event
     */
    @FXML
    void PesquisarAction(ActionEvent event) {
    	arbitrosData.clear();
    	String nome =this.nome.getText().toUpperCase().strip();
    	// Se o nome a ser pesquisado nao for vazio
    	if(nome!=" ".strip()) {
    		for(Arbitro arbitro: arbitroDao.SearchArb(nome)){
	    		this.arbitros.add(arbitro);}
    		// Se a lista nao estiver vazia 
    		if(arbitros.size()!=0) {
    			arbitros = arbitroDao.SearchArb(nome);
		    	for(Arbitro arbitro: arbitros){
		    		this.arbitrosData.add(arbitro);
		    		this.LabelError.setText("Pesquisa Realizada");
		    		this.nome.clear();}}
    		else{this.LabelError.setText("Arbitro não encontrado");}}
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

      	this.arbitrosData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn nomeCol = new TableColumn("     Nome     ");

    	
	    IDCol.setCellValueFactory(new PropertyValueFactory<Arbitro, Integer>("id"));
	    nomeCol.setCellValueFactory(new PropertyValueFactory<Arbitro, String>("nome"));
	    
	    this.Tabela.getColumns().addAll(IDCol,nomeCol);
     
	    arbitrosData.addAll(arbitros);
      	
      	this.Tabela.setItems(arbitrosData);
    }
    
    
}

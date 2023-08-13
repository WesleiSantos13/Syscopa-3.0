package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.Principal;
import app.Dao.SelecaoDaoImpl;
import app.model.Selecao;
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

public class PesquisaSelecaoController {
	ObservableList<Selecao> selecoesData;
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	// Lista temporaria
	private List<Selecao> selecoes = new ArrayList<>();
	
	
	
    @FXML
    private Label LabelError;

    @FXML
    private Button Pesquisar;

    @FXML
    private TableView<Selecao> Tabela;

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
    	selecoesData.clear();
    	String nome =this.nome.getText().toUpperCase().strip();    	
    	if(nome!=" ".strip()) {
    		for(Selecao selecao: selecaoDao.SearchSelec(nome)){
	    		this.selecoes.add(selecao);}
    		if(selecoes.size()!=0) {
    			selecoes = selecaoDao.SearchSelec(nome);
		    	for(Selecao selecao: selecoes){
		    		this.selecoesData.add(selecao);
		    		this.LabelError.setText("Pesquisa Realizada");
		    		this.nome.clear();}}
    		else{this.LabelError.setText("Seleção não encontrada");}}
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
    void initialize() {

          	
      	this.selecoesData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn nomeCol = new TableColumn("         Nome       ");
      	TableColumn pontCol = new TableColumn("Pontuação");
      	TableColumn saldoCol = new TableColumn("Saldo de Gols");
      	TableColumn CartoesCol = new TableColumn("Total de Cartões");
   
	    IDCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("id"));
	    nomeCol.setCellValueFactory(new PropertyValueFactory<Selecao, String>("nome"));
	    pontCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("pontuacao"));
	    saldoCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("saldoGols"));
	    CartoesCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("totalCartoes"));
	    
	    this.Tabela.getColumns().addAll(IDCol,nomeCol,pontCol,saldoCol, CartoesCol);
     
      	selecoesData.addAll(selecoes);
      	
      	this.Tabela.setItems(selecoesData);
    }
}

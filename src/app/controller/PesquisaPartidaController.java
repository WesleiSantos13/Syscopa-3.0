package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.Principal;
import app.Dao.FaseGruposDaoImpl;
import app.Dao.FinalDaoImpl;
import app.Dao.OitavasDeFinalDaoImpl;
import app.Dao.QuartasDeFinalDaoImpl;
import app.Dao.SemifinaisDaoImpl;
import app.Dao.TerceiroLugarDaoImpl;
import app.model.Partida;
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

public class PesquisaPartidaController {
	FaseGruposDaoImpl faseGruposDao = new FaseGruposDaoImpl();
	OitavasDeFinalDaoImpl oitavasDao = new OitavasDeFinalDaoImpl();
	QuartasDeFinalDaoImpl quartasDao = new QuartasDeFinalDaoImpl();
	SemifinaisDaoImpl semiDao = new SemifinaisDaoImpl();
	FinalDaoImpl finalDao = new FinalDaoImpl();
	TerceiroLugarDaoImpl terceiroDao = new TerceiroLugarDaoImpl();	
	private ObservableList<Partida> partidasData;
	//Lista temporaria
	private List<Partida> partidas = new ArrayList<>();
	
    @FXML
    private Label LabelError;

    @FXML
    private Button Pesquisar;

    @FXML
    private TableView<Partida> Tabela;

    @FXML
    private TextField data;

    @FXML
    private Button voltar;

    
   
    /** Opcao de pesquisa
     * 
     * @param event
     */
    @FXML
    void PesquisarAction(ActionEvent event) {
    	partidasData.clear();
    	partidas.clear();
    	String data =this.data.getText().toUpperCase().strip();
    	//Se o nome nao for vazio
    	if(data!=" ".strip()) {
    		//Adicionando todas as partidas na lista temporaria
    		for(Partida partida: faseGruposDao.SearchPart(data)){
	    		this.partidas.add(partida);}
    		for(Partida partida: oitavasDao.SearchOitavFinal(data)){
	    		this.partidas.add(partida);}
    		for(Partida partida: quartasDao.SearchPart(data)){
	    		this.partidas.add(partida);}
    		for(Partida partida: semiDao.SearchPart(data)){
	    		this.partidas.add(partida);}
    		for(Partida partida: finalDao.SearchPart(data)){
	    		this.partidas.add(partida);}
    		for(Partida partida: terceiroDao.SearchPart(data)){
	    		this.partidas.add(partida);}
    		// Se a lista temporaria nao estiver vazia
    		if(partidas.size()!=0) {
		    	//partidas = faseGruposDao.SearchPart(data);
    			for(Partida partida: partidas){
		    		this.partidasData.add(partida);}
		    		this.LabelError.setText("Pesquisa Realizada");
		    		this.data.clear();}
    		else{this.LabelError.setText("Partida não encontrada");}}
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

      	this.partidasData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn dataCol = new TableColumn("Data");
      	TableColumn localCol = new TableColumn("Local");
      	TableColumn horarioCol = new TableColumn("Horário");
      	TableColumn nomeSelecao1Col = new TableColumn("Seleção 1");
      	TableColumn golsSelecao1Col = new TableColumn("GS1");
       	TableColumn golsSelecao2Col = new TableColumn("GS2");
      	TableColumn nomeSelecao2Col = new TableColumn("Seleção 2");
      	TableColumn nomeArbitroCol = new TableColumn("Arbitro");
      	TableColumn C_VermelhosCol = new TableColumn("Cartões V.S1");
      	TableColumn C_AmarelosCol = new TableColumn("Cartões A.S1");
      	TableColumn C_VermelhosCol2 = new TableColumn("Cartões. V.S2");
      	TableColumn C_AmarelosCol2 = new TableColumn("Cartões. A.S2");
      	
      	
	    IDCol.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("id"));
	    dataCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("data"));
	    localCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("local"));
	    horarioCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("horario"));
	    nomeSelecao1Col.setCellValueFactory(new PropertyValueFactory<Partida, String>("nomeSelecao1"));
	    golsSelecao1Col.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("golsSelecao1"));
	    golsSelecao2Col.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("golsSelecao2"));
	    nomeSelecao2Col.setCellValueFactory(new PropertyValueFactory<Partida, String>("nomeSelecao2"));
	    nomeArbitroCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("nomeArb"));
	    C_VermelhosCol.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("cartaoVe"));
	    C_AmarelosCol.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("cartaoA"));
	    C_VermelhosCol2.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("cartaoVe2"));
	    C_AmarelosCol2.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("cartaoA2"));
      	
	    this.Tabela.getColumns().addAll(IDCol,dataCol,localCol,horarioCol,nomeSelecao1Col,golsSelecao1Col,golsSelecao2Col,nomeSelecao2Col,nomeArbitroCol,C_VermelhosCol, C_AmarelosCol, C_VermelhosCol2, C_AmarelosCol2);
     
	    partidasData.addAll(partidas);
      	
	    this.Tabela.setItems(partidasData);
    }    
    
    
}

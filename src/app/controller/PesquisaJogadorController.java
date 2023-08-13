package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.Principal;
import app.Dao.JogadorDaoImpl;
import app.model.Jogador;
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
/** Classe controle responsavel por pesquisar jogadores
 * 
 * @author Weslei Silva Santos
 *
 */
public class PesquisaJogadorController {
	JogadorDaoImpl jogadorDao = new JogadorDaoImpl();
	private ObservableList<Jogador> jogadoresData;
	private List<Jogador> jogadores = new ArrayList<>();
	
	@FXML
	private Label LabelError;
	
    @FXML
    private Button Pesquisar;

    @FXML
    private TableView<Jogador> Tabela;

    @FXML
    private TextField nomeJogador;

    @FXML
    private Button voltar;

    
    /** Opcao de pesquisa
     * 
     * @param event
     */
    @FXML
    void PesquisarAction(ActionEvent event) {
    	jogadoresData.clear();
    	String nome =this.nomeJogador.getText().toUpperCase().strip();
    	//Se o nome nao for vazio
    	if(nome!=" ".strip()) {
    		for(Jogador jogador: jogadorDao.SearchJog(nome)){
	    		this.jogadores.add(jogador);}
    		// Se a lista temporaria nao estiver vazia
    		if(jogadores.size()!=0) {
	    		jogadores = jogadorDao.SearchJog(nome);
		    	for(Jogador jogador: jogadores){
		    		this.jogadoresData.add(jogador);
		    		this.LabelError.setText("Pesquisa Realizada");
		    		this.nomeJogador.clear();}}
    		else{this.LabelError.setText("Jogador não encontrado");}}
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

      	this.jogadoresData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn nomeCol = new TableColumn("     Nome     ");
    	TableColumn PosicaoCol = new TableColumn("    Posição   ");
    	TableColumn cartVeCol = new TableColumn("C. Vermelhos");
    	TableColumn cartACol = new TableColumn("C. Amarelos");
    	TableColumn golsCol = new TableColumn("Gols");
    	
	    IDCol.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("codJog"));
	    nomeCol.setCellValueFactory(new PropertyValueFactory<Jogador, String>("nome"));
	    PosicaoCol.setCellValueFactory(new PropertyValueFactory<Jogador, String>("posicao"));
	    cartVeCol.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("cartVe"));
	    cartACol.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("cartA"));
	    golsCol.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("gols"));
	    
	    
	    this.Tabela.getColumns().addAll(IDCol,nomeCol,PosicaoCol, cartVeCol, cartACol, golsCol);
     
	
	    
      	jogadoresData.addAll(jogadores);
      	
      	this.Tabela.setItems(jogadoresData);
    }
    
    
    
    
}

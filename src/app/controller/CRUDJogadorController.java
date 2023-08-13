package app.controller;

import java.io.IOException; 
import app.Dao.SelecaoDaoImpl;
import app.Principal;
import app.Dao.JogadorDaoImpl;
import app.model.Jogador;
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

/** Classe controle responsavel pelas jogadores
* 
* @author Weslei Silva Santos
*
*/
public class CRUDJogadorController {
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	JogadorDaoImpl jogadorDao = new JogadorDaoImpl();
	private ObservableList<Jogador> jogadores;
	
	
    @FXML
    private Button Editar;

    @FXML
    private Button Excluir;

    @FXML
    private Label LabelError;

    @FXML
    private TextField PosicaoJogador;

    @FXML
    private TableView<Jogador> Tabela;

    @FXML
    private Button Voltar;

    @FXML
    private TextField nomeJogador;

    @FXML
    private TextField cartoesAmarelos;

    @FXML
    private TextField cartoesVermelhos;

    @FXML
    private TextField gols;

    
    
    
    @FXML
    void EditarAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	
		if(i>=0) {
	    	try {
	    	
	        	int id = jogadorDao.ListarJog().get(i).getCodJog();
	        	int IdSelecao =jogadorDao.ListarJog().get(i).getIdSelecao();
	        	Jogador novoJogador = new Jogador(id, this.nomeJogador.getText().toUpperCase(), this.PosicaoJogador.getText().toUpperCase(), Integer.parseInt(this.cartoesVermelhos.getText()), Integer.parseInt(this.cartoesAmarelos.getText()), Integer.parseInt(this.gols.getText()), IdSelecao);
	    		jogadorDao.UpdateJog(novoJogador, id);	    		
	    		this.jogadores.set(i, novoJogador);
	    		this.LabelError.setText(" Jogador Atualizado ");
	    		clear();
	    		
	    	}
	    	catch(Exception erro) {
	    		this.LabelError.setText(" Dados inválidos ");
	    	}
    	
    	
   }
    }

    @FXML
    void ExcluirAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	if(i>=0) {
    		this.jogadores.remove(i);
    		int id = jogadorDao.ListarJog().get(i).getCodJog();
    		//Deletando o id do jogador dentro da Selecao
			for (Selecao selecao : selecaoDao.ListSelecao()) {
				for(int z=0;z<selecao.getTime().size();z++) {
					if(selecao.getTime().get(z)==id) {
						selecao.getTime().remove(z);											
						}}}
    		jogadorDao.DeleteJog(id);
    		this.LabelError.setText(" Jogador Deletado ");
    	}
    }

    @FXML
    void VoltarAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/TelaPrincipal.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}
    
    
  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
    void initialize() {

      	this.jogadores=FXCollections.observableArrayList();
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
     
      	jogadores.addAll(jogadorDao.ListarJog());
      	
      	this.Tabela.setItems(jogadores);
    }
    
    void clear() {
    	this.nomeJogador.clear();
		this.PosicaoJogador.clear();
		this.gols.clear();
		this.cartoesAmarelos.clear();
		this.cartoesVermelhos.clear();
    }
}

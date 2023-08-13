package app.controller;

import java.io.IOException; 

import app.Principal;
import app.Dao.ArbitroDaoImpl;
import app.Dao.FaseGruposDaoImpl;
import app.model.Arbitro;
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
/** Classe controle responsavel pelo arbitro
* 
* @author Weslei Silva Santos
*
*/
public class CRUDArbitroController {
	ArbitroDaoImpl arbitroDao = new ArbitroDaoImpl();
	FaseGruposDaoImpl faseGruposDao = new FaseGruposDaoImpl();
	ObservableList<Arbitro> arbitrosData;
    @FXML
    private Button Editar;

    @FXML
    private Button Excluir;

    @FXML
    private Label LabelError;

    @FXML
    private Label LabelError1;

    @FXML
    private TableView<Arbitro> Tabela;

    @FXML
    private Button Voltar;

    @FXML
    private TextField nome;

    @FXML
    void EditarAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
		if(i>=0) {
	    	try {
	    		//Se o nome nao for vazio
	    		if(this.nome.getText().toUpperCase().strip()!="".strip()) {
		        	int id = arbitroDao.ListArb().get(i).getId();
		       	
		        	Arbitro arbitro = new Arbitro(id, this.nome.getText().toUpperCase(),arbitroDao.ListArb().get(i).getIdPartida() );
		    		this.arbitrosData.set(i, arbitro);
		    		this.LabelError.setText(" Arbitro Atualizado ");
		    		// Atualiza no Dao
					arbitroDao.UpdateArb(arbitro, id);
					//Atualiza na partida
					for(Partida partida: faseGruposDao.ListPart()) {
						if(partida.getArbitro()==id) {
							partida.setNomeArb(nome.getText().toUpperCase());
						}
						this.nome.clear();
		    	}}
	    		else{this.LabelError.setText(" Dados inválidos ");
	    			
	    		}}
	    	catch(Exception erro) {
	    		this.LabelError.setText(" Dados inválidos "); 
	    	}
    	
    	
    }
    }

    @FXML
    void ExcluirAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	if(i>=0) {
    		this.arbitrosData.remove(i);
    		int id = arbitroDao.ListArb().get(i).getId();
    		// Deleta do Dao
    		arbitroDao.DeleteArb(id);
    		// Tira da partida
    		for(Partida partida: faseGruposDao.ListPart()) {
    			if(partida.getArbitro()==id) {
    				partida.setNomeArb("não definido");
    				partida.setArbitro(0);
    						}}    	}
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

      	this.arbitrosData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn nomeCol = new TableColumn("     Nome     ");

    	
	    IDCol.setCellValueFactory(new PropertyValueFactory<Arbitro, Integer>("id"));
	    nomeCol.setCellValueFactory(new PropertyValueFactory<Arbitro, String>("nome"));
	    
	    this.Tabela.getColumns().addAll(IDCol,nomeCol);
     
	    arbitrosData.addAll(arbitroDao.ListArb());
      	
      	this.Tabela.setItems(arbitrosData);
    }

}

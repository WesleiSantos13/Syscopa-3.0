package app.controller;

import java.io.IOException; 
import java.util.ArrayList;


import app.Dao.TecnicoDaoImpl;
import app.Dao.FaseGruposDaoImpl;

import app.Dao.JogadorDaoImpl;
import app.Principal;
import app.Dao.SelecaoDaoImpl;
import app.model.Funcoes;

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

/** Classe controle responsavel por editar, listar e excluir selecoes
 * 
 * @author Weslei Silva Santos
 *
 */
public class EditarSelecaoController {

	
	@FXML
	private Button Excluir;

	 
    @FXML
    private Button Editar;

    @FXML
    private Label LabelError;
   
    @FXML
    private Label LabelError1;
   
    @FXML
    private TableView<Selecao> Tabela;

    @FXML
    private Button Voltar;

    @FXML
    private TextField nomeSelecao;

    JogadorDaoImpl jogadorDao = new JogadorDaoImpl();
    SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
    TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl();
    FaseGruposDaoImpl faseGruposDao = new  FaseGruposDaoImpl();
	
    ObservableList<Selecao> selecoes;
   
    /** Inicializaçao de tabela
     * 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    void initialize() {

          	
      	this.selecoes=FXCollections.observableArrayList();
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
     
      	selecoes.addAll(selecaoDao.ListSelecao());
      	
      	this.Tabela.setItems(selecoes);
    }
    
    /** Opcao de editar selecao
     * 
     * @param event
     */
    @FXML
    void EditarAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	
		if(i>=0) {
			if(selecaoDao.ListSelecao().get(i).getIdGrupo()==0) { 
			try {
				//Se o nome nao for vazio
				if(this.nomeSelecao.getText().toUpperCase().strip()!="".strip()) {
					int id = selecaoDao.ListSelecao().get(i).getId();
					ArrayList<Integer> tecnico= selecaoDao.ListSelecao().get(i).getTecnico();
		    		ArrayList<Integer> time = selecaoDao.ListSelecao().get(i).getTime();
		        	int pontuacao =  selecaoDao.ListSelecao().get(i).getPontuacao();
		        	int saldoGols = selecaoDao.ListSelecao().get(i).getSaldoGols();
		    		Selecao novaSelecao = new Selecao(id, this.nomeSelecao.getText().toUpperCase(), time, tecnico, selecaoDao.ListSelecao().get(i).getIdGrupo(), pontuacao, saldoGols, selecaoDao.ListSelecao().get(i).getTotalCartoes());
		    		
		    		//Atualizando o nome da selecao dentro do tecnico
		    		if(tecnico.size()>0) {
		    			int index=Funcoes.BuscaPosicaoTec(tecnicoDao.ListTec(), id);
		    			Tecnico novoTecnico = new Tecnico(id, tecnicoDao.ListTec().get(index).getNome(), id,this.nomeSelecao.getText().toUpperCase() );
		    			tecnicoDao.UpdateTec(novoTecnico, id);
		    		}
		    		selecaoDao.UpdateSelecao(novaSelecao, id);
		    		this.selecoes.set(i, novaSelecao);
		    		this.LabelError.setText(" Selecão Atualizada ");
		    		this.nomeSelecao.clear();}
				else {
					this.LabelError.setText(" Dados inválidos ");
				}
	    	}
	    	catch(Exception erro) {
	    		this.LabelError.setText(" Dados inválidos ");
	    	}}
			else {
				this.LabelError.setText(" Impossível editar, pois");
				this.LabelError1.setText("a selecão tem grupo definido");}
    }
			}
    
    /** Opcao de voltar ao menu inicial
     * 
     * @param event
     */
    @FXML
    void VoltarAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDSelecao.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}
    

    /** Opcao de excluir
     * 
     * @param event
     */
    @FXML
    void ExcluirAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	if(i>=0) {
    		int id = selecaoDao.ListSelecao().get(i).getId();
    		Selecao selecao =selecaoDao.ListSelecao().get(i);
    		// Se a selecao estiver sem grupo
    		if(selecao.getIdGrupo()==0) {
    		
    			//Remove jogadores do Dao que estão na selecao
				for(int z=0;z<selecao.getTime().size();z++) {
					jogadorDao.DeleteJog(selecao.getTime().get(z));}
				//Remove tecnico do Dao que esta na selecao
				tecnicoDao.DeleteTec(id);
				selecaoDao.DeleteSelecao(id);
				this.LabelError.setText(" Selecão Deletada ");
				this.selecoes.remove(i);
				}
    		else {
    			this.LabelError.setText("Impossível deletar, pois");
    			this.LabelError1.setText("a selecão tem grupo definido");}
    		}
    	}
  







}
    
    
    


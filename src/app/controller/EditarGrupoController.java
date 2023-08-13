package app.controller;

import java.io.IOException;  
import java.util.ArrayList ;

import app.Principal;
import app.Dao.FaseGruposDaoImpl;
import app.Dao.GrupoDaoImpl;
import app.Dao.SelecaoDaoImpl;
import app.model.Grupo;
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
import app.model.Funcoes;

/** Classe controle responsavel por editar, listar e excluir grupos
 * 
 * @author Weslei Silva Santos
 *
 */
public class EditarGrupoController {
	GrupoDaoImpl grupoDao = new GrupoDaoImpl();
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	FaseGruposDaoImpl faseGruposDao = new FaseGruposDaoImpl();
	
	ObservableList<Grupo> GruposData;
    @FXML
    private Button Editar;

    @FXML
    private Button Excluir;

    @FXML
    private Label LabelError;

    @FXML
    private TableView<Grupo> Tabela;

    @FXML
    private Button Voltar;

    @FXML
    private TextField nomeGrupo;

    @FXML
    void EditarAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
		if(i>=0) {
	    	try {
	    		int id = grupoDao.ListGrup().get(i).getId();
	    		String Selecao1 = grupoDao.ListGrup().get(i).getSelecao1();
	    		String Selecao2 = grupoDao.ListGrup().get(i).getSelecao2();
	    		String Selecao3 = grupoDao.ListGrup().get(i).getSelecao3();
	    		String Selecao4 = grupoDao.ListGrup().get(i).getSelecao4();
	    		ArrayList<Integer> ids = grupoDao.ListGrup().get(i).getSelecoes();
	    		Grupo novoGrupo = new Grupo(id, this.nomeGrupo.getText().toUpperCase(), ids, Selecao1, Selecao2, Selecao3, Selecao4);
	    		grupoDao.UpdateGrup(novoGrupo, id);
	    		this.GruposData.set(i, novoGrupo);
	    		this.LabelError.setText(" Grupo Atualizado ");
	    		this.nomeGrupo.clear();
	    	}
	    	catch(Exception erro) {
	    		this.LabelError.setText(" Dados inválidos ");
	    	}
    }}

    
    
    
    @FXML
    void ExcluirAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	if(i>=0) {
    		int id = grupoDao.ListGrup().get(i).getId();
    		//Verificar se o grupo nao tem partidas marcadas
			Boolean verificarPartida= Funcoes.verificarGrupoPartida(id, faseGruposDao.ListPart());
			if(!verificarPartida){
	    		this.GruposData.remove(i);
	    		Grupo grupo = grupoDao.ListGrup().get(i);
	    		//Busca todos os ids de selecoes dentro dos grupos
				  for(int j =0; j<grupo.getSelecoes().size();j++) {
					 int idSelecao=grupo.getSelecoes().get(j);
					 // Busca as selecoes para comparar
					 for (int k =0; k<selecaoDao.ListSelecao().size();k++) {
						 Selecao selecao = selecaoDao.ListSelecao().get(k);						
						 if(idSelecao ==selecao.getId()) {
							 //Zera o id do grupo dentro da selecao e a pontuacao
							 Selecao novaSelecao = new Selecao(idSelecao, selecao.getNome(), selecao.getTime(), selecao.getTecnico(), 0,selecao.getPontuacao(), selecao.getSaldoGols(), selecao.getTotalCartoes());
							 // Atualiza no Dao
							 selecaoDao.UpdateSelecao(novaSelecao, idSelecao);}}}   
	    		grupoDao.DeleteGrup(id);
	       		this.LabelError.setText(" Grupo Deletado ");
	       		}
			else {
				this.LabelError.setText("Impossível deletar, pois as partidas do grupo foram criadas ");
			}
			}
    }

    
    /** Opcao de voltar ao menu inicial
     * 
     * @param event
     */
    @FXML
    void VoltarAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDGrupo.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}



    
    /** Inicializacao de tabela
     * 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
    void initialize() {

      	this.GruposData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn letraCol = new TableColumn("  Grupo ");
    	TableColumn selecao1Col = new TableColumn("  Seleção 1  ");
    	TableColumn selecao2Col = new TableColumn("  Seleção 2  ");
    	TableColumn selecao3Col = new TableColumn("  Seleção 3  ");
    	TableColumn selecao4Col = new TableColumn("  Seleção 4  ");
    	
	    IDCol.setCellValueFactory(new PropertyValueFactory<Grupo, Integer>("id"));
	    letraCol.setCellValueFactory(new PropertyValueFactory<Grupo, String>("letraGrupo"));
	    selecao1Col.setCellValueFactory(new PropertyValueFactory<Grupo, String>("selecao1"));
	    selecao2Col.setCellValueFactory(new PropertyValueFactory<Grupo, String>("selecao2"));
	    selecao3Col.setCellValueFactory(new PropertyValueFactory<Grupo, String>("selecao3"));
	    selecao4Col.setCellValueFactory(new PropertyValueFactory<Grupo, String>("selecao4"));
	    
	    
	    this.Tabela.getColumns().addAll(IDCol, letraCol,selecao1Col, selecao2Col,selecao3Col, selecao4Col);
     
      	GruposData.addAll(grupoDao.ListGrup());
      	
      	this.Tabela.setItems(GruposData);
    }



}

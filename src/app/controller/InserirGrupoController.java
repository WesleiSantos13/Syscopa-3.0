package app.controller;

import java.io.IOException; 
import java.util.ArrayList;

import app.Principal;
import app.Dao.GrupoDaoImpl;
import app.Dao.SelecaoDaoImpl;
import app.model.Funcoes;
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
/** Classe controle responsavel por inserir grupos
 * 
 * @author Weslei Silva Santos
 *
 */
public class InserirGrupoController {
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	private ObservableList<Selecao> selecoesData;
	GrupoDaoImpl grupoDao = new GrupoDaoImpl();
	private ArrayList<Selecao> SelecoesSemGrupo = new ArrayList<>();
	
	
    @FXML
    private Label LabelError;

    @FXML
    private TextField Letra;

    @FXML
    private Button Registrar;

    @FXML
    private TableView<Selecao> Tabela;

    @FXML
    private Button Voltar;

    @FXML
    private TextField id1;

    @FXML
    private TextField id2;

    @FXML
    private TextField id3;

    @FXML
    private TextField id4;

    /** Inicializacao da tabela
     * 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    void initialize() {
    	atualizarTabela();
      	this.selecoesData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn nomeCol = new TableColumn("    Nome     ");
      	TableColumn pontCol = new TableColumn("Pontuação");
      	TableColumn saldoCol = new TableColumn("Saldo de Gols");
   
	    IDCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("id"));
	    nomeCol.setCellValueFactory(new PropertyValueFactory<Selecao, String>("nome"));
	    pontCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("pontuacao"));
	    saldoCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("saldoGols"));
      	
	    this.Tabela.getColumns().addAll(IDCol,nomeCol,pontCol,saldoCol);
     
      	selecoesData.addAll(SelecoesSemGrupo);
      	
      	this.Tabela.setItems(selecoesData);
    }
    
    //Opcao de registro de grupo
    @FXML
    void RegistrarAction(ActionEvent event) {  	
    	// O cadastro so pode ser realizado se existir 32 selecoes na lista
    	if(selecaoDao.ListSelecao().size()==32) {
	    	// E se nao existir 8 grupos formados
	    	if(grupoDao.ListGrup().size()<8) {
	    		try {
	    			ArrayList<Integer> selecoes= new ArrayList<>();
			    	selecoes.add(Integer.parseInt(this.id1.getText()));
			    	selecoes.add(Integer.parseInt(this.id2.getText()));
			    	selecoes.add(Integer.parseInt(this.id3.getText()));
			    	selecoes.add(Integer.parseInt(this.id4.getText()));
			    	int idGrupo = grupoDao.getUltimoid();
			    	int index1 = Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),Integer.parseInt(this.id1.getText()));
			    	int index2 = Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),Integer.parseInt(this.id2.getText()));
			    	int index3 = Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),Integer.parseInt(this.id3.getText()));
			    	int index4 = Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),Integer.parseInt(this.id4.getText()));
			    	// Se as selecoes selecionadas estiverem sem grupo
			    	if(selecaoDao.ListSelecao().get(index1).getIdGrupo()==0 &&
		    		   selecaoDao.ListSelecao().get(index2).getIdGrupo()==0 &&
		    		   selecaoDao.ListSelecao().get(index3).getIdGrupo()==0 &&
		    		   selecaoDao.ListSelecao().get(index4).getIdGrupo()==0 ) {	
			    		// Se os ids digitados forem iguais
			    		if(Integer.parseInt(this.id1.getText())!=Integer.parseInt(this.id2.getText()) & Integer.parseInt(this.id1.getText())!=Integer.parseInt(this.id2.getText()) &
			    		   Integer.parseInt(this.id1.getText())!=Integer.parseInt(this.id3.getText()) & Integer.parseInt(this.id1.getText())!=Integer.parseInt(this.id4.getText()) &
			    		   Integer.parseInt(this.id2.getText())!=Integer.parseInt(this.id3.getText()) & Integer.parseInt(this.id1.getText())!=Integer.parseInt(this.id4.getText()) &
			    		   Integer.parseInt(this.id3.getText())!=Integer.parseInt(this.id4.getText())) {
			    
					    	selecaoDao.ListSelecao().get(index1).setIdGrupo(idGrupo);
					    	selecaoDao.ListSelecao().get(index2).setIdGrupo(idGrupo);
					    	selecaoDao.ListSelecao().get(index3).setIdGrupo(idGrupo);
					    	selecaoDao.ListSelecao().get(index4).setIdGrupo(idGrupo);
					    	
					    	Grupo grupo = new Grupo(idGrupo, this.Letra.getText().toUpperCase(), selecoes, selecaoDao.ListSelecao().get(index1).getNome()
					    			, selecaoDao.ListSelecao().get(index2).getNome(),selecaoDao.ListSelecao().get(index3).getNome(), 
					    			selecaoDao.ListSelecao().get(index4).getNome());
					    	grupoDao.CreateGrup(grupo);
					    	clear();
					    	atualizarTabela();
					    	this.selecoesData=FXCollections.observableArrayList();
					    	selecoesData.addAll(SelecoesSemGrupo);
					    	this.Tabela.setItems(selecoesData);
					    	
					    	this.LabelError.setText("Grupo cadastrado");	
			    	}
			    		else {this.LabelError.setText("Os ids são iguais");}}			    	
			    	else{
			    		this.LabelError.setText("Uma das seleções já possui grupo");
			    	}}
		    	
		    	catch(Exception erro) {
		    		this.LabelError.setText(" Dados inválidos ");
		    	}}
	    	else {
	    		this.LabelError.setText("Limite de grupos alcançado");}
	    	}
    	else {
    		this.LabelError.setText("É necessário ter 32 seleções cadastradas");
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
			e.printStackTrace();
		}
    }
    
    void clear() {
    	this.Letra.clear();
    	this.id1.clear();
    	this.id2.clear();
    	this.id3.clear();
    	this.id4.clear();
    }

    void atualizarTabela() {
    	SelecoesSemGrupo.clear();
    	for(Selecao  selecao : selecaoDao.ListSelecao() ){
    		if(selecao.getIdGrupo()==0) {
    			SelecoesSemGrupo.add(selecao);
    		}
    }}
    
}

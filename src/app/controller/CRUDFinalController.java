package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import app.Principal;
import app.Dao.ArbitroDaoImpl;
import app.Dao.FinalDaoImpl;
import app.Dao.SelecaoDaoImpl;
import app.Dao.SemifinaisDaoImpl;
import app.model.Arbitro;
import app.model.Funcoes;
import app.model.Partida;
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
/** Classe controle responsavel pela final da copa
* 
* @author Weslei Silva Santos
*
*/
public class CRUDFinalController {
	// Lista de exibicao na tabela
	private ObservableList<Partida> partidas;
	SemifinaisDaoImpl semiDao = new SemifinaisDaoImpl();
	FinalDaoImpl finalDao = new FinalDaoImpl();
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	ArbitroDaoImpl arbitroDao = new ArbitroDaoImpl();
	
	// Lista responsavel por guardar os ids das partidas de empate
	private static ArrayList<Partida> empates= new ArrayList<Partida>(); 
	
	
    @FXML
    private Button Criar;

    @FXML
    private Button Editar;

    @FXML
    private Button Excluir;

    @FXML
    private Label LabelError;

    @FXML
    private Label LabelError1;

    @FXML
    private TableView<Partida> Tabela;

    @FXML
    private Button Voltar;

    @FXML
    private TextField cAmarelos1;

    @FXML
    private TextField cAmarelos2;

    @FXML
    private TextField cVermelhos1;

    @FXML
    private TextField cVermelhos2;

    @FXML
    private TextField data;

    @FXML
    private TextField golsSelecao1;

    @FXML
    private TextField golsSelecao2;

    @FXML
    private TextField horario;

    @FXML
    private TextField local;

    @FXML
    private TextField nomeArbitro;

    /** Opcao de criar partidas
     * 
     * @param event
     */
    @FXML
    void CriarAction(ActionEvent event) {
    	// verificar se todas as partidas das quartas ja foram realizadas
    	Boolean verificar = Funcoes.verificarEstadoPart(semiDao.ListPart());
    	ArrayList<Selecao> carregarSelecao = selecaoDao.ListSelecao();
    	ArrayList<Integer> IdsVencedoras = new ArrayList<Integer>();
    	//Se as partidas da semifinal ja foram criadas e editadas
    	if(semiDao.ListPart().size()==2 && verificar) {
    		// Se a lista da final estiver vazia 
    		if(finalDao.ListPart().size()==0) {
	    		int idVencedora = 0;
				for(Partida partida: semiDao.ListPart()){
		    		// Verificando as selecoes vencedoras
					if(partida.getGolsSelecao1()>partida.getGolsSelecao2()){
		    			idVencedora = partida.getSelecao1();}
		    		if(partida.getGolsSelecao1()<partida.getGolsSelecao2()) {
		    			idVencedora = partida.getSelecao2();}
		    		// Adicionando o id das selecoes vencedoras em uma lista
		    		IdsVencedoras.add(idVencedora);}
				//Fazendo as partidas com base no chaveamento da copa
		    	int idSelecao1 = IdsVencedoras.get(0); 
		    	int idSelecao2 = IdsVencedoras.get(1);
	    		Partida partida = new Partida(finalDao.getUltimoid(), "não definido", "não definido", "não definido ",carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getId(), carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getId(), 0,0, 0, "não definido",0,0,0,0, 0, false);	
			    finalDao.CreatePart(partida);
			    this.partidas.add(partida);}
    		else{this.LabelError.setText("A final já foi criada");}}	
    	else{
    		this.LabelError.setText("É necessário realizar as semifinais para criar a final");}}
    
    
    
    
    
    /** Opcao de editar partida
     * 
     * @param event
     */
    @FXML
    void EditarAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	//Se a linha da tabela selecionada existir
    	if(i>=0) {
    		try {
    			// Se o nome do arbitro e data da partida nao for vazio 
    			if(this.data.getText().toUpperCase().strip()!="".strip() & this.nomeArbitro.getText().toUpperCase().strip()!="".strip()) {
	    			Partida partida = finalDao.ListPart().get(i);
			    	int golsSelecao1 = Integer.parseInt(this.golsSelecao1.getText());
			    	int golsSelecao2 = Integer.parseInt(this.golsSelecao2.getText());
	
					Partida NovaPartida = new Partida(partida.getId(), this.data.getText(), this.horario.getText(), this.local.getText(),partida.getNomeSelecao1(), partida.getNomeSelecao2(), partida.getSelecao1(), 
							partida.getSelecao2(),arbitroDao.getUltimoid(), golsSelecao1, golsSelecao2,this.nomeArbitro.getText().toUpperCase(), Integer.parseInt(this.cVermelhos1.getText()), Integer.parseInt(this.cAmarelos1.getText()),  Integer.parseInt(this.cVermelhos2.getText()), Integer.parseInt(this.cAmarelos2.getText()), partida.getIdGrupo(), true);
	
					Arbitro Arbitro = new Arbitro(arbitroDao.getUltimoid(), this.nomeArbitro.getText().toUpperCase(), semiDao.getUltimoid());
					// Cria o arbitro no Dao
					arbitroDao.Create(Arbitro);		
					// Atualiza partida no Dao
					finalDao.UpdatePart(NovaPartida, partida.getId());
					this.partidas.set(i, partida);
					clear();
					// Se os gols forem iguais, ira para os penaltis
					if(golsSelecao1== golsSelecao2) {
						empates.add(NovaPartida);
						try {	
			        		Parent root = FXMLLoader.load(getClass().getResource("/app/view/PenaltisFinal.fxml"));
			        		Scene cena = new Scene(root);
			        		Principal.setScene(cena);
			        	} catch (IOException e) {
			        		e.printStackTrace();}
			    	}
					this.LabelError.setText(" Partida editada ");}
    			else{
    				this.LabelError.setText(" Dados inválidos ");
    			}}
    		catch(Exception erro) {
	    		this.LabelError.setText(" Dados inválidos ");}
    	}
    }

    
    
    /** Opcao de excluir partidas
     * 
     * @param event
     */    
    @FXML
    void ExcluirAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	//Se a linha da tabela selecionada existir
    	if(i>=0) {
    		this.partidas.remove(i);
    		int id = finalDao.ListPart().get(i).getId();
    		finalDao.DeletePart(id);
    		this.LabelError.setText("Partida Deletada");}}

    
    
    /** Opcao de voltar ao menu inicial
     * 
     * @param event
     */
    @FXML
    void VoltarAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/TelaPrincipal.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}

  
    
    
    /** Inicializacao da tabela
     * 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
    void initialize() {

      	this.partidas=FXCollections.observableArrayList();
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
	    partidas.addAll(finalDao.ListPart());
      	this.Tabela.setItems(partidas);
    }
    
    
    
    
    
    
    void clear() {
    	this.nomeArbitro.clear();
    	this.local.clear();
    	this.data.clear();
    	this.horario.clear();
    	this. golsSelecao1.clear();
    	this.golsSelecao2.clear();
    	this.cAmarelos1.clear();
    	this.cVermelhos1.clear();
    	this.cAmarelos2.clear();
    	this.cVermelhos2.clear();
    }
    
    public static ArrayList<Partida> getEmpates() {
		return empates;
	}



	public static void setEmpates(ArrayList<Partida> empates) {
		CRUDFinalController.empates = empates;
	}   
    
    
}

package app.controller;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

import app.Principal;
import app.Dao.ArbitroDaoImpl;
import app.Dao.ClassificadosGrupoDaoImpl;
import app.Dao.FaseGruposDaoImpl;
import app.Dao.GrupoDaoImpl;
import app.Dao.JogadorDaoImpl;
import app.Dao.SelecaoDaoImpl;
import app.model.Arbitro;
import app.model.Funcoes;
import app.model.Grupo;
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
/** Classe controle responsavel pela fase de grupos
* 
* @author Weslei Silva Santos
*
*/
public class CRUDFaseDeGruposController {
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	JogadorDaoImpl jogadorDao = new JogadorDaoImpl();
	ArbitroDaoImpl arbitroDao = new ArbitroDaoImpl();
	GrupoDaoImpl grupoDao = new GrupoDaoImpl();
	FaseGruposDaoImpl faseGruposDao = new FaseGruposDaoImpl();
	private ObservableList<Partida> partidas;
	ClassificadosGrupoDaoImpl classificadosGrupoDao = new ClassificadosGrupoDaoImpl();
	
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
    	//Se as partidas da fase de grupos estiverem criadas
    	if(faseGruposDao.ListPart().size()==48) {
    		this.LabelError.setText("Todas as partidas da fase de grupos já foram criadas");
    	}
    	List<Selecao> carregarSelecao = selecaoDao.ListSelecao();	
    	// Se os 8 grupos estiverem formados 
    	if(grupoDao.ListGrup().size()==8) {
    		// So sera possivel criar as partidas automaticas, se a lista de partidas estiver vazia
    		if(faseGruposDao.ListPart().size()==0) {
    			//Buscando todos os grupos
    			for (Grupo grupo : grupoDao.ListGrup()) {
    				//Buscando o id da primeira selecao dentro do grupo
    				for(int k=0; k<grupo.getSelecoes().size();k++) {
    					//id da selecao1
    					int idSelecao1=grupo.getSelecoes().get(k);
    					//Buscando o id da segunda selecao dentro do grupo
    					for(int p=k+1; p<grupo.getSelecoes().size();p++) {
    						//id da selecao2
    						int idSelecao2=grupo.getSelecoes().get(p);
    						//Cria a partida com dados vazios, somente com os dados dados da selecao
    						Partida partida = new Partida(faseGruposDao.getUltimoid(), "não definido", "não definido", "não definido ",carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getId(), carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getId(), 0,0, 0, "não definido",0,0,0,0, grupo.getId(), false);
    						faseGruposDao.CreatePart(partida);
    						this.partidas.add(partida);
    						}}}
    			this.LabelError.setText("Partidas Criadas");}
    		}
    	else {this.LabelError.setText("É necessário 8 grupos para fazer as partidas");}
    	// Se as partidas lista nao estiver cheia nem vazia
    	if(faseGruposDao.ListPart().size()!=0 && faseGruposDao.ListPart().size()!=48) {
    		this.LabelError.setText("Para criar novas partidas, delete todas as atuais");}
    	
    
    	
    
    }
    
    
    /** Opcao de editar partida
     * 
     * @param event
     */
    @FXML
    void EditarAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	if(i>=0) {
    		//Se a lista de classificacao estiver vazia 
    		if(classificadosGrupoDao.ListClassGrupo().size()==0) {
	    		try {
	    			// Se o nome do arbitro e data da partida nao for vazio 
	    			if(this.data.getText().toUpperCase().strip()!="".strip() & this.nomeArbitro.getText().toUpperCase().strip()!="".strip()) {
			    		Partida partida = faseGruposDao.ListPart().get(i);
				    	ArrayList<Selecao> carregarSelecao = selecaoDao.ListSelecao();
				    	int golsSelecao1 = Integer.parseInt(this.golsSelecao1.getText());
				    	int golsSelecao2 = Integer.parseInt(this.golsSelecao2.getText());
				    	int TotalCartoes1 = Integer.parseInt(this.cAmarelos1.getText()) +Integer.parseInt(this.cVermelhos1.getText());
				    	int TotalCartoes2 = Integer.parseInt(this.cAmarelos2.getText()) +Integer.parseInt(this.cVermelhos2.getText());
				    	
				    	int idSelecao1=partida.getSelecao1();
				    	int indexSelecao1 = Funcoes.BuscaPosicao(carregarSelecao, idSelecao1);
				    	Selecao selecao1 =carregarSelecao.get(indexSelecao1);
				    	
				    	int idSelecao2=partida.getSelecao2();
				    	int indexSelecao2 = Funcoes.BuscaPosicao(carregarSelecao, idSelecao2);
						Selecao selecao2 =carregarSelecao.get(indexSelecao2);
				    	
						//Adicionando cartoes
						selecao1.setTotalCartoes(selecao1.getTotalCartoes()+TotalCartoes1);
						selecao2.setTotalCartoes(selecao2.getTotalCartoes()+TotalCartoes2);
						
						//Adicionando e removendo saldo de gols
						selecao1.setSaldoGols(selecao1.getSaldoGols()-golsSelecao2+golsSelecao1);
						selecao2.setSaldoGols(selecao2.getSaldoGols()+golsSelecao2-golsSelecao1);
						
				    	//Adicionando pontuacao de vitoria da selecao 1
						if(golsSelecao1>golsSelecao2) {
							Selecao Novaselecao = new Selecao(idSelecao1,selecao1.getNome() ,selecao1.getTime(),selecao1.getTecnico(),
									selecao1.getIdGrupo(), selecao1.getPontuacao()+3, selecao1.getSaldoGols(),selecao1.getTotalCartoes());
							selecaoDao.UpdateSelecao(Novaselecao, idSelecao1);}
						
						//Adicionando pontuacao de vitoria da selecao 2 
						if(golsSelecao2>golsSelecao1) {
							Selecao Novaselecao = new Selecao(idSelecao2,selecao2.getNome() ,selecao2.getTime(),selecao2.getTecnico(),
									selecao2.getIdGrupo(), selecao2.getPontuacao()+3, selecao2.getSaldoGols(),selecao2.getTotalCartoes());
							selecaoDao.UpdateSelecao(Novaselecao, idSelecao2);}
						
						
						//Adicionando pontuacao de empate
						if(golsSelecao2==golsSelecao1) {
							Selecao Novaselecao1 = new Selecao(idSelecao1,selecao1.getNome() ,selecao1.getTime(),selecao1.getTecnico(),
									selecao1.getIdGrupo(), selecao1.getPontuacao()+1, selecao1.getSaldoGols(),selecao1.getTotalCartoes());
							selecaoDao.UpdateSelecao(Novaselecao1, idSelecao1);
							

							Selecao Novaselecao2 = new Selecao(idSelecao2,selecao2.getNome() ,selecao2.getTime(),selecao2.getTecnico(),
									selecao2.getIdGrupo(), selecao2.getPontuacao()+1, selecao2.getSaldoGols(),selecao2.getTotalCartoes());
							selecaoDao.UpdateSelecao(Novaselecao2, idSelecao2);}
						
					
						
						
						Partida NovaPartida = new Partida(partida.getId(), this.data.getText(), this.horario.getText(), this.local.getText(),partida.getNomeSelecao1(), partida.getNomeSelecao2(), partida.getSelecao1(), 
								partida.getSelecao2(),arbitroDao.getUltimoid(), golsSelecao1, golsSelecao2,this.nomeArbitro.getText().toUpperCase(), Integer.parseInt(this.cVermelhos1.getText()), Integer.parseInt(this.cAmarelos1.getText()),  Integer.parseInt(this.cVermelhos2.getText()), Integer.parseInt(this.cAmarelos2.getText()), partida.getIdGrupo(), true);
						
						Arbitro Arbitro = new Arbitro(arbitroDao.getUltimoid(), this.nomeArbitro.getText().toUpperCase(), faseGruposDao.getUltimoid());
						// Cria o arbitro no Dao
						arbitroDao.Create(Arbitro);		
						// Atualiza partida no Dao
						faseGruposDao.UpdatePart(NovaPartida, partida.getId());
						this.partidas.set(i, partida);
						
						//clear();
						this.LabelError.setText(" Partida editada ");}
	    			else{
	    				this.LabelError.setText(" Dados inválidos ");}}
    		catch(Exception erro) {
		    		this.LabelError.setText(" Dados inválidos ");
		    	}}
    	
    	else {
    		this.LabelError.setText("Impossível editar, pois a classificação foi feita");}		
    }}

    
    /** Opcao de excluir partidas
     * 
     * @param event
     */    
    @FXML
    void ExcluirAction(ActionEvent event) {
    	int i =this.Tabela.getSelectionModel().getSelectedIndex();
    	if(i>=0) {
    		// Se a lista de selecoes classificadas estiver vazia
    		if(classificadosGrupoDao.ListClassGrupo().size()==0) {
	    		this.partidas.remove(i);
	    		int id = faseGruposDao.ListPart().get(i).getId();
	    		faseGruposDao.DeletePart(id);
	    		this.LabelError.setText("Partida Deletada");}
    		else {
        		this.LabelError.setText("Impossível deletar, pois a classificação foi criada");}
    	}
    }

    
    
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
      	TableColumn C_VermelhosCol = new TableColumn("Cartões. V.S1"); 
      	TableColumn C_AmarelosCol = new TableColumn("Cartões. A.S1");
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
     
	    partidas.addAll(faseGruposDao.ListPart());
      	
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
    
}

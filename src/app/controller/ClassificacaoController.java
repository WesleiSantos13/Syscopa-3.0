package app.controller;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import app.Dao.ClassificadosGrupoDaoImpl;
import app.Dao.FaseGruposDaoImpl;
import app.Principal;
import app.Dao.GrupoDaoImpl;
import app.Dao.OitavasDeFinalDaoImpl;
import app.Dao.SelecaoDaoImpl;
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
import javafx.scene.control.cell.PropertyValueFactory;
import app.model.ClassificadosGrupo;
import app.model.Funcoes;
import app.model.Grupo;
import app.model.Selecao;
/** Classe controle responsavel pela classificacao
* 
* @author Weslei Silva Santos
*
*/
public class ClassificacaoController {
	ClassificadosGrupoDaoImpl classificadosGrupoDao = new ClassificadosGrupoDaoImpl();
	GrupoDaoImpl grupoDao = new GrupoDaoImpl();
	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	FaseGruposDaoImpl faseGruposDao = new FaseGruposDaoImpl();
	OitavasDeFinalDaoImpl oitavasDao = new OitavasDeFinalDaoImpl();
	private ObservableList<Selecao> selecoesData;
	private static ArrayList<Selecao> selecoesTemp= new ArrayList<Selecao>();
	
	@FXML
    private Label LabelError;

    @FXML
    private TableView<Selecao> Tabela;

    
    @FXML
    private Button classificar;

    @FXML
    private Button voltar;
    
    @FXML
    private Button Excluir;
    
  
  

    @FXML
    void classificarAction(ActionEvent event) {
    	Boolean Verificar = Funcoes.verificarEstadoPart(faseGruposDao.ListPart());
    	// Se as partidas da fase de grupos foram criadas e realizadas
    	if(faseGruposDao.ListPart().size()==48 && Verificar) {
	    	//Se a classificacao ja foi feita
    		if(classificadosGrupoDao.ListClassGrupo().size()==0) {
	    		FazerClassificacao();
				for(int k=0;k<classificadosGrupoDao.ListClassGrupo().size();k++) {
					ClassificadosGrupo ranking = classificadosGrupoDao.ListClassGrupo().get(k);
					int idSelecao1 = ranking.getIdClassificado1();
					int idSelecao2 = ranking.getIdClassificado2();
					int index1 = Funcoes.BuscaPosicao(selecaoDao.ListSelecao(), idSelecao1);
					int index2 = Funcoes.BuscaPosicao(selecaoDao.ListSelecao(), idSelecao2);
					selecoesTemp.add(selecaoDao.ListSelecao().get(index1));
					selecoesTemp.add(selecaoDao.ListSelecao().get(index2));
					this.selecoesData.add(selecaoDao.ListSelecao().get(index1));
					this.selecoesData.add(selecaoDao.ListSelecao().get(index2));
					this.LabelError.setText("Classificação criada");}
			}
	    	else {
	    		this.LabelError.setText("A classificação já foi criada");
	    	}
    }
    	else{ 
    		this.LabelError.setText("É necessário ter 48 partidas realizadas na fase grupos");}
    	}	
    

    
    
    @FXML
    void voltarAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/TelaPrincipal.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}

    
    @FXML
    void ExcluirAction(ActionEvent event) {
    	// Se as oitavas nao nao foram criadas
    	if(oitavasDao.ListOitavFinal().size()==0) {
	    	this.selecoesData.clear();;
		    selecoesTemp.clear();
		    classificadosGrupoDao.ListClassGrupo().clear();
		    this.LabelError.setText("Seleções deletadas da classificação");}
    	else {
    		this.LabelError.setText("Impossível deletar, pois as oitavas foram criadas");
    	}
    }
    
    
    
    
    
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
    void initialize() {

      	this.selecoesData=FXCollections.observableArrayList();
      	TableColumn IDCol = new TableColumn("ID");
      	TableColumn nomeCol = new TableColumn("Nome");
      	TableColumn pontCol = new TableColumn("Pontuação");
      	TableColumn saldoCol = new TableColumn("Saldo Gols");
      	TableColumn CartoesCol = new TableColumn("Total Cartões");
   
	    IDCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("id"));
	    nomeCol.setCellValueFactory(new PropertyValueFactory<Selecao, String>("nome"));
	    pontCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("pontuacao"));
	    saldoCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("saldoGols"));
	    CartoesCol.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("totalCartoes"));
	    
	    this.Tabela.getColumns().addAll(IDCol,nomeCol,pontCol,saldoCol, CartoesCol);
     
      	selecoesData.addAll(selecoesTemp);
      	
      	this.Tabela.setItems(selecoesData);
    }
    
    
    
    
    
    
    
    /** Metodo para buscar uma selecao classificada da fase de grupos
	 * 
	 */
	public static int buscarSelClassGrupos (List<Grupo> grupos, int i, List<Selecao> selecoes, List<Integer> idSelecoes) {
		Random random = new Random();
		int primeiroId = idSelecoes.get(0);
		int indexPrimeiroId = Funcoes.BuscaPosicao(selecoes,primeiroId);
		Selecao selecaoClassificada = selecoes.get(indexPrimeiroId);
		int idSel = idSelecoes.get(0);
		int indexsel = Funcoes.BuscaPosicao(selecoes, idSel);
		int maior1 = selecoes.get(indexsel).getPontuacao();
	
	
		//Buscando em todas as selecoes nos grupos
		for(int x=0; x<idSelecoes.size();x++) {
			int idSelecao = idSelecoes.get(x);
			int index = Funcoes.BuscaPosicao(selecoes, idSelecao);
			Selecao selecao = selecoes.get(index);
			
		
			// Armazena a selecao com a maior pontuacao
			if(maior1<=selecao.getPontuacao()) {
				selecaoClassificada = selecoes.get(index);
				maior1= selecao.getPontuacao();
			}}
			
			// Verifica se a selecao atualmente classificada tem pontuacao igual a outra selecao da lista
			for(int k1=0; k1<idSelecoes.size();k1++) {
				int idSelecao1 = idSelecoes.get(k1);
				int index1 = Funcoes.BuscaPosicao(selecoes, idSelecao1);
				Selecao selecao1 = selecoes.get(index1);
				
				// Se existir selecoes com pontuacao igual a selecao "classificada", o criterio de desempate sera pelo saldo de gols
				if(selecaoClassificada.getPontuacao()==selecao1.getPontuacao()) {
					//Se o saldo de gols da selecao a ser comparada for maior que a atual
					if(selecaoClassificada.getSaldoGols()<selecao1.getSaldoGols()) {
						// A selecao classificada passa ser a que tem saldo de gols maior
						selecaoClassificada=selecao1;}
					// Se o saldo de gols for igual, havera, o criterio de desempate sera pela quantidade de cartoes
					if(selecaoClassificada.getSaldoGols()==selecao1.getSaldoGols()) {
						//Se o total de cartoes da selecao a ser comparada menor que a atual
						if(selecaoClassificada.getTotalCartoes()>selecao1.getTotalCartoes()) {
							selecaoClassificada = selecao1;}
						//Se o total de cartoes da selecao a ser comparada for igual a atual, havera um sorteio
						if(selecaoClassificada.getTotalCartoes()==selecao1.getTotalCartoes()) {
							int numero = random.nextInt(1);
							if (numero==0) {
								return selecao1.getId();}
							if (numero==1) {
								return selecaoClassificada.getId();}}
						}}}
			return selecaoClassificada.getId();}
    
    
	public void FazerClassificacao() {		
		// Buscando em todos os grupos
		for(int i=0; i<grupoDao.ListGrup().size();i++) {
	
			ArrayList<Integer> selecoes = new ArrayList<Integer>();
			for(int j=0; j<4;j++) {
				selecoes.add(grupoDao.ListGrup().get(i).getSelecoes().get(j));}
			
						
			int idClassificado1 =buscarSelClassGrupos(grupoDao.ListGrup(),i, selecaoDao.ListSelecao(), selecoes);	
			
			//Removendo o id da primeira selecao classificada da lista
			for (int z = 0; z < selecoes.size(); z++) {
				// Se achar o id na lista
				if(idClassificado1 == selecoes.get(z)) {
					selecoes.remove(z);}}
			
			
		
			int idClassificado2 =buscarSelClassGrupos(grupoDao.ListGrup(),i, selecaoDao.ListSelecao(), selecoes);	
			ClassificadosGrupo ranking = new ClassificadosGrupo(classificadosGrupoDao.getUltimoid(),idClassificado1, idClassificado2);
			classificadosGrupoDao.CreateClassGrupo(ranking);
			}
		}
    
    
}

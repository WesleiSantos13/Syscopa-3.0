package app.controller;

import java.io.IOException;  
import java.util.ArrayList;  
import app.Principal;
import app.Dao.JogadorDaoImpl;
import app.Dao.SelecaoDaoImpl;
import app.Dao.TecnicoDaoImpl;
import app.model.Jogador;
import app.model.Selecao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import app.model.Tecnico;

/** Classe responsavel por inserir selecoes
 * 
 * @author Weslei Silva Santos
 *
 */
public class InserirSelecaoController {

	@FXML
	  private Label LabelError;

	@FXML
	  private Label LabelError1;
	
	@FXML
    private Button btnVoltar;
	
	@FXML
	private Button btnEditareExcluir;
	
    @FXML
    private Button btnCadastrarSelecao;

    @FXML
    private TextField btnNomeJogador1;

    @FXML
    private TextField btnNomeJogador10;

    @FXML
    private TextField btnNomeJogador11;

    @FXML
    private TextField btnNomeJogador2;

    @FXML
    private TextField btnNomeJogador3;

    @FXML
    private TextField btnNomeJogador4;

    @FXML
    private TextField btnNomeJogador5;

    @FXML
    private TextField btnNomeJogador6;

    @FXML
    private TextField btnNomeJogador7;

    @FXML
    private TextField btnNomeJogador8;

    @FXML
    private TextField btnNomeJogador9;

    @FXML
    private TextField btnNomeSelecao;

    @FXML
    private TextField btnNomeTecnico;

    @FXML
    private TextField btnPosicaoJogador1;

    @FXML
    private TextField btnPosicaoJogador10;

    @FXML
    private TextField btnPosicaoJogador11;

    @FXML
    private TextField btnPosicaoJogador2;

    @FXML
    private TextField btnPosicaoJogador3;

    @FXML
    private TextField btnPosicaoJogador4;

    @FXML
    private TextField btnPosicaoJogador5;

    @FXML
    private TextField btnPosicaoJogador6;

    @FXML
    private TextField btnPosicaoJogador7;

    @FXML
    private TextField btnPosicaoJogador8;

    @FXML
    private TextField btnPosicaoJogador9;

    @FXML
    void btnCadastrarSelecaoAction(ActionEvent event) {
    	SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
    	JogadorDaoImpl jogadorDao = new JogadorDaoImpl();
    	TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl();
    	
    	// Se a a lista de selecoes for menor que 32
    	if(selecaoDao.ListSelecao().size()<32) {  
	    	int ultimoIdSelecao = selecaoDao.getUltimoid();
	    	// Se os nomes nao forem vazios
	    	if(this.btnNomeJogador1.getText().toUpperCase().strip()!="".strip()
	    			& this.btnNomeJogador2.getText().toUpperCase().strip()!="".strip()
	    			& this.btnNomeJogador3.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador4.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador5.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador6.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador7.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador8.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador9.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador10.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeJogador11.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeTecnico.getText().toUpperCase().strip()!="".strip()
					& this.btnNomeSelecao.getText().toUpperCase().strip()!="".strip())
					{
	    	

				ArrayList<Integer> tecnico = new ArrayList<>();
		    	ArrayList<Integer> time = new ArrayList<>();
		    	
		    	Jogador jogador1 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador1.getText().toUpperCase(),  this.btnPosicaoJogador1.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador1);
		    	time.add(jogadorDao.getUltimoid()-1); 
		    	
		    	Jogador jogador2 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador2.getText().toUpperCase(),  this.btnPosicaoJogador2.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador2);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador3 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador3.getText().toUpperCase(),  this.btnPosicaoJogador3.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador3);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador4 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador4.getText().toUpperCase(),  this.btnPosicaoJogador4.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador4);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador5 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador5.getText().toUpperCase(),  this.btnPosicaoJogador5.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador5);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador6 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador6.getText().toUpperCase(),  this.btnPosicaoJogador6.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador6);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador7 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador7.getText().toUpperCase(),  this.btnPosicaoJogador7.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador7);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador8 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador8.getText().toUpperCase(),  this.btnPosicaoJogador8.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador8);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador9 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador9.getText().toUpperCase(),  this.btnPosicaoJogador9.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador9);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador10 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador10.getText().toUpperCase(),  this.btnPosicaoJogador10.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador10);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	
		    	Jogador jogador11 = new Jogador(jogadorDao.getUltimoid(),  this.btnNomeJogador11.getText().toUpperCase(),  this.btnPosicaoJogador11.getText().toUpperCase(), 0, 0, 0, ultimoIdSelecao);
		    	jogadorDao.Create(jogador11);
		    	time.add(jogadorDao.getUltimoid()-1);
		    	    	
		    	int idTec =tecnicoDao.getUltimoid();
		    	tecnico.add(idTec);
		    
		    	Tecnico Tecnico = new Tecnico(idTec, this.btnNomeTecnico.getText().toUpperCase(), ultimoIdSelecao, this.btnNomeSelecao.getText().toUpperCase());
		    	tecnicoDao.CreateTec(Tecnico);
		    	
		    	Selecao selecao = new Selecao(ultimoIdSelecao, this.btnNomeSelecao.getText().toUpperCase(),time ,tecnico , 0,0,0,0);
		    	selecaoDao.CreateSelecao(selecao);
		    	clear();
		    	this.LabelError.setText("Seleção Cadastrada");}
	    	else {
	    		this.LabelError.setText("Dados inválidos");
	    	}
	    	}
    	else{
    		this.LabelError.setText("Todas as Selecões já foram cadastradas");
    	    		
    		
    	}}
    	
    
    
    /** Opcao de voltar ao menu inicial
     * 
     * @param event
     */
    @FXML
    void btnVoltarAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDSelecao.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}
    
    
   
    /** Opcao de executar a listagem e edicao de selecao
     * 
     * @param event
     */
    @FXML
    void btnEditareExcluirAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/EditarSelecao.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}
    
   
    void clear() {
    	this.btnNomeSelecao.clear();
    	this.btnNomeTecnico.clear();
    	this.btnNomeJogador1.clear();
    	this.btnNomeJogador2.clear();
    	this.btnNomeJogador3.clear();
    	this.btnNomeJogador4.clear();
    	this.btnNomeJogador5.clear();
    	this.btnNomeJogador6.clear();
    	this.btnNomeJogador7.clear();
    	this.btnNomeJogador8.clear();
    	this.btnNomeJogador9.clear();
    	this.btnNomeJogador10.clear();
    	this.btnNomeJogador11.clear();
    	this.btnPosicaoJogador1.clear();
    	this.btnPosicaoJogador2.clear();
    	this.btnPosicaoJogador3.clear();
    	this.btnPosicaoJogador4.clear();
    	this.btnPosicaoJogador5.clear();
    	this.btnPosicaoJogador6.clear();
    	this.btnPosicaoJogador7.clear();
    	this.btnPosicaoJogador8.clear();
    	this.btnPosicaoJogador9.clear();
    	this.btnPosicaoJogador10.clear();
    	this.btnPosicaoJogador11.clear();
    }
}



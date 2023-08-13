package app.controller;



import java.io.IOException;  

import app.Principal;
import app.Dao.FaseGruposDaoImpl;
import app.Dao.GrupoDaoImpl;
import app.Dao.SelecaoDaoImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import app.Pre_set;
/** Controle do Menu principal do programa
 * 
 * @author Weslei Silva Santos
 *
 */
public class TelaPrincipalController {
	
	@FXML
	private Button btnQuartas;
	
	@FXML
	private Button btnClassificacao;
    
	@FXML
    private Button btnArbitros;

    @FXML
    private Button btnGrupos;

    @FXML
    private Button btnJogadores;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnSelecoes;

    @FXML
    private Button btnTecnicos;
    
    @FXML
    private Button btnFaseDeGrupos;
   
    @FXML
    private Button btnPreSet;
    
    @FXML
    private Button btnOitavas;
    

    @FXML
    private Button btnPesquisar;
    
    @FXML
    private Button btnSemi;
    
    @FXML
    private Button btnFinal;
    
    @FXML
    private Button btnTerceiro;
    
    @FXML
    private Button btnPodio;
    
    @FXML
    private Button btnPreSetFaseGrupos;
    
    
    GrupoDaoImpl grupoDao = new GrupoDaoImpl();  
    SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
    FaseGruposDaoImpl faseGruposDao = new FaseGruposDaoImpl();
    
    
    /** Opcao de pre set de partidas
     * 
     * @param event
     */
    @FXML
    void btnPreSetFaseGruposAction(ActionEvent event) {
    	if(faseGruposDao.ListPart().size()==0 && grupoDao.ListGrup().size()!=0) {
    		Pre_set.PartidasFaseGrupos();
    	}
    }
    
    
    
    
    /** Opcao para pesquisa
     * 
     * @param event 
     */
    @FXML
    void btnPesquisarAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/MenuPesquisar.fxml"));
			Scene cena = new Scene(root); 
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
   
    
    
    /** Opcao para exibir os finalistas da copa
     * 
     * @param event 
     */
    @FXML
    void btnPodioAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/Resultados.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    
    /** Opcao para executar a interface de acesso a partida valendo o terceiro lugar
     * 
     * @param event 
     */
    @FXML
    void btnTerceiroAction(ActionEvent event) {
     	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUD3Lugar.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    
    
    /** Opcao para executar a interface de  acesso a partida final
     * 
     * @param event 
     */
    @FXML
    void btnFinalAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDFinal.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    /** Opcao para executar a interface de  acesso a partidas da semifinal
     * 
     * @param event 
     */
    @FXML
    void btnSemiAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDSemi.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
    
    /** Opcao para executar a interface de  acesso a partidas das quartas de final
     * 
     * @param event 
     */
    @FXML
    void btnQuartasAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDQuartas.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    
    
    /** Opcao para executar a interface de  acesso a partidas das oitavas de final
     * 
     * @param event 
     */
    @FXML
    void btnOitavasAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDOitavas.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    
    
    /** Opcao para executar a interface de  acesso a partidas da fase grupos
     * 
     * @param event 
     */
    @FXML
    void btnFaseDeGruposAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDFaseDeGrupos.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    /** Opcao para executar a interface de  acesso a arbitros
     * 
     * @param event 
     */
    @FXML
    void btnArbitrosAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDArbitro.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    /** Opcao para executar a interface de  acesso a classificacao da fase grupos
     * 
     * @param event 
     */
    @FXML
	void btnClassificacaoAction(ActionEvent event) {
    	try {	
    		Parent root = FXMLLoader.load(getClass().getResource("/app/view/Classificacao.fxml"));
    		Scene cena = new Scene(root);
    		Principal.setScene(cena);
    	} catch (IOException e) {
    		e.printStackTrace();}}
	    

    /** Opcao para executar a interface de  acesso aos grupos
     * 
     * @param event 
     */
    @FXML
    void btnGruposAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDGrupo.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    /** Opcao para executar a interface de  acesso a jogadores
     * 
     * @param event 
     */
    @FXML
    void btnJogadoresAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDJogador.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /** Opcao para fechar o programa
     * 
     * @param event 
     */
    @FXML
    void btnSairAction(ActionEvent event) {
    	Principal.getStage().close();
    }

    
    
    
    /** Opcao para executar a interface de  acesso selecoes
     * 
     * @param event 
     */
    @FXML
    void btnSelecoesAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDSelecao.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    /** Opcao para executar a interface de  acesso a tecnicos
     * 
     * @param event 
     */
    @FXML
    void btnTecnicosAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/app/view/CRUDTecnico.fxml"));
			Scene cena = new Scene(root);
			Principal.setScene(cena);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    
    /** Opcao para adicionar as selecoes e grupos pre criados no Dao
     * 
     * @param event 
     */
    @FXML
    void btnPreSetAction(ActionEvent event) {
    	//So sera permitido o pre set se nao existir selecoes criadas
    	if(selecaoDao.ListSelecao().size()==0) {
    		Pre_set.construir();}
    }

}

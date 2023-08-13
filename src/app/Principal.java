package app;
import javafx.fxml.FXMLLoader;      
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.stage.Stage;
/** Classe Executora das interfaces
* 
* @author Weslei Silva Santos
*
*/
public class Principal extends Application {
	/* Autor: Weslei Silva Santos     
	Componente Curricular: EXA863 - MI Programação
	Concluido em: 12/12/2022
	Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
	trecho de código de outro colega ou de outro autor, tais como provindos de livros e
	apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
	de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
	do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.*/
	
	// As imagens foram da pngwing.com e da Pixabay.com
	
	
	private static Scene scene;
	
	@SuppressWarnings("exports")
	public static void setScene(Scene newScene) {
		scene = newScene;
		stage.setScene(scene);
		stage.centerOnScreen();
	}
	
	
	@SuppressWarnings("exports")
	public static Stage getStage() {
		return stage;
	}

	@SuppressWarnings("exports")
	public static void setStage(Stage stage){
		Principal.stage = stage;
	}
 
	@SuppressWarnings("exports")
	public static Stage stage;
	
	
	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/app/view/TelaPrincipal.fxml"));
		scene = new Scene(root);
		stage.setTitle("SysCopa");
		stage.setResizable(false);
		stage.centerOnScreen();
		Image icone = new Image("bola.png");
		stage.getIcons().add(icone);
		stage.setScene(scene);
		stage.show();
		setStage(stage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

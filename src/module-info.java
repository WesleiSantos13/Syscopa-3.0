
/** Classe responsavel por chamar os requerimentos do programa
 * @author Weslei Silva Santos
 *
 */
module GerenciadorNotas {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;

	
	opens app.controller to javafx.graphics, javafx.fxml;
	opens app.model;
	exports app;
}
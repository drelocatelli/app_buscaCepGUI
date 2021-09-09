package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@SuppressWarnings("unused")
	private String cep;
	
	@FXML
	public Pane panel;
	
	@FXML
	public Label resultado;
	
	public void createScene(ActionEvent event, String args[]) throws IOException{
		// Getting MainController args
		this.cep = args[0];
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Result.fxml"));

		// source scene by button
		Node source = (Node) event.getSource();
		stage = (Stage) (source).getScene().getWindow();
		stage.setTitle("Resultado");
		
		// create a pane
		StackPane rootpane = new StackPane();
		
		String msg = String.format("Você buscou por: %s\n\nhaha", cep);

		// create items
		Text res = new Text(msg);
		
		// properties
		rootpane.setAlignment(res, Pos.TOP_LEFT);
		res.setTranslateX(50.0);
		res.setTranslateY(150.0);
		
		// create a scene
		rootpane.getChildren().add(res);
		Scene sc = new Scene(rootpane, 600, 400);
		
		stage.setScene(sc);
		stage.setResizable(false);
		stage.show();
		
	}
	
	public void loadScene(ActionEvent event, String args[]) throws IOException{
		// Getting MainController args
		this.cep = args[0];
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Result.fxml"));

		// source scene by button
		Node source = (Node) event.getSource();
		stage = (Stage) (source).getScene().getWindow();
		root = loader.load();
		
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
		


	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
	}

}

package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import gui.getCep;

public class ResultController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
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
		
		getCep res = new getCep(); 
		boolean status = res.result(cep);
		String results = res.results;
		String msg;
		
		if(!status) {
			msg = String.format("Você buscou por: %s\n\n%s", this.cep);
		}else {
			msg = String.format("Você buscou por: %s\n\n%s", this.cep, results);
			
			try {
				// create a pane
				StackPane rootpane = new StackPane();
				
				// create items
				Text title = new Text("Resultado");
				Text result = new Text(msg);
				Button voltar = new Button("Tentar novamente");
				
				// botao voltar
				voltar.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent ev) {
						System.out.println("VOLTAR");
						
					}
				});
				
				// properties
				rootpane.setAlignment(result, Pos.TOP_LEFT);
				rootpane.setAlignment(title, Pos.TOP_CENTER);
				rootpane.setAlignment(voltar, Pos.BOTTOM_RIGHT);
				
				voltar.setTranslateY(-30.0);
				voltar.setTranslateX(-15.0);
				
				title.setStyle("-fx-font:30 Arial;");
				title.setTranslateY(35.0);
				
				result.setStyle("-fx-font:18 Arial;");
				result.setTranslateX(50.0);
				result.setTranslateY(110.0);
				
				// create a scene
				ObservableList<Node> rootPaneChidren = rootpane.getChildren();
				rootPaneChidren.add(title);
				rootPaneChidren.add(result);
				rootPaneChidren.add(voltar);
				
				Scene sc = new Scene(rootpane, 600, 300);
				
				stage.setScene(sc);
				stage.setResizable(false);
				stage.show();

			}catch(Exception err) {
				err.printStackTrace();
			}

		}
		
	}
	
	public void loadScene(ActionEvent event) throws IOException{
		String src = "/gui/Main.fxml";
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(src));

			// source scene by button
			Node source = (Node) event.getSource();
			stage = (Stage) (source).getScene().getWindow();
			root = loader.load();
			
			scene = new Scene(root);
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		}catch(Exception err) {
			err.printStackTrace();
		}
	}
		


	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
	}

}

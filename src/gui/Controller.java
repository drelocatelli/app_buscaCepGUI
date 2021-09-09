package gui;

import java.awt.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Controller implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField cepInput;
	
	@FXML
	private Button submitBtn;
	@FXML
	private Label searched;
	
	private String cep;
	
	public void switchScene(ActionEvent event, String src) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(src));
		// source scene by button
		Node source = (Node) event.getSource();
		stage = (Stage) (source).getScene().getWindow();
		root = loader.load();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML
	public void formHandle(KeyEvent event) {
		
		// se pressionado enter
		if(event.getCode().equals(KeyCode.ENTER)) {
			System.out.println("OK");
		}
		
	}
	
	@FXML
	public void submit(ActionEvent event) throws IOException {

		cep = cepInput.getText();
		
		if(!cep.isEmpty()) {
			String searchMsg = String.format("Busca por: %s", cep);
	
			searched.setText(searchMsg);
			
			this.switchScene(event, "/gui/Result.fxml");
			
		}else {
			searched.setText("");
		}

		
	}
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	
	}
	

}

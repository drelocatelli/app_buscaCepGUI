package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.input.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class Controller implements Initializable{
	
	@FXML
	private TextField cepInput;
	
	@FXML
	private Button submitBtn;
	@FXML
	private Label searched;
	
	private String cep;
	
	@FXML
	public void formHandle(KeyEvent event) {
		
		// se pressionado enter
		if(event.getCode().equals(KeyCode.ENTER)) {
			this.submit();
		}
		
	}
	
	@FXML
	public void submit() {

		cep = cepInput.getText();
		
		if(!cep.isEmpty()) {
			String searchMsg = String.format("Busca por: %s", cep);
	
			searched.setText(searchMsg);
		}else {
			searched.setText("");
		}

		
	}
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
	}
	

}

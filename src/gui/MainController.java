package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class MainController implements Initializable{
	
	@FXML
	public TextField cepInput;
	
	@FXML
	private Button submitBtn;
	@FXML
	private Label searched;
	
	public String cep;
	
	
	@FXML
	public void formHandle(KeyEvent event) {
		// se pressionado enter
		if(event.getCode().equals(KeyCode.ENTER)) {
			// clica botao
			submitBtn.fire();
		}
		
	}
	
	@FXML
	public void submit(ActionEvent event) throws IOException {

		cep = cepInput.getText();
				
		if( !(cep.isEmpty()) ) {
			String searchMsg = String.format("Busca por: %s", cep);
	
			searched.setText(searchMsg);
			
			// troca cena
			String args[] = {cep};
			ResultController resultController = new ResultController();
			resultController.createScene(event, args);
			
		}else {
			searched.setText("");
		}
		
	}
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	
	}
	

}

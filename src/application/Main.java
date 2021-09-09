package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private Stage primaryStage;
	private Scene scene;
	private Parent root;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Main.fxml"));
			root = loader.load();
			
			// get controller
//			Controller controller = loader.getController();
			
			
			this.primaryStage.setResizable(false);
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// Title
			this.primaryStage.setTitle("Busca CEP");
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

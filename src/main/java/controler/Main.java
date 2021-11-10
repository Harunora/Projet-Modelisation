package controler;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	static Scene scene;
	private Parent root;
    // java --module-path 'path-to-javafx-binaries/lib' --add-modules javafx.controls,javafx.fxml -jar .\projetmode.jar
    public void start(Stage stage) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/MainView.fxml"));
            URL fxmlFileUrl = getClass().getResource("/MainView.fxml");
            loader.setLocation(fxmlFileUrl);
            root = loader.load();
            scene = new Scene(root);
            MainControler  m = loader.getController();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Modélisateur 3D");
            stage.show();
            m.setScene(scene);
            
        
    }
    public Stage getStage() {
    	return getStage();
    }
    

    public static void main(String[] args) {
            Application.launch(args);
    }
    
    public static Scene getScene() {
    	return scene;
    }
}

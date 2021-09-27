package demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class MainControler extends Application implements Initializable {
	@FXML
	Button LoadFolder, bVue1, bVue2, bVue3, bVue4;
	@FXML
	TreeView<String> TV;
	@FXML
	Canvas canvas;

	public void start(Stage stage) throws IOException {
		ExplorerFile  ef = new ExplorerFile(); 
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/MainView.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("3D View");
		stage.show();
		LoadFolder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				TV =ExplorerFile.FolderSearcher(stage);
			}
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

package controler;

import java.io.IOException;

import graph.CanvasWriter;
import graph.Rotation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class CanvasViewer {
	
	@FXML
	Canvas CanvasView;
	
	protected Scene scene;
	protected Stage stage;
	protected CanvasWriter cw;
	
	
	public CanvasViewer(CanvasWriter cw , Rotation r, int homothetie) throws IOException {
		 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("/View.fxml"));
         Parent root = loader.load();
         scene = new Scene(root);
         //CanvasViewer  m = loader.getController();
		 stage.setScene(scene);
         stage.setResizable(false);
         stage.setTitle("View");
         stage.show();
         this.cw = cw;
	}
	
}

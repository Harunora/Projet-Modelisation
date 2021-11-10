package controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import graph.CanvasWriter;
import graph.Rotation;
import graph.UpdateGraph;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class CanvasViewer implements Initializable {
	
	@FXML
	Canvas CanvasView;
	
	protected CanvasWriter cw;
	
	
	public CanvasViewer(CanvasWriter cw , Rotation r, int homothetie, UpdateGraph graphe) throws IOException {		 
		this.cw = cw;
        this.cw.canvas = CanvasView;
        graphe.update(r.getMcourante());
        cw.updateCanvasWriter(graphe);
	}
	
	public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        MainControler  m = loader.getController();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Modélisateur 3D");
        stage.show();
        m.setScene(scene);
        
   }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			this.start(new Stage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

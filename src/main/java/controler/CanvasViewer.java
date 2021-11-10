package controler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import graph.CanvasWriter;
import graph.Rotation;
import graph.UpdateGraph;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CanvasViewer {
	
	@FXML
	Canvas canvasView;
	
	
	protected CanvasWriter cw;
	protected UpdateGraph updateGraph;
	
	
	public CanvasViewer(CanvasWriter cw , Rotation r, int homothetie, UpdateGraph graphe) throws IOException {		 
		this.cw = cw;
        this.cw.canvas = canvasView;
        this.updateGraph = graphe;
        updateGraph.update(r.getMcourante());
	}
	
	public void canvasShow (StackPane sp) {
		
		Scene secondScene = new Scene(sp, 750, 510);
		Canvas canvasView = new Canvas();
		sp.getChildren().add(canvasView);
		canvasView.setWidth(750.0);
		canvasView.setHeight(510.0);
        Stage stageView = new Stage();
        stageView.setTitle("View");
        stageView.setScene(secondScene);
        stageView.setResizable(false);
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.show();
        
        
		
		
	}
}

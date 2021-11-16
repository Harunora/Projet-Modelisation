package controler;

import java.io.IOException;
import graph.CanvasWriter;
import graph.UpdateGraph;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rotation.Rotation;

public class CanvasViewer {
	
	@FXML
	Canvas canvasView;
	
	
	protected CanvasWriter canvasWriter;
	protected UpdateGraph updateGraph;
	protected int homothetie;
	protected Rotation rotation;
	
	public CanvasViewer(CanvasWriter cw , Rotation r, int homothetie, UpdateGraph graphe) throws IOException {		 
		this.canvasWriter = cw;
        this.updateGraph = graphe;
        this.rotation = r;
        this.homothetie = homothetie;
	}
	
	public void canvasShow (StackPane sp, String position) {
		
		Scene secondScene = new Scene(sp, 750, 510);
		Canvas canvasView = new Canvas();
		sp.getChildren().add(canvasView);
		canvasView.setWidth(750.0);
		canvasView.setHeight(510.0);
        Stage stageView = new Stage();
        stageView.setTitle(position);
        stageView.setScene(secondScene);
        stageView.setResizable(false);
        stageView.initModality(Modality.WINDOW_MODAL);
        stageView.show();
        
        updateGraph.update(rotation.getMcourante());
        canvasWriter= new CanvasWriter(canvasView,updateGraph);
        canvasWriter.changeHomothesie(homothetie);
		
		
	}
}

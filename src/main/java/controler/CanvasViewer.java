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
import rotation.Mouvement;

/**
 * The Class CanvasViewer.
 */
public class CanvasViewer {
	
	/** The canvas view. */
	@FXML
	Canvas canvasView;
	
	
	/** The canvas writer. */
	protected CanvasWriter canvasWriter;
	
	/** The update graph. */
	protected UpdateGraph updateGraph;
	
	/** The homothetie. */
	protected int homothetie;
	
	/** The rotation. */
	protected Mouvement rotation;
	
	/**
	 * Instantiates a new canvas viewer.
	 *
	 * @param cw the cw
	 * @param r the r
	 * @param homothetie the homothetie
	 * @param graphe the graphe
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public CanvasViewer(CanvasWriter cw , Mouvement r, int homothetie, UpdateGraph graphe) throws IOException {		 
		this.canvasWriter = cw;
        this.updateGraph = graphe;
        this.rotation = r;
        this.homothetie = homothetie;
	}
	
	/**
	 * Canvas show.
	 *
	 * @param sp the sp
	 * @param position the position
	 */
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
        //canvasWriter.changeHomothesie(homothetie);
		
		
	}
}

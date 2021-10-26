package demo;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import graph.CanvasWriter;
import graph.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class MainControler implements Initializable {
    @FXML
    Button loadfolder, btreebase , baide, btop, bright, bleft, bbot, bturnaroundleft, bturnaroundright, btop1, bright1, bleft1, bbot1, bturnaroundleft1, bturnaroundright1, brechargeCanvas;
    
    @FXML
    Slider sensliderRot, sensliderTrans;
    
    @FXML
    TextField tfvalueRot, tfvalueTrans, tfvalueHomo;
    
    @FXML
    TreeView<String> TV;
    
    @FXML
    Canvas canvas;
    
    @FXML
    HBox hcontainerCanvas;
    
    public File current = null;
    public Stage stage = new Stage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	ExplorerFile ef = new ExplorerFile();
    	btreebase.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String pwd = System.getProperty("user.dir");
				System.out.println(pwd+"/data");
				File directory = new File(pwd+"/data");
				if (directory == null || !directory.isDirectory()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Could not open directory");
					alert.setContentText("The file is invalid.");
					alert.showAndWait();				
				} else {
					TV.setRoot(ef.getNodesForDirectory(directory));
				}
				
			}
    	});
        loadfolder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				DirectoryChooser dc = new DirectoryChooser();
				dc.setInitialDirectory(new File(System.getProperty("user.home")));
				File choice = dc.showDialog(stage);
				if (choice == null || !choice.isDirectory()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Could not open directory");
					alert.setContentText("The file is invalid.");
					alert.showAndWait();				
				} else {
					TV.setRoot(ef.getNodesForDirectory(choice));
				}
				current = ef.getCurrent(TV);
				
			}
			
		});
        
        File test= new File("data/apple.ply");
        FileReader fr=new FileReader();
		CanvasWriter cw = new CanvasWriter(canvas,fr.read(test));
		cw.changeHomothesie(2000);

        
        brechargeCanvas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
			}
			
		});
        
        
        
    }
    
 

}

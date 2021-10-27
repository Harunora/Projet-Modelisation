package controler;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import graph.CanvasWriter;
import graph.FileReader;
import graph.Graph;
import graph.Matrice;
import graph.Rotation;
import graph.RotationAroundLeft;
import graph.RotationAroundRight;
import graph.RotationDown;
import graph.RotationLeft;
import graph.RotationRight;
import graph.RotationUp;
import graph.UpdateGraph;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class MainControler implements Initializable {
    @FXML
    Button loadfolder, btreebase , baide, btop, bright, bleft, bbot, bturnaroundleft, bturnaroundright, btop1, bright1, bleft1, bbot1, bturnaroundleft1, bturnaroundright1, brechargeCanvas, bHomomoin, bHomoplus;
    
    @FXML
    Slider sensliderRot, sensliderTrans, sensliderHomo;
    
    @FXML
    TextField tfvalueRot, tfvalueTrans, tfvalueHomo;
    
    @FXML
    TreeView<String> TV;
    
    @FXML
    Canvas canvas;
    
    @FXML
    HBox hcontainerCanvas;
    
    public File current = new File("data/cow.ply");
    FileReader fr=new FileReader();
    CanvasWriter cw = null;
    public Stage stage = new Stage();
    UpdateGraph u = new UpdateGraph();
    Graph graphe = fr.read(current);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	ExplorerFile ef = new ExplorerFile();
    	stage.setResizable(true);
    	
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
				current = ef.getFile(TV);
				
			}
			
		});
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
        
        fr=new FileReader();
        graphe = fr.read(current);
        cw = new CanvasWriter(canvas,graphe);
		
		cw.changeHomothesie(2000);
		
		bright.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationRight(graphe.getMatrice(),null); 
				Matrice tmp = r.rotate(18);
				graphe = u.Update(graphe,tmp);
				cw = new CanvasWriter(canvas, graphe);
			}
		});
		bleft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationLeft(graphe.getMatrice(),null); 
				Matrice tmp = r.rotate(Math.PI/2.0);
				graphe = u.Update(graphe,tmp);
				cw = new CanvasWriter(canvas, graphe);
			}
		});
		bturnaroundleft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationAroundLeft(graphe.getMatrice(),null); 
				Matrice tmp = r.rotate(Math.PI/2.0);
				graphe = u.Update(graphe,tmp);
				cw = new CanvasWriter(canvas, graphe);
			}
		});
		
		bturnaroundright.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationAroundRight(graphe.getMatrice(),null); 
				Matrice tmp = r.rotate(Math.PI/2.0);
				graphe = u.Update(graphe,tmp);
				cw = new CanvasWriter(canvas, graphe);
			}
		});
		btop.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationUp(graphe.getMatrice(),null); 
				Matrice tmp = r.rotate(Math.PI/2.0);
				graphe = u.Update(graphe,tmp);
				cw = new CanvasWriter(canvas, graphe);
			}
		});
		bbot.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationDown(graphe.getMatrice(),null); 
				Matrice tmp = r.rotate(Math.PI/2.0);
				graphe = u.Update(graphe,tmp);
				cw = new CanvasWriter(canvas, graphe);
			}
		});

		bHomoplus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(cw.homothesie<0) {
					cw.changeHomothesie(cw.homothesie-50);
				}
				
			}
		});
		
		bHomomoin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(cw.homothesie<0) {
					cw.changeHomothesie(cw.homothesie+50);
					}
				else {
					System.out.println("stop");
				}
			}
			
		});
		

        
        brechargeCanvas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {
				cw = null;
				current = ef.getFile(TV);
				cw = new CanvasWriter(canvas,graphe);
				cw.changeHomothesie(200);
				
			}
			
		});
        
        
        
    }
    
 

}

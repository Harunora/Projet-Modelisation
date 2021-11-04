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
import javafx.scene.Scene;
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
    
    protected Scene scene;
    
    public File current = new File("data/cow.ply");
    FileReader fr=new FileReader();
    CanvasWriter cw = null;
    public Stage stage = new Stage();
    UpdateGraph graphe = fr.read(current);
    UpdateGraph u = new UpdateGraph(graphe.getNbFaces(),graphe.getFaces(), graphe.getMatrice(),graphe.getSommetsDeFaces());
    Matrice tmp = null;
    Rotation r = null;
    
    @SuppressWarnings("incomplete-switch")
	@Override
    public void initialize(URL location, ResourceBundle resources) {
    	ExplorerFile ef = new ExplorerFile();
    	stage.setResizable(true);
    	Scene scene  = Main.getScene();
    	
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
        cw = new CanvasWriter(canvas,u);
		
		cw.changeHomothesie(2000);
		
		
		
		
		bright.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				r = new RotationRight(graphe.getMatrice(),null); 
			    r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		bleft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationLeft(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		bturnaroundleft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationAroundLeft(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		
		bturnaroundright.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationAroundRight(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		btop.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				r = new RotationUp(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		bbot.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				r = new RotationDown(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
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
				cw = new CanvasWriter(canvas,u);
				cw.changeHomothesie(200);
				System.out.println("refresh");
				
			}
			
		});
        
        
        
    }
    
    
    @SuppressWarnings("incomplete-switch")
	public void setScene (Scene s) {
    	s.setOnKeyPressed(e->{
			switch(e.getCode()){
			case D:
				r = new RotationRight(graphe.getMatrice(),null); 
			    r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
			break;
			case Q:
				r = new RotationLeft(graphe.getMatrice(),null); 
			    r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case Z:
				r = new RotationUp(graphe.getMatrice(),null); 
			    r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case S:
				r = new RotationDown(graphe.getMatrice(),null); 
			    r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case E:
				r = new RotationAroundRight(graphe.getMatrice(),null); 
			    r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case A:
				r = new RotationAroundLeft(graphe.getMatrice(),null); 
			    r.rotate(Math.PI/100);
				graphe = fr.read(current);
				graphe.update(r.getMcourante());
				cw.updateCanvasWriter(graphe);
				
				break;
			}
			
		});
    }
 

}

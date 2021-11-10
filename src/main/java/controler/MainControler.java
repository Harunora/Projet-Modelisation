package controler;

import java.io.File;
import java.io.IOException;
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
import graph.Translation;
import graph.UpdateGraph;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainControler implements Initializable {
    @FXML
    Button loadfolder, btreebase , baide, btop, bright, bleft, bbot, bturnaroundleft, bturnaroundright, btop1, bright1, bleft1, bbot1, bturnaroundleft1, bturnaroundright1, brechargeCanvas, bHomomoin, bHomoplus, binfoaffi, Fview, Aview ,Sview;
    
    @FXML
    TreeView<File> TV;
    
    @FXML
    Canvas canvas;
    
    @FXML
    HBox hcontainerCanvas;
    
    protected Scene scene;
   
    public File current = new File("exemples/test.ply");
    ExplorerFile ef = new ExplorerFile();
    FileReader fr=new FileReader();
    
    public Stage stage = new Stage();
    UpdateGraph graphe = fr.read(current);
    UpdateGraph u = new UpdateGraph(graphe.getNbFaces(),graphe.getFaces(), graphe.getMatrice(),graphe.getSommetsDeFaces());
    CanvasWriter cw;
    Rotation r;
    Translation t;

    
    @SuppressWarnings("incomplete-switch")
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        ef = new ExplorerFile();
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
					try {
						TV.setRoot(ef.getNodesForDirectory(choice));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
        btreebase.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String pwd = System.getProperty("user.dir");
				System.out.println(pwd+"/exemples");
				File directory = new File(pwd+"/exemples");
				if (directory == null || !directory.isDirectory()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Could not open directory");
					alert.setContentText("The file is invalid.");
					alert.showAndWait();
				} else {
					try {
						TV.setRoot(ef.getNodesForDirectory(directory));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
    	});
        
		fr=new FileReader();
		graphe = fr.read(current);
		cw= new CanvasWriter(canvas,graphe);
        
        baide.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{


			Label secondLabel = new Label("===========================================================================\n"
					+ "Appuiyer sur la touche P pour lancer en cas de bug \n\n"
					+ "Si le modele ne s'affiche pas correctement allez dans source folder -> git -> exemples puis selectionnez le model a afficher\n\n"
					+ "Le bouton reinitialiser (ou w) remet le modele a�son etat de base\n\n"
					+ "La rotation s'effectue aussi avec les touches z q s d\n"
					+ "La translation s'effectue aussi avec les touches t f g h\n"
					+ "\n\n\n"
					+ "");

			StackPane secondaryLayout = new StackPane();
			secondaryLayout.getChildren().add(secondLabel);

			Scene secondScene = new Scene(secondaryLayout, 630, 200);

			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Aide");
			newWindow.setScene(secondScene);

			// Specifies the modality for new window.
			newWindow.initModality(Modality.WINDOW_MODAL);

			newWindow.show();

		});
		
		
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
					cw.changeHomothesie(cw.homothesie-20);
				}
				
			}
		});
		
		bHomomoin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(cw.homothesie<-21) {
					cw.changeHomothesie(cw.homothesie+20);
					}
				else {
					System.out.println("stop");
				}
			}
			
		});
		
		bright1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				t = new Translation(graphe.getMatrice(), -1, 0);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		bleft1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				t = new Translation(graphe.getMatrice(), 1, 0);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		
		btop1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				t = new Translation(graphe.getMatrice(), 0, 1);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});
		
		bbot1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				t = new Translation(graphe.getMatrice(), 0, -1);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
			}
		});

        
        brechargeCanvas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {
				cw.clear(javafx.scene.paint.Color.WHITE);
				fr = new FileReader();
				current=ef.getFile(TV);
				graphe = fr.read(current);
				cw.updateCanvasWriter(graphe);
			}
		});   
        
        Fview.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {
				r = new RotationLeft(graphe.getMatrice(),null); 
				r.rotate(Math.PI/2);
				CanvasWriter ocw= cw;
				CanvasViewer cv = new CanvasViewer();
				try {
					cv.start(new Stage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			//case L:
			//	cw = new CanvasWriter(canvas,fr.read(current));
			//	break;
			
			case P:
				cw.clear(javafx.scene.paint.Color.WHITE);
				fr = new FileReader();
				current=ef.getFile(TV);
				graphe = fr.read(current);
				cw.updateCanvasWriter(graphe);
				break;
			
			case B:
				if(cw.homothesie<0) {
					cw.changeHomothesie(cw.homothesie-20);
				}
				break;
				
			case N:
				if(cw.homothesie<-21) {
					cw.changeHomothesie(cw.homothesie+20);
				}
				break;
			case T:
				t = new Translation(graphe.getMatrice(), 0, 1);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case F:
				t = new Translation(graphe.getMatrice(), 1, 0);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case G:
				t = new Translation(graphe.getMatrice(), 0, -1);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case H:
				t = new Translation(graphe.getMatrice(), -1, 0);
				t.translate();
				graphe = fr.read(current);
				graphe.update(t.getMcourante());
				cw.updateCanvasWriter(graphe);
				break;
			case W:
				graphe = fr.read(current);
				graphe.update(graphe.getMatriceOriginal());
				cw.updateCanvasWriter(graphe);
				break;
			}
			
		});
    }
    

}
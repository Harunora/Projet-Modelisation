package controler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import graph.CanvasWriter;
import graph.FileReader;
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
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Button buttonLoadFolder, btreebase , buttonHelp, buttonRotateUp, buttonRotateRight, buttonRotateLeft, buttonRotateDown, buttonRotateAroundRight, buttonRotateAroundLeft, buttonTranslateUp, buttonTranslateRight, buttonTranslateLeft, buttonTranslateDown, buttonReloadCanvas, buttonHomothetieDown, buttonHomothetieUp, buttonModelData, Fview, Aview ,Sview;
    
    @FXML
    TreeView<File> treeView;
    
    @FXML
    Canvas canvas;
    
    @FXML
    HBox hcontainerCanvas;
    
    protected Scene scene;
   
    public File currentFile = new File("exemples/test.ply");
    ExplorerFile explorerFile = new ExplorerFile();
    FileReader fileReader=new FileReader();
    
    public Stage stage = new Stage();
    UpdateGraph graphe = fileReader.read(currentFile);
    UpdateGraph updateGraphe = new UpdateGraph(graphe.getNbFaces(),graphe.getFaces(), graphe.getMatrice(),graphe.getSommetsDeFaces(), graphe.getAuteur());
    CanvasWriter canvasWriter;
    Rotation rotation;
    Translation translation;

    
    @SuppressWarnings("incomplete-switch")
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        explorerFile = new ExplorerFile();
    	stage.setResizable(true);
    	Scene scene  = Main.getScene();
    	
        buttonLoadFolder.setOnAction(new EventHandler<ActionEvent>() {
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
						treeView.setRoot(explorerFile.getNodesForDirectory(choice));
						updateFile();
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
					try {
						treeView.setRoot(explorerFile.getNodesForDirectory(directory));
						updateFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}

			
    	});
        
		fileReader=new FileReader();
		graphe = fileReader.read(currentFile);
		canvasWriter= new CanvasWriter(canvas,graphe);
        
        buttonHelp.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{


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
		
        
        buttonModelData.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{


			Label secondLabel = new Label("===========================================================================\n"
					+ "Nom du fichier : "+ currentFile.getName() +"\n\n"
					+ "Auteur : "+ graphe.getAuteur() +"\n\n"
					+ "Nombre de Faces : "+ graphe.getNbFaces()+"\n\n"
					+ "Nombre de Sommet par faces : "+ graphe.getNbSommet() +"\n"
					+ "\n\n\n"
					+ "");

			StackPane secondaryLayout = new StackPane();
			secondaryLayout.getChildren().add(secondLabel);

			Scene secondScene = new Scene(secondaryLayout, 630, 200);

			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Info Fichier");
			newWindow.setScene(secondScene);

			// Specifies the modality for new window.
			newWindow.initModality(Modality.WINDOW_MODAL);

			newWindow.show();

		});
		
		buttonRotateRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				rotation = new RotationRight(graphe.getMatrice(),null); 
			    rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
			}
		});
		buttonRotateLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationLeft(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(r.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
			}
		});
		buttonRotateAroundRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationAroundLeft(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(r.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
			}
		});
		
		buttonRotateAroundLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Rotation r = new RotationAroundRight(graphe.getMatrice(),null); 
				r.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(r.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
			}
		});
		buttonRotateUp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				rotation = new RotationUp(graphe.getMatrice(),null); 
				rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
			}
		});
		buttonRotateDown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				rotation = new RotationDown(graphe.getMatrice(),null); 
				rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
			}
		});
		
		buttonHomothetieUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(canvasWriter.homothesie<0) {
					canvasWriter.changeHomothesie(canvasWriter.homothesie-20);
				}
				
			}
		});
		
		buttonHomothetieDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(canvasWriter.homothesie<-21) {
					canvasWriter.changeHomothesie(canvasWriter.homothesie+20);
					}
				else {
					System.out.println("stop");
				}
			}
			
		});
		
		buttonTranslateRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				translateAction(-1,0);
			}
		});
		buttonTranslateLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				translateAction(1,0);
			}
		});
		
		buttonTranslateUp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				translateAction(0,1);
			}
		});
		
		buttonTranslateDown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				translateAction(0,-1);
			}
		});

        
        buttonReloadCanvas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {
				updateFile();
			}
		});   
        
        Fview.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {
				Rotation rotationView = new RotationLeft(graphe.getMatrice(),null); 
				rotationView.rotate(Math.PI/2);
				fileReader=new FileReader();
				graphe = fileReader.read(currentFile);
				StackPane sp1 = new StackPane();
				try {
					CanvasViewer cv = new CanvasViewer(canvasWriter, rotationView, canvasWriter.homothesie, graphe);
					cv.canvasShow(sp1, "Front View");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        Aview.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {
				Rotation rotationView = new RotationUp(graphe.getMatrice(),null); 
				rotationView.rotate(Math.PI/2);
				fileReader=new FileReader();
				graphe = fileReader.read(currentFile);
				StackPane sp1 = new StackPane();
				try {
					CanvasViewer cv = new CanvasViewer(canvasWriter, rotationView, canvasWriter.homothesie, graphe);
					cv.canvasShow(sp1, "Front View");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		 Sview.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				
				public void handle(ActionEvent e) {
					Rotation rotationView = new RotationLeft(graphe.getMatrice(),null); 
					rotationView.rotate(Math.PI);
					fileReader=new FileReader();
					graphe = fileReader.read(currentFile);
					StackPane sp1 = new StackPane();
					try {
						CanvasViewer cv = new CanvasViewer(canvasWriter, rotationView, canvasWriter.homothesie, graphe);
						cv.canvasShow(sp1, "Front View");
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
				rotation = new RotationRight(graphe.getMatrice(),null); 
			    rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
			break;
			case Q:
				rotation = new RotationLeft(graphe.getMatrice(),null); 
			    rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
				break;
			case Z:
				rotation = new RotationUp(graphe.getMatrice(),null); 
			    rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
				break;
			case S:
				rotation = new RotationDown(graphe.getMatrice(),null); 
			    rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
				break;
			case E:
				rotation = new RotationAroundRight(graphe.getMatrice(),null); 
			    rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
				break;
			case A:
				rotation = new RotationAroundLeft(graphe.getMatrice(),null); 
			    rotation.rotate(Math.PI/100);
				graphe = fileReader.read(currentFile);
				graphe.update(rotation.getMcourante());
				canvasWriter.updateCanvasWriter(graphe);
				break;
			case P:
				updateFile();
				break;
			
			case B:
				if(canvasWriter.homothesie<0) {
					canvasWriter.changeHomothesie(canvasWriter.homothesie-20);
				}
				break;
				
			case N:
				if(canvasWriter.homothesie<-21) {
					canvasWriter.changeHomothesie(canvasWriter.homothesie+20);
				}
				break;
			case T:
				translateAction(0,1);
				break;
			case F:
				translateAction(1,0);
				break;
			case G:
				translateAction(0,-1);
				break;
			case H:
				translateAction(-1,0);
				break;
			case W:
				graphe = fileReader.read(currentFile);
				graphe.update(graphe.getMatriceOriginal());
				canvasWriter.updateCanvasWriter(graphe);
				break;
			}
			
		});
    	
    	
    }




	private void translateAction(int x, int y) {
		translation = new Translation(graphe.getMatrice(), x, y);
		translation.translate();
		graphe = fileReader.read(currentFile);
		graphe.update(translation.getMcourante());
		canvasWriter.updateCanvasWriter(graphe);
	}
    
    private void updateFile() {
		canvasWriter.clear(javafx.scene.paint.Color.WHITE);
		fileReader = new FileReader();
		currentFile=explorerFile.getFile(treeView);
		if(currentFile != null && currentFile.isFile()) {
			graphe = fileReader.read(currentFile);
			canvasWriter.updateCanvasWriter(graphe);
		}
	}
    

}
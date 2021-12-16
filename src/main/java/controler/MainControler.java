package controler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import file.ExplorerFile;
import file.UpdateFile;
import graph.CanvasWriter;
import graph.FileReader;
import graph.Matrice;
import graph.UpdateGraph;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import math.Homothetie;
import math.Translation;
import rotation.Rotation;
import rotation.RotationAroundLeft;
import rotation.RotationAroundRight;
import rotation.RotationDown;
import rotation.RotationLeft;
import rotation.RotationRight;
import rotation.RotationUp;

public class MainControler implements Initializable {
    @FXML
    Button buttonLoadFolder, btreebase ,buttonLightZDown,buttonLightZUp,buttonLightUp,buttonLightDown,buttonLightRight,buttonLightLeft,buttonHelp, buttonRotateUp, buttonRotateRight, buttonRotateLeft, buttonRotateDown, buttonRotateAroundRight, buttonRotateAroundLeft, buttonTranslateUp, buttonTranslateRight, buttonTranslateLeft, buttonTranslateDown, buttonReloadCanvas, buttonHomothetieDown, buttonHomothetieUp, buttonModelData, Fview, Aview ,Sview, editCommentaireButton, editAuteurButton;
    
    @FXML
    TreeView<String> treeView;
    
    @FXML
    ColorPicker areteColorPicker,pointColor, faceColor, backgroundColor;
    
    @FXML
    Canvas canvas, canvasTop, canvasDown;
    
    @FXML
    CheckBox checkOmbre,printPoint,printColor,printLine;
    
    @FXML
    HBox hcontainerCanvas;
    
    protected Scene scene;
   
    public File currentFile = new File("exemples/cube.ply");
    private ExplorerFile explorerFile = new ExplorerFile();
    private FileReader fileReader=new FileReader();
    
    public Stage stage = new Stage();
    private UpdateGraph graphe = fileReader.read(currentFile);
    private UpdateGraph grapheTop, grapheDown;
    private CanvasWriter canvasWriterMain, canvasWriterTop, canvasWriterDown;
    private Rotation rotation;
    private Translation translation;
    private Homothetie homothetie;

    
    @SuppressWarnings("incomplete-switch")
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        explorerFile = new ExplorerFile();
    	stage.setResizable(true);
    	Scene scene = Main.getScene();
    	
        buttonLoadFolder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				DirectoryChooser dc = new DirectoryChooser();
				dc.setInitialDirectory(new File(System.getProperty("user.home")));
				File choice = dc.showDialog(stage);
				if (choice == null || !choice.isDirectory()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Could not open directory");
					alert.setContentText("Pas un dossier valide.");
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
		grapheTop = graphe;
		grapheDown = graphe;
		canvasWriterMain= new CanvasWriter(canvas,graphe);
		//canvasWriterTop= new CanvasWriter(canvasTop,graphe.getVueCote());
		//canvasWriterDown= new CanvasWriter(canvasDown,graphe.getVueDessus());
        
        buttonHelp.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{


			Label secondLabel = new Label("===========================================================================\n"
					+ "Appuiyer sur la touche P pour lancer en cas de bug \n\n"
					+ "Si le modele ne s'affiche pas correctement allez dans source folder -> git -> exemples puis selectionnez le model a afficher\n\n"
					+ "Le bouton reinitialiser (ou w) remet le modele a�son etat de base\n\n"
					+ "La rotation s'effectue aussi avec les touches z(haut), q(gauche), s(bas), d(droite), \n"
					+ "             a(droite par rapport au plan 2D), e(gauche par rapport au plan 2D)\n\n"
					+ "La translation s'effectue aussi avec les touches t(haut) f(dgauche) g(bas) h(droite)\n"
					+ "\n"
					+ "Pour agrandir ou reduire le model b(agrandir) et n(reduire) "
					+ "");

			StackPane secondaryLayout = new StackPane();
			secondaryLayout.getChildren().add(secondLabel);

			Scene secondScene = new Scene(secondaryLayout, 750, 250);

			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Aide");
			newWindow.setScene(secondScene);

			// Specifies the modality for new window.
			newWindow.initModality(Modality.WINDOW_MODAL);

			newWindow.show();

		});
        
        editAuteurButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
        	if(currentFile != null && currentFile.isFile()) {
        		UpdateFile updateFile = new UpdateFile(currentFile,fileReader.getLigneAuteur(),fileReader.getLigneCom());
        		TextArea textField = new TextArea();
        		Button validButton = new Button();
        		validButton.setText("Confirmer");
        		textField.setPrefSize(100.0,40.0);
        		textField.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        		validButton.setPrefSize(100.0, 40.0);
        		validButton.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        		StackPane secondaryLayout = new StackPane();
        		HBox hbox = new HBox();
        		hbox.getChildren().add(textField);
        		hbox.getChildren().add(validButton);
        		secondaryLayout.getChildren().add(hbox);
        		/*
        		secondaryLayout.getChildren().add(textField);
        		secondaryLayout.getChildren().add(validButton);
*/
        		Scene secondScene = new Scene(secondaryLayout, 250,80);

        		// New window (Stage)
        		Stage newWindow = new Stage();
        		newWindow.setTitle("Info Auteur");
        		newWindow.setScene(secondScene);

        		// Specifies the modality for new window.
        		newWindow.initModality(Modality.WINDOW_MODAL);

        		newWindow.show();
        		
        		validButton.addEventHandler(MouseEvent.MOUSE_CLICKED, i->{
        			updateFile.remplaceAuteur(fileReader.getLigneAuteur(), textField.getText());
        			newWindow.close();
        		});
        		
        	}
        });
        
        editCommentaireButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
        	if(currentFile != null && currentFile.isFile()) {
        		UpdateFile updateFile = new UpdateFile(currentFile,fileReader.getLigneAuteur(),fileReader.getLigneCom());
        		TextArea textField = new TextArea();
        		Button validButton = new Button();
        		StackPane secondaryLayout = new StackPane();
        		validButton.setText("Confirmer");
        		textField.setPrefSize(100.0,40.0);
        		textField.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        		validButton.setPrefSize(100.0, 40.0);
        		validButton.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        		secondaryLayout.getChildren().add(textField);
        		secondaryLayout.getChildren().add(validButton);

        		Scene secondScene = new Scene(secondaryLayout, 250, 80);

        		// New window (Stage)
        		Stage newWindow = new Stage();
        		newWindow.setTitle("Editer Commentaire");
        		newWindow.setScene(secondScene);

        		// Specifies the modality for new window.
        		newWindow.initModality(Modality.WINDOW_MODAL);

        		newWindow.show();
        		
        		validButton.addEventHandler(MouseEvent.MOUSE_CLICKED, i->{
        			updateFile.remplaceCommentaire(fileReader.getLigneCom(), textField.getText());
        			newWindow.close();
        		});
        		
        	}
        });
		
        
        buttonModelData.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{

        	if(currentFile != null && currentFile.isFile()) {
        		Label secondLabel = new Label("===========================================================================\n"
        				+ "Nom du fichier : "+ currentFile.getName() +"\n\n"
        				+ "Auteur : "+ graphe.getAuteur() + "a la ligne " + fileReader.getLigneAuteur() +"\n\n"
        				+ "Nombre de Faces : "+ graphe.getNbFaces()+"\n\n"
						+ "Nombre de Sommet par faces : "+ graphe.getNbSommet() +"\n\n"
						+ "Autre commentaire : "+ fileReader.getCommentaire()+ "a la ligne " + fileReader.getLigneCom()+"\n\n"
						+ "\n\n\n"
						+ "");

        		StackPane secondaryLayout = new StackPane();
        		secondaryLayout.getChildren().add(secondLabel);

        		Scene secondScene = new Scene(secondaryLayout, 1000, 400);

        		// New window (Stage)
        		Stage newWindow = new Stage();
        		newWindow.setTitle("Info Fichier");
        		newWindow.setScene(secondScene);

        		// Specifies the modality for new window.
        		newWindow.initModality(Modality.WINDOW_MODAL);

        		newWindow.show();
        	}
		});
		
		buttonRotateRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					rotateRight();
				}
			}
		});
		buttonRotateLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					rotationLeft();
				}
			}
		});
		buttonRotateAroundRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					rotationAroundLeft();
					
				}
			}
		});
		
		buttonRotateAroundLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					rotationAroundLeft();
				}
			}
		});
		buttonRotateUp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					rotationUp();
				}
			}
		});
		buttonRotateDown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					rotationDown(); 
				}
			}
		});
		
		buttonHomothetieUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(canvasWriterMain.homothesie<0) {
					homothetieAction(5);
				}
				
			}
		});
		
		buttonHomothetieDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(canvasWriterMain.homothesie<-21) {
					homothetieAction(-5);
					}
				else {
					System.out.println("stop");
				}
			}
			
		});
		
		buttonTranslateRight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					translateAction(0.9,0.0,0.0);
				}	
			}
		});
		buttonTranslateLeft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					translateAction(1.1,0.0,0.0);
				}
			}
		});
		
		buttonTranslateUp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					translateAction(0.0,1.1,0.0);
				}	
			}
		});
		
		buttonTranslateDown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(currentFile != null && currentFile.isFile()) {
					translateAction(0.0,0.9,0.0);
				}
			}
		});
        
        buttonReloadCanvas.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				updateFile();
			}
		});   
        
        printLine.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				canvasWriterMain.printLine(printLine.isSelected());
				canvasWriterMain.update(graphe);
				canvasWriterTop.printLine(printLine.isSelected());
				canvasWriterTop.update(graphe);
				canvasWriterDown.printLine(printLine.isSelected());
				canvasWriterDown.update(graphe);
			}
		});   
        
        printColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				canvasWriterMain.printColor(printColor.isSelected());
				canvasWriterMain.update(graphe);
				canvasWriterTop.printColor(printColor.isSelected());
				canvasWriterTop.update(graphe);
				canvasWriterDown.printColor(printColor.isSelected());
				canvasWriterDown.update(graphe);
			}
		});
        
        printPoint.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				canvasWriterMain.printPoint(printPoint.isSelected());
				canvasWriterMain.update(graphe);
				canvasWriterTop.printPoint(printPoint.isSelected());
				canvasWriterTop.update(graphe);
				canvasWriterDown.printPoint(printPoint.isSelected());
				canvasWriterDown.update(graphe);
			}
		});
        
        faceColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				graphe.setColor(faceColor.getValue());
			}
		});
        
        pointColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				canvasWriterMain.setPointColor(pointColor.getValue());
				canvasWriterTop.setPointColor(pointColor.getValue());
				canvasWriterDown.setPointColor(pointColor.getValue());
			}
		});
        
        backgroundColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				canvasWriterMain.setBackgroundColor(backgroundColor.getValue());
				canvasWriterTop.setBackgroundColor(backgroundColor.getValue());
				canvasWriterDown.setBackgroundColor(backgroundColor.getValue());
			}
		});
        
        areteColorPicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				canvasWriterMain.setLineColor(areteColorPicker.getValue());
				canvasWriterTop.setLineColor(areteColorPicker.getValue());
				canvasWriterDown.setLineColor(areteColorPicker.getValue());
			}
		});
        
        checkOmbre.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				graphe.ombrage(checkOmbre.isSelected());
			}
		});
        
        buttonLightUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				graphe.modifierLumiere(0, 1, 0);
			}
		}); 
        
        buttonLightDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				graphe.modifierLumiere(0, -1, 0);
			}
		});  
        
        buttonLightRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				graphe.modifierLumiere(-1, 0, 0);
			}
		});  
        
        buttonLightLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				graphe.modifierLumiere(1, 0, 0);
			}
		});  
        
        buttonLightZUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				graphe.modifierLumiere(0, 0, 1);
			}
		}); 
        
        buttonLightZDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent e) {
				graphe.modifierLumiere(0, 0, -1);
			}
		});}
        
       
    
    @SuppressWarnings("incomplete-switch")
	public void setScene (Scene s) {
    	s.setOnKeyPressed(e->{
			switch(e.getCode()){
			case D:
				rotateRight();
			break;
			case Q:
				rotationLeft();
				break;
			case Z:
				rotationUp();
				break;
			case S:
				rotationDown();
				break;
			case E:
				rotationAroundRight();
				break;
			case A:
				rotationAroundLeft();
				break;
			case P:
				updateFile();
				break;
			case B:
				if(canvasWriterMain.homothesie<0) {
					homothetieAction(1.2);
				}
				break;
				
			case N:
				if(canvasWriterMain.homothesie<-21) {
					homothetieAction(0.8);
				}
				break;
			case T:
				translateAction(0.0,1.1,0.0);
				break;
			case F:
				translateAction(1.1,0.0,0.0);
				break;
			case G:
				translateAction(0.0,0.9,0.0);
				break;
			case H:
				translateAction(0.9,0.0,0.0);
				break;
			case W:
				graphe = fileReader.read(currentFile);
				graphe.attach(canvasWriterMain);
				graphe.attach(canvasWriterTop);
				graphe.attach(canvasWriterDown);
				graphe.update(graphe.getMatriceOriginal());
				break;
			}			
		});
    	
    }

	private void rotateRight() {
		rotation = new RotationRight(graphe.getMatrice(),null); 
		rotation.rotate(Math.PI/100);
		graphe.update(rotation.getMcourante());
	}

	private void rotationLeft() {
		rotation = new RotationLeft(graphe.getMatrice(),null); 
		rotation.rotate(Math.PI/100);
		graphe.update(rotation.getMcourante());
	}

	private void rotationDown() {
		rotation = new RotationDown(graphe.getMatrice(),null); 
		rotation.rotate(Math.PI/100);
		graphe.update(rotation.getMcourante());
	}
	
	private void rotationUp() {
		rotation = new RotationUp(graphe.getMatrice(),null); 
		rotation.rotate(Math.PI/100);	
		graphe.update(rotation.getMcourante());
	}
	
	private void rotationAroundLeft() {
		rotation = new RotationAroundLeft(graphe.getMatrice(),null); 
		rotation.rotate(Math.PI/100);
		graphe.update(rotation.getMcourante());
	}
	
	private void rotationAroundRight() {
		rotation = new RotationAroundRight(graphe.getMatrice(),null); 
		rotation.rotate(Math.PI/100);		
		graphe.update(rotation.getMcourante());
	}

	private void translateAction(double x, double y, double z) {
		translation = new Translation(graphe.getMatrice());
		System.out.println("avant : " + translation.getMcourante().getX(0));
		translation.translate(x, y, z);
		graphe.update(translation.getMcourante());
		System.out.println("apres : " + translation.getMcourante().getX(0));

	}
	
	private void homothetieAction(double k) {
		homothetie = new Homothetie(graphe.getMatrice());
		homothetie.homothetate(k);
		graphe.update(homothetie.getMcourante());
	}
    
    private void updateFile() {
		canvasWriterMain.clear(javafx.scene.paint.Color.WHITE);
		//canvasWriterTop.clear(javafx.scene.paint.Color.WHITE);
		//canvasWriterDown.clear(javafx.scene.paint.Color.WHITE);
		fileReader = new FileReader();
		currentFile=explorerFile.getFile(treeView);
		if(currentFile != null && currentFile.isFile()) {
			graphe = fileReader.read(currentFile);
			//grapheTop = graphe.getVueCote();
			//grapheDown = graphe.getVueDessus();
			canvasWriterMain.update(graphe);
			graphe.attach(canvasWriterMain);
			grapheDown.attach(canvasWriterDown);
			grapheTop.attach(canvasWriterTop);
			//canvasWriterTop.update(graphe.getVueCote());
			//canvasWriterDown.update(graphe.getVueDessus());
		}
	}
    

}
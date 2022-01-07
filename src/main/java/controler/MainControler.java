package controler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import file.ExplorerFile;
import file.UpdateFile;
import graph.CanvasWriter;
import graph.FileReader;
import graph.Matrix;
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
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import math.Homothety;
import math.Translation;
import rotation.Mouvement;
import rotation.RotationAroundLeft;
import rotation.RotationAroundRight;
import rotation.RotationDown;
import rotation.RotationLeft;
import rotation.RotationRight;
import rotation.RotationUp;

/**
 * The Class MainControler.
 * 
 * @author Matheo, Christopher, Julien
 */
public class MainControler implements Initializable {

	/** The edit auteur button. */
	@FXML
	Button buttonLoadFolder, bTreeBase ,buttonLightZDown,buttonLightZUp,buttonLightUp,buttonLightDown,buttonLightRight,buttonLightLeft,buttonHelp, buttonRotateUp, buttonRotateRight, buttonRotateLeft, buttonRotateDown, buttonRotateAroundRight, buttonRotateAroundLeft, buttonTranslateUp, buttonTranslateRight, buttonTranslateLeft, buttonTranslateDown, buttonReloadCanvas, buttonHomothetieDown, buttonHomothetieUp, buttonModelData, frontView, aView ,sideView, editCommentaireButton, editAuteurButton;

	/** The tree view. */
	@FXML
	TreeView<String> treeView;

	/** The background color. */
	@FXML
	ColorPicker areteColorPicker,pointColor, faceColor, backgroundColor;

	/** The canvas down. */
	@FXML
	Canvas canvas, canvasTop, canvasDown;

	/** The print line. */
	@FXML
	CheckBox checkOmbre,printPoint,printColor,printLine;

	/** The hcontainer canvas. */
	@FXML
	HBox hcontainerCanvas;

	/** The scene. */
	protected Scene scene;

	/** The current file. */
	public File currentFile = new File("exemples/cube.ply");
	public File defaultFile = new File("exemples/apple.ply");


	/** The explorer file. */
	private ExplorerFile explorerFile = new ExplorerFile();

	/** The file reader. */
	private FileReader fileReader=new FileReader();

	/** The stage. */
	public Stage stage = new Stage();

	/** The graphe. */
	private UpdateGraph graphe = fileReader.read(currentFile);

	/** The canvas writer down. */
	private CanvasWriter canvasWriterMain, canvasWriterTop, canvasWriterDown;

	/** The rotation. */
	private Mouvement rotation;

	/** The translation. */
	private Translation translation;

	/** The homothetie. */
	private Homothety homothetie;


	/**
	 * Initialize.
	 *
	 * @param location the location
	 * @param resources the resources
	 */
	@SuppressWarnings("incomplete-switch")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		explorerFile = new ExplorerFile();
		stage.setResizable(true);
		Scene scene = Main.getScene();

		buttonLoadFolder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DirectoryChooser directory = new DirectoryChooser();
				directory.setInitialDirectory(new File(System.getProperty("user.home")));
				File choice = directory.showDialog(stage);
				if (choice == null || !choice.isDirectory()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Could not open directory");
					alert.setContentText("Pas un dossier valide.");
					alert.showAndWait();
				} else {
					try {
						treeView.setRoot(explorerFile.getNodesForDirectory(choice));
						updateFile();
					} catch (IOException exception) {
						// TODO Auto-generated catch block
						exception.printStackTrace();
					}
				}

			}

		});
		bTreeBase.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String pwd = System.getProperty("user.dir");
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
		UpdateGraph grapheTmp = graphe; 

		Matrix matrix = new RotationUp(graphe.getMatrix(),null).mouvement(Math.PI);
		graphe.update(matrix);
		UpdateGraph grapheTop = graphe;
		graphe = grapheTmp;
		canvasWriterTop= new CanvasWriter(canvasTop,grapheTop);
		matrix = new RotationLeft(graphe.getMatrix(),null).mouvement(Math.PI);
		graphe.update(matrix);
		UpdateGraph grapheSide = graphe;
		graphe = grapheTmp;
		canvasWriterDown= new CanvasWriter(canvasDown,grapheSide);
		canvasWriterMain= new CanvasWriter(canvas,graphe);

		buttonHelp.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{


			Label secondLabel = new Label("===========================================================================\n"
					+ "Appuiyer sur la touche P pour lancer en cas de bug \n\n"
					+ "Si le modele ne s'affiche pas correctement allez dans source folder -> git -> exemples puis selectionnez le model a afficher\n\n"
					+ "Le bouton reinitialiser (ou w) remet le modele a�son etat de base\n\n"
					+ "La rotation s'effectue aussi avec les touches z(haut), q(gauche), s(bas), d(droite), \n"
					+ "             a(droite par rapport au plan 2D), e(gauche par rapport au plan 2D)\n\n"
					+ "La translation s'effectue aussi avec les touches t(haut) f(dgauche) g(bas) h(droite)\n"
					+ "\n"
					+ "Pour agrandir ou reduire le model b(agrandir) et n(reduire) ");

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
				UpdateFile updateFile = new UpdateFile(currentFile,fileReader.getAuthorLine(),fileReader.getCommentLine());
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
					updateFile.remplaceAuteur(fileReader.getAuthorLine(), textField.getText());
					newWindow.close();
				});

			}
		});

		editCommentaireButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
			if(currentFile != null && currentFile.isFile()) {
				UpdateFile updateFile = new UpdateFile(currentFile,fileReader.getAuthorLine(),fileReader.getCommentLine());
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

				Scene secondScene = new Scene(secondaryLayout, 250, 80);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Editer Commentaire");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				newWindow.show();

				validButton.addEventHandler(MouseEvent.MOUSE_CLICKED, i->{
					updateFile.remplaceCommentaire(fileReader.getCommentLine(), textField.getText());
					newWindow.close();
				});

			}
		});


		buttonModelData.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{

			if(currentFile != null && currentFile.isFile()) {
				Label secondLabel = new Label("===========================================================================\n"
						+ "Nom du fichier : "+ currentFile.getName() +"\n\n"
						+ "Auteur : "+ graphe.getAuthor() + "a la ligne " + fileReader.getAuthorLine() +"\n\n"
						+ "Nombre de Faces : "+ graphe.getNbFaces()+"\n\n"
						+ "Nombre de Sommet par faces : "+ graphe.getNbVertex() +"\n\n"
						+ "Autre commentaire : "+ fileReader.getComment()+ "a la ligne " + fileReader.getCommentLine()+"\n\n"
						+ "\n\n\n");

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
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					rotationRight();
				}
			}
		});
		buttonRotateLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					rotationLeft();
				}
			}
		});
		buttonRotateAroundRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					rotationAroundLeft();

				}
			}
		});

		buttonRotateAroundLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					rotationAroundLeft();
				}
			}
		});
		buttonRotateUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					rotationUp();
				}
			}
		});
		buttonRotateDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					rotationDown(); 
				}
			}
		});

		buttonHomothetieUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				homothetieAction(5);
			}
		});

		buttonHomothetieDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent envent) {
				homothetieAction(-5);
			}

		});

		buttonTranslateRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					translateAction(0.5,0.0,0.0);
				}	
			}
		});
		buttonTranslateLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					translateAction(-0.5,0.0,0.0);
				}
			}
		});

		buttonTranslateUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {	
					translateAction(0.0,-0.5,0.0);
				}	
			}
		});

		buttonTranslateDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(currentFile != null && currentFile.isFile()) {
					translateAction(0.0,0.5,0.0);
				}
			}
		});

		buttonReloadCanvas.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				updateFile();
			}
		});   

		printLine.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
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
			public void handle(ActionEvent event) {
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
			public void handle(ActionEvent event) {
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
			public void handle(ActionEvent event) {
				graphe.setColor(faceColor.getValue());
			}
		});

		pointColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				canvasWriterMain.setPointColor(pointColor.getValue());
				canvasWriterTop.setPointColor(pointColor.getValue());
				canvasWriterDown.setPointColor(pointColor.getValue());
			}
		});

		backgroundColor.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				canvasWriterMain.setBackgroundColor(backgroundColor.getValue());
				canvasWriterTop.setBackgroundColor(backgroundColor.getValue());
				canvasWriterDown.setBackgroundColor(backgroundColor.getValue());
			}
		});

		areteColorPicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				canvasWriterMain.setLineColor(areteColorPicker.getValue());
				canvasWriterTop.setLineColor(areteColorPicker.getValue());
				canvasWriterDown.setLineColor(areteColorPicker.getValue());
			}
		});

		checkOmbre.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				graphe.umbrage(checkOmbre.isSelected());
			}
		});

		buttonLightUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				graphe.updateLight(0, -1, 0);
			}
		}); 

		buttonLightDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				graphe.updateLight(0, 1, 0);
			}
		});  

		buttonLightRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				graphe.updateLight(1, 0, 0);
			}
		});  

		buttonLightLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				graphe.updateLight(-1, 0, 0);
			}
		});  

		buttonLightZUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				graphe.updateLight(0, 0, 1);
			}
		}); 

		buttonLightZDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override	
			public void handle(ActionEvent event) {
				graphe.updateLight(0, 0, -1);
			}
		});}



	/**
	 * Sets the scene.
	 *
	 * @param scene the new scene
	 */
	@SuppressWarnings("incomplete-switch")
	public void setScene (Scene scene) {
		scene.setOnKeyPressed(e->{
			switch(e.getCode()){
			case D:
				rotationRight();
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
				homothetieAction(1.2);
				break;
			case N:
				homothetieAction(0.8);
				break;
			case T:
				translateAction(0.0,-0.5,0.0);
				break;
			case F:
				translateAction(-0.5,0.0,0.0);
				break;
			case G:
				translateAction(0.0,0.5,0.0);
				break;
			case H:
				translateAction(0.5,0.0,0.0);
				break;
			case W:
				graphe = fileReader.read(currentFile);
				graphe.attach(canvasWriterMain);
				//graphe.attach(canvasWriterTop);
				//graphe.attach(canvasWriterDown);
				graphe.update(graphe.getOriginalMatrix());
				break;
			}			
		});

	}

	/**
	 * Rotate right.
	 */
	private void rotationLeft() {
		rotation = new RotationRight(graphe.getMatrix(),null); 
		rotation.mouvement(Math.PI/100);
		graphe.update(rotation.getCurrentMatrix());
	}

	/**
	 * Rotation left.
	 */
	private void rotationRight() {
		rotation = new RotationLeft(graphe.getMatrix(),null); 
		rotation.mouvement(Math.PI/100);
		graphe.update(rotation.getCurrentMatrix());
	}

	/**
	 * Rotation down.
	 */
	private void rotationUp() {
		rotation = new RotationDown(graphe.getMatrix(),null); 
		rotation.mouvement(Math.PI/100);
		graphe.update(rotation.getCurrentMatrix());
	}

	/**
	 * Rotation up.
	 */
	private void rotationDown() {
		rotation = new RotationUp(graphe.getMatrix(),null); 
		rotation.mouvement(Math.PI/100);	
		graphe.update(rotation.getCurrentMatrix());
	}

	/**
	 * Rotation around left.
	 */
	private void rotationAroundLeft() {
		rotation = new RotationAroundLeft(graphe.getMatrix(),null); 
		rotation.mouvement(Math.PI/-100);
		graphe.update(rotation.getCurrentMatrix());
	}

	/**
	 * Rotation around right.
	 */
	private void rotationAroundRight() {
		rotation = new RotationAroundRight(graphe.getMatrix(),null); 
		rotation.mouvement(Math.PI/100);		
		graphe.update(rotation.getCurrentMatrix());
	}

	/**
	 * Translate action.
	 *
	 * @param xCoordinate the x
	 * @param yCoordinate the y
	 * @param zCoordinate the z
	 */
	private void translateAction(double xCoordinate, double yCoordinate, double zCoordinate) {
		translation = new Translation(graphe.getMatrix());
		translation.translate(new Matrix(1, xCoordinate , yCoordinate, zCoordinate ,1.0));
		graphe.update(translation.getMcourante());

	}

	/**
	 * Homothetie action.
	 *
	 * @param coef the k
	 */
	private void homothetieAction(double coef) {
		homothetie = new Homothety(graphe.getMatrix());
		homothetie.mouvement(coef);
		graphe.update(homothetie.getCurrentMatrix());
	}

	/**
	 * Update file.
	 */
	private void updateFile() {
		canvasWriterMain.clear(javafx.scene.paint.Color.WHITE);
		canvasWriterTop.clear(javafx.scene.paint.Color.WHITE);
		canvasWriterDown.clear(javafx.scene.paint.Color.WHITE);
		fileReader = new FileReader();
		currentFile=explorerFile.getFile(treeView);
		if(currentFile != null && currentFile.isFile()) {
			graphe = fileReader.read(currentFile);		

			UpdateGraph grapheTmp = graphe; 

			Matrix matrix = new RotationUp(graphe.getMatrix(),null).mouvement(Math.PI);
			graphe.update(matrix);
			UpdateGraph grapheTop = graphe;
			graphe = grapheTmp;
			canvasWriterTop= new CanvasWriter(canvasTop,grapheTop);
			matrix = new RotationLeft(graphe.getMatrix(),null).mouvement(Math.PI);
			graphe.update(matrix);
			UpdateGraph grapheSide = graphe;
			graphe = grapheTmp;
			canvasWriterDown= new CanvasWriter(canvasDown,grapheSide);
			canvasWriterMain.update(graphe);
			graphe.attach(canvasWriterMain);
		}
	}


}
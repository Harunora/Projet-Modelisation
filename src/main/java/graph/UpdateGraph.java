package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javafx.scene.paint.Color;
import math.CalculColor;


/**
 * The Class UpdateGraph.
 */
public class UpdateGraph extends Graph{


	/** The sommets. */
	private List<Vertex> sommets = new ArrayList<Vertex>();
	
	/** The has set color. */
	private boolean hasSetColor;
	
	/** The d. */
	private int number,vertexA,vertexB,vertexC,vertexD;
	
	/** The lumiere. */
	Matrix lumiere = new Matrix(1,1,1,1,1);
	
	/** The calcul color. */
	private CalculColor calculColor = new CalculColor(lumiere,this.color);
	
	/** The original. */
	private Graph original;
	
	/** The calcule lumiere. */
	protected boolean calculeLumiere = true;

	
	/**
	 * Instantiates a new update graph.
	 *
	 * @param nbFace the nb face
	 * @param faces the faces
	 * @param matrice the matrice
	 * @param sommetDeFaces the sommet de faces
	 * @param auteur the auteur
	 */
	public UpdateGraph(int nbFace, List<Face> faces, Matrix matrice, List<String> sommetDeFaces, String auteur) {
		super(nbFace, faces, matrice, sommetDeFaces, auteur);
		this.original=new Graph(nbFace, faces, matrice, sommetDeFaces, auteur);
	}
	
	/**
	 * Update.
	 *
	 * @param matrix the ma
	 */
	public void update(Matrix matrix) {
		this.faces=this.original.faces;
		this.matrix=this.original.matrix;
		this.listOfFaces=this.original.listOfFaces;
		matrix = matrix;
		faces.clear();
		sommets.clear();
		for(int i = 0; i<matrix.getLength(); i++) {
			sommets.add(new Vertex(matrix.getX(i),matrix.getY(i),matrix.getZ(i)));
		}
		readFace();	
		notifyObserver();
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(javafx.scene.paint.Color color) {
		hasSetColor = true;
		this.color = color;
		for(int index = 0; index< this.nbFaces; index++) {
			setFaceColor(index, color);
		}
	}

	/**
	 * Read face.
	 */
	private void readFace() {
		for(int i = 0; i<nbFaces; i++) {
			readNbFace(i);
		}
	}

	/**
	 * Read nb face.
	 *
	 * @param index the i
	 */
	private void readNbFace(int index) {
		StringTokenizer lineToken = new StringTokenizer(listOfFaces.get(index));
		number = Integer.parseInt(lineToken.nextToken());
		vertexA = Integer.parseInt(lineToken.nextToken());
		vertexB = Integer.parseInt(lineToken.nextToken());
		vertexC = Integer.parseInt(lineToken.nextToken());
		if(number==4) {
			vertexD = Integer.parseInt(lineToken.nextToken());			
		}
		List<Vertex> tmp = new ArrayList<Vertex>();
		addListSommet(tmp);
		Face faceTmp = new Face(number, tmp, color);
		Color colorTmp = color;
		if(calculeLumiere){
			colorTmp=calculColor.getColor(faceTmp);
		}
		faceTmp = new Face(number, tmp, colorTmp);
		//System.out.println("couleur ombre " + colorTmp);
		//System.out.println("couleur globale : " + color);
		faces.add(faceTmp);

	}
	/*

    public UpdateGraph getVueDessus() {
        Matrice rotationTop = new RotationUp(this.getMatrice(), null).rotate(Math.PI/2.0);
        UpdateGraph tmp = this.update(rotationTop);
        return retour;
    }
	
	public UpdateGraph getVueCote() {
        Matrice rotationSide = new RotationLeft(this.getMatrice(), null).rotate(Math.PI/2.0);
        UpdateGraph retour= new UpdateGraph(nb, faces, rotationSide, sommetsDeFaces, auteur);
        return retour;
    }
    */
	
	/**
	 * Ombrage.
	 *
	 * @param value the value
	 */
	public void ombrage(boolean value) {
		this.calculeLumiere=value;
		update(matrix);
	}

	/**
	 * Adds the list sommet.
	 *
	 * @param tmp the tmp
	 */
	private void addListSommet(List<Vertex> tmp) {
		tmp.add(sommets.get(vertexA));
		tmp.add(sommets.get(vertexB));
		tmp.add(sommets.get(vertexC));
		if(number == 4) {
			tmp.add(sommets.get(vertexD));			
		}
	}
	
	/**
	 * Modifier lumiere.
	 *
	 * @param xCoordinate the x
	 * @param yCoordinate the y
	 * @param zCoordinate the z
	 */
	public void modifierLumiere(int xCoordinate,int yCoordinate,int zCoordinate) {
		lumiere.changeXCoordinate(0, xCoordinate);
		lumiere.changeYCoordinate(0, yCoordinate);
		lumiere.changeZCoordinate(0, zCoordinate);
		calculColor = new CalculColor(lumiere,this.color);
		update(matrix);
	}
}

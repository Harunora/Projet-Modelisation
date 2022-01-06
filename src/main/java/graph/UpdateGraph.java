package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javafx.scene.paint.Color;
import math.CalculColor;


/**
 * The Class UpdateGraph.
 * 
 * @author matheo
 */
public class UpdateGraph extends Graph{


	/** The list of vertices */
	private List<Vertex> vertices = new ArrayList<Vertex>();
	
	/** the number of vertices and all the vertices coordinate */
	private int numberOfVertices,vertexA,vertexB,vertexC,vertexD;
	
	/** The light . */
	Matrix light = new Matrix(1,1,1,1,1);
	
	/** The calcul color. */
	private CalculColor calculColor = new CalculColor(light,this.color);
	
	/** The orignal graph  */
	private Graph original;
	
	/** if the light is calculed. */
	protected boolean lightCalcul = true;

	
	/**
	 * Instantiates a new update graph.
	 *
	 * @param nbFaces the amount of faces
	 * @param faces the list of faces
	 * @param matrix the matrix
	 * @param listOfFaces the list of faces (String)
	 * @param author the author
	 */
	public UpdateGraph(int nbFaces, List<Face> faces, Matrix matrix, List<String> listOfFaces, String author) {
		super(nbFaces, faces, matrix, listOfFaces, author);
		this.original=new Graph(nbFaces, faces, matrix, listOfFaces, author);
	}
	
	/**
	 * Update the graph with a new matrix
	 *
	 * @param matrix the new matrix
	 */
	public void update(Matrix matrix) {
		this.faces=this.original.faces;
		this.matrix=this.original.matrix;
		this.listOfFaces=this.original.listOfFaces;
		this.matrix = matrix;
		faces.clear();
		vertices.clear();
		for(int i = 0; i<matrix.getLength(); i++) {
			vertices.add(new Vertex(matrix.getX(i),matrix.getY(i),matrix.getZ(i)));
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
		this.color = color;
		for(int index = 0; index< this.nbFaces; index++) {
			setFaceColor(index, color);
		}
	}

	/**
	 * Read face.
	 */
	private void readFace() {
		for(int index = 0; index<nbFaces; index++) {
			readNbFace(index);
		}
	}

	/**
	 * Read the amount of faces
	 *
	 * @param index the index in the list of Faces (String)
	 */
	private void readNbFace(int index) {
		StringTokenizer lineToken = new StringTokenizer(listOfFaces.get(index));
		numberOfVertices = Integer.parseInt(lineToken.nextToken());
		vertexA = Integer.parseInt(lineToken.nextToken());
		vertexB = Integer.parseInt(lineToken.nextToken());
		vertexC = Integer.parseInt(lineToken.nextToken());
		if(numberOfVertices==4) {
			vertexD = Integer.parseInt(lineToken.nextToken());			
		}
		List<Vertex> verticesListTmp = new ArrayList<Vertex>();
		addListVertex(verticesListTmp);
		Face faceTmp = new Face(numberOfVertices, verticesListTmp, color);
		Color colorTmp = color;
		if(lightCalcul){
			colorTmp=calculColor.getColor(faceTmp);
		}
		faceTmp = new Face(numberOfVertices, verticesListTmp, colorTmp);
		faces.add(faceTmp);
	}
	
	/**
	 * Ombrage.
	 *
	 * @param value the value
	 */
	public void umbrage(boolean value) {
		this.lightCalcul=value;
		update(matrix);
	}

	/**
	 * Adds the list vertex.
	 *
	 * @param tmp the temporal list of Vertex
	 */
	private void addListVertex(List<Vertex> tmp) {
		tmp.add(vertices.get(vertexA));
		tmp.add(vertices.get(vertexB));
		tmp.add(vertices.get(vertexC));
		if(numberOfVertices == 4) {
			tmp.add(vertices.get(vertexD));			
		}
	}
	
	/**
	 * update the light.
	 *
	 * @param xCoordinate the x
	 * @param yCoordinate the y
	 * @param zCoordinate the z
	 */
	public void updateLight(int xCoordinate,int yCoordinate,int zCoordinate) {
		light.changeXCoordinate(0, xCoordinate);
		light.changeYCoordinate(0, yCoordinate);
		light.changeZCoordinate(0, zCoordinate);
		calculColor = new CalculColor(light,this.color);
		update(matrix);
	}
}

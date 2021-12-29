package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;
import math.CalculColor;
import rotation.RotationLeft;
import rotation.RotationUp;

/**
 * The Class UpdateGraph.
 */
public class UpdateGraph extends Graph{


	/** The sommets. */
	private List<Sommet> sommets = new ArrayList<Sommet>();
	
	/** The has set color. */
	private boolean hasSetColor;
	
	/** The d. */
	private int nb,a,b,c,d;
	
	/** The lumiere. */
	Matrice lumiere = new Matrice(1,1,1,1,1,1);
	
	/** The calcul color. */
	private CalculColor calculColor = new CalculColor(lumiere,this.color);
	
	/** The original. */
	private Graph original;
	
	/** The calcule lumiere. */
	protected boolean calculeLumiere = true;

	protected Graph graph1, graph2;

	
	/**
	 * Instantiates a new update graph.
	 *
	 * @param nbFace the nb face
	 * @param faces the faces
	 * @param matrice the matrice
	 * @param sommetDeFaces the sommet de faces
	 * @param auteur the auteur
	 */
	public UpdateGraph(int nbFace, List<Face> faces, Matrice matrice, List<String> sommetDeFaces, String auteur) {
		super(nbFace, faces, matrice, sommetDeFaces, auteur);
		this.original=new Graph(nbFace, faces, matrice, sommetDeFaces, auteur);
		this.graph1 = new Graph(nbFace, faces, matrice, sommetDeFaces, auteur);
		this.graph2 = new Graph(nbFace, faces, matrice, sommetDeFaces, auteur);
	}
	
	public UpdateGraph(Graph graph) {
		super(graph.nbFaces, graph.faces, graph.matrice, graph.sommetsDeFaces, graph.auteur);
		this.original = new Graph(graph.nbFaces, graph.faces, graph.matrice, graph.sommetsDeFaces, graph.auteur);
		this.graph1 = new Graph(graph.nbFaces, graph.faces, graph.matrice, graph.sommetsDeFaces, graph.auteur);
		this.graph2 = new Graph(graph.nbFaces, graph.faces, graph.matrice, graph.sommetsDeFaces, graph.auteur);
	}
	
	/**
	 * Update.
	 *
	 * @param ma the ma
	 */
	public void update(Matrice ma) {
		this.faces=this.original.faces;
		this.matrice=this.original.matrice;
		this.sommetsDeFaces=this.original.sommetsDeFaces;
		matrice = ma;
		faces.clear();
		sommets.clear();
		for(int i = 0; i<matrice.getTaille(); i++) {
			sommets.add(new Sommet(matrice.getX(i),matrice.getY(i),matrice.getZ(i)));
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
		for(int i = 0; i< this.nbFaces; i++) {
			faces.get(i).setColor(this.color);
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
	 * @param i the i
	 */
	private void readNbFace(int i) {
		StringTokenizer lineToken = new StringTokenizer(sommetsDeFaces.get(i));
		nb = Integer.parseInt(lineToken.nextToken());
		a = Integer.parseInt(lineToken.nextToken());
		b = Integer.parseInt(lineToken.nextToken());
		c = Integer.parseInt(lineToken.nextToken());
		if(nb==4) {
			d = Integer.parseInt(lineToken.nextToken());			
		}
		List<Sommet> tmp = new ArrayList<Sommet>();
		addListSommet(tmp);
		Face faceTmp = new Face(nb, tmp, color);
		Color colorTmp = color;
		if(calculeLumiere){
			colorTmp=calculColor.getColor(faceTmp);
		}
		faceTmp = new Face(nb, tmp, colorTmp);
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
		update(matrice);
	}

	/**
	 * Adds the list sommet.
	 *
	 * @param tmp the tmp
	 */
	private void addListSommet(List<Sommet> tmp) {
		tmp.add(sommets.get(a));
		tmp.add(sommets.get(b));
		tmp.add(sommets.get(c));
		if(nb == 4) {
			tmp.add(sommets.get(d));			
		}
	}
	
	/**
	 * Modifier lumiere.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public void modifierLumiere(int x,int y,int z) {
		lumiere.modifieX(0, x);
		lumiere.modifieY(0, y);
		lumiere.modifieZ(0, z);
		calculColor = new CalculColor(lumiere,this.color);
		update(matrice);
	}
	
	public Graph getGraphDown() {
		return this.graph1;
	}
	
	public Graph getGraphSide() {
		return this.graph2;
	}
	
	public void setGraphDown(UpdateGraph graph) {
		this.graph1 = graph;
	}
	
	public void setGraphSide(UpdateGraph graph) {
		this.graph2 = graph;
	}
}

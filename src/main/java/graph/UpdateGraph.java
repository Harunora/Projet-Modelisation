package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import math.CalculColor;

public class UpdateGraph extends Graph{


	private List<Sommet> sommets = new ArrayList<Sommet>();
	protected int nb,a,b,c,d,r,g,bl;
	Matrice lumiere = new Matrice(1,1,1,1,1,1);
	private CalculColor calculColor = new CalculColor(lumiere,this.color);



	public UpdateGraph(int nbFace, List<Face> faces, Matrice matrice, List<String> sommetDeFaces, String auteur) {
		super(nbFace, faces, matrice, sommetDeFaces, auteur);

	}
	public void update(Matrice ma) {
		matrice = ma;
		faces.clear();
		for(int i = 0; i<matrice.taille; i++) {
			sommets.add(new Sommet(matrice.getX(i),matrice.getY(i),matrice.getZ(i)));
		}
		readFace();	

	}
	
	public void setColor(javafx.scene.paint.Color color) {
		System.out.println("entre dans l'autre");
		double r = color.getRed()*255;
		double g = color.getGreen()*255;
		double b = color.getBlue()*255;
		this.color = new Color(r,g,b);
		for(int i = 0; i< this.nbFaces; i++) {
			faces.get(i).setColor(this.color);
		}
	}

	private void readFace() {
		for(int i = 0; i<nbFaces; i++) {
			readNbFace(i);
		}
	}

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
		//Color colorTmp = calculColor.getColor(faceTmp);
		//faceTmp = new Face(nb, tmp, colorTmp);
		//System.out.println("couleur ombre " + colorTmp);
		//System.out.println("couleur globale : " + color);
		faces.add(faceTmp);

	}

	private void addListSommet(List<Sommet> tmp) {
		tmp.add(sommets.get(a));
		tmp.add(sommets.get(b));
		tmp.add(sommets.get(c));
		if(nb == 4) {
			tmp.add(sommets.get(d));			
		}
	}
}

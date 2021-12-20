package math;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import graph.Face;
import graph.Matrice;
import graph.Sommet;
import javafx.scene.paint.Color;

/**
 * The Class ColorFacecalcTest.
 */
class ColorFacecalcTest {

	/**
	 * Simpletest face.
	 */
	@Test
	void simpletestFace() {
		Color color = new Color(64.0/255.0, 255.0/255.0, 64.0/255.0, 1.0);
		Matrice lumiere = new Matrice(1,1);
		lumiere.add(100,100,100,1);
		CalculColor calcolor = new CalculColor(lumiere, color);
		Face face = new Face(0, color);
		
		face.addSommet(new Sommet(1, 2, 3));
		face.addSommet(new Sommet(2,2,5));
		face.addSommet(new Sommet(2,3,3));
		
		Color res = calcolor.getColor(face);
		Color sol1 = new Color(12.0/255.0, 49.0/255.0, 12.0/255.0, 1.0);
		assertEquals(sol1.toString(), res.toString());
		
	}
	
	/**
	 * Colorbehind.
	 */
	@Test
	void colorbehind() {
		Color color = new Color(64.0/255.0, 255.0/255.0, 64.0/255.0, 1.0);
		Matrice lumiere = new Matrice(1,1);
		lumiere.add(1,1,1,1);
		CalculColor colorCalc = new CalculColor(lumiere, color);
		Face faces= new Face(3, color);
		faces.addSommet(new Sommet(1, 2, 3));
		faces.addSommet(new Sommet(2,2,5));
		faces.addSommet(new Sommet(2,3,3));
		
		Color res = colorCalc.getColor(faces);
		Color sol1 = new Color(12.0/255.0, 49.0/255.0, 12.0/255.0, 1.0);
		assertEquals(sol1.toString(), res.toString());
	}
}

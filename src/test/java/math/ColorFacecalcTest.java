package math;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import graph.Face;
import graph.Matrix;
import graph.Vertex;
import javafx.scene.paint.Color;

/**
 * The Class ColorFacecalcTest.
 */
class ColorFacecalcTest {

	/**
	 * Simpletest face.
	 */
	/*@Test
	void simpletestFace() {
		Color color = new Color(64.0/255.0, 255.0/255.0, 64.0/255.0, 1.0);
		Matrix lumiere = new Matrix(1,1);
		lumiere.add(100,100,100,1);
		CalculColor calcolor = new CalculColor(lumiere, color);
		
		List<Vertex> listVertex = new ArrayList<>();
		
		listVertex.add(new Vertex(1, 2, 3));
		listVertex.add(new Vertex(2,2,5));
		listVertex.add(new Vertex(2,3,3));
		
		Face face = new Face(5, listVertex, Color.WHITE);
		Color res = calcolor.getColor(face);
		Color sol1 = new Color(12.0/255.0, 49.0/255.0, 12.0/255.0, 1.0);
		assertEquals(sol1.toString(), res.toString());
		
	}
	*/
	/**
	 * Colorbehind.
	 */
	//@Test
	
	/*
	 void colorbehind() {
		Color color = new Color(64.0/255.0, 255.0/255.0, 64.0/255.0, 1.0);
		Matrix lumiere = new Matrix(1,1);
		lumiere.add(1,1,1,1);
		CalculColor colorCalc = new CalculColor(lumiere, color);
		
		List<Vertex> listVertex = new ArrayList<>();
		listVertex.add(new Vertex(1, 2, 3));
		listVertex.add(new Vertex(2,2,5));
		listVertex.add(new Vertex(2,3,3));
		
		Face face = new Face(5, listVertex, Color.WHITE);
		
		Color res = colorCalc.getColor(face);
		Color sol1 = new Color(12.0/255.0, 49.0/255.0, 12.0/255.0, 1.0);
		assertEquals(sol1.toString(), res.toString());
	}
	
	*/
}

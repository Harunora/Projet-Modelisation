package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

/**
 * The Class UpdateGraphTest.
 */
class UpdateGraphTest {
	
	/** The my path. */
	String myPath = System.getProperty("user.dir")+File.separator+"exemples"+File.separator;
	
	/** The file. */
	File file = new File(myPath+"cube.ply");
	
	/** The file 2. */
	File file2 = new File(myPath+"apple.ply");
	
	/**
	 * Implementation.
	 *
	 * @return the graph
	 */
	Graph implementation() {
		List<Face> f = new ArrayList<Face>();
		Matrix matrice;
		Vertex s0 = new Vertex(0,0,0);
		Vertex s1 = new Vertex(0,0,1);
		Vertex s2 = new Vertex(0,1,1);
		Vertex s3 = new Vertex(0,1,0);
		Vertex s4 = new Vertex(1,0,0);
		Vertex s5 = new Vertex(1,0,1);
		Vertex s6 = new Vertex(1,1,1);
		Vertex s7 = new Vertex(1,1,0);
		List<Vertex> listSommet1 = new ArrayList<Vertex>();
		listSommet1.add(s0);
		listSommet1.add(s1);
		listSommet1.add(s2);
		listSommet1.add(s3);
		List<Vertex> listSommet2 = new ArrayList<Vertex>();
		listSommet2.add(s7);
		listSommet2.add(s6);
		listSommet2.add(s5);
		listSommet2.add(s4);
		List<Vertex> listSommet3 = new ArrayList<Vertex>();
		listSommet3.add(s0);
		listSommet3.add(s4);
		listSommet3.add(s5);
		listSommet3.add(s1);
		List<Vertex> listSommet4 = new ArrayList<Vertex>();
		listSommet4.add(s1);
		listSommet4.add(s5);
		listSommet4.add(s6);
		listSommet4.add(s2);
		List<Vertex> listSommet5 = new ArrayList<Vertex>();
		listSommet5.add(s2);
		listSommet5.add(s6);
		listSommet5.add(s7);
		listSommet5.add(s3);
		List<Vertex> listSommet6 = new ArrayList<Vertex>();
		listSommet6.add(s3);
		listSommet6.add(s7);
		listSommet6.add(s4);
		listSommet6.add(s0);
		f.add(new Face(4,listSommet1, Color.WHITE));
		f.add(new Face(4,listSommet2, Color.WHITE));
		f.add(new Face(4,listSommet3, Color.WHITE));
		f.add(new Face(4,listSommet4, Color.WHITE));
		f.add(new Face(4,listSommet5, Color.WHITE));
		f.add(new Face(4,listSommet6, Color.WHITE));
		matrice = new Matrix(7, 6);
		List<String> string = new ArrayList<String>();
		string.add("4 0 1 2 3\n");
		string.add("4 7 6 5 4\n");
		string.add("4 0 4 5 1\n");
		string.add("4 1 5 6 2\n");
		string.add("4 2 6 7 3\n");
		string.add("4 3 7 4 0\n");
		return new Graph(6,f, matrice, string, "");
	}
	
	/**
	 * Test update 1.
	 */
	@Test
	void testUpdate1() {
		FileReader r = new FileReader();
		Graph old = r.read(file);
		Graph attendu = implementation();
		UpdateGraph u = new UpdateGraph(old.nbFaces, old.faces, old.matrix, old.listOfFaces, ""); 
		u.update(old.matrix);
		assertEquals(attendu.getFace(0).getVertex().get(0).getX(), u.getFace(0).getVertex().get(0).getX());
	}
	
	/**
	 * Test update 2.
	 */
	@Test
	void testUpdate2() {
		FileReader r = new FileReader();
		Graph old = r.read(file);
		Graph attendu = implementation();
		UpdateGraph u = new UpdateGraph(old.nbFaces, old.faces, old.matrix, old.listOfFaces, ""); 
		u.matrix.getX()[0] = 2;
		u.update(old.matrix);
		assertNotEquals(attendu.getFace(0).getVertex().get(0).getX(), u.getFace(0).getVertex().get(0).getX());
	}
	

}

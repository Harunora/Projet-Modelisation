package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

/**
 * The Class FileReaderTest.
 */
class FileReaderTest {
	
	/** The my path. */
	String myPath = System.getProperty("user.dir")+File.separator+"exemples"+File.separator;
	
	/** The file. */
	File file = new File(myPath+"cube.ply");
	
	/** The file 2. */
	File file2 = new File(myPath+"apple.ply");
	
	/** The r. */
	FileReader fileReader = new FileReader();
	
	/** The r 2. */
	FileReader fileReader2 = new FileReader();
	
	/** The attendu. */
	Graph attendu = implementation();
	
	/** The obtenu. */
	Graph obtenu = fileReader.read(file);
	
	/** The obtenu 2. */
	Graph obtenu2 = fileReader2.read(file2);
	
	/**
	 * Implementation.
	 *
	 * @return the graph
	 */
	Graph implementation() {
		List<Face> face = new ArrayList<Face>();
		Matrix matrice;
		Vertex vertex0 = new Vertex(0,0,0);
		Vertex vertex1 = new Vertex(0,0,1);
		Vertex vertex2 = new Vertex(0,1,1);
		Vertex vertex3 = new Vertex(0,1,0);
		Vertex vertex4 = new Vertex(1,0,0);
		Vertex vertex5 = new Vertex(1,0,1);
		Vertex vertex6 = new Vertex(1,1,1);
		Vertex vertex7 = new Vertex(1,1,0);
		List<Vertex> listSommet1 = new ArrayList<Vertex>();
		listSommet1.add(vertex0);
		listSommet1.add(vertex1);
		listSommet1.add(vertex2);
		listSommet1.add(vertex3);
		List<Vertex> listSommet2 = new ArrayList<Vertex>();
		listSommet2.add(vertex7);
		listSommet2.add(vertex6);
		listSommet2.add(vertex5);
		listSommet2.add(vertex4);
		List<Vertex> listSommet3 = new ArrayList<Vertex>();
		listSommet3.add(vertex0);
		listSommet3.add(vertex4);
		listSommet3.add(vertex5);
		listSommet3.add(vertex1);
		List<Vertex> listSommet4 = new ArrayList<Vertex>();
		listSommet4.add(vertex1);
		listSommet4.add(vertex5);
		listSommet4.add(vertex6);
		listSommet4.add(vertex2);
		List<Vertex> listSommet5 = new ArrayList<Vertex>();
		listSommet5.add(vertex2);
		listSommet5.add(vertex6);
		listSommet5.add(vertex7);
		listSommet5.add(vertex3);
		List<Vertex> listSommet6 = new ArrayList<Vertex>();
		listSommet6.add(vertex3);
		listSommet6.add(vertex7);
		listSommet6.add(vertex4);
		listSommet6.add(vertex0);
		face.add(new Face(4,listSommet1, Color.WHITE));
		face.add(new Face(4,listSommet2, Color.WHITE));
		face.add(new Face(4,listSommet3, Color.WHITE));
		face.add(new Face(4,listSommet4, Color.WHITE));
		face.add(new Face(4,listSommet5, Color.WHITE));
		face.add(new Face(4,listSommet6, Color.WHITE));
		matrice = new Matrix(7, 6);
		return new Graph(6,face, matrice, null, "");
	}
	
	/**
	 * Test nb faces.
	 */
	@Test
	void testNbFaces() {
		assertEquals(attendu.getNbFaces(), obtenu.getNbFaces());
	}
	
	/**
	 * Test nb sommets.
	 */
	@Test
	void testNbSommets() {
		assertEquals(attendu.getFaces().get(0).getNbVertex(), obtenu.getFaces().get(0).getNbVertex());
	}
	
	/**
	 * Test face 1.
	 */
	@Test
	void testFace1() {
		assertEquals(attendu.getFaces().get(0).toString(), obtenu.getFaces().get(0).toString());
	}
	
	/**
	 * Test face 2.
	 */
	@Test
	void testFace2() {
		assertEquals(attendu.getFaces().get(1).toString(), obtenu.getFaces().get(1).toString());
	}
	
	/**
	 * Test sommet 1.
	 */
	@Test
	void testSommet1() {
		assertEquals(attendu.getFaces().get(1).getVertex().toString(), obtenu.getFaces().get(1).getVertex().toString());
	}
	
	/**
	 * Test sommet 2.
	 */
	@Test
	void testSommet2() {
		assertEquals(attendu.getFaces().get(3).getVertex().toString(), obtenu.getFaces().get(3).getVertex().toString());
	}

	@Test
	void testGraph() {
		assertEquals(attendu.toString(), obtenu.toString());
	}

	@Test
	void testNbFacesEF() {
		assertEquals(1704, obtenu2.getNbFaces());
		
	}
	@Test
	void testNbSommetsFileReader() {
		assertEquals(3, obtenu2.getNbVertex());
	}

	@Test
	void testSizeSommets() {
		assertEquals(6, obtenu.getFaces().size());
	}

}

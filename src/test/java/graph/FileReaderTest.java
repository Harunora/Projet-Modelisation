package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

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
	FileReader r = new FileReader();
	
	/** The r 2. */
	FileReader r2 = new FileReader();
	
	/** The attendu. */
	Graph attendu = implementation();
	
	/** The obtenu. */
	Graph obtenu = r.read(file);
	
	/** The obtenu 2. */
	Graph obtenu2 = r2.read(file2);
	
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
		f.add(new Face(4,listSommet1, null));
		f.add(new Face(4,listSommet2, null));
		f.add(new Face(4,listSommet3, null));
		f.add(new Face(4,listSommet4, null));
		f.add(new Face(4,listSommet5, null));
		f.add(new Face(4,listSommet6, null));
		matrice = new Matrix(7, 6);
		return new Graph(6,f, matrice, null, "");
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
	
	/**
	 * Test graph.
	 */
	@Test
	void testGraph() {
		assertEquals(attendu.toString(), obtenu.toString());
	}
	
	/**
	 * Test nb faces EF.
	 */
	@Test
	void testNbFacesEF() {
		assertEquals(1704, obtenu2.getNbFaces());
		
	}
	
	/**
	 * Test nb sommets file reader.
	 */
	@Test
	void testNbSommetsFileReader() {
		assertEquals(3, obtenu2.getNbVertex());
	}
	
	
	/**
	 * Test size sommets.
	 */
	@Test
	void testSizeSommets() {
		assertEquals(6, obtenu.getFaces().size());
	}

}

package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MatriceTest {
	String myPath = System.getProperty("user.dir")+File.separator+"data"+File.separator;
	File file = new File(myPath+"test.ply");
	FileReader r = new FileReader();
	Graph attendu = r.read(file);
	Graph obtenu = r.read(file);
	
	@Test
	void testX() {
		System.out.println(obtenu.matrice);
		System.out.println(obtenu.matrice.toString());
		assertEquals(attendu.matrice.x[0], obtenu.matrice.x[0]);
	}
	
	
	
	@Test
	void testSommet2() {
		assertEquals(attendu.getFaces().get(3).getSommets().toString(), obtenu.getFaces().get(3).getSommets().toString());
		System.out.println("attendu :" +attendu.getFaces().get(3).getSommets().toString());
		System.out.println("obtenu  :" +obtenu.getFaces().get(3).getSommets().toString());
		System.out.println("obtenu matrice :" +obtenu.getMatrice());
	}


}

package graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
	private String actual = "";
	private int nbFaces = 0,nbSommets = 0;
	private List<Sommet> sommets = new ArrayList<Sommet>();
	private List<Face>faces = new ArrayList<Face>();
	private List<String> sommetsDeFaces = new ArrayList<String>();
	Matrice matrice;




	public UpdateGraph read(File fileTest) {
		try {
			FileInputStream file = new FileInputStream(fileTest);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				actual = actualNext(scanner);
				startFile(scanner);
				matrice = new Matrice(nbSommets, nbFaces);
				readSommet(nbSommets, sommets, scanner);
				readFace(nbFaces, sommets, faces, sommetsDeFaces, scanner);	
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return  new UpdateGraph(nbFaces, faces, matrice, sommetsDeFaces);
	}


	private void startFile(Scanner scanner) {
		boolean achieved = false;
		while(!achieved) {
			actual = actualNext(scanner);
			if(actual.equals("end_header"+"\n")) {
				achieved = true;
			}

			if(actual.startsWith("element vertex")) {
				nbSommets = Integer.parseInt(actual.substring(15,actual.length()-1)); 
			}

			

			if(actual.startsWith("element face")) {
				nbFaces = Integer.parseInt(actual.substring(13,actual.length()-1));
			}




		}
	}

	private String actualNext(Scanner scanner) {
		actual=scanner.nextLine()+"\n";
		return actual;
	}

	private void readFace(int nbFaces, List<Sommet> sommets, List<Face> faces,List<String> stringFace, Scanner scanner) {
		for(int i = 0; i<nbFaces; i++) {
			actual = actualNext(scanner);
			stringFace.add(actual);
			List<Sommet> listSommetTmp = new ArrayList<Sommet>();
			List<Integer> listIdxSommet = new ArrayList<Integer>();
			StringTokenizer lineToken = new StringTokenizer(actual);
			int nb = Integer.parseInt(lineToken.nextToken());
			for(int j = 0; j<nb; j++) {
				listIdxSommet.add(Integer.parseInt(lineToken.nextToken()));
			}
			for(int j = 0; j< nb; j++) {
				listSommetTmp.add(sommets.get(listIdxSommet.get(j)));
			}
			faceAdd(faces, listSommetTmp, lineToken, nb);
		}
	}

	private void faceAdd(List<Face> faces, List<Sommet> listSommetTmp, StringTokenizer actuel, int nb) {
		if(actuel.hasMoreTokens()) {
			int[] rgbTab = addRgb(actuel);
			Color colorTmp = new Color(rgbTab);
			Face faceTmp = new Face(nb,listSommetTmp ,colorTmp);
			faces.add(faceTmp);
		}else {
			Face faceTmp = new Face(nb,listSommetTmp);
			faces.add(faceTmp);
		}
		
		
	}

	private int[] addRgb(StringTokenizer actuel) {
		return new int[] {Integer.parseInt(actuel.nextToken()),Integer.parseInt(actuel.nextToken()),Integer.parseInt(actuel.nextToken())};
	}

	private void readSommet(int nbSommets, List<Sommet> sommets, Scanner scanner) {
		for(int i = 0; i<nbSommets; i++) {
			actual = actualNext(scanner);
			String[] s1 = actual.split(" ");
			double[] tabXyz = addXyz(s1);
			Sommet tmp = new Sommet(tabXyz);
			sommets.add(tmp);
			matrice.add(tmp);
		}
	}

	private double[] addXyz(String[] s1) {
		return new double[] {Double.parseDouble(s1[0]),Double.parseDouble(s1[1]),Double.parseDouble(s1[2])};
	}

}
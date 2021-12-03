package graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
	private String actual = "",auteur="",commentaire="";
	private boolean hasColor;
	private int nbFaces = 0,nbSommets = 0;
	private List<Sommet> sommets = new ArrayList<Sommet>();
	private List<Face>faces = new ArrayList<Face>();
	private List<String> sommetsDeFaces = new ArrayList<String>();
	protected Matrice matrice;




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
		return  new UpdateGraph(nbFaces, faces, matrice, sommetsDeFaces, auteur);
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

			if(actual.startsWith("comment")) {
				if(actual.startsWith("comment made by")) {
					auteur = actual.substring(15);
				}else {
					commentaire += actual.substring(7) + "\n";
				}
			}

			if(actual.startsWith("property uchar red\n")) {
				hasColor = true;
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
			if(actual.equals("")) {
				i--;
			}else {
				stringFace.add(actual);
				List<Sommet> listSommetTmp = new ArrayList<Sommet>();
				List<Integer> listIdxSommet = new ArrayList<Integer>();
				StringTokenizer lineToken = new StringTokenizer(actual);
				int nb = Integer.parseInt(lineToken.nextToken());
				for(int j = 0; j<nb; j++ ) {
					listIdxSommet.add(Integer.parseInt(lineToken.nextToken()));
				}
				for(int j = 0; j< nb; j++) {
					listSommetTmp.add(sommets.get(listIdxSommet.get(j)));
				}
				faceAdd(faces, listSommetTmp, lineToken, nb);

			}
		}
	}

	private void faceAdd(List<Face> faces, List<Sommet> listSommetTmp, StringTokenizer lineToken, int nb) {
		if(hasColor) {
			//double r = Double.parseDouble(lineToken.nextToken());
			//double g = Double.parseDouble(lineToken.nextToken());
			//double b = Double.parseDouble(lineToken.nextToken());
			Face faceTmp = new Face(nb,listSommetTmp, null);
			faces.add(faceTmp);
		}else {
			Face faceTmp = new Face(nb,listSommetTmp, null);			
			faces.add(faceTmp);
		}
	}


	private void readSommet(int nbSommets, List<Sommet> sommets, Scanner scanner) {
		for(int i = 0; i<nbSommets; i++) {
			Sommet tmp;
			actual = actualNext(scanner);
			String[] s1 = actual.split(" ");
			double[] tabXyz = addXyz(s1);
			tmp = new Sommet(tabXyz);
			sommets.add(tmp);
			matrice.add(tmp);
		}
	}

	private double[] addXyz(String[] s1) {
		return new double[] {Double.parseDouble(s1[0]),Double.parseDouble(s1[1]),Double.parseDouble(s1[2])};
	}


	public String getAuteur() {
		return auteur;
	}


	public String getCommentaire() {
		return commentaire;
	}

}
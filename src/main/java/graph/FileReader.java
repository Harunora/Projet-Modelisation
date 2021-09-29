package graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
	
	public static Graph read() {
		String actual = "";
		float x = 0,y = 0,z = 0;
		int r,g,b;
		int nbFaces = 0,nbSommets = 0;
		List<Sommet> sommets = new ArrayList<Sommet>();
		List<Face>faces = new ArrayList<Face>();
		boolean test = true;
		String myPath = System.getProperty("user.dir")+File.separator+"data"+File.separator;
		try {
			FileInputStream file = new FileInputStream(myPath+"infoBoard");
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine())
			{
				actual=scanner.nextLine()+"\n";
				// tant que "end_header" n'a pas été trouvé ont continue , elle sert à chercher les nombre de faces et de sommets
				while(actual.equals("end_header") && !test) {
					actual=scanner.nextLine()+"\n";
					if(actual.equals("end_header")) {
						test = true;
					}
					if(actual.equals("element vertex 10")) {
						nbSommets = Integer.parseInt(actual.substring(15,17)); 
					}
					if(actual.equals("element face 16")) {
						nbFaces = Integer.parseInt(actual.substring(13,15)); 
					}
				}
				//ensuite dans la lecture nous sommes arrivé aux sommets que nous allons lire les coordonée grace au split (mais peu etre remplacé par le tkens)
				for(int i = 0; i<nbSommets; i++) {
					actual = actual.substring(2);
					String[] s1 = actual.split("  ");
					String[] s2 = actual.split("  ");
					x = Float.parseFloat(s1[0]);
					y = Float.parseFloat(s2[0]);
					z = Float.parseFloat(s2[1]);
					Sommet tmp = new Sommet(x,y,z);
					sommets.add(tmp);
				}
				//de la même façons que les sommets , nous enregistrons les faces 
				for(int i = 0; i<nbFaces; i++) {
					List<Sommet> listSommetTmp = new ArrayList<Sommet>();
					List<Integer> listIdxSommet = new ArrayList<Integer>();
					actual = actual.substring(2);
					StringTokenizer actuel = new StringTokenizer(actual);
					int nb = Integer.parseInt(actuel.nextToken());
					for(int j = 0; j<nb; j++) {
						listIdxSommet.add(Integer.parseInt(actuel.nextToken()));
					}
					for(int j = 0; j< nbSommets; j++) {
						listSommetTmp.add(sommets.get(listIdxSommet.get(i)));
					}
					if(actuel.hasMoreTokens()) {
						r = Integer.parseInt(actuel.nextToken());
						g = Integer.parseInt(actuel.nextToken());
						b = Integer.parseInt(actuel.nextToken());
						Color colorTmp = new Color(r,g,b);
						Face faceTmp = new Face(nbSommets,listSommetTmp ,colorTmp);
						faces.add(faceTmp);
					}else {
						Face faceTmp = new Face(nbSommets,listSommetTmp);
						faces.add(faceTmp);
					}
				}	
			}
			scanner.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  new Graph(nbFaces, faces);

	}

}

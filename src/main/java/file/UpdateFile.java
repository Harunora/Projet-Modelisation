package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateFile {
	int ligneAuteur,ligneCom;
	List<String> contenuFichier = new ArrayList<String>();
	File fichier;

	public UpdateFile(File fichier, int ligneAuteur, int ligneCom){
		this.ligneAuteur = ligneAuteur;
		this.ligneCom = ligneCom;
		this.fichier = fichier;
		System.out.println(ligneAuteur);
		fileReader();
	}

	public void remplaceAuteur(int ligne, String comment) {
		if(ligneAuteur == 0) {
			contenuFichier.add(2, "comment made by " + comment);
		}else {
			if(ligne != ligneAuteur && ligne != ligneCom) {
				System.out.println("Erreur \n la ligne de donnée est " + ligne + " elle doit etre = " + ligneAuteur);
			}else {
				contenuFichier.set(ligne-1, ("comment made by " + comment) ) ;
			}	
		}
		fileWriter();
	}
	
	public void remplaceCommentaire(int ligne, String comment) {
		if(ligneCom == 0) {
			if(ligneAuteur==0) {
				contenuFichier.add(2, "comment " + comment);				
			}else {
				contenuFichier.add(3, "comment " + comment);
			}
		}else {
			if(ligne != ligneCom) {
				System.out.println("Erreur \n la ligne de donnée est " + ligne + " elle doit etre = " + ligneCom);
			}else {
				contenuFichier.set(ligne-1, ("comment " + comment) ) ;
			}	
		}
		fileWriter();
	}

	public void fileWriter() {
		try(PrintWriter pw = new PrintWriter(fichier)){
			for(int i = 0; i<contenuFichier.size(); i++) {
				pw.println(String.valueOf(contenuFichier.get(i)));				
			}
		} catch (IOException e) {
			System.out.println("Writing error : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("remplacement fait");
	}

	public void fileReader() {
		contenuFichier.clear();
		String text;
		FileInputStream file = null;
		try {
			file = new FileInputStream(fichier);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine())
		{
			text=scanner.nextLine();
			contenuFichier.add(text);
		}
		scanner.close();
	}

	public String toString() {
		String res = "";
		for(int i = 0; i<contenuFichier.size();i++) {
			res+=contenuFichier.get(i);
		}
		return res;
	}

}

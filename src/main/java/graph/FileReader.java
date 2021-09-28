package graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	public FileReader() {
		
	}
	
	public static Sommet read() {
		String actual = "";
		float x = 0,y = 0,z = 0;
		boolean test = true;
		String myPath = System.getProperty("user.dir")+File.separator+"data"+File.separator;
		try {
			FileInputStream file = new FileInputStream(myPath+"infoBoard");
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine())
			{
				actual=scanner.nextLine()+"\n";
				while(actual.equals("end_header") && !test) {
					actual=scanner.nextLine()+"\n";
					if(actual.equals("end_header")) {
						test = true;
					}
				}
				
				
			}
			scanner.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(actual);

		return  new Sommet(x, y, z);

	}

}

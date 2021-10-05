package demo;

import java.io.File;
import java.io.FileFilter;

import graph.FileReader;
import graph.Graph;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ExplorerFile {
	
	private static TreeView<String> tree;
	private File current = null;
	private String currentPath ="";
    FileReader r = new FileReader();

	public static boolean existFile(File[] f, File f1) {
		for (int i = 0; i < f.length; i++) {
			if (f[i].equals(f1)) {
				return true;
			}
		}
		return false;

	}
	
	
	public TreeView<String> getTree() {
		return tree;
	}


	public void setTree(TreeView<String> tree) {
		ExplorerFile.tree= tree;
	}

	public  TreeItem<String> getNodesForDirectory(File directory) { 
		this.currentPath ="";
		TreeItem<String> root = new TreeItem<String>(directory.getName());
		System.out.println(directory.getAbsolutePath());

		for (File f : directory.listFiles()) {
			if (f.isDirectory()) {
				root.getChildren().add(getNodesForDirectory(f));
				System.out.println(getNodesForDirectory(f));
			} else {			
				String rep = directory.getAbsolutePath();
				this.currentPath = rep;
				File repFile = new File(rep);

				File[] fichiersPly = repFile.listFiles(new FileFilter() {

					public boolean accept(File pathname) {

						String fileName = pathname.getName();

						return fileName.endsWith(".ply");
					}
					

				});
				

				for (File fichierPly : fichiersPly) {
					System.out.println(fichierPly.getName());

				}

				if (existFile(fichiersPly, f)) {
					System.out.println("Loading " + f.getName());
					root.getChildren().add(new TreeItem<String>(f.getName()));
				}
			}

		}

		return root;
	}
	
	public void getFile(TreeView<String> tV) {
		
		
		tV.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->{
			if (newValue != null) {
				String s = ((TreeItem<String>) newValue).getValue();
				File fi = new File(currentPath+""+File.separatorChar+""+s);
				//si newValue c'est un file
				if(fi.isFile()) {
					System.out.println(((TreeItem<String>) newValue).getValue());
					current = fi;
					System.out.println(current.getAbsolutePath());
				}
				
				}
			Graph graph = r.read(current);
			System.out.println(graph.getNbFaces());
			System.out.println("test");
				
		});
		
	}


	public File getCurrent(TreeView<String> tv) {
		getFile(tv);
		return current;
	}


	public void setCurrent(File current) {
		this.current = current;
	}


	public String getCurrentPath(TreeView<String> tv) {
		getFile(tree);
		return currentPath;
	}


	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	
	 
	
}

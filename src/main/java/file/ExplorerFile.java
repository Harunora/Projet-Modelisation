package file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import graph.FileReader;
import graph.Graph;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


/**
 * The Class ExplorerFile.
 *
 * @author Julien
 */
public class ExplorerFile {
	
	/** The tree. */
	private TreeView<File> tree;
	
	/** The map file. */
	protected MapFile mapFile = new MapFile();
	
	/** The current. */
	private File current = null;
	
	/** The current path. */
	private String currentPath = "";
	
	/** The graph. */
	private Graph graph;
	
	/** The tmp. */
	private String tmp;
	
	/** The r. */
	public FileReader r = new FileReader();
	
	/**
	 * Exist file.
	 *
	 * @param f the f
	 * @param f1 the f 1
	 * @return true, if successful
	 */
	/*
	 * Methode static qui permet de voir si un fichier f existe dans un tableau de fichier
	 * 
	 */
	public static boolean existFile(File[] f, File f1) {
		for (int i = 0; i < f.length; i++) {
			if (f[i].equals(f1)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the tree.
	 *
	 * @return the tree
	 */
	public TreeView<File> getTree() {
		return tree;
	}

	/**
	 * Sets the tree.
	 *
	 * @param tree the new tree
	 */
	public void setTree(TreeView<File> tree) {
		this.tree = tree;
	}

	/**
	 * Gets the nodes for directory.
	 *
	 * @param directory the directory
	 * @return the nodes for directory
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Methode qui permet de trouver les Fils d'un repertoire
	 * 
	 */
	public TreeItem<String> getNodesForDirectory(File directory) throws IOException {
		this.currentPath = "";
		TreeItem<String> root = new TreeItem<>();
		

		for (File f : directory.listFiles()) {
			if (!f.isDirectory()) {
				String rep = directory.getAbsolutePath();
				this.currentPath = rep;
				File repFile = new File(rep);

				File[] fichiersPly = repFile.listFiles(new FileFilter() {
					public boolean accept(File pathname) {
						String fileName = pathname.getName();
						return fileName.endsWith(".ply");
					}
				});
				
				if (existFile(fichiersPly, f)) {
					for(int i = 0; i < fichiersPly.length ; i++) {
						mapFile.add(fichiersPly[i].getName(), fichiersPly[i]);
					}
					root.getChildren().add(new TreeItem<String>(f.getName()));
					
				}
			}			
		}
		return root;
	}
	
	/**
	 * Gets the file.
	 *
	 * @param tv the tv
	 * @return the file
	 */
	public File getFile(TreeView<String> tv) {
		tv.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				tmp = ((TreeItem<String>) newValue).getValue();
			}
		});	
		current = mapFile.getFileOf(tmp);
		return current;
	}
	
	/**
	 * Sets the current.
	 *
	 * @param current the new current
	 */
	public void setCurrent(File current) {
		this.current = current;
	}
	
	/**
	 * Gets the current path.
	 *
	 * @param treeView the tree view
	 * @return the current path
	 */
	public String getCurrentPath(TreeView<String> treeView) {
		/*
		 * Retourne le chemin courant
		 * @param treeView TreeView
		 */
		return currentPath;
	}
	
	/**
	 * Sets the current path.
	 *
	 * @param currentPath the new current path
	 */
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	
	/**
	 * Gets the graph.
	 *
	 * @return the graph
	 */
	public Graph getGraph() {
		return graph;
	}
}
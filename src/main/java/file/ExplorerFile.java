package file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import graph.FileReader;
import graph.Graph;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


/**
 * la classe ExplorerFile.
 *
 * @author Julien Lalloyer
 */
public class ExplorerFile {
	
	/** L'arbre de fichier. */
	private TreeView<File> tree;
	
	/** La table de fichier. */
	protected MapFile mapFile = new MapFile();
	
	/** Le fichier courant. */
	private File current = null;
	
	/** Le cheminn courant. */
	private String currentPath = "";
	
	/** Le graphe. */
	private Graph graph;
	
	/** String temporaire. */
	private String tmp;
	
	/** Le lecteur de fichier. */
	public FileReader fileReader = new FileReader();
	
	/**
	 * Methode static qui permet de voir si un fichier f existe dans un tableau de fichier
	 *
	 * @param tabFile le tableau de fichier
	 * @param file le fichier a chercher
	 * @return true, si il existe dans le tableau tabFile
	 *  
	 */
	public static boolean existFile(File[] tabFile, File file) {
		for (int i = 0; i < tabFile.length; i++) {
			if (tabFile[i].equals(file)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prendre l'abre de fichier.
	 *
	 * @return L'arbre
	 */
	public TreeView<File> getTree() {
		return tree;
	}

	/**
	 * Donne une valeur a l'arbre.
	 *
	 * @param tree le nouveau tree
	 */
	public void setTree(TreeView<File> tree) {
		this.tree = tree;
	}

	/**
	 * Methode qui permet de trouver les Fils d'un repertoire
	 *
	 * @param directory le repertoire
	 * @return les elements fils de ce repertoire
	 * @throws IOException Signale une I/O exception s'est produit.
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
	 * Prend le fichier selectionne file.
	 *
	 * @param treeView l'abre de fichier
	 * @return le fichier selectionné
	 */
	public File getFile(TreeView<String> treeView) {
		treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				tmp = ((TreeItem<String>) newValue).getValue();
			}
		});	
		current = mapFile.getFileOf(tmp);
		return current;
	}
	
	/**
	 * Donne une valeur pour le nouveau fichier courant.
	 *
	 * @param current le nouveau fichier courant
	 */
	public void setCurrent(File current) {
		this.current = current;
	}
	
	/**
	 * Retourne le chemin courant
	 *
	 * @param treeView l'abre de chaine de caractere
	 * @return le chemin courant
	 */
	public String getCurrentPath(TreeView<String> treeView) {
		return currentPath;
	}
	
	/**
	 * Donne une valeur au chemin courant.
	 *
	 * @param currentPath le nouveau chemin courant
	 */
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	
	/**
	 * Retourne le graphe.
	 *
	 * @return le graphe
	 */
	public Graph getGraph() {
		return graph;
	}
}
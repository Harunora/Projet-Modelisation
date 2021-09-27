package demo;

import java.io.File;
import java.io.FileFilter;

import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ExplorerFile {
	
	private static TreeView<String> tree = new TreeView();

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



	public static TreeView<String> FolderSearcher(Stage primaryStage) {
		DirectoryChooser dc = new DirectoryChooser();
		dc.setInitialDirectory(new File(System.getProperty("user.home")));
		File choice = dc.showDialog(primaryStage);
		if (choice == null || !choice.isDirectory()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Could not open directory");
			alert.setContentText("The file is invalid.");

			alert.showAndWait();
		} else {
			tree.setRoot(getNodesForDirectory(choice));
		}
		return tree;
	}

	public static TreeItem<String> getNodesForDirectory(File directory) { 

		TreeItem<String> root = new TreeItem<String>(directory.getName());
		System.out.println(directory.getAbsolutePath());

		for (File f : directory.listFiles()) {
			if (f.isDirectory()) {
				root.getChildren().add(getNodesForDirectory(f));
				System.out.println(getNodesForDirectory(f));
			} else {

				String rep = directory.getAbsolutePath();
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
	
}

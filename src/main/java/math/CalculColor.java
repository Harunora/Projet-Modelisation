package math;

import java.util.ArrayList;

import graph.Face;
import graph.Matrix;
import graph.Vertex;
import javafx.scene.paint.Color;

/**
 * the calculcolor classe calculate the color of a face according to the position of the light
 * 
 * @author Julien Lalloyer
 */
public class CalculColor {
	
	/** the color. */
	Color color;
	
	/** the light. */
	Matrix light;
	
	/**
	 * constructor of calculator
	 *
	 * @param lightCoordinate is the coordinate of the light 
	 * @param color is the color of the face
	 */
	public CalculColor(Matrix lightCoordinate, Color color) {
		ScalarProduct scalarProduct = new ScalarProduct(lightCoordinate);
		ProdVectoUni produitVectoUni =  new ProdVectoUni(scalarProduct);
		this.light = produitVectoUni.getNorme();
		this.color = color;
	}
	
	/**
	 * get the current color of the face and return the result with the light
	 *
	 * @param face the current face
	 * @return the color return with the light
	 */
	public Color getColor(Face face) {
		ArrayList<Vertex> listVertices = (ArrayList<Vertex>) face.getVertex();
		if(face.getNbVertex()== 3) {
			ScalarProduct scalarProduct = new ScalarProduct(listVertices.get(0), listVertices.get(1));
			scalarProduct.prodScal(new ScalarProduct(listVertices.get(0), listVertices.get(2)).getMatrice());
			ProdVectoUni prodVectoUni = new ProdVectoUni(scalarProduct);
			double coef = calcfactlumiere(prodVectoUni);	
			double red = face.getRed();
			double green = face.getGreen();
			double blue = face.getBlue();
			if(coef > 0.0) {
				color = new Color((red * coef), (green * coef), (blue* coef), 1.0);
			}else {
					color = new Color(0.0,0.0,0.0,1.0);
			}
		}
		return color;
	}

	/**
	 * Calculate the coefficient to manipulate for the color
	 *
	 * @param le produit vetoriel unitaire des faces
	 * @return the coefficient that must be applied
	 */
	private double calcfactlumiere(ProdVectoUni produitVectoUni) {
		double coord_x = produitVectoUni.getNormeX() * light.getX(0); 
		double coord_y =produitVectoUni.getNormeY() * light.getY(0) ;
		double coord_z =produitVectoUni.getNormeZ() * light.getZ(0);
		return coord_x+coord_y+coord_z;
		
	}
}

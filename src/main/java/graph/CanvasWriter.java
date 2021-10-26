package graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasWriter {

	Graph listface;
	Canvas canvas;
	
	
	GraphicsContext graphicContext;
	List<Color> color;
	List<double[]> x;
	List<double[]> y;
	
	int homothesie=100;
	
	
	public CanvasWriter(Canvas c, Graph lf) {
		x=new ArrayList<double[]>();
		y=new ArrayList<double[]>();
		canvas=c;
		graphicContext=c.getGraphicsContext2D();
		
		listface=lf;
		useGraph();
	}
	
	public void changeHomothesie(int i) {
		homothesie=i;
		useGraph();
	}
	
	public void writeOnCanvas() {
		for(int i=0;i<x.size();i++) {
			graphicContext.strokePolygon(this.x.get(i),this.y.get(i), this.y.get(i).length);
			//graphicContext.setFill(null);
			//graphicContext.fillPolygon(i1, i2,i1.length);
		}
	}
	
	public void useGraph() {
		for(int i=0;i<listface.getNbFaces();i++) {
			double[] i1=new double[this.listface.getFace(i).nbSommet];
			double[] i2=new double[this.listface.getFace(i).nbSommet];
			for(int j=0;j<this.listface.getFace(i).nbSommet;j++) {
				i1[j]=this.listface.getFace(i).sommets.get(j).getX()*homothesie+canvas.getHeight()/2;
				i2[j]=this.listface.getFace(i).sommets.get(j).getY()*homothesie+canvas.getWidth()/2; 
			}
			
			this.x.add(i1);
			this.y.add(i2);
			
		}
		writeOnCanvas();
	}
}

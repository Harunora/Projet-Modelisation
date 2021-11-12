package graph;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasWriter {

	public Graph listface;
	public Canvas canvas;

	public GraphicsContext graphicContext;
	List<Color> color;
	List<double[]> x;
	List<double[]> y;
	List<double[]> z;
	double height;
	double width;

	public int homothesie=-100;


	public CanvasWriter(Canvas c, Graph lf) {
		x=new ArrayList<double[]>();
		y=new ArrayList<double[]>();
		z=new ArrayList<double[]>();
		color = new ArrayList<Color>();
		canvas=c;
		graphicContext=c.getGraphicsContext2D();
		width=c.getWidth()/2;
		height=c.getHeight()/2;
		listface=lf;
		useGraph();
		addColor();
	}

	public void addColor() {

	}

	public void updateCanvasWriter(Graph newGraph){
		this.listface=newGraph;
		useGraph();
	}

	public void changeHomothesie(int i) {
		homothesie=i;
		useGraph();

	}

	public void writeOnCanvas() {
		clear(javafx.scene.paint.Color.WHITE);
		int idx=0;
		while(this.x.size()!=0) {
			idx=getPositionHighestZ();
			graphicContext.strokePolygon(this.x.get(idx),this.y.get(idx), this.y.get(idx).length);
			graphicContext.setFill(javafx.scene.paint.Color.RED);
			//graphicContext.setFill(javafx.scene.paint.Color.rgb(color.get(idx).getR(), color.get(idx).getG(), color.get(idx).getB()));
			graphicContext.fillPolygon(this.x.get(idx),this.y.get(idx), this.y.get(idx).length);
			removeFace(idx);
		}
	}

	public void clear(Paint c) {
		graphicContext.setFill(c);
		graphicContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

	}

	public void useGraph() {
		this.x.clear();
		this.y.clear();
		for(int i=0;i<listface.getNbFaces();i++) {
			double[] i1=new double[this.listface.getFace(i).nbSommet];
			double[] i2=new double[this.listface.getFace(i).nbSommet];
			double[] i3=new double[this.listface.getFace(i).nbSommet];
			for(int j=0;j<this.listface.getFace(i).nbSommet;j++) {
				i1[j]=this.listface.getFaceX(i, j)*homothesie+height;
				i2[j]=this.listface.getFaceY(i, j)*homothesie+width;
				i3[j]=this.listface.getFaceZ(i, j)*homothesie+width;
			}			
			this.x.add(i1);
			this.y.add(i2);
			this.z.add(i3);
			/*
			if(this.listface.getFaces().get(i).getSommets().get(0).getColor() == null) {
				this.color.add(new Color(255, 255, 255));
			}else {
				this.color.add(this.listface.getFaces().get(i).getSommets().get(0).getColor());
			}*/
		}
		writeOnCanvas();
	}

	public double getHighestValue(double[] tab) {
		double retour=-1000.00;
		for(int i=0;i<tab.length;i++) {
			if(retour<tab[i]) {
				retour=tab[i];
			}
		}
		return retour;
	}

	public int getPositionHighestZ() {
		int retour=0;

		for(int i=0;i<z.size();i++) {
			if(getHighestValue(z.get(i))>getHighestValue(z.get(retour))) {
				retour=i;
			}
		}

		return retour; 
	}

	public void removeFace(int idx) {
		this.x.remove(idx);
		this.y.remove(idx);
		this.z.remove(idx);
	}
}

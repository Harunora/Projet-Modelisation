package graph;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasWriter {

	public Graph listface;
	public Canvas canvas;

	public GraphicsContext graphicContext;
	protected javafx.scene.paint.Color modelColor;
	protected javafx.scene.paint.Color backgroundColor;
	protected List<double[]> x;
	protected List<double[]> y;
	protected List<double[]> z;
	protected double height;
	protected double width;
	private boolean linePrint = true;
	private boolean colorPrint = true;
	public int homothesie=-100;


	public CanvasWriter(Canvas c, Graph lf) {
		x=new ArrayList<double[]>();
		y=new ArrayList<double[]>();
		z=new ArrayList<double[]>();
		modelColor = modelColor.WHITE;
		backgroundColor = backgroundColor.GRAY;
		canvas=c;
		graphicContext=c.getGraphicsContext2D();
		width=c.getWidth()/2;
		height=c.getHeight()/2;
		listface=lf;
		useGraph();
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
		clear(backgroundColor);
		int idx=0;
		while(this.x.size()!=0) {
			idx=getPositionHighestZ();
			if(colorPrint) {
				graphicContext.setFill(modelColor);
				graphicContext.fillPolygon(this.x.get(idx),this.y.get(idx), this.y.get(idx).length);
			}
			if(linePrint) {
				graphicContext.strokePolygon(this.x.get(idx),this.y.get(idx), this.y.get(idx).length);
			}
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
	
	public void inversePrintLine() {
		this.linePrint=!this.linePrint;
	}
	
	public void inversePrintColor() {
		this.colorPrint=!this.colorPrint;
	}

	public void removeFace(int idx) {
		this.x.remove(idx);
		this.y.remove(idx);
		this.z.remove(idx);
	}

	public void setModelColor(Color value) {
		this.modelColor=value;
		System.out.println(modelColor);
		useGraph();
		
	}
	
	public void setBackgroundColor(Color value) {
		this.backgroundColor=value;
		System.out.println(backgroundColor);
		useGraph();
		
	}
}

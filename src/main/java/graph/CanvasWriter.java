package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import mvc.Observer;
import mvc.Subject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


/**
 * The Class CanvasWriter.
 * 
 * @author christopher
 */
public class CanvasWriter implements Observer{

	/** The model. */
	public Graph model;
	
	/** The canvas. */
	public Canvas canvas;
	
	/** The graphic context. */
	public GraphicsContext graphicContext;
	
	/** The point color. */
	protected Color pointColor, backgroundColor, lineColor;
	
	/** all the list of coordinates. */
	protected List<double[]> xCoordinate, yCoordinate,zCoordinate;
	
	/** The color. */
	protected List<Color> color;
	
	/** The height and the width */
	protected double height, width;
	
	/** The line print. */
	private boolean linePrint = true, colorPrint = true, pointPrint = true;

	/**
	 * Instantiates a new canvas writer.
	 *
	 * @param canvas the c
	 * @param graph the lf
	 */
	public CanvasWriter(Canvas canvas, Graph graph) {
		xCoordinate=new ArrayList<double[]>();
		yCoordinate=new ArrayList<double[]>();
		zCoordinate=new ArrayList<double[]>();
		color=new ArrayList<Color>();
		backgroundColor = Color.GRAY;
		lineColor= Color.BLACK;
		pointColor=Color.BLACK;
		this.canvas=canvas;
		graphicContext=canvas.getGraphicsContext2D();
		width=canvas.getWidth()/2;
		height=canvas.getHeight()/2;
		model=graph;
		this.update(model);
	}

	/**
	 * Write on canvas.
	 */
	public void writeOnCanvas() {
		clear(backgroundColor);
		for(int i=0;i<this.xCoordinate.size();i++){
			if(pointPrint) {
				graphicContext.setStroke(pointColor);
				for(int j=0;j<this.xCoordinate.get(i).length;j++) {
					graphicContext.strokeOval(this.xCoordinate.get(i)[j]-1,this.yCoordinate.get(i)[j]-1,2, 2);
				}
			}
			if(colorPrint) {
				graphicContext.setFill(this.color.get(i));
				graphicContext.fillPolygon(this.xCoordinate.get(i),this.yCoordinate.get(i), this.yCoordinate.get(i).length);
			}
			if(linePrint) {
				graphicContext.setStroke(lineColor);
				graphicContext.strokePolygon(this.xCoordinate.get(i),this.yCoordinate.get(i), this.yCoordinate.get(i).length);
			}
		}
	}

	/**
	 * Clear.
	 *
	 * @param color the new color
	 */
	public void clear(Paint color) {
		graphicContext.setFill(color);
		graphicContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

	}

	/**
	 * Use graph.
	 */
	public void useGraph() {
		double[] xFace, yFace, zFace;
		this.xCoordinate.clear();
		this.yCoordinate.clear();
		this.zCoordinate.clear();
		this.color.clear();
		Collections.sort(model.getFaces());
		for(int index=0;index<model.getNbFaces();index++) {
			xFace=new double[this.model.getFace(index).nbvertices];
			yFace=new double[this.model.getFace(index).nbvertices];
		    zFace=new double[this.model.getFace(index).nbvertices];
			for(int j=0;j<this.model.getFace(index).nbvertices;j++) {
				xFace[j]=this.model.getFaceX(index, j)*100+height;
				yFace[j]=this.model.getFaceY(index, j)*100+width;
				zFace[j]=this.model.getFaceZ(index, j)*100+width;
			}
			this.xCoordinate.add(xFace);
			this.yCoordinate.add(yFace);
			this.zCoordinate.add(zFace);
			Color colorTmp=this.model.getFace(index).getColor();
			this.color.add(colorTmp);
		}
		writeOnCanvas();
	}

	/**
	 * Prints the line.
	 *
	 * @param value the value
	 */
	public void printLine(boolean value) {
		this.linePrint=value;
	}

	/**
	 * Prints the color.
	 *
	 * @param value the value
	 */
	public void printColor(boolean value) {
		this.colorPrint=value;
	}
	
	/**
	 * Prints the point.
	 *
	 * @param value the value
	 */
	public void printPoint(boolean value) {
		this.pointPrint=value;
	}
	
	/**
	 * Sets the background color.
	 *
	 * @param value the new background color
	 */
	public void setBackgroundColor(Color value) {
		this.backgroundColor=value;
		useGraph();
	}
	
	/**
	 * Sets the line color.
	 *
	 * @param value the new line color
	 */
	public void setLineColor(Color value) {
		this.lineColor=value;
		useGraph();
	}
	
	/**
	 * Sets the point color.
	 *
	 * @param value the new point color
	 */
	public void setPointColor(Color value) {
		this.pointColor=value;
		useGraph();
	}

	/**
	 * Update.
	 *
	 * @param subj the subj
	 */
	@Override
	public void update(Subject subj) {
		// TODO Auto-generated method stub
		update(subj, null);
	}

	/**
	 * Update.
	 *
	 * @param subj the subj
	 * @param data the data
	 */
	@Override
	public void update(Subject subj, Object data) {
		this.model= (UpdateGraph) subj;
		useGraph();
	}

}

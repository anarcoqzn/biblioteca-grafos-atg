package model.vertex;

import java.util.ArrayList;
import java.util.List;

public abstract class Vertex {
	
	protected String id;
	protected List<Vertex> connectedVertices;
	protected boolean ink;
	
	private double distanciaMin = Double.MAX_VALUE;
	
	public Vertex(String id) {
		this.id = id;
		connectedVertices = new ArrayList<>();
		this.ink = false;
	}
	
	public String getId() {
		return this.id;
	}

	public boolean getInk() {
		return ink;
	}
	
	public void setInk(boolean ink) {
		this.ink = ink;
	}

	public List<Vertex> getConnectedVertices(){
		return this.connectedVertices;
	}
	
	public int hashCode() {
		return Integer.parseInt(id);
	}
	
	@Override
	public boolean equals(Object obj) {
			if(obj instanceof Vertex) {
				obj = (Vertex) obj;
				if(obj.hashCode() == this.hashCode()) return true;
			}
		return false;
	}
	
	@Override
	public String toString() {
		return getId();
	}

	public double getDistanciaMin() {
		return distanciaMin;
	}

	public void setDistanciaMin(double distanciaMin) {
		this.distanciaMin = distanciaMin;
	}
}

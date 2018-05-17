package model.vertex;

import java.util.List;

public abstract class Vertex {
	
	protected String id;
	protected List<Vertex> connectedVertices;
	protected boolean ink;
	protected int depth;
	
	public String getId() {
		return this.id;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth; 
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
	
	public void addConnectedVertex(Vertex v) {
		this.connectedVertices.add(v);
	}
	
	public int hashCode() {
		return Integer.parseInt(id);
	}
	
	@Override
	public boolean equals(Object obj) {
			if(obj instanceof Vertex) {
				obj = (VWeighted) obj;
				if(obj.hashCode() == this.hashCode()) return true;
			}
		return false;
	}
	
	@Override
	public String toString() {
		return getId();
	}
}

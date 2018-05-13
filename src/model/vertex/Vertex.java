package model.vertex;

import java.util.List;

public abstract class Vertex {
	
	protected String id;
	protected List<Vertex> connectedVertices;
	
	public String getId() {
		return this.id;
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

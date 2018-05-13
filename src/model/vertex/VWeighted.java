package model.vertex;

import java.util.ArrayList;
import java.util.List;

public class VWeighted extends Vertex{
	
	protected List<Float> edgeWeights; 
	
	public VWeighted(String id) {
		super(id);
		this.edgeWeights = new ArrayList<>();
	}
	
	public List<Float> getEdgeWeights() {
		return edgeWeights;
	}
	
	public void connectTo(Vertex vertex, Float weight) {
		this.connectedVertices.add(vertex);
		this.edgeWeights.add(weight);
		
		vertex.connectedVertices.add(this);
		((VWeighted) vertex).edgeWeights.add(weight); 
	}
	
	public Float getConnectionWeight(Vertex vertex) {
		return edgeWeights.get(this.connectedVertices.indexOf(vertex));
	}
}

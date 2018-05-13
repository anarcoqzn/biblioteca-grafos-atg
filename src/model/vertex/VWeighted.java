package model.vertex;

import java.util.ArrayList;
import java.util.List;

public class VWeighted extends Vertex{
	
	protected List<Float> edgeWeights; 
	
	public VWeighted(String id) {
		this.id = id;
		this.edgeWeights = new ArrayList<>();
		this.connectedVertices = new ArrayList<>();
	}
	
	public List<Float> getEdgeWeights() {
		return edgeWeights;
	}
}

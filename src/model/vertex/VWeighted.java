package model.vertex;

import java.util.ArrayList;
import java.util.List;

public class VWeighted extends Vertex{
	
	protected List<Float> connectionWeights; 
	
	public VWeighted(String id) {
		this.id = id;
		this.connectionWeights = new ArrayList<>();
		this.connectedVertices = new ArrayList<>();
	}
}

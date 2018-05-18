package model.graph;

import model.vertex.VNormal;
import model.vertex.Vertex;

public class GNormal extends Graph{
	

	public GNormal(int verticesQuantity) {
		super(verticesQuantity);
	}
	
	public void addConnection(Vertex v1, Vertex v2) {
		if(searchVertexById(v1.getId()) != null && searchVertexById(v2.getId()) != null) {
			((VNormal) v1).connectTo(v2);
		}
	}
}

package model.graph;

import model.vertex.VNormal;
import model.vertex.Vertex;

public class GNormal extends Graph{
	

	public GNormal(int verticesQuantity) {
		super(verticesQuantity);
	}
	
	public void addConnection(Vertex vertex1, Vertex vertex2) {
		if(searchVertexById(vertex1.getId()) != null && searchVertexById(vertex2.getId()) != null) {
			((VNormal) vertex1).connectTo(vertex2);
		}
	}
}

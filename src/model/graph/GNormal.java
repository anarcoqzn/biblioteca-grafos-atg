package model.graph;

import model.vertex.VNormal;

public class GNormal extends Graph{
	

	public GNormal(int verticesQuantity) {
		super(verticesQuantity);
	}
	
	public void addConnection(VNormal v1, VNormal v2) {
		this.vertices.add(v1);
		this.vertices.add(v2);
		
		v1.connectTo(v2);
	}
	
}

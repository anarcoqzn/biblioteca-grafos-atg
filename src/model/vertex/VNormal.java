package model.vertex;

import java.util.ArrayList;

public class VNormal extends Vertex{

	public VNormal(String id) {
		super(id);
	}
	
	public void connectTo(Vertex vertex) {
		this.connectedVertices.add(vertex);
		vertex.connectedVertices.add(this);
	}
}

package model.vertex;

import java.util.ArrayList;

public class VNormal extends Vertex{

	public VNormal(String id) {
		this.id = id;
		this.connectedVertices = new ArrayList<>();
		this.ink = false;
	}
}

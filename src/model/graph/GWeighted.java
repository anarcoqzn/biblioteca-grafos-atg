package model.graph;

import model.vertex.VWeighted;
import model.vertex.Vertex;

public class GWeighted extends Graph{
	
	public GWeighted(int verticesQuantity) {
		super(verticesQuantity);
	}
	
	public void addConnection(Vertex v1, Vertex v2, Float weight) {
		if(searchVertexById(v1.getId()) != null && searchVertexById(v2.getId()) != null) {
			((VWeighted) v1).connectTo(v2, weight);
		}
	}
	
	public String toString() {
		vertices.forEach(v -> v.getConnectedVertices().forEach(
				connection -> System.out.println(v + " -> "+ ((VWeighted) v).getConnectionWeight(connection)+" -> "+ connection))); 
		
		return "Quantidade de vertices: " + vertices.size();
	}
}

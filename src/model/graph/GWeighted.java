package model.graph;

import model.vertex.VWeighted;

public class GWeighted extends Graph{
	
	public GWeighted(int verticesQuantity) {
		super(verticesQuantity);
	}
	
	public void addConnection(VWeighted vertex1, VWeighted vertex2, Float weight) {
		this.vertices.add(vertex1);
		this.vertices.add(vertex2);
		
		vertex1.connectTo(vertex2, weight);
	}
	
	public String toString() {
		vertices.forEach(v -> v.getConnectedVertices().forEach(
				connection -> System.out.println(v + " -> "+ ((VWeighted) v).getConnectionWeight(connection)+" -> "+ connection))); 
		
		return "Quantidade de vertices: " + vertices.size();
	}
}

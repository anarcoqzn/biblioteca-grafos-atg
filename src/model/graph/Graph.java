package model.graph;

import java.util.ArrayList;
import java.util.List;
import model.vertex.*;

public abstract class Graph {
	
	protected List<Vertex> vertices;
	protected int verticesQuantity;
	
	public Graph(int verticesQuantity) {
		this.verticesQuantity = verticesQuantity;
		this.vertices = new ArrayList<>(verticesQuantity);
	}
	
	public Vertex searchVertexById(String id) {
		
		for(Vertex v: vertices) {
			if(v.getId().equals(id)) return v;
		}
		return null;
	}
	
	public void addVertex(Vertex vertex) {
		if(this.vertices.contains(vertex)) System.out.println("Vertex already existis in this graph");
		else {
			vertices.add(vertex);
		}
	}

	@Override
	public String toString() {
		vertices.forEach(v -> v.getConnectedVertices().forEach(
				connection -> System.out.println(v + " -> " + connection))); 
		
		return "Quantidade de vertices: " + vertices.size();
	}
}

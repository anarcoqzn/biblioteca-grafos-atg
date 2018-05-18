package model.graph;

import java.util.ArrayList;
import java.util.List;
import model.vertex.*;
import model.edge.*;

public abstract class Graph {
	
	protected List<Vertex> vertices;
	protected int vertexQuantity;
	protected List<Edge> edges;
	
	public Graph(int verticesQuantity) {
		this.vertexQuantity = verticesQuantity;
		this.vertices = new ArrayList<>(verticesQuantity);
		this.edges = new ArrayList<>();
	}
	
	public Vertex searchVertexById(String id) {
		
		for(Vertex vertex: vertices) {
			if(vertex.getId().equals(id)) return vertex;
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

	public boolean isColored () {
		for(Vertex v : vertices) {
			if(v.getInk() == false) {
				return false;
			}	
		}
		return true;
	}
	
	public int getVertexNumber() {
		return vertices.size();
	}
	
	public List<Vertex> getVertices() {
		return vertices;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
}

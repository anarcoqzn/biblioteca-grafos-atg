package model.graph;

import java.util.ArrayList;
import java.util.List;
import model.vertex.*;

public abstract class Graph {
	
	protected List<Vertex> graph;
	
	public Graph() {
		graph = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		graph.forEach(v -> v.getConnectedVertices().forEach(
				connection -> System.out.println(v + " -> " + connection))); 
		
		return "Quantidade de vertices: " + graph.size();
	}
	
	public Vertex searchVertexById(String id) {
		
		for(Vertex v: graph) {
			if(v.getId().equals(id)) return v;
		}
		return null;
	}
}

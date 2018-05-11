package base;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> graph;
	
	public Graph() {
		graph = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		graph.forEach(v -> v.getConnectedVertices().keySet().forEach(
				connection -> System.out.println(v + " -> "+v.getConnectedVertices().get(connection)+" -> "+ connection))); 
		
		return "Quantidade de vertices: " + graph.size();
	}
	
	public Vertex searchVertexById(String id) {
		
		for(Vertex v: graph) {
			if(v.getId().equals(id)) return v;
		}
		return null;
	}
	
	public void adicionaVertice(Vertex v) {
		graph.add(v);
	}
}

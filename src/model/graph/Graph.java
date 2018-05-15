package model.graph;

import java.util.ArrayList;
import java.util.List;
import model.vertex.*;

public abstract class Graph {
	
	protected List<Vertex> graph;
	
	public Graph() {
		graph = new ArrayList<>();
	}
	
	public boolean isColored () {
		for(Vertex v : this.graph) {
			if(v.getInk() == false) {
				return false;
			}	
		}
		return true;
	}
	
	public List getListofVertex() {
		return graph;
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

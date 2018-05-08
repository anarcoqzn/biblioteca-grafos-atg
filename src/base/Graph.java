package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> graph;
	
	public Graph() {
		graph = new ArrayList<>();
	}
	
	public void readWeightedGraph(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		 int allVertices = Integer.parseInt(reader.readLine());
		 String[] line;
		 Float weight;
		 
	        for(int i = 0; i <= allVertices; i++) {
	        	
	                line = reader.readLine().split(" ");               
	             	weight = Float.parseFloat(line[2]);                                  
	                
	                Vertex firstVertex = searchVertexById(line[0]);
	                Vertex secondVertex = searchVertexById(line[1]);
	                
	                if(firstVertex != null && secondVertex != null) firstVertex.addWeightedConnection(secondVertex, weight);
	                
	                else if(firstVertex != null && secondVertex == null){
	                	
	                	secondVertex = new Vertex(line[1]);
	               		firstVertex.addWeightedConnection(secondVertex, weight);
	               		graph.add(secondVertex);
	        	                	
	                }else if(firstVertex == null && secondVertex != null) {
	                	
	                	firstVertex = new Vertex(line[0]);
	                	firstVertex.addWeightedConnection(secondVertex, weight);
	                	graph.add(firstVertex);
	                	
	                }else {
	                	firstVertex = new Vertex(line[0]);
	                	secondVertex = new Vertex(line[1]);
	                	
	                	firstVertex.addWeightedConnection(secondVertex, weight);
	                	graph.add(firstVertex);
	                	graph.add(secondVertex);
	                }   
	        }
	        reader.close();
	}
	
	@Override
	public String toString() {
		graph.forEach(v -> v.getConnectedVertices().keySet().forEach(
				connection -> System.out.println(v + " -> "+v.getConnectedVertices().get(connection)+" -> "+ connection))); 
		
		return "Quantidade de vertices: " + graph.size();
	}
	
	private Vertex searchVertexById(String id) {
		
		for(Vertex v: graph) {
			if(v.getId().equals(id)) return v;
		}
		return null;
	}
}

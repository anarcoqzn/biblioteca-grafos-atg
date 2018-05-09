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
		String line1 = reader.readLine();
		Float weight;
			
			do{
					String[] vertexData = line1.split(" ");
	             	weight = Float.parseFloat(vertexData[2]);                                  
	                
	                Vertex firstVertex = searchVertexById(vertexData[0]);
	                Vertex secondVertex = searchVertexById(vertexData[1]);
	                
	                if(firstVertex != null && secondVertex != null) firstVertex.addWeightedConnection(secondVertex, weight);
	                
	                else if(firstVertex != null && secondVertex == null){
	                	
	                	secondVertex = new Vertex(vertexData[1]);
	               		firstVertex.addWeightedConnection(secondVertex, weight);
	               		graph.add(secondVertex);
	        	                	
	                }else if(firstVertex == null && secondVertex != null) {
	                	
	                	firstVertex = new Vertex(vertexData[0]);
	                	firstVertex.addWeightedConnection(secondVertex, weight);
	                	graph.add(firstVertex);
	                	
	                }else {
	                	firstVertex = new Vertex(vertexData[0]);
	                	secondVertex = new Vertex(vertexData[1]);
	                	
	                	firstVertex.addWeightedConnection(secondVertex, weight);
	                	graph.add(firstVertex);
	                	graph.add(secondVertex);
	                }   
	                line1 = reader.readLine();
	                               
	        }while(line1 != null);
			
	        reader.close();
	}
	
	public Float getMeanEdge(Graph graph) {
		return null;
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

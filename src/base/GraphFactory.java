package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class GraphFactory {
	
	public static Graph readWeightedGraph(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		Graph graph = new Graph();
		
		int allVertices = Integer.parseInt(reader.readLine());
		String line1 = reader.readLine();
		Float weight;
			
			do{
					String[] vertexData = line1.split(" ");
	             	weight = Float.parseFloat(vertexData[2]);                                  
	                
	                Vertex firstVertex = graph.searchVertexById(vertexData[0]);
	                Vertex secondVertex = graph.searchVertexById(vertexData[1]);
	                
	                if(firstVertex != null && secondVertex != null) firstVertex.addWeightedConnection(secondVertex, weight);
	                
	                else if(firstVertex != null && secondVertex == null){
	                	
	                	secondVertex = new Vertex(vertexData[1]);
	               		firstVertex.addWeightedConnection(secondVertex, weight);
	               		graph.adicionaVertice(secondVertex);
	        	                	
	                }else if(firstVertex == null && secondVertex != null) {
	                	
	                	firstVertex = new Vertex(vertexData[0]);
	                	firstVertex.addWeightedConnection(secondVertex, weight);
	                	graph.adicionaVertice(firstVertex);
	                	
	                }else {
	                	firstVertex = new Vertex(vertexData[0]);
	                	secondVertex = new Vertex(vertexData[1]);
	                	
	                	firstVertex.addWeightedConnection(secondVertex, weight);
	                	graph.adicionaVertice(firstVertex);
	                	graph.adicionaVertice(secondVertex);
	                }   
	                line1 = reader.readLine();
	                               
	        }while(line1 != null);
			
	        reader.close();
	        return graph;
	}
	
	public static void readGraph(String path) {
		
	}


}

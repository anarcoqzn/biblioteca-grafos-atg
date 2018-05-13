package manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.graph.GWeighted;
import model.graph.Graph;
import model.vertex.VWeighted;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	@Override
	public Graph readGraph(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graph readWeightedGraph(String path) throws IOException  {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			int verticesQuantity = Integer.parseInt(reader.readLine());
			
			Graph graph = new GWeighted(verticesQuantity);			
			String line1 = reader.readLine();
			Float weight;
				
				do{
						String[] vertexData = line1.split(" ");
		             	weight = Float.parseFloat(vertexData[2]);                                  
		                
		                VWeighted firstVertex = (VWeighted) graph.searchVertexById(vertexData[0]);
		                VWeighted secondVertex = (VWeighted) graph.searchVertexById(vertexData[1]);
		                
		                if(firstVertex != null && secondVertex != null) firstVertex.connectTo(secondVertex, weight);
		                
		                else if(firstVertex != null && secondVertex == null){
		                	
		                	secondVertex = new VWeighted(vertexData[1]);
		               		firstVertex.connectTo(secondVertex, weight);
		               		graph.addVertex(secondVertex);
		        	                	
		                }else if(firstVertex == null && secondVertex != null) {
		                	
		                	firstVertex = new VWeighted(vertexData[0]);
		                	firstVertex.connectTo(secondVertex, weight);
		                	graph.addVertex(firstVertex);
		                	
		                }else {
		                	firstVertex = new VWeighted(vertexData[0]);
		                	secondVertex = new VWeighted(vertexData[1]);
		                	
		                	firstVertex.connectTo(secondVertex, weight);
		                	graph.addVertex(firstVertex);
		                	graph.addVertex(secondVertex);
		                }   
		                line1 = reader.readLine();
		                               
		        }while(line1 != null);
				
		        reader.close();
	        return graph;
	}

	@Override
	public int getVertexNumber(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEdgeNumber(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMeanEdge(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String graphRepresentation(Graph graph, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BFS(Graph graph, Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DFS(Graph graph, Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean connected(Graph graph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String shortestPath(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mst(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

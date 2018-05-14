package manager;

import java.io.IOException;

import model.graph.Graph;
import model.vertex.Vertex;


/**
 * 
 * @authors Anarco Nascimento, Helena Dantas, Lílian Teixeira, Manoel Neto and Victor Arruda
 * 
 * This library is capable of creating and representing graphs, and manipulating a set of classical algorithms over graphs
 * 
 */
public interface GraphManageable {
	
	public Graph readGraph(String path) throws IOException;
	public Graph readWeightedGraph(String path);
	
	public int getVertexNumber(Graph graph);
	public int getEdgeNumber(Graph graph) ;
	public float getMeanEdge(Graph graph);
	
	public String graphRepresentation (Graph graph,String type);
	
	public String BFS(Graph graph,Vertex v); 
	public String DFS(Graph graph,Vertex v);
	
	public boolean connected(Graph graph);
	public String shortestPath(Vertex v1, Vertex v2);
	
	public String mst(Graph graph); 
}


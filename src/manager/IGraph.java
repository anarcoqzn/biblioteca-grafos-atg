package manager;

import model.graph.Graph;
import model.vertex.VWeighted;

public interface IGraph {

	public void readGraph(String path);
	public void readWeightedGraph(String path);
	
	
	public int getVertexNumber(Graph graph);
	public int getEdgeNumber(Graph graph) ;
	public float getMeanEdge(Graph graph);
	
	public String graphRepresentation (Graph graph,String type);
	
	public String BFS(Graph graph,VWeighted v); 
	public String DFS(Graph graph,VWeighted v);
	
	public String SCC(Graph graph);
	public String shortestPath(VWeighted v1,VWeighted v2);
	
	public String mst(Graph graph); 
}


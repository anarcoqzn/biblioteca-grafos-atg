package base;

public interface IGraph {

	public void readGraph(String path);
	public void readWeightedGraph(String path);
	
	
	public int getVertexNumber(Graph graph);
	public int getEdgeNumber(Graph graph) ;
	public float getMeanEdge(Graph graph);
	
	public String graphRepresentation (Graph graph,String type);
	
	public String BFS(Graph graph,Vertex v); 
	public String DFS(Graph graph,Vertex v);
	
	public String SCC(Graph graph);
	public String shortestPath(Vertex v1,Vertex v2);
	
	public String mst(Graph graph); 
}


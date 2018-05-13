package manager;

import model.graph.Graph;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	@Override
	public Graph readGraph(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graph readWeightedGraph(String path) {
		// TODO Auto-generated method stub
		return null;
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

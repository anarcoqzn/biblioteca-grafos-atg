

import java.io.IOException;

import manager.GraphManageable;
import manager.GraphManager;
import model.graph.Graph;
import model.vertex.Vertex; //

public class Main {

	public static void main(String[] args) throws IOException {
	
		GraphManageable manager = new GraphManager();
		
		Graph g = manager.readWeightedGraph("resources/weightedGraph.txt");
		
		System.out.println(g);
				
		Graph g2 = manager.readGraph("resources/simpleGraph.txt");
		
		System.out.println(g2);

		//testes
		
		Vertex v1 = g.searchVertexById("1");
		Vertex v2 = g.searchVertexById("4");
		
		manager.shortestPath(g, v1, v2);
		
	}
}

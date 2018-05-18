

import java.io.IOException;

import manager.GraphManageable;
import manager.GraphManager;
import model.graph.Graph;
import model.vertex.Vertex;

public class Main {

	public static void main(String[] args) throws IOException {
		
		GraphManageable manager = new GraphManager();
		
		Graph g = manager.readWeightedGraph("resources/weightedGraph.txt");
		
		System.out.println("Grafo com pesos" + "\n");
		System.out.println(g + "\n");
				
		Graph g2 = manager.readGraph("resources/simpleGraph.txt");

		System.out.println("Grafo normal" + "\n");
		System.out.println(g2 + "\n");
		
		int g3 = manager.getEdgeNumber(manager.readGraph("resources/weightedGraph.txt"));
		
		System.out.println("Número de arestas --> " + g3);
			
	}
}

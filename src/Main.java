

import java.io.IOException;

import manager.GraphManageable;
import manager.GraphManager;
import model.graph.Graph;

public class Main {

	public static void main(String[] args) throws IOException {
	
		GraphManageable manager = new GraphManager();
		
		Graph g = manager.readWeightedGraph("resources/grafo.txt");
		
		System.out.println(g);
		
	}

}



import java.io.IOException;

import manager.GraphManageable;
import manager.GraphManager;
import model.graph.Graph;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Graph grafo;
		
//		grafo = GraphFactory.readWeightedGraph("resources/grafo.txt");
		
		
//		Graph g2 = ManipuladorGrafo.readGraph("path");
		
//		System.out.println(grafo);
		
		grafo = GraphManager.readGraph1("resources/grafoSimples.txt");//("C:\\Users\\lilia\\Desktop\\grafos.txt");//"resources/grafoSimples.txt");
		
		///////////////////////////////////
		

		GraphManageable manager = new GraphManager();
		
		Graph g = manager.readWeightedGraph("resources/grafo.txt");
		
		System.out.println(g);
	}

}

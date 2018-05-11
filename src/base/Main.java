package base;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Graph grafo = new Graph();
		
		grafo = GraphFactory.readWeightedGraph("resources/grafo.txt");
		
		
//		Graph g2 = ManipuladorGrafo.readGraph("path");
		
		System.out.println(grafo);
	}

}

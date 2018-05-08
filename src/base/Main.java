package base;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Graph grafo = new Graph();
		
		grafo.readWeightedGraph("resources/grafo.txt");
		
		
		System.out.println(grafo);
	}

}

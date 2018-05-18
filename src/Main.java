

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import manager.GraphManageable;
import manager.GraphManager;
import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.Vertex; //

public class Main {

	public static void main(String[] args) throws IOException {
	
		GraphManager manager = new GraphManager();
		Graph graph;
		
		Graph g = manager.readWeightedGraph("resources/weightedGraph.txt");
		
		//System.out.println("Grafo com pesos" + "\n");
		//System.out.println(g + "\n");
				
		Graph g2 = manager.readGraph("resources/simpleGraph.txt");
		
		Vertex vertex;
		
		graph = manager.readGraph("resources/weightedGraph.txt");
		Vertex t1 = graph.searchVertexById("1");
	//	System.out.println( "t " + t1 + " --> tt");
		
		
		Graph g3;
		g3 = manager.readGraph("resources/simpleGraph.txt");
		
		String graph1 = manager.graphRepresentation(g3, "AL");
		System.out.println(graph1);
		
		
		
		//System.out.println(g2);
		
		//teste classe Edge
		/*System.out.println(g2.getEdges());

		System.out.println("Grafo normal" + "\n");
		System.out.println(g2 + "\n");
		//testes shortestPath
		Vertex v1 = g.searchVertexById("1");
		Vertex v2 = g.searchVertexById("5");
		manager.shortestPath(g, v1, v2);
		
		System.out.println(g2);
		*/
		
		int g5 = manager.getEdgeNumber(manager.readGraph("resources/weightedGraph.txt"));
		//System.out.println(manager.getMeanEdge(g));
		
		
	//	System.out.println("Número de arestas --> " + g3);
		
		
		int g4 = manager.getVertexNumber(manager.readGraph("resources/simpleGraph.txt"));
	//	System.out.println("Número do vertices --> " + g4);
		
	//	float g5 = manager.getMeanEdge(manager.readGraph("resources/weightedGraph.txt"));
		//System.out.println("tt" + g5);
			
		// testes bfs,dfs,connected
		/*
		VNormal vv1 = new VNormal("1");
		VNormal vv2 = new VNormal("2");
		VNormal vv3 = new VNormal("3");
		VNormal vv4 = new VNormal("4");
		VNormal vv5 = new VNormal("5");
		vv1.connectTo(vv2);
		vv1.connectTo(vv5);
		vv2.connectTo(vv5);
		vv5.connectTo(vv3);
		vv5.connectTo(vv4);
		GNormal g1 = new GNormal(5);
		g1.addVertex(vv1);
		g1.addVertex(vv2);
		g1.addVertex(vv3);
		g1.addVertex(vv4);
		g1.addVertex(vv5);
		
		String bfs = manager.BFS(g1, vv1);
		String dfs = manager.DFS(g1, vv1);
		
		System.out.println(bfs);
		System.out.println(dfs);
		if(manager.connected(g1)) {
			System.out.println("é conexo");
		}
		else {
			System.out.println("é desconexo");
		}*/
		
		System.out.println(manager.graphRepresentation(g2,""));
		List<Vertex> path = new ArrayList<>();
		List<List<Vertex>> path2 = new ArrayList<>();
		Vertex v1 = g.searchVertexById("1");
		Vertex v2 = g.searchVertexById("5");
		System.out.println(manager.shortestPath(g, v1, v2));
		
	}
}

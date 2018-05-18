

import java.io.IOException;

import manager.GraphManageable;
import manager.GraphManager;
import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.Vertex; //

public class Main {

	public static void main(String[] args) throws IOException {
	
		GraphManageable manager = new GraphManager();
		
		Graph g = manager.readWeightedGraph("resources/weightedGraph.txt");
		
		System.out.println("Grafo com pesos" + "\n");
		System.out.println(g + "\n");
				
		Graph g2 = manager.readGraph("resources/simpleGraph.txt");
		
		System.out.println(g2);
		
		//teste classe Edge
		System.out.println(g2.getEdges());

		System.out.println("Grafo normal" + "\n");
		System.out.println(g2 + "\n");
		//testes shortestPath
		Vertex v1 = g.searchVertexById("1");
		Vertex v2 = g.searchVertexById("5");
		manager.shortestPath(g, v1, v2);
		
		System.out.println(g2);
		int g3 = manager.getEdgeNumber(manager.readGraph("resources/weightedGraph.txt"));
		System.out.println(manager.getMeanEdge(g));
		
		System.out.println("Número de arestas --> " + g3);
			
		// testes bfs,dfs,connected
		
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
		}
		
		
	}
}

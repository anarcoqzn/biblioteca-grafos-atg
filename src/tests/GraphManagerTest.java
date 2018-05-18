package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import manager.GraphManager;
import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;

public class GraphManagerTest {
	
	GraphManager manager;
	Graph simpleGraph;
	Graph weightedGraph;
	VNormal v1;
	VNormal v2;
	VNormal v3;
	VNormal v4;
	VNormal v5;
	GNormal g1;
	
	
	
	@Before
	public void setUp() {
		
		manager = new GraphManager();
		simpleGraph = manager.readGraph("resources/simpleGraph.txt");
		weightedGraph = manager.readWeightedGraph("resources/weightedGraph.txt");
		v1 = new VNormal("1");
		v2 = new VNormal("2");
		v3 = new VNormal("3");
		v4 = new VNormal("4");
		v5 = new VNormal("5");
		v1.connectTo(v2);
		v1.connectTo(v5);
		v2.connectTo(v5);
		v3.connectTo(v5);
		v4.connectTo(v5);
		g1 = new GNormal(5);
		g1.addVertex(v1);
		g1.addVertex(v2);
		g1.addVertex(v3);
		g1.addVertex(v4);
		g1.addVertex(v5);
		
	}
	
	@Test
	public void readGraphTest() {
		
	}
	
	@Test
	public void readWeightedGraphTest() {
		
	}
	
	@Test
	public void getEdgeNumberTest() {
		
		int edge1 = manager.getEdgeNumber(simpleGraph);
		assertEquals(5, edge1);
		
		int edge2 = manager.getEdgeNumber(weightedGraph);
		assertEquals(6, edge2);
		
	}
	
	@Test
	public void getVertexNumberTest() {
		
		int vertex1 = manager.getVertexNumber(simpleGraph);
		assertEquals(5, vertex1);
		
		int vertex2 = manager.getVertexNumber(weightedGraph);
		assertEquals(5, vertex2);
		
	}
	
	
	@Test
	public void getMeanEdgeTest() {
		
		float meanEdge1 = manager.getMeanEdge(weightedGraph);
		assertEquals(2.4, meanEdge1, 0.1);
		
		float meanEdge2 = manager.getMeanEdge(simpleGraph);
		assertEquals(2.0, meanEdge2, 0.1);
		
		
		
	}
	
	@Test
	public void getRepresentationTest() {
		
	}
	
	@Test
	public void bfsGNormalTest() {
		String bfs = manager.BFS(g1, v1);
		assertEquals("1 - 0 -\n2 - 1 1\n3 - 2 5\n4 - 2 5\n5 - 1 1",bfs);
	}
	
	@Test
	public void dfsGNormalTest(){
		String dfs = manager.DFS(g1, v1);
		assertEquals("1 - 0 -\n2 - 1 1\n3 - 3 5,4 - 3 5\n5 - 2 2",dfs);
	}

}

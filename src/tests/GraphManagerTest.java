package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import manager.GraphManager;
import model.graph.Graph;

public class GraphManagerTest {
	
	GraphManager manager;
	Graph graph;
	
	@Before
	public void setUp() {
		manager = new GraphManager();
	}
	
	@Test
	public void readGraphTest() {
		
	}
	
	@Test
	public void readWeightedGraphTest() {
		
	}
	
	@Test
	public void getEdgeNumberTest() {
		
		graph = manager.readGraph("resources/simpleGraph.txt");
		int edge1 = manager.getEdgeNumber(graph);
		assertEquals(5, edge1);
		
		graph = manager.readGraph("resources/weightedGraph.txt");
		int edge2 = manager.getEdgeNumber(graph);
		assertEquals(6, edge2);
		
	}
	
	@Test
	public void getVertexNumberTest() {
		
		graph = manager.readGraph("resources/simpleGraph.txt");
		int vertex1 = manager.getVertexNumber(graph);
		assertEquals(5, vertex1);
		
		graph = manager.readGraph("resources/weightedGraph.txt");
		int vertex2 = manager.getVertexNumber(graph);
		assertEquals(5, vertex2);
		
	}
	
	
	@Test
	public void getMeanEdgeTest() {
		
	}
	
	@Test
	public void getRepresentationTest() {
		
	}

}

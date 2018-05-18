package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import manager.GraphManager;
import model.graph.Graph;

public class GraphManagerTest {
	
	GraphManager manager;
	Graph simpleGraph;
	Graph weightedGraph;
	
	@Before
	public void setUp() {
		
		manager = new GraphManager();
		simpleGraph = manager.readGraph("resources/simpleGraph.txt");
		weightedGraph = manager.readWeightedGraph("resources/weightedGraph.txt");
		
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

}

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
	Graph graph;
	String representationSimpleAL;
	String representationSimpleAM;
	String representationWeightAL;
	String representationWeightAM;
	
	@Before
	public void setUp() {
		
		manager = new GraphManager();
		simpleGraph = manager.readGraph("resources/simpleGraph.txt");
		weightedGraph = manager.readWeightedGraph("resources/weightedGraph.txt");
		representationSimpleAL = manager.graphRepresentation(simpleGraph, "AL");
		representationSimpleAM = manager.graphRepresentation(simpleGraph, "AM");
		representationWeightAL = manager.graphRepresentation(weightedGraph, "AL");
		representationSimpleAM = manager.graphRepresentation(weightedGraph, "AM");
		
	}
	
	@Test
	public void readGraphTest() {
		
		graph = manager.readGraph("resources/simpleGraph.txt");
		//assertEquals(graph, simpleGraph);
	}
	
	@Test
	public void readWeightedGraphTest() {
		
		graph = manager.readWeightedGraph("resources/weightedGraph.txt");
		//assertEquals(graph, weightedGraph);
		
		
	}
		
	@Test
	public void getVertexNumberTest() {
		
		int vertex1 = manager.getVertexNumber(simpleGraph);
		assertEquals(5, vertex1);
		
		int vertex2 = manager.getVertexNumber(weightedGraph);
		assertEquals(5, vertex2);
		
	}
	
	@Test
	public void getEdgeNumberTest() {
		
		int edge1 = manager.getEdgeNumber(simpleGraph);
		assertEquals(5, edge1);
		
		int edge2 = manager.getEdgeNumber(weightedGraph);
		assertEquals(6, edge2);
		
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
		
		String representationSAL = manager.graphRepresentation(simpleGraph, "AL");
		assertEquals(representationSimpleAL, representationSAL);
		
		String representationSAM = manager.graphRepresentation(simpleGraph, "AM");
		///assertEquals(representationSimpleAM, representationSAM);
		
		String representationWAL = manager.graphRepresentation(weightedGraph, "AL");
		//assertEquals(representationWeightAL, representationSAL);
		
		String representationWAM = manager.graphRepresentation(weightedGraph, "AM");
	//	assertEquals(representationWeightAM, representationWAM);
		
	}
	
	@Test
	public void BFSTest() {
		
	}
	
	@Test
	public void DFSTest() {
		
	}
	
	@Test 
	public void conectedTest() {
		
	}
	
	@Test
	public void shortestPath() {
		
	}
	
	@Test
	public void mstTest() {
		
	}

}

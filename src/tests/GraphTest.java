package tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import manager.GraphManager;
import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.VWeighted;
import model.vertex.Vertex;

public class GraphTest {
	
	int vertexNumber;
	GNormal graphG;
	Graph simpleGraph;
	Graph weightGraph;
	GraphManager manager;
	Vertex vertex ;
	

	@Before
	public void setUp() {
		vertexNumber = 5;
		graphG = new GNormal(vertexNumber);
		manager = new GraphManager();
		simpleGraph = manager.readGraph("resources/simpleGraph.txt");
		weightGraph = manager.readWeightedGraph("resources/weightedGraph.txt");
	}

	@Test
	public void VertexTest() {
		Vertex vertex = new VNormal("1");
		this.graphG.addVertex(vertex);
		assertEquals(1, graphG.getVertexNumber());
		
		vertex = new VNormal("2");
		graphG.addVertex(vertex);
		graphG.addConnection((VNormal)graphG.searchVertexById("1"), (VNormal) graphG.searchVertexById("2"));
		assertEquals(2,graphG.getVertexNumber());
	}
	
	@Test 
	public void searchVertexByIdTest() {
	
		Vertex vertex1 = new VNormal("5");
		vertex = simpleGraph.searchVertexById("5");
		assertEquals(vertex1, vertex);
		
		Vertex vertex2 = new VWeighted("3");
		vertex = weightGraph.searchVertexById("3");
		assertEquals(vertex2, vertex);
		
	}
	
	@Test
	public void isColoredTest() {
		
	}
	
	@Test
	public void getVertexNumber() {
	
		
	}
	
	@Test
	public void getVertices() {
		
	}
	
	@Test
	public void getEdges() {
		
	}
	
}

package tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import manager.GraphManager;
import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.Vertex;

public class GraphTest {
	int vertexNumber;
	GNormal graphG;
	//Graph graph;

	@Before
	public void setUp() {
		vertexNumber = 5;
		graphG = new GNormal(vertexNumber);
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
	
}

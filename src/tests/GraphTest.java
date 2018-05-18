package tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.Vertex;

public class GraphTest {
	int vertexNumber;
	GNormal graph;
	Graph emptyG;

	@Before
	public void setUp() {
		vertexNumber = 5;
		graph = new GNormal(vertexNumber);
	}

	@Test
	public void VertexTest() {
		Vertex vertex = new VNormal("1");
		this.graph.addVertex(vertex);
		assertEquals(1, graph.getVertexNumber());
		
		vertex = new VNormal("2");
		graph.addVertex(vertex);
		graph.addConnection((VNormal)graph.searchVertexById("1"), (VNormal) graph.searchVertexById("2"));
		assertEquals(2,graph.getVertexNumber());
	}
}

package tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.Vertex;

public class GraphTest {
	int vertexNumber;
	Graph graph;
	Graph emptyG;

	@Before
	public void setUp() {
		vertexNumber = 5;
		graph = new GNormal(vertexNumber);
	}

	@Test
	public void VertexTest() {
		Vertex vertex = new VNormal("id1");
		this.graph.addVertex(vertex);
		assertEquals(1, graph.getVertexNumber());
	}
}


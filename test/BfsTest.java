import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import manager.GraphManager;
import model.graph.GNormal;
import model.vertex.VNormal;
import model.vertex.Vertex;

class BfsTest {

	private VNormal v1;
	private VNormal v2;
	private VNormal v3;
	private VNormal v4;
	private VNormal v5;
	private ArrayList<Vertex> vertices;
	private GNormal g1;
	private GraphManager manager;
	
	@Before
	public void setUp() {
		v1 = new VNormal("1");
		v2 = new VNormal("2");
		v3 = new VNormal("3");
		v4 = new VNormal("4");
		v5 = new VNormal("5");
		v1.addConnectedVertex(v2);
		v1.addConnectedVertex(v5);
		v2.addConnectedVertex(v1);
		v2.addConnectedVertex(v5);
		v3.addConnectedVertex(v5);
		v4.addConnectedVertex(v5);
		v5.addConnectedVertex(v1);
		v5.addConnectedVertex(v2);
		v5.addConnectedVertex(v3);
		v5.addConnectedVertex(v4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		g1 = new GNormal(vertices);
		manager = new GraphManager();
	}
	
	@Test
	public void testBfs() {
		String a = g1.toString();
		System.out.println(a);
	}
}



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;

import manager.GraphManager;
import model.graph.GNormal;
import model.vertex.VNormal;
import model.vertex.Vertex;

public class Main {

	public static void main(String[] args) throws IOException {
		
		VNormal v1 = new VNormal("1");
		VNormal v2 = new VNormal("2");
		VNormal v3 = new VNormal("3");
		VNormal v4 = new VNormal("4");
		VNormal v5 = new VNormal("5");
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
		ArrayList<Vertex> vertices = new ArrayList<>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		GNormal g1 = new GNormal(vertices);
		GraphManager manager = new GraphManager();
		
		Boolean connected = manager.connected(g1);
		if(connected) {
			System.out.println("123");
		}else {
			System.out.println("345");
		}
		
	}

}

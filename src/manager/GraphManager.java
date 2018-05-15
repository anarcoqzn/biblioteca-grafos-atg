package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.graph.GNormal;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	@Override
	public Graph readGraph(String path) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader ler; 
		int vertices;
		Graph graph = null;
		String texto;
		String[] quantidadeVertices;
		
		try {
			
			ler = new BufferedReader(new FileReader(path));
			vertices = Integer.parseInt(ler.readLine());
			graph = new GNormal(vertices);
			texto = ler.readLine();
			
			while(texto != null ) {
				
				quantidadeVertices = texto.split("");
				VNormal vertice1 = (VNormal) graph.searchVertexById(quantidadeVertices[0]) ;
				VNormal vertice2 = (VNormal) graph.searchVertexById(quantidadeVertices[1]);
				
				if(vertice1 != null && vertice2 != null) {
					vertice1.connectTo(vertice2);
				}else if(vertice1 != null && vertice2 == null) {
					vertice2 = new VNormal(quantidadeVertices[1]);
					vertice1.connectTo(vertice2);
					graph.addVertex(vertice2);
				}else if(vertice1 == null && vertice2 != null) {
					vertice1 = new VNormal(quantidadeVertices[0]);
					vertice1.connectTo(vertice2);
					graph.addVertex(vertice1);
				}else {
					vertice1 = new VNormal(quantidadeVertices[0]);
					vertice2 = new VNormal(quantidadeVertices[1]);
					
					vertice1.connectTo(vertice2);
					
					graph.addVertex(vertice1);
					graph.addVertex(vertice2);
				}
 			
			}
			ler.close();
		}catch(FileNotFoundException e){  
            e.printStackTrace();  
        }catch(IOException e){  
            e.printStackTrace();  
        }  
		
		return graph;
	}
	
	@Override
	public Graph readWeightedGraph(String path) {
		return null;
	}

	@Override
	public int getVertexNumber(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEdgeNumber(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMeanEdge(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String graphRepresentation(Graph graph, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BFS(Graph graph, Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DFS(Graph graph, Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean connected(Graph graph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String shortestPath(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mst(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

		
}

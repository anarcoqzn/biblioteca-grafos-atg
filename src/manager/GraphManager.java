package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.graph.GNormal;
import model.graph.GWeighted;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.VWeighted;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	@Override
	public Graph readGraph(String path){
		
		BufferedReader ler; 		
		String primeiraLinha = null;
		int quantidadeVertices = 0;
		Graph graph = null;
				
		try {
					
			ler = new BufferedReader(new FileReader(path));
			quantidadeVertices = Integer.parseInt(ler.readLine());
			primeiraLinha = ler.readLine();
			graph = new GNormal(quantidadeVertices);
					
			System.out.println("Quantidade de vertices: " + quantidadeVertices);
					
			do {
					
				String[] quantidadeVertice = primeiraLinha.split(" ");
						
				VNormal vertice1 = (VNormal) graph.searchVertexById(quantidadeVertice[0]) ;
				VNormal vertice2 = (VNormal) graph.searchVertexById(quantidadeVertice[1]);
						
				if(vertice1 != null && vertice2 != null) {
					
					vertice1.connectTo(vertice2);
					
				}else if(vertice1 != null && vertice2 == null) {
					
					vertice2 = new VNormal(quantidadeVertice[1]);
					vertice1.connectTo(vertice2);
					
					graph.addVertex(vertice2);
					
				}else if(vertice1 == null && vertice2 != null) {

					vertice1 = new VNormal(quantidadeVertice[0]);
					vertice1.connectTo(vertice2);
					
					graph.addVertex(vertice1);
						
				}else {
							
					vertice1 = new VNormal(quantidadeVertice[0]);
					vertice2 = new VNormal(quantidadeVertice[1]);
					vertice1.connectTo(vertice2);
							
					graph.addVertex(vertice1);
					graph.addVertex(vertice2);
				}
						
				System.out.println("Arestas : " + quantidadeVertice[0]+ "->" + quantidadeVertice[1]);
				
				primeiraLinha = ler.readLine();
		 			
				}while(primeiraLinha!= null);
						
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
			
		BufferedReader reader;
		String line1 = null;
		int verticesQuantity = 0;			
		Float weight;
		Graph graph = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			verticesQuantity = Integer.parseInt(reader.readLine());
			line1 = reader.readLine();
			graph = new GWeighted(verticesQuantity);			
			
			do{
					String[] vertexData = line1.split(" ");
	             	weight = Float.parseFloat(vertexData[2]);                                  
	                
	                VWeighted firstVertex = (VWeighted) graph.searchVertexById(vertexData[0]);
	                VWeighted secondVertex = (VWeighted) graph.searchVertexById(vertexData[1]);
	                
	                if(firstVertex != null && secondVertex != null) firstVertex.connectTo(secondVertex, weight);
	                
	                else if(firstVertex != null && secondVertex == null){
	                	
	                	secondVertex = new VWeighted(vertexData[1]);
	               		firstVertex.connectTo(secondVertex, weight);
	               		graph.addVertex(secondVertex);
	        	                	
	                }else if(firstVertex == null && secondVertex != null) {
	                	
	                	firstVertex = new VWeighted(vertexData[0]);
	                	firstVertex.connectTo(secondVertex, weight);
	                	graph.addVertex(firstVertex);
	                	
	                }else {
	                	firstVertex = new VWeighted(vertexData[0]);
	                	secondVertex = new VWeighted(vertexData[1]);
	                	
	                	firstVertex.connectTo(secondVertex, weight);
	                	graph.addVertex(firstVertex);
	                	graph.addVertex(secondVertex);
	                }   
	                line1 = reader.readLine();
	                               
	        }while(line1 != null);
			
	        reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
        return graph;
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

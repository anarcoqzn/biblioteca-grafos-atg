package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.edge.Edge;
import model.edge.EdgeNormal;
import model.edge.EdgeWeighted;
import model.graph.GNormal;
import model.graph.GWeighted;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.VWeighted;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	//private int quantidadeVertices;
	
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
			
			System.out.println("----------execucao readGraph----------");
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
				
				graph.addEdge(new EdgeNormal(vertice1, vertice2)); //classe Edge
						
				System.out.println("Arestas : " + quantidadeVertice[0]+ "->" + quantidadeVertice[1]);
				
				primeiraLinha = ler.readLine();
		 			
				}while(primeiraLinha!= null);
						
					ler.close();
				
		}catch(FileNotFoundException e){  
		            
			e.printStackTrace();  
		     
		}catch(IOException e){  
		           
			e.printStackTrace();  
		}  
		System.out.println("-------fim da execucao readGraph------");	
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
	                graph.addEdge(new EdgeWeighted(firstVertex, secondVertex, weight)); //classe Edge
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
		return graph.getVertexNumber();
	}

	@Override
	public int getEdgeNumber(Graph graph) {
		return graph.getEdges().size();
	}

	@Override
	public float getMeanEdge(Graph graph) {
		float edgeNumber = graph.getEdges().size();
		float verticesNumber = graph.getVertexNumber();
		
		return (2*edgeNumber)/verticesNumber;
	}

	@Override
	public String graphRepresentation(Graph graph, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BFS(Graph graph, Vertex v) {
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();	
		HashMap<String, String> rep = new HashMap<>();
		v.setDepth(0);
		String line = v.getId() + " - " + v.getDepth() + " -\n";	
		v.setInk(true);
		rep.put(v.getId(),line);
		caminho.add(v);		
		while (!caminho.isEmpty()){	
			ArrayList<Vertex> aux = new ArrayList<Vertex>();
			for(Vertex vert : caminho.get(0).getConnectedVertices()) {
				aux.add(vert);
			}	
			while(!aux.isEmpty()){		
				if(aux.get(0).getInk() == false) {
					aux.get(0).setInk(true);
					aux.get(0).setDepth(caminho.get(0).getDepth()+1);
					caminho.add(aux.get(0));	
					line = aux.get(0).getId() + " - " + aux.get(0).getDepth() + " " + caminho.get(0).getId() + "\n";	
					rep.put(aux.get(0).getId(), line);
				}
				aux.remove(0);	
			}
			caminho.remove(0);	
			
		}
		String retorno = "";
		for(Vertex vertex : graph.getVertices()) {
			retorno += rep.get(vertex.getId());
			vertex.setInk(false);
		}
		return retorno;
	}

	@Override
	public String DFS(Graph graph, Vertex v) {
		
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();	
		HashMap<String, String> rep = new HashMap<>();
		v.setDepth(0);	
		String line = v.getId() + " - " + v.getDepth() + " -\n";	
		v.setInk(true);	
		rep.put(v.getId(),line);
		caminho.add(v);
		while(!graph.isColored()) {	
			ArrayList<Vertex> aux = new ArrayList<Vertex>();
			for(Vertex vert : caminho.get(caminho.size()-1).getConnectedVertices()) {
				aux.add(vert);
			}
			boolean colored = false;	
			for(int i = 0; i < aux.size(); i++) {	
				if(aux.get(i).getInk() == false) {	
					colored = true; 	
					aux.get(i).setInk(true);	
					aux.get(i).setDepth(caminho.get(caminho.size()-1).getDepth()+1);
					caminho.add(aux.get(i));	
					line = aux.get(i).getId() + " - " + aux.get(i).getDepth() + " " + caminho.get(caminho.size()-2).getId() + "\n";	
					rep.put(aux.get(i).getId(), line);
					break;
				}
			}
			if(colored == false) {	
				caminho.remove(caminho.size()-1);			
			}			
		}
		String retorno = "";
		for(Vertex vertex : graph.getVertices()) {
			retorno += rep.get(vertex.getId());
			vertex.setInk(false);
		}
		return retorno;
	}

	@Override
	public boolean connected(Graph graph) {
		List<Vertex> vertex = graph.getVertices(); 
		for (int i = 0;i < vertex.size()- 1; i++) { 
			for (int j = i+1; j < vertex.size(); j++) { 
				if(!path(vertex.get(i), vertex.get(j))) { 
					return false; 	
				}
				for(Vertex v: vertex) {
					v.setInk(false);
				}
			}
		}
		return true;
	}

	@Override
	public String shortestPath(Graph graph, Vertex v1, Vertex v2) {
		
		//Grafo Normal
		if(graph instanceof GNormal && v1 instanceof VNormal && v2 instanceof VNormal) {
			System.out.println("grafo normal"); //apenas p teste
		
		//Grafo Ponderado
		}else if(graph instanceof GWeighted && v1 instanceof VWeighted && v2 instanceof VWeighted) {
			System.out.println("grafo ponderado"); //apenas p teste
			v1.setDistanciaMin(0);
			int comprimento = graph.getVertexNumber();
			
			for (int i = 0; i < comprimento-1; i++) {
				for (Edge aresta : graph.getEdges()) {
					
					if(aresta.getVertexInicial().getDistanciaMin() == Double.MAX_VALUE) continue;
					
					Vertex v = aresta.getVertexInicial();
					Vertex u = aresta.getVertexFinal();
					
					double novaDistancia = v.getDistanciaMin() + ((EdgeWeighted)aresta).getPeso();
					
					if(novaDistancia < u.getDistanciaMin()) {
						u.setDistanciaMin(novaDistancia);
						u.setVertexAnterior(v);
					}
				}

				for(Edge aresta : graph.getEdges()) {
					if(aresta.getVertexInicial().getDistanciaMin() != Double.MAX_VALUE) {
						//if(existeCiclo(arest)){
						//	syso("Existe uma aresta negativa");
						//	return;
						//}
					}
					
					if(v2.getDistanciaMin() == Double.MAX_VALUE) {
						System.out.println("Nao existe um caminho para o destino");
						break;
					}else {
						System.out.println("O menor caminho eh: "+v2.getDistanciaMin());
						break;
					}
				}
			}
		}
		return null;
	}

	@Override
	public String mst(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean path(Vertex v1, Vertex v2) {
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();
		v1.setInk(true);	
		caminho.add(v1);	
		while (!caminho.isEmpty()){		
			ArrayList<Vertex> aux = new ArrayList<Vertex>();
			for(Vertex vert : caminho.get(caminho.size()-1).getConnectedVertices()) {
				aux.add(vert);
			}	
			while(!aux.isEmpty()){		
				if(aux.get(0).getInk() == false) {
					if(aux.get(0).getId().equals(v2.getId())) {
						return true;
					}
					else {	
						aux.get(0).setInk(true);
						caminho.add(aux.get(0));
					}
				}
				aux.remove(0);
			}
			caminho.remove(0);	
		}
		return false;
	}
	
	
	
}

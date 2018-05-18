package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.edge.*;
import model.graph.GNormal;
import model.graph.GWeighted;
import model.graph.Graph;
import model.vertex.VNormal;
import model.vertex.VWeighted;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	@Override
	public Graph readGraph(String path){
		
		BufferedReader read; 		
		String firstLine = null;
		int quantityVertex = 0;
		Graph graph = null;
				
		try {
					
			read = new BufferedReader(new FileReader(path));
			quantityVertex = Integer.parseInt(read.readLine());
			firstLine = read.readLine();
			graph = new GNormal(quantityVertex);
			
			do {
					
				String[] vertexData = firstLine.split(" ");
						
				VNormal vertex1 = (VNormal) graph.searchVertexById(vertexData[0]) ;
				VNormal vertex2 = (VNormal) graph.searchVertexById(vertexData[1]);
						
				if(vertex1 != null && vertex2 != null) {
					
					vertex1.connectTo(vertex2);
					
				}else if(vertex1 != null && vertex2 == null) {
					
					vertex2 = new VNormal(vertexData[1]);
					vertex1.connectTo(vertex2);
					
					graph.addVertex(vertex2);
					
				}else if(vertex1 == null && vertex2 != null) {

					vertex1 = new VNormal(vertexData[0]);
					vertex1.connectTo(vertex2);
					
					graph.addVertex(vertex1);
						
				}else {
							
					vertex1 = new VNormal(vertexData[0]);
					vertex2 = new VNormal(vertexData[1]);
					vertex1.connectTo(vertex2);
							
					graph.addVertex(vertex1);
					graph.addVertex(vertex2);
				}
				
				graph.addEdge(new EdgeNormal(vertex1, vertex2)); //classe Edge
						
				firstLine = read.readLine();
		 			
				}while(firstLine!= null);
						
					read.close();
				
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
	                graph.addEdge(new EdgeWeighted(firstVertex, secondVertex, weight));//classe Edge
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
		ArrayList<Vertex> way = new ArrayList<Vertex>();	
		HashMap<String, String> rep = new HashMap<>();
		v.setDepth(0);
		String line = v.getId() + " - " + v.getDepth() + " -\n";	
		v.setInk(true);
		rep.put(v.getId(),line);
		way.add(v);		
		while (!way.isEmpty()){	
			ArrayList<Vertex> aux = new ArrayList<Vertex>();
			for(Vertex vert : way.get(0).getConnectedVertices()) {
				aux.add(vert);
			}	
			while(!aux.isEmpty()){		
				if(aux.get(0).getInk() == false) {
					aux.get(0).setInk(true);
					aux.get(0).setDepth(way.get(0).getDepth()+1);
					way.add(aux.get(0));	
					line = aux.get(0).getId() + " - " + aux.get(0).getDepth() + " " + way.get(0).getId() + "\n";	
					rep.put(aux.get(0).getId(), line);
				}
				aux.remove(0);	
			}
			way.remove(0);	
			
		}
		String exit = "";
		for(Vertex vertex : graph.getVertices()) {
			exit += rep.get(vertex.getId());
			vertex.setInk(false);
		}
		return exit;
	}

	@Override
	public String DFS(Graph graph, Vertex v) {
		
		ArrayList<Vertex> way = new ArrayList<Vertex>();	
		HashMap<String, String> rep = new HashMap<>();
		v.setDepth(0);	
		String line = v.getId() + " - " + v.getDepth() + " -\n";	
		v.setInk(true);	
		rep.put(v.getId(),line);
		way.add(v);
		while(!graph.isColored()) {	
			ArrayList<Vertex> aux = new ArrayList<Vertex>();
			for(Vertex vert : way.get(way.size()-1).getConnectedVertices()) {
				aux.add(vert);
			}
			boolean colored = false;	
			for(int i = 0; i < aux.size(); i++) {	
				if(aux.get(i).getInk() == false) {	
					colored = true; 	
					aux.get(i).setInk(true);	
					aux.get(i).setDepth(way.get(way.size()-1).getDepth()+1);
					way.add(aux.get(i));	
					line = aux.get(i).getId() + " - " + aux.get(i).getDepth() + " " + way.get(way.size()-2).getId() + "\n";	
					rep.put(aux.get(i).getId(), line);
					break;
				}
			}
			if(colored == false) {	
				way.remove(way.size()-1);			
			}			
		}
		String exit = "";
		for(Vertex vertex : graph.getVertices()) {
			exit += rep.get(vertex.getId());
			vertex.setInk(false);
		}
		return exit;
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
	public String shortestPath(Graph graph, Vertex vertex1, Vertex vertex2) {
		
		//Grafo Normal
		if(graph instanceof GNormal && vertex1 instanceof VNormal && vertex2 instanceof VNormal) {
			System.out.println("grafo normal"); //apenas p teste
		
		//Grafo Ponderado
		}else if(graph instanceof GWeighted && vertex1 instanceof VWeighted && vertex2 instanceof VWeighted) {
			System.out.println("grafo ponderado"); //apenas p teste
			vertex1.setDistanciaMin(0);
			int lenght = graph.getVertexNumber();
			
			for (int i = 0; i < lenght-1; i++) {
				for (Edge edge : graph.getEdges()) {
					
					if(edge.getVertexInicial().getDistanciaMin() == Double.MAX_VALUE) continue;
					
					Vertex v = edge.getVertexInicial();
					Vertex u = edge.getVertexFinal();
					
					double novaDistancia = v.getDistanciaMin() + ((EdgeWeighted)edge).getWeight();
					
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
					
					if(vertex2.getDistanciaMin() == Double.MAX_VALUE) {
						System.out.println("Nao existe um caminho para o destino");
						break;
					}else {
						System.out.println("O menor caminho eh: "+vertex2.getDistanciaMin());
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
		ArrayList<Vertex> way = new ArrayList<Vertex>();
		v1.setInk(true);	
		way.add(v1);	
		while (!way.isEmpty()){		
			ArrayList<Vertex> aux = new ArrayList<Vertex>();
			for(Vertex vert : way.get(way.size()-1).getConnectedVertices()) {
				aux.add(vert);
			}	
			while(!aux.isEmpty()){		
				if(aux.get(0).getInk() == false) {
					if(aux.get(0).getId().equals(v2.getId())) {
						return true;
					}
					else {	
						aux.get(0).setInk(true);
						way.add(aux.get(0));
					}
				}
				aux.remove(0);
			}
			way.remove(0);	
		}
		return false;
	}
}

package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.edge.*;
import model.graph.*;
import model.vertex.*;

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
		float edgeNumber = getEdgeNumber(graph);
		float verticesNumber = getVertexNumber(graph);
		
		return (2*edgeNumber)/verticesNumber;
	}

	@Override
	public String graphRepresentation(Graph graph, String type) {
		if(type == "AL") return adjacencyList(graph);
		else if(type == "AM") return adjacencyMatrix(graph);
		else return "Tipo de representação não existente";
	}
	
	private String adjacencyMatrix(Graph graph) {
		
		String saida = "";
		int matrixSize = graph.getVertexNumber() + 1;
		String[][] matrix = new String[matrixSize][matrixSize];
		
		for(int i = 0; i < matrixSize; i++) {
			if (i == 0)	matrix[0][i] = " ";
			else matrix[0][i] = graph.getVertices().get(i-1).getId();
		}
		
		for(int i = 0; i < matrixSize; i++) {
			if (i == 0)	matrix[i][0] = " ";
			else matrix[i][0] = graph.getVertices().get(i-1).getId();
		}
		if(graph instanceof GNormal) {
			for(int i = 1; i < matrixSize; i++) {
				VNormal current = (VNormal) graph.getVertices().get(i-1); 

				for(int j = 1; j < matrixSize; j++) {
					VNormal current2 = (VNormal) graph.getVertices().get(j-1);
					
					if(current.getConnectedVertices().contains(current2)) matrix[i][j] = "1";
					else matrix[i][j] = "0";
				}
			}
		}else if(graph instanceof GWeighted){
			for(int i = 1; i < matrixSize; i++) {
				VWeighted current = (VWeighted) graph.getVertices().get(i-1); 
				for(int j = 1; j < matrixSize; j++) {
					VWeighted current2 = (VWeighted) graph.getVertices().get(j-1);
					
					if(current.getConnectedVertices().contains(current2))	matrix[i][j] = current.getConnectionWeight(current2).toString();
					else matrix[i][j] = "0";
				}
			}
		}
		
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				saida += matrix[i][j] + " ";
			}
			saida += "\n";
		}
		
		return saida;
	}

	private String adjacencyList(Graph graph) {
		String result = "";
		
		if(graph instanceof GNormal) {
			for(Vertex v : graph.getVertices()) {
				result += v.getId() + " - ";
				for(Vertex v2 : v.getConnectedVertices()) {
					result += v2.getId() + " ";
				}
				result += "\n";
			}
			
		}else if(graph instanceof GWeighted) {
			for(Vertex v : graph.getVertices()) {
				result += v.getId() + " - ";
				for(Vertex v2 : v.getConnectedVertices()) {
					result += v2.getId() + "(" +((VWeighted)v).getConnectionWeight(v2)+")" + " ";
				}
				result += "\n";
			}
		}
		return result;
	}
	
	@Override
	public String BFS(Graph graph, Vertex v) {
		ArrayList<Vertex> way = new ArrayList<Vertex>();	
		HashMap<String, String> rep = new HashMap<>();
		v.setDepth(0);
		String line = v.getId() + " - " + v.getDepth();	
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
					line = "\n" + aux.get(0).getId() + " - " + aux.get(0).getDepth() + " " + way.get(0).getId() + "\n";	
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
		String line = v.getId() + " - " + v.getDepth();	
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
					line = "\n" + aux.get(i).getId() + " - " + aux.get(i).getDepth() + " " + way.get(way.size()-2).getId() + "\n";	
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
	public String shortestPath(Graph graph, Vertex v1, Vertex v2) {
		String result = "";
		List<Vertex> vertices = graph.getVertices();
		List<List<Vertex>> ways = allWays(v1, v2, new ArrayList<>(), new ArrayList<>());
		if(vertices.contains(v1) && vertices.contains(v2)) {
			int index = 0;
			int smaller = Integer.MAX_VALUE;
			List<Vertex> smallerArray = new ArrayList<>();
			
			for(; index < ways.size();index++) {
				if(ways.get(index).size() < smaller) {
					smaller = ways.get(index).size();
					smallerArray = ways.get(index);
				}
			}
			
			for(Vertex v : smallerArray) {
				result += v.getId() + " ";
			}
		}
		return result;
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
	
	private List<List<Vertex>> allWays(Vertex v1, Vertex v2, List<Vertex> path, List<List<Vertex>> ways){
		
		if(v1.getConnectedVertices().contains(v2)) {
			if(!path.contains(v1)) path.add(v1); 
			path.add(v2);
			ways.add(path);
			return ways;
		}
		
		v1.setInk(true);
		path.add(v1);
		for(Vertex temp : v1.getConnectedVertices()) {
			List<Vertex> path2 = new ArrayList<>();
			if(!temp.getInk()) {
				path2.addAll(path);
				allWays(temp,v2,path2,ways);
			}
		}
		return ways;
	}
}

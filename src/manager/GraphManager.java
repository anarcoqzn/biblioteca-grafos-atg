package manager;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.graph.GNormal;
import model.graph.GWeighted;
import model.graph.Graph;
import model.vertex.VWeighted;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	@Override
	public Graph readGraph(String path) throws IOException{
		// TODO Auto-generated method stub
		return null;
	}
	
	//teve que ficar estatico
	//corrigir
	public static Graph readGraph1(String path) {
		
		Graph graph ;
		
		String texto;  
		int contador = 0;
		//local onde esta o texto
	    File file = new File(path);
	    
	    String[] array = null;
		
	     
	        try{  
	            BufferedReader br = new BufferedReader(new FileReader(file)); 
	          //  int tamanhoArray ;
	            
	            
	            
	            while((texto = br.readLine()) != null){
	            	//tamanhoArray = Integer.parseInt(texto);
	            	
	            	if(contador == 0) {
	            	System.out.println("Número de vértices: " + texto);
	            		//array = new String[tamanhoArray];
	            	contador += 1;
	            	}else {
	            		/**for(int i=1; i< array.length  ; i++) {
	            			array[i] = br.readLine();
	            			System.out.println("a" + array[i]);
	            		}*/
	            		System.out.println("Aresta: " + texto);
	            		
	            	}
	            }  
	            br.close();
	        }catch(FileNotFoundException e){  
	            e.printStackTrace();  
	        }catch(IOException e){  
	            e.printStackTrace();  
	        }  
	    
		
		//return graph;
		 return null;
		

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

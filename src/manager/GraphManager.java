package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		// faz uma busca em largura na arvore que é:  dado um vertice inicial é definido ele como o nivel 0 e sua representação e adiciona a string 
		// depois, são vistos os vertices adjacentos (ou filhos)e feitos o mesmo só que aumento a sua "profundidade" em 1 até se percorrer a arvore por competo da raiz até as folhas. 
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();//lista caminho onde se é colocado primeiramente o vertice inicial; 
		int nivel = 0;
		String retorno = v.getId() + " - " + nivel + " -\n";	//String que começa com a representação do vertice inicial que não possui vertice pai;
		v.setInk(true);
		caminho.add(v);		//adiciona vetor inicial a lista caminho;
		while (!caminho.isEmpty()){		// enquanto a lista caminho não estiver vazia;
			List<Vertex> aux = caminho.get(0).getConnectedVertices();	//lista auxiliar que vai reter os vertices conectados ao vetice pai;
			nivel++;
			while(!aux.isEmpty()){//enquanto a lista auxiliar ainda não estiver vazia; 
				if(aux.get(0).getInk() == false) {
					aux.get(0).setInk(true);
					caminho.add(aux.get(0));	//adiciona o vertice conectado a lista caminho;
					retorno += aux.get(0).getId() + " - " + nivel + " " + caminho.get(0).getId() + "\n";//adiciona a representação do vertice filho + nivel + vertice pai;
				}
				aux.remove(0);	// remove vertice filho da lista auxiliar;
			}
			caminho.remove(0);	//remove vertice pai apos todos os seus vertices conectados serem adicionados a lista caminho;
			
		}
		return retorno;
	}

	@Override
	public String DFS(Graph graph, Vertex v) {
		//ao contrario do bfs o dfs tenta se aprofundar o maximo possivel e depois fazer o backtracking das outras opções até ter percorrido a arvore inteira.
		//eu tive que criar uma variavel boolean ink em vertex porque na busca em profundidade é necessario fazer backtracking;
		//e marcar quais vertices já foram contabilizados e um metodo boolean colored me grafo que retorno se todos os vertices do grafo foram coloridos na busca;
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();// lista caminho onde é colocado os vertices ;
		int nivel = 0;// nivel da camada da busca;
		String retorno = v.getId() + " - " + nivel + " -\n";// String de retorno;
		v.setInk(true);// pinta o vertice para que ele seja reconhecido como já contabilizado na busca;
		caminho.add(v);// adiciona v a caminho;
		while(!graph.isColored()) {// enquanto ainda existir vertices descoloridos no grafico; 
			List<Vertex> aux = caminho.get(caminho.size()-1).getConnectedVertices();// se pega uma lista dos vertices adjacentes;
			boolean colored = false;// se afirmar que coloriu é falso;
			for(int i = 0; i < aux.size(); i++) {// busca os vertices adjacentes por vertices ainda não coloridos;
				if(aux.get(i).getInk() == false) {// caso encontre;
					colored = true; // coloriu é verdadeiro;
					aux.get(i).setInk(true);//colore o vertice;
					caminho.add(aux.get(i));//adiciona o vertice a caminho;
					nivel++;// aumenta o nivel;
					retorno += aux.get(i).getId() + " - " + nivel + " " + caminho.get(caminho.size()-2).getId() + "\n";// adiciona a sua representação a String retorno;
				}
			}
			if(colored == false) {// Caso ele não encontre um vertice adjacente descolorido;
				caminho.remove(caminho.size()-1);//faz o back tracking , remove o ultimo vertice da lista e retorna ao pai para verificar se ele ainda não tem outro filho descolorido;
				nivel--; // diminui o nivel;
			}
			
		}
		return retorno;
	}

	@Override
	public boolean connected(Graph graph) {
		// TODO Auto-generated method stub
		return false;
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
	
}

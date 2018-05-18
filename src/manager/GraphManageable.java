package manager;

import model.graph.Graph;
import model.vertex.Vertex;


/**
 * 
 * @authors Anarco Nascimento, Helena Dantas, Lílian Teixeira, Manoel Neto and Victor Arruda
 * 
 * This library is capable of creating and representing graphs, and manipulating a set of classical algorithms over graphs
 * 
 */
public interface GraphManageable {
	
	/**
	 * O método lê um arquivo de texto e gera um grafo a partir das informações obtidas.
	 * 
	 * @param path
	 * @return Graph
	 */
	public Graph readGraph(String path);
	
	/**
	 * O método lê um arquivo de texto e gera um grafo com pesos a partir das informações obtidas.
	 * 
	 * @param path
	 * @return Graph
	 */
	public Graph readWeightedGraph(String path);
	
	/**
	 * O método recebe um grafo e retorna o número de vertices que o grafo possui.
	 * 
	 * @param graph
	 * @return int
	 */
	public int getVertexNumber(Graph graph);
	
	/**
	 * O método recebe um grafo e retorna o número de arestas que o grafo possui.
	 * 
	 * @param graph
	 * @return int
	 */
	public int getEdgeNumber(Graph graph) ;
	
	/**
	 * O método recebe um grafo e retorna o grau médio das arestas.
	 * 
	 * @param graph
	 * @return float
	 */
	public float getMeanEdge(Graph graph);
	
	/**
	 * O método recebe um grafo e um tipo de representação.
	 * Retorna a representação escolhida: uma matriz adjacência ou uma lista adjacência.
	 * 
	 * @param graph
	 * @param type
	 * @return String
	 */
	public String graphRepresentation (Graph graph,String type);
	
	/**
	 * O método recebe um grafo e um vértice, executa a busca em largura no grafo procurando o vértice recebido.
	 * Retorna uma lista de vértices, a profundidade e o vértice pai.
	 * 
	 * @param graph
	 * @param v
	 * @return String
	 */
	public String BFS(Graph graph,Vertex v); 
	
	/**
	 * O método recebe um grafo e um vértice, executa a busca em profundidade no grafo procurando o vértice recebido.
	 * Retorna uma lista de vértices, a profundidade e o vértice pai.
	 * 
	 * @param graph
	 * @param v
	 * @return String
	 */
	public String DFS(Graph graph,Vertex v);
	
	/**
	 * 
	 * @param graph
	 * @return boolean
	 */
	public boolean connected(Graph graph);
	
	/**
	 * O método recebe um grafo e dois vértices.
	 * Retorna o menor caminho entre eles.
	 * 
	 * @param graph
	 * @param v1
	 * @param v2
	 * @return String
	 */
	public String shortestPath(Graph graph, Vertex v1, Vertex v2);
	
	/**
	 *  O método recebe um grafo.
	 *  Retorna um 
	 *  
	 * @param graph
	 * @return String
	 */
	public String mst(Graph graph); 
	
	/**
	 * O método recebe dois vértices.
	 * Retonra true se existe um caminho entre eles e  false caso contrário.
	 * 
	 * @param v1
	 * @param v2
	 * @return Boolean
	 */
	public Boolean path(Vertex v1,Vertex v2);
}


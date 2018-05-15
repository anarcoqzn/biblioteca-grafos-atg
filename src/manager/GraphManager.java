package manager;

import java.util.ArrayList;
import java.util.List;

import model.graph.Graph;
import model.vertex.Vertex;

public class GraphManager implements GraphManageable {
	
	@Override
	public Graph readGraph(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graph readWeightedGraph(String path) {
		// TODO Auto-generated method stub
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

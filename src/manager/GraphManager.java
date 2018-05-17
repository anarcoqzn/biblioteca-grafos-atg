package manager;

import java.util.ArrayList;
import java.util.HashMap;
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
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();	//lista caminho onde se é colocado primeiramente o vertice inicial;
		HashMap<String, String> rep = new HashMap<>();
		v.setDepth(0);
		String line = v.getId() + " - " + v.getDepth() + " -\n";	//String que começa com a representação do vertice inicial que não possui vertice pai;
		v.setInk(true);
		rep.put(v.getId(),line);
		caminho.add(v);		//adiciona vetor inicial a lista caminho;
		while (!caminho.isEmpty()){		// enquanto a lista caminho não estiver vazia;
			List<Vertex> aux = caminho.get(0).getConnectedVertices();	//lista auxiliar que vai reter os vertices conectados ao vetice pai;
			while(!aux.isEmpty()){		//enquanto a lista auxiliar ainda não estiver vazia; 
				if(aux.get(0).getInk() == false) {
					aux.get(0).setInk(true);
					aux.get(0).setDepth(caminho.get(0).getDepth()+1);
					caminho.add(aux.get(0));	//adiciona o vertice conectado a lista caminho;
					line = aux.get(0).getId() + " - " + aux.get(0).getDepth() + " " + caminho.get(0).getId() + "\n";	//adiciona a representação do vertice filho + nivel + vertice pai;
					rep.put(aux.get(0).getId(), line);
				}
				aux.remove(0);	// remove vertice filho da lista auxiliar;
			}
			caminho.remove(0);	//remove vertice pai apos todos os seus vertices conectados serem adicionados a lista caminho;
			
		}
		String retorno = "";
		for(Vertex vertex : graph.getListofVertex()) {
			retorno += rep.get(vertex.getId());
		}
		return retorno;
	}

	@Override
	public String DFS(Graph graph, Vertex v) {
		//ao contrario do bfs o dfs tenta se aprofundar o maximo possivel e depois fazer o backtracking das outras opções até ter percorrido a arvore inteira.
		//eu tive que criar uma variavel boolean ink em vertex porque na busca em profundidade é necessario fazer backtracking;
		//e marcar quais vertices já foram contabilizados e um metodo boolean colored me grafo que retorno se todos os vertices do grafo foram coloridos na busca;
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();	// lista caminho onde é colocado os vertices ;
		HashMap<String, String> rep = new HashMap<>();
		v.setDepth(0);	// nivel da camada da busca;
		String line = v.getId() + " - " + v.getDepth() + " -\n";	// String de retorno;
		v.setInk(true);	// pinta o vertice para que ele seja reconhecido como já contabilizado na busca;
		rep.put(v.getId(),line);
		caminho.add(v);	// adiciona v a caminho;
		while(!graph.isColored()) {	// enquanto ainda existir vertices descoloridos no grafico; 
			List<Vertex> aux = caminho.get(caminho.size()-1).getConnectedVertices();	// se pega uma lista dos vertices adjacentes;
			boolean colored = false;	// se afirmar que coloriu é falso;
			for(int i = 0; i < aux.size(); i++) {	// busca os vertices adjacentes por vertices ainda não coloridos;
				if(aux.get(i).getInk() == false) {	// caso encontre;
					colored = true; 	// coloriu é verdadeiro;
					aux.get(i).setInk(true);	//colore o vertice;
					aux.get(i).setDepth(caminho.get(caminho.size()-1).getDepth()+1);
					caminho.add(aux.get(i));	//adiciona o vertice a caminho;
					line = aux.get(i).getId() + " - " + aux.get(i).getDepth() + " " + caminho.get(caminho.size()-2).getId() + "\n";	// adiciona a sua representação a String retorno;
					rep.put(aux.get(i).getId(), line);
					break;
				}
			}
			if(colored == false) {	// Caso ele não encontre um vertice adjacente descolorido;
				caminho.remove(caminho.size()-1);	//faz o back tracking , remove o ultimo vertice da lista e retorna ao pai para verificar se ele ainda não tem outro filho descolorido;			}
			}
		}
		String retorno = "";
		for(Vertex vertex : graph.getListofVertex()) {
			retorno += rep.get(vertex.getId());
		}
		return retorno;
	}

	@Override
	public boolean connected(Graph graph) {
		// metodo que retorna um boolean para se o grafo é conexo ou não, ou seja,
		// se é possivel encontrar um caminho de qualquer vertice do grafo pra qualquer vertice do grafo.
		List<Vertex> vertex = graph.getListofVertex(); // lista dos vertices do grafo;
		boolean retorno =  true; // defino que o grafo é conexo até encontrar um caso que prove o contrario;
		for (int i = 0;i < vertex.size()- 1; i++) { //faço um varredura de todas as combinações de vertices;
			for (int j = i+1; j < vertex.size(); j++) { 
				if(!path(vertex.get(i), vertex.get(j))) { // caso não tenha um caminho entre o vertice i e j;
					retorno = false; // define retorno  falso;
					break; // quebra o segundo laço;
				}
			}
			if(retorno == false) { // caso retorno seja falso, quebra o primeiro laço;
				break;
			}
			
		}
		return retorno;
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

	@Override
	public boolean path (Vertex v1, Vertex v2) {
		ArrayList<Vertex> caminho = new ArrayList<Vertex>();
		Boolean retorno = false;
		v1.setInk(true);	
		caminho.add(v1);	
		while (!caminho.isEmpty()){		
			List<Vertex> aux = caminho.get(0).getConnectedVertices();	
			while(!aux.isEmpty()){		
				if(aux.get(0).getInk() == false) {
					if(aux.get(0).equals(v2)) {
						retorno = true;
						break;
					}
					aux.get(0).setInk(true);
					caminho.add(aux.get(0));	
				}
				aux.remove(0);
			}
			if(retorno == true) {
				break;
			}
			caminho.remove(0);	
		}
		return retorno;
	}
	
}

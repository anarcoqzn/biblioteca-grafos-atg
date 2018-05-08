package base;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
	
	private String id;
	private Map<Vertex, Float> connectedVertices; //Chave eh o vértice ao qual este vértice está conectado, e o valor é o peso da aresta 
												//entre este vértice e o vértice conectado
	
	public Vertex(String id) {
		this.id = id;
		this.connectedVertices = new HashMap<>();
	}
	
	public String getId() {
		return id;
	}
	
	public void addWeightedConnection(Vertex v, Float weight){
		this.connectedVertices.put(v, weight);
		v.connectedVertices.put(this, weight);    //A conexao entre dois vertices eh feita bilateralmente
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
	
	public Map<Vertex, Float> getConnectedVertices(){
		return this.connectedVertices;
	}
	
	public int hashCode() {
		return Integer.parseInt(id);
	}
	
	public boolean equals(Vertex v) {
		return this.hashCode() == v.hashCode();
	}
}

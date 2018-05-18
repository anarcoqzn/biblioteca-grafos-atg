package model.edge;

import model.vertex.Vertex;

public class EdgeWeighted extends Edge{

	protected double weight;
	
	public EdgeWeighted(Vertex vertexInitial, Vertex vertexFinal, double weight) {
		super(vertexInitial, vertexFinal);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}

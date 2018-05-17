package model.edge;

import model.vertex.Vertex;

public class EdgeWeighted extends Edge{

	protected double peso;
	
	public EdgeWeighted(Vertex vi, Vertex vf, double peso) {
		super(vi, vf);
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}

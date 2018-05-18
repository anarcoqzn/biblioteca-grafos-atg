package model.edge;

import model.vertex.Vertex;

public abstract class Edge {
	
	protected Vertex vertexInitial;
	protected Vertex vertexFinal;
	
	public Edge(Vertex vi, Vertex vf) {
		this.vertexInitial = vi;
		this.vertexFinal = vf;
	}

	public Vertex getVertexInicial() {
		return vertexInitial;
	}

	public void setVertexInicial(Vertex verticeInicial) {
		this.vertexInitial = verticeInicial;
	}

	public Vertex getVertexFinal() {
		return vertexFinal;
	}

	public void setVertexFinal(Vertex verticeFinal) {
		this.vertexFinal = verticeFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertexFinal == null) ? 0 : vertexFinal.hashCode());
		result = prime * result + ((vertexInitial == null) ? 0 : vertexInitial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (vertexFinal == null) {
			if (other.vertexFinal != null)
				return false;
		} else if (!vertexFinal.equals(other.vertexFinal))
			return false;
		if (vertexInitial == null) {
			if (other.vertexInitial != null)
				return false;
		} else if (!vertexInitial.equals(other.vertexInitial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return vertexInitial + " -> " + vertexFinal;
	}
	
}

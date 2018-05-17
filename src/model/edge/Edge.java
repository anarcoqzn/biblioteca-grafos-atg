package model.edge;

import model.vertex.Vertex;

public abstract class Edge {
	
	protected Vertex vertexInicial;
	protected Vertex vertexFinal;
	
	public Edge(Vertex vi, Vertex vf) {
		this.vertexInicial = vi;
		this.vertexFinal = vf;
	}

	public Vertex getVertexInicial() {
		return vertexInicial;
	}

	public void setVertexInicial(Vertex verticeInicial) {
		this.vertexInicial = verticeInicial;
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
		result = prime * result + ((vertexInicial == null) ? 0 : vertexInicial.hashCode());
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
		if (vertexInicial == null) {
			if (other.vertexInicial != null)
				return false;
		} else if (!vertexInicial.equals(other.vertexInicial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return vertexInicial + " -> " + vertexFinal;
	}
	
}

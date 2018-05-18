package model.edge;

import model.vertex.Vertex;

public abstract class Edge {
	
	protected Vertex initialVertex;
	protected Vertex finalVertex;
	
	public Edge(Vertex initialVertex, Vertex finalVertex) {
		this.initialVertex = initialVertex;
		this.finalVertex = finalVertex;
	}

	public Vertex getInitialVertex() {
		return initialVertex;
	}

	public void setInitialVertex(Vertex initialVertex) {
		this.initialVertex = initialVertex;
	}

	public Vertex getFinalVertex() {
		return finalVertex;
	}

	public void setFinalVertex(Vertex finalVertex) {
		this.finalVertex = finalVertex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finalVertex == null) ? 0 : finalVertex.hashCode());
		result = prime * result + ((initialVertex == null) ? 0 : initialVertex.hashCode());
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
		if (finalVertex == null) {
			if (other.finalVertex != null)
				return false;
		} else if (!finalVertex.equals(other.finalVertex))
			return false;
		if (initialVertex == null) {
			if (other.initialVertex != null)
				return false;
		} else if (!initialVertex.equals(other.initialVertex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return initialVertex + " -> " + finalVertex;
	}
	
}

package model.graph;

import java.util.List;

import model.vertex.Vertex;

public class GNormal extends Graph{

	public GNormal(List<Vertex> vertex) {
		this.graph = vertex;
	}
	
	@Override
	public boolean isColored() {
		// TODO Auto-generated method stub
		return super.isColored();
	}

	@Override
	public List getListofVertex() {
		// TODO Auto-generated method stub
		return super.getListofVertex();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public Vertex searchVertexById(String id) {
		// TODO Auto-generated method stub
		return super.searchVertexById(id);
	}
	

}

package model.vertex;

import java.util.ArrayList;
import java.util.List;

public class VNormal extends Vertex{

	public VNormal(String id) {
		this.id = id;
		this.connectedVertices = new ArrayList<>();
		this.ink = false;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public boolean getInk() {
		// TODO Auto-generated method stub
		return super.getInk();
	}

	@Override
	public void setInk(boolean ink) {
		// TODO Auto-generated method stub
		super.setInk(ink);
	}

	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		return super.getDepth();
	}

	@Override
	public void setDepth(int depth) {
		// TODO Auto-generated method stub
		super.setDepth(depth);
	}

	@Override
	public List<Vertex> getConnectedVertices() {
		// TODO Auto-generated method stub
		return super.getConnectedVertices();
	}

	@Override
	public void addConnectedVertex(Vertex v) {
		// TODO Auto-generated method stub
		super.addConnectedVertex(v);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

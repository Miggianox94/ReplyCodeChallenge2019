package it.codechallenge.sevincovoglioaumento.datamodel;

public class Node {
	private int terrainCost; //sarà 0 se sono headquarter
	private int column;
	private int row;
	
	
	
	public Node(Integer terrainCost, int column, int row) {
		super();
		this.terrainCost = terrainCost;
		this.column = column;
		this.row = row;
	}
	
	
	public int getTerrainCost() {
		return terrainCost;
	}
	public void setTerrainCost(int terrainCost) {
		this.terrainCost = terrainCost;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}


	@Override
	public String toString() {
		return "Node [terrainCost=" + terrainCost + ", column=" + column + ", row=" + row + "]";
	}
	
	
	
	
}

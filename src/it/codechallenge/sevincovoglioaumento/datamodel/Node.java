package it.codechallenge.sevincovoglioaumento.datamodel;

import java.util.HashSet;
import java.util.Set;

public class Node implements NodeInterface<Node> {
	private int terrainCost; //sarà 0 se sono headquarter
	private int column;
	private int row;
	
	boolean assignedToCluster;
	boolean visited;
	
	public Node[][] nodes;
	
	
	
	public Node(Integer terrainCost, int column, int row) {
		super();
		this.terrainCost = terrainCost;
		this.column = column;
		this.row = row;
	}
	
	
	
	
	public boolean isAssignedToCluster() {
		return assignedToCluster;
	}




	public void setAssignedToCluster(boolean assignedToCluster) {
		this.assignedToCluster = assignedToCluster;
	}




	public boolean isVisited() {
		return visited;
	}




	public void setVisited(boolean visited) {
		this.visited = visited;
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




	@Override
	public double getHeuristic(Node goal) {
		return Math.abs(this.getRow()-goal.getRow())+Math.abs(this.getColumn()-goal.getColumn());
	}




	@Override
	public double getTraversalCost(Node neighbour) {
		return neighbour.getTerrainCost();
	}




	@Override
	public Set<Node> getNeighbours() {
		Set<Node> neighbours = new HashSet<Node>();

		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++) {
				if ((i == row && j == column) || i < 0 || j < 0 || j >= nodes.length
						|| i >= nodes[j].length) {
					continue;
				}

				if ((i < row && j < column) || (i > row && j > column)) {
					continue;
				}


				neighbours.add(nodes[i][j]);
			}
		}

		return neighbours;
	}
	
	
	
	
}

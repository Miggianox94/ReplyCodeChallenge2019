package it.codechallenge.sevincovoglioaumento.datamodel;

import java.util.List;

public class Grid2d {
	

	public static List<Node> findPath(int xStart, int yStart,int costStart, int xGoal, int yGoal, int costEnd, Node[][] map) {
		Node a = new Node(costStart,xStart, yStart);
		Node b = new Node(costStart,xStart, yStart);
		a.nodes = map;
		b.nodes = map;
		return PathFinding.doAStar(a, b, map);
	}

}

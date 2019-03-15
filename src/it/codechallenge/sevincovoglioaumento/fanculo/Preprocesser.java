package it.codechallenge.sevincovoglioaumento.fanculo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import it.codechallenge.sevincovoglioaumento.datamodel.CustomerOffice;
import it.codechallenge.sevincovoglioaumento.datamodel.Grid2d;
import it.codechallenge.sevincovoglioaumento.datamodel.Node;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputPreprocess;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputRead;

public class Preprocesser {
	public static List<OutputPreprocess> preprocessPhase(OutputRead parsed){
		long start = System.currentTimeMillis();
		
		
		List<OutputPreprocess> toRet = new ArrayList<>();
		int clusterCardinalityMax = parsed.getNumberCustomer()/parsed.getMaxNumberReplyOffices();
		
		for(CustomerOffice hq : parsed.getCustomerOffices()) {
			OutputPreprocess out = createCluster(hq,parsed,clusterCardinalityMax);
			if(out == null) {
				continue;
			}
			toRet.add(createCluster(hq,parsed,clusterCardinalityMax));
		}
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toRet;
	}
	
	private static OutputPreprocess createCluster(CustomerOffice hq, OutputRead parsed,int clusterCardinalityMax) {
		//creo cluster
		int cardinality = clusterCardinalityMax;
		OutputPreprocess outPre = new OutputPreprocess();
		outPre.cluster = new HashSet<CustomerOffice>();
		while(cardinality != 0) {
			//trovo nodo più vicino
			CustomerOffice nearest = findNearestCustomerOffice(hq,parsed);
			if(nearest == null) {
				continue;
			}
			nearest.getNode().setAssignedToCluster(true);
			outPre.cluster.add(nearest);
			cardinality--;
		}
		return outPre;
	}
	
	private static CustomerOffice findNearestCustomerOffice(CustomerOffice hq, OutputRead parsed) {
		//trovo il più vicino ad hq che non sia appartenente a nessun altro cluster
		int maxScore = Integer.MIN_VALUE;
		CustomerOffice nearest = null;
		for(CustomerOffice other : parsed.getCustomerOffices()) {
			if(!other.equals(hq) && !other.getNode().isAssignedToCluster()) {
				//calcolo score
				int currentScore = calculateScore(hq,other,parsed);
				if(currentScore == -1) {
					continue;
				}
				if(currentScore > maxScore) {
					maxScore = currentScore;
					nearest = other;
				}
			}
		}
		return nearest;
	}
	
	private static int calculateScore(CustomerOffice one, CustomerOffice two,OutputRead parsed) {
		one.setNode(parsed.getNodes()[one.getNode().getRow()][one.getNode().getColumn()]);
		two.setNode(parsed.getNodes()[two.getNode().getRow()][two.getNode().getColumn()]);
		List<Node> path = Grid2d.findPath(one.getNode().getRow(), one.getNode().getColumn(), one.getNode().getTerrainCost(), two.getNode().getRow(), two.getNode().getColumn(), two.getNode().getTerrainCost(), parsed.getNodes());
		if(path == null)return -1;
		int score = 0;
		for(Node node : path) {
			score+=node.getTerrainCost();
		}
		return score;
	}
	
}
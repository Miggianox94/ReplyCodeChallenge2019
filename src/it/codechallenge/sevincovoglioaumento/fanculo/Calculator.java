package it.codechallenge.sevincovoglioaumento.fanculo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.codechallenge.sevincovoglioaumento.datamodel.CustomerOffice;
import it.codechallenge.sevincovoglioaumento.datamodel.Node;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputCalculating;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputPreprocess;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputRead;
import it.codechallenge.sevincovoglioaumento.datamodel.RigaOutput;

public class Calculator {
	

	public static OutputCalculating calulatingPhase2(OutputRead parsed){
		OutputCalculating toRet = new OutputCalculating();
		
		List<CustomerOffice> offices = parsed.getCustomerOffices();
		//ordino customer
		Collections.sort(offices, new Comparator<CustomerOffice>() {
		    @Override
		    public int compare(CustomerOffice lhs, CustomerOffice rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		        return lhs.getReward()-rhs.getReward();
		    }
		});
		
		//per ogni customer piazz
		
		return toRet;
	}
	
	
	public static OutputCalculating calulatingPhase(List<OutputPreprocess> preprocessed, OutputRead parsed){
		long start = System.currentTimeMillis();
		
		OutputCalculating toRet = new OutputCalculating();
		
		for(OutputPreprocess cluster : preprocessed) {
			CustomerOffice cazzo = cluster.cluster.iterator().next();
			RigaOutput calpestabile = findCalpestabile(cazzo,parsed);
			if(calpestabile!= null) {
				toRet.add(calpestabile);
			}
			
		}
		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toRet;
	}
	
	private static RigaOutput findCalpestabile(CustomerOffice start,OutputRead parsed) {
		Node starttrue = parsed.getNodes()[start.getNode().getRow()][start.getNode().getColumn()];
		while(true) {
			String path = "";
			for(Node neighbour : starttrue.getNeighbours()) {
				if(!neighbour.isVisited()) {
					neighbour.isVisited();
					if(neighbour.getTerrainCost() < Integer.MAX_VALUE) {
						if(neighbour.getRow()<starttrue.getRow()) {
							path+="D";
							return new RigaOutput(String.valueOf(neighbour.getRow()),String.valueOf(neighbour.getColumn()),path);
						}
						else if(neighbour.getRow()>starttrue.getRow()) {
							//UP
							path+="U";
							return new RigaOutput(String.valueOf(neighbour.getRow()),String.valueOf(neighbour.getColumn()),path);
						}
						else {
							if(neighbour.getColumn() > starttrue.getColumn()) {
								//right
								path+="R";
								return new RigaOutput(String.valueOf(neighbour.getRow()),String.valueOf(neighbour.getColumn()),path);
							}
							else {
								//left
								path+="L";
								return new RigaOutput(String.valueOf(neighbour.getRow()),String.valueOf(neighbour.getColumn()),path);
							}
						}
					}
				}
			}
			if(starttrue.getRow() < parsed.getNodes().length) {
				//TODO: vado sempre giu
				path+="D";
				starttrue = parsed.getNodes()[starttrue.getRow()+1][starttrue.getColumn()];
			}
			else {
				return null;
			}
		}
	}
}

package it.codechallenge.sevincovoglioaumento.fanculo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import it.codechallenge.sevincovoglioaumento.datamodel.CustomerOffice;
import it.codechallenge.sevincovoglioaumento.datamodel.Node;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputRead;

public class Reader {
	public static OutputRead readFile(String inputPath) throws IOException{
		long start = System.currentTimeMillis();
		
		OutputRead toReturn = new OutputRead();
		toReturn.setCustomerOffices(new ArrayList<CustomerOffice>());
		File file = new File(inputPath);
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		
		boolean firstLineOk = false;
		int counter = 1;
		int rowCounter = 0;
		for(String line : lines) {
			if(!firstLineOk) {
				String[] splitted = line.split(" ");
				toReturn.setWidth(Integer.parseInt(splitted[0]));
				toReturn.setHeight(Integer.parseInt(splitted[1]));
				toReturn.setNumberCustomer(Integer.parseInt(splitted[2]));
				toReturn.setMaxNumberReplyOffices(Integer.parseInt(splitted[3]));
				toReturn.setNodes(new Node[toReturn.getWidth()][toReturn.getHeight()]);
				firstLineOk = true;
			}
			else {
				if(counter <= toReturn.getNumberCustomer()) {
					CustomerOffice custOffice = new CustomerOffice();
					String[] splitted = line.split(" ");
					custOffice.setReward(Integer.parseInt(splitted[2]));
					custOffice.setNode(new Node(0,Integer.parseInt(splitted[0]),Integer.parseInt(splitted[1])));
					counter++;
					toReturn.getCustomerOffices().add(custOffice);
				}
				else {
					int columnCounter = 0;
					String[] splitted = line.split("");
					int cost = 0;
					for(String singleNode : splitted) {
						if("#".equals(singleNode)) {
							cost = Integer.MAX_VALUE;
						}
						else if("~".equals(singleNode)) {
							cost = 800;
						}
						else if("*".equals(singleNode)) {
							cost = 200;
						}
						else if("+".equals(singleNode)) {
							cost = 150;
						}
						else if("X".equals(singleNode)) {
							cost = 120;
						}
						else if("_".equals(singleNode)) {
							cost = 100;
						}
						else if("H".equals(singleNode)) {
							cost = 70;
						}
						else if("T".equals(singleNode)) {
							cost = 50;
						}
						Node node = new Node(cost,columnCounter,rowCounter);
						toReturn.getNodes()[rowCounter][columnCounter] = node;
						columnCounter++;
						
					}
					rowCounter++;
					
				}

			}
		}
		

		
		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toReturn;
	}
}

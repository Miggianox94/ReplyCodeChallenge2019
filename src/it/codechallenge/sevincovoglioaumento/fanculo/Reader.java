package it.codechallenge.sevincovoglioaumento.fanculo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import it.codechallenge.sevincovoglioaumento.datamodel.OutputRead;

public class Reader {
	public static OutputRead readFile(String inputPath) throws IOException{
		long start = System.currentTimeMillis();
		
		OutputRead toReturn = new OutputRead();
		File file = new File(inputPath);
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		
		boolean firstLineOk = false;
		int counter = 1;
		for(String line : lines) {
			if(!firstLineOk) {
				String[] splitted = line.split(" ");
				toReturn.setWidth(Integer.parseInt(splitted[0]));
				toReturn.setHeight(Integer.parseInt(splitted[1]));
				toReturn.setNumberCustomer(Integer.parseInt(splitted[2]));
				toReturn.setMaxNumberReplyOffices(Integer.parseInt(splitted[3]));
			}
			else {
				
				counter++;
			}
		}
		

		
		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toReturn;
	}
}

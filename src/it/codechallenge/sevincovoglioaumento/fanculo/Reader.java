package it.codechallenge.sevincovoglioaumento.fanculo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import it.codechallenge.sevincovoglioaumento.datamodel.OutputRead;

public class Reader {
	public static List<OutputRead> readFile(String inputPath) throws IOException{
		long start = System.currentTimeMillis();
		
		List<OutputRead> toReturn = new ArrayList<>();
		File file = new File(inputPath);
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		
		//TODO: COMPLETE HERE
		
		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toReturn;
	}
}

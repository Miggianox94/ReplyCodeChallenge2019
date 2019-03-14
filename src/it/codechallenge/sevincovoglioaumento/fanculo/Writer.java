package it.codechallenge.sevincovoglioaumento.fanculo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import it.codechallenge.sevincovoglioaumento.datamodel.OutputCalculating;

public class Writer {
	public static void writeFile(List<OutputCalculating> calculated, String outputPath) {
		long start = System.currentTimeMillis();
		
		
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath)))
		{

			//TODO: COMPLETE HERE
			//writer.write(<something>+"\n");
		
		}
		catch(Exception ex)
		{
			System.out.println("Scoppiato in scrittura: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		
		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
	}
}

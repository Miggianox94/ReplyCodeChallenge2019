package it.codechallenge.sevincovoglioaumento.fanculo;

import java.io.BufferedWriter;
import java.io.FileWriter;

import it.codechallenge.sevincovoglioaumento.datamodel.OutputCalculating;

public class Writer {
	public static void writeFile(OutputCalculating calculated, String outputPath) {
		long start = System.currentTimeMillis();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

			writer.write(calculated.toString());
			writer.flush();

			writer.close();

		} catch (Exception ex) {
			System.out.println("Scoppiato in scrittura: " + ex.getMessage());
			ex.printStackTrace();
		}

		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : " + timeElapsed);
	}
}

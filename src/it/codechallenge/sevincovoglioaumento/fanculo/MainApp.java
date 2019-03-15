package it.codechallenge.sevincovoglioaumento.fanculo;

import java.util.List;

import it.codechallenge.sevincovoglioaumento.datamodel.OutputCalculating;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputPreprocess;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputRead;

public class MainApp {

	private final static String inputPath = "./input/1_victoria_lake.txt";
	private final static String outputPath = "./output/1.txt";
	
	public static void main(String[] args) throws Exception {
		
		OutputRead parsed = Reader.readFile(inputPath);

		System.out.println("########### READ PHASE FINISHED #############");
		
		//List<OutputPreprocess> preprocessed = Preprocesser.preprocessPhase(parsed);
		
		System.out.println("########### PREPROCESS PHASE FINISHED #############");
		
		//OutputCalculating calculated = Calculator.calulatingPhase(preprocessed,parsed);
		
		OutputCalculating calculated = Calculator.calulatingPhase2(parsed);
		
		System.out.println("########### CALCULATING PHASE FINISHED #############");
		
		Writer.writeFile(calculated,outputPath);
		
		System.out.println("########### WRITE PHASE FINISHED #############");
	}
	
}

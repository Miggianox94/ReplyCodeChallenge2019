package it.codechallenge.sevincovoglioaumento.fanculo;

import java.util.ArrayList;
import java.util.List;

import it.codechallenge.sevincovoglioaumento.datamodel.OutputPreprocess;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputRead;

public class Preprocesser {
	public static List<OutputPreprocess> preprocessPhase(OutputRead parsed){
		long start = System.currentTimeMillis();
		
		
		List<OutputPreprocess> toRet = new ArrayList<>();

		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toRet;
	}
}

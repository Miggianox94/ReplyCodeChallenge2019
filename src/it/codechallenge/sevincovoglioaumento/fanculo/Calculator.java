package it.codechallenge.sevincovoglioaumento.fanculo;

import java.util.ArrayList;
import java.util.List;

import it.codechallenge.sevincovoglioaumento.datamodel.OutputCalculating;
import it.codechallenge.sevincovoglioaumento.datamodel.OutputPreprocess;

public class Calculator {
	public static List<OutputCalculating> calulatingPhase(OutputPreprocess preprocessed){
		long start = System.currentTimeMillis();
		
		List<OutputCalculating> toRet = new ArrayList<>();
		

		
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("---------------TIME ELAPSED READ FILE : "+timeElapsed);
		return toRet;
	}
}

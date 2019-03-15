package it.codechallenge.sevincovoglioaumento.datamodel;

import java.util.ArrayList;

public class OutputCalculating extends ArrayList<RigaOutput>{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < this.size(); i++)
		{
			if(i != this.size() - 1 )
				result += this.get(i).toString()+"\n";
			else result += this.get(i).toString();
		}
		
		return result;
	}

}

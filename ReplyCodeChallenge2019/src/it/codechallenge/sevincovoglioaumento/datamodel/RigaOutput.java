package it.codechallenge.sevincovoglioaumento.datamodel;

public class RigaOutput {
	String coordX;
	String coordY;
	
	String pathToCO;

	public RigaOutput(String coordX, String coordY, String pathToCO)
	{
		this.coordX = coordX;
		this.coordY = coordY;
		
		if(pathToCO != null)
			this.pathToCO = pathToCO;
		else this.pathToCO = "";
	}
	
	@Override
	public String toString() {
		return coordX + " " + coordY + " " + pathToCO;
	}
}

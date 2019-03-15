package it.codechallenge.sevincovoglioaumento.datamodel;

public class CustomerOffice {

	Node node;
	int reward;
	

	public CustomerOffice(Node node, int reward) {
		super();
		this.node = node;
		this.reward = reward;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	@Override
	public String toString() {
		return "CustomerOffice [node=" + node + ", reward=" + reward + "]";
	}
	
	
	
	
	
	
	
}

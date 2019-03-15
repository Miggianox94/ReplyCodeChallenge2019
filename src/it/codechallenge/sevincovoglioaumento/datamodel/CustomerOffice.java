package it.codechallenge.sevincovoglioaumento.datamodel;

public class CustomerOffice {

	Node node;
	int reward;
	

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {

		CustomerOffice other = (CustomerOffice) obj;
		return (other.getNode().getRow() == this.node.getRow()) && (other.getNode().getColumn() == this.node.getColumn());
	}
	
	
	
	
	
	
	
	
	
}

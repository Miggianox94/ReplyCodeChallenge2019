package it.codechallenge.sevincovoglioaumento.datamodel;

import java.util.List;

public class OutputRead {
	
	private int width;
	private int height;
	private int numberCustomer;
	private int maxNumberReplyOffices;
	
	private List<CustomerOffice> customerOffices;
	private Node[][] nodes;

	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getNumberCustomer() {
		return numberCustomer;
	}
	public void setNumberCustomer(int numberCustomer) {
		this.numberCustomer = numberCustomer;
	}
	public int getMaxNumberReplyOffices() {
		return maxNumberReplyOffices;
	}
	public void setMaxNumberReplyOffices(int maxNumberReplyOffices) {
		this.maxNumberReplyOffices = maxNumberReplyOffices;
	}
	public List<CustomerOffice> getCustomerOffices() {
		return customerOffices;
	}
	public void setCustomerOffices(List<CustomerOffice> customerOffices) {
		this.customerOffices = customerOffices;
	}
	public Node[][] getNodes() {
		return nodes;
	}
	public void setNodes(Node[][] nodes) {
		this.nodes = nodes;
	}
	
	

}

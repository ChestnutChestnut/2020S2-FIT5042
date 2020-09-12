/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.math.BigDecimal;
import java.text.NumberFormat;


/**
 *
 * @author Shuang Xu
 * note:property is java bean
 * 
 */
//TODO Exercise 1.3 Step 1 Please refer tutorial exercise. 
public class Property {
	private int propertyID;
	private String address;
	private int numberOfBedrooms;
	private int size;
	private double price;
	
	public Property() {
		this.propertyID = 0;
		this.address = "unknown";
		this.numberOfBedrooms=0;
		this.size = 0;
		this.price = 0;
		
		
	}
	
	public Property(Property property) {
        this.propertyID = property.propertyID;
        this.address = property.address;
        this.numberOfBedrooms = property.numberOfBedrooms;
        this.size = property.size;
        this.price = property.price;
    }

	
	public Property(int propertyID, String address, int numberOfBedrooms, int size, double price) {
		super();
		this.propertyID = propertyID;
		this.address = address;
		this.numberOfBedrooms = numberOfBedrooms;
		this.size = size;
		this.price = price;
		
		
	}

	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Property [propertyID=" + propertyID + ", address=" + address + ", numberOfBedrooms=" + numberOfBedrooms
				+ ", size=" + size + ", price=" + price + "]";
	}
	
	
	
    
}


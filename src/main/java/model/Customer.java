package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Feb 19, 2022
 */
@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param customerName
	 */
	public Customer(int id, String customerName) {
		super();
		this.id = id;
		this.customerName = customerName;
	}
	/**
	 * @param customerName
	 */
	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + "]";
	}

}

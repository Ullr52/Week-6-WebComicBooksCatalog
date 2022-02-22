package model;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Feb 19, 2022
 */
@Entity
public class WantListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String custListName;
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Customer customer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ComicBooksList>listOfComics;
	/**
	 * 
	 */
	public WantListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param custListName
	 * @param tripDate
	 * @param customer
	 * @param listOfComics
	 */
	public WantListDetails(int id, String custListName, LocalDate tripDate, Customer customer,
			List<ComicBooksList> listOfComics) {
		super();
		this.id = id;
		this.custListName = custListName;
		this.tripDate = tripDate;
		this.customer = customer;
		this.listOfComics = listOfComics;
	}
	/**
	 * @param custListName
	 * @param tripDate
	 * @param customer
	 * @param listOfComics
	 */
	public WantListDetails(String custListName, LocalDate tripDate, Customer customer,
			List<ComicBooksList> listOfComics) {
		super();
		this.custListName = custListName;
		this.tripDate = tripDate;
		this.customer = customer;
		this.listOfComics = listOfComics;
	}
	/**
	 * @param custListName
	 * @param tripDate
	 * @param customer
	 */
	public WantListDetails(String custListName, LocalDate tripDate, Customer customer) {
		super();
		this.custListName = custListName;
		this.tripDate = tripDate;
		this.customer = customer;
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
	 * @return the custListName
	 */
	public String getcustListName() {
		return custListName;
	}
	/**
	 * @param custListName the custListName to set
	 */
	public void setcustListName(String custListName) {
		this.custListName = custListName;
	}
	/**
	 * @return the tripDate
	 */
	public LocalDate getTripDate() {
		return tripDate;
	}
	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the listOfComics
	 */
	public List<ComicBooksList> getListOfComics() {
		return listOfComics;
	}
	/**
	 * @param listOfComics the listOfComics to set
	 */
	public void setListOfComics(List<ComicBooksList> listOfComics) {
		this.listOfComics = listOfComics;
	}
	@Override
	public String toString() {
		return "WantListDetails [id=" + id + ", custListName=" + custListName + ", tripDate=" + tripDate + ", customer="
				+ customer + ", listOfComics=" + listOfComics + "]";
	}
	
	

}

package com.promineotech.FinalProject.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Listings {
	
	private Long id;
	private Set<ListingCategories> ListingCategories;
	private Users user;
	private double ListingPrice;
	private Date ListingDate;
	private boolean ListingStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getListingID() {
		return id;
	}
	
	public void setListingID(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "userId")
	public Users getUser() {
	  return user;
	}
	public void setUser(Users user) {
	  this.user = user;
	}
	
	public double getListingPrice() {
		return ListingPrice;
	}
	public void setListingPrice(double listingPrice) {
		ListingPrice = listingPrice;
	}
	public Date getListingDate() {
		return ListingDate;
	}
	public void setListingDate(Date listingDate) {
		ListingDate = listingDate;
	}
	public boolean isListingStatus() {
		return ListingStatus;
	}
	public void setListingSold(boolean listingStatus) {
		ListingStatus = listingStatus;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "listingcategories",
			joinColumns = @JoinColumn(name = "listingid", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "listingcategoryid", referencedColumnName = "id"))
	public Set<ListingCategories> getListingCategories() {
		return ListingCategories;
	}

	public void setListingCategories(Set<ListingCategories> listingCategories) {
		ListingCategories = listingCategories;
	}
	

}

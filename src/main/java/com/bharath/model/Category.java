package com.bharath.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	int categoryid;
	String categoryName;
	String categoryDiscription;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDiscription() {
		return categoryDiscription;
	}
	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}
	
	
	
}

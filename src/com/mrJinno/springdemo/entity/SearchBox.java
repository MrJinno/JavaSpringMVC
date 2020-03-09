package com.mrJinno.springdemo.entity;

public class SearchBox {

	private String searchType;
	
	private String searchName;
	
	public SearchBox() {
		setSearchType("firstName");
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
}

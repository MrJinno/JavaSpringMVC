package com.mrJinno.springdemo.dao;

import java.util.List;

import com.mrJinno.springdemo.entity.Customer;
import com.mrJinno.springdemo.entity.SearchBox;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> getSortedCustomers(SearchBox searchbox);
}

package com.mrJinno.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mrJinno.springdemo.entity.Customer;
import com.mrJinno.springdemo.entity.SearchBox;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Customer> query=currentSession.createQuery("from Customer "
				+ "order by lastName", Customer.class);
		
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Customer tempCustomer = currentSession.get(Customer.class, theId);
		currentSession.delete(tempCustomer);
	}

	@Override
	public List<Customer> getSortedCustomers(SearchBox searchBox) {
		
		if (searchBox.getSearchName().isEmpty()) {
			return getCustomers();
		}
		else {
			Session session=sessionFactory.getCurrentSession();
			return session.createQuery("from Customer s where s." 
			+ searchBox.getSearchType() + "='"
			+ searchBox.getSearchName() + "'")
			.getResultList();
		}
	}
}

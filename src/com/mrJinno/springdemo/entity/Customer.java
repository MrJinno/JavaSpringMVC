package com.mrJinno.springdemo.entity;


import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@Pattern(regexp="[A-Z][a-z]+", message="is required! First Name has to start with Uppercase letter")
	private String firstName;
	
	@Column(name="last_name")
	@Pattern(regexp="[A-Z][a-z]+", message="is required! Last Name has to start with Uppercase letter")
	private String lastName;
	
	@Column(name="email")
	@Pattern(regexp="[a-z]+[0-9]*@[a-z]+.[a-z]+", message="is required! Pattern: example@gmail.com")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_detail_id")
	private CustomerDetail customerDetail;
	
	public Customer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}

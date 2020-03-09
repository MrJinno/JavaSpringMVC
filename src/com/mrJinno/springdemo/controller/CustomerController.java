package com.mrJinno.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrJinno.springdemo.entity.Customer;
import com.mrJinno.springdemo.entity.SearchBox;
import com.mrJinno.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer> customers=customerService.getCustomers();
		model.addAttribute("customers", customers);
		model.addAttribute("searchBy",new SearchBox());
		
		return "list-customers";
	}
	
	@GetMapping("showFormforAdd")
	public String showFormForAdd(Model model) {
		
		Customer theCustomer=new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer tempCustomer=customerService.getCustomer(theId);
		theModel.addAttribute("customer", tempCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/details")
	public String showCustomerDetails(@RequestParam("customerId") int theId, Model model) {
		
		model.addAttribute("customer",customerService.getCustomer(theId));
		
		return "customer-details";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@ModelAttribute("searchBy") SearchBox searchBox, Model theModel) {
		
		List<Customer> customers=customerService.getSortedCustomers(searchBox);
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
}

package com.example.polls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.polls.model.Customer;
import com.example.polls.repository.CustomerTerainRepository;

@CrossOrigin("*")
@Controller
@RequestMapping("/admincustomer")
public class AdmincustomerController {
	
	   @Autowired
	    private CustomerTerainRepository customerRepository;

	    @GetMapping("/list")
	    public String listCustomers(Model model) {
	        List<Customer> customers = customerRepository.findAll();
	        model.addAttribute("customers", customers);
	        return "list";
	    }

	    @GetMapping("/add")
	    public String addCustomerForm(Model model) {
	        model.addAttribute("customer", new Customer());
	        return "add";
	    }

	    @PostMapping("/add")
	    public String addCustomer(@ModelAttribute Customer customer) {
	        customerRepository.save(customer);
	        return "redirect:/customers/list";
	    }

	    @GetMapping("/edit/{id}")
	    public String editCustomerForm(@PathVariable Long id, Model model) {
	        Customer customer = customerRepository.findById(id).orElse(null);
	        model.addAttribute("customer", customer);
	        return "edit";
	    }

	    @PostMapping("/edit")
	    public String editCustomer(@ModelAttribute Customer customer) {
	        customerRepository.save(customer);
	        return "redirect:/customers/list";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteCustomer(@PathVariable Long id) {
	        customerRepository.deleteById(id);
	        return "redirect:/customers/list";
	    }

	    @GetMapping("/{id}")
	    public String viewCustomer(@PathVariable Long id, Model model) {
	        Customer customer = customerRepository.findById(id).orElse(null);
	        model.addAttribute("customer", customer);
	        return "view";
	    }

}

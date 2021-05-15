package springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springdemo.dao.*;
import springdemo.entity.Customer;
import springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> c=customerService.getCustomers();
		
		theModel.addAttribute("customers",c);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addCustomers(Model theModel) {
		Customer c=new Customer();
		theModel.addAttribute("customer",c);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomers(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
}

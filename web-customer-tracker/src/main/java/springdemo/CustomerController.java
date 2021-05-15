package springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.dao.*;
import springdemo.entity.Customer;
import springdemo.service.CustomerService;
import util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel,@RequestParam(required=false) String sort) {
		int s=2;
		if(sort!=null)
			s=Integer.parseInt(sort);
		else
			s=SortUtils.LAST_NAME;
		List<Customer> c=customerService.getCustomers(s);
		
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
	
	@RequestMapping("/showUpdateForm")
	public String addCustomers(@RequestParam("customerId") int id,Model theModel) {
		Customer c=customerService.getCustomer(id);
		theModel.addAttribute("customer",c);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomers(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String name,Model theModel) {
		List<Customer> c=customerService.searchCustomers(name);
		theModel.addAttribute("customers",c);
		return "list-customers";
	}
}

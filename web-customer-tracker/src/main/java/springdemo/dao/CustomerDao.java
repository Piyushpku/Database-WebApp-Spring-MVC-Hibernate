package springdemo.dao;

import java.util.List;

import springdemo.entity.Customer;
public interface CustomerDao {

	public List<Customer> getcustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String name);
}

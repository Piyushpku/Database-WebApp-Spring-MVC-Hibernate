package springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.CustomerController;
import springdemo.entity.Customer;
import springdemo.service.CustomerServiceImpl;

@Repository
public class CustomerDaoImp implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getcustomers() {
		Session s= sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=s.createQuery("from Customer", Customer.class);
		List<Customer> c=theQuery.getResultList();
		return c;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		/*SessionFactory factory=new Configuration()
						.configure()
						.addAnnotatedClass(CustomerDaoImp.class)
						.addAnnotatedClass(CustomerController.class)
						.addAnnotatedClass(Customer.class)
						.addAnnotatedClass(CustomerServiceImpl.class)
						.buildSessionFactory();
		Session s=factory.getCurrentSession();
		s.beginTransaction();
		s.save(theCustomer);
		s.getTransaction().commit();
		factory.close();*/
		Session s= sessionFactory.getCurrentSession();
		s.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session s= sessionFactory.getCurrentSession();
		Customer c=s.get(Customer.class,id);
		return c;
	}

}

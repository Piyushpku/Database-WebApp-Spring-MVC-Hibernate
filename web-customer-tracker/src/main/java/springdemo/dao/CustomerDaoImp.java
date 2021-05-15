package springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Customer;

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

}

package day4assignment2.abstracts;

import day4assignment2.entities.Customer;

public interface ICustomerCheckService {
	public boolean checkIfRealPerson(Customer customer);
}

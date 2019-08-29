package bai6;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		 
		ArrayList ListCustomer = new ArrayList <Customer>();
		
		Customer ct = new Customer (1,"Phan Van Tai",4,"28374");
		Customer ct1 = new Customer (1,"Phan Van Tai1",4,"28374");
		Customer ct2 = new Customer (1,"Phan Van Tai2",4,"28374");
		Customer ct3 = new Customer (1,"Phan Van Tai4",4,"28374");
		Customer ct4 = new Customer (1,"Phan Van Tai5",4,"28374");
		
		
		ListCustomer.add(ct);
		ListCustomer.add(ct1);
		ListCustomer.add(ct2);
		ListCustomer.add(ct3);
		ListCustomer.add(ct4);
		
		System.out.println(ListCustomer);
		

	}
}

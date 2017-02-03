package de.unibremen.pi;

public class TestSynchronized {

	public static void main(String[] args) {

		Shop umbrellaShop = new ThreadSafeShop();

		Customer c1 = new ThreadSafeCustomer("Schwarz", umbrellaShop);
		Customer c2 = new ThreadSafeCustomer("Hering", umbrellaShop);
		Customer c3 = new ThreadSafeCustomer("Schmidtmann", umbrellaShop);
		Customer c4 = new ThreadSafeCustomer("Trollinger", umbrellaShop);
		Customer c5 = new ThreadSafeCustomer("Müller-Lüdenscheid", umbrellaShop);
		Employee e1 = new Employee("Erwin", umbrellaShop);
		Employee e2 = new Employee("Gundula", umbrellaShop);

		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();

		e1.start();
		e2.start();
	}

}

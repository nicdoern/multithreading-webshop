package de.unibremen.pi;

public class TestUnsynchronized {

	public static void main(String[] args) {

		Shop umbrellaShop = new Shop();

		Customer c1 = new Customer("Schwarz", umbrellaShop);
		Customer c2 = new Customer("Hering", umbrellaShop);
		Customer c3 = new Customer("Schmidtmann", umbrellaShop);
		Customer c4 = new Customer("Trollinger", umbrellaShop);
		Customer c5 = new Customer("Müller-Lüdenscheid", umbrellaShop);
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

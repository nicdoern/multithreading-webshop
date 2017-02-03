package de.unibremen.pi;

public class ThreadSafeCustomer extends Customer {

	public ThreadSafeCustomer(String name, Shop shop) {
		super(name, shop);
	}
	
	/**
	 * Lege einen zuf�lligen Artikel in den Warenkorb
	 */
	public void putRandomArticleIntoBasket() {
		synchronized (shop) {
			super.putRandomArticleIntoBasket();
		}
	}

	/**
	 * Lege Artikel in den Warenkorb
	 * @param articleName Name des gew�hlten Artikels
	 * @throws Exception 
	 */
	public void putIntoBasket(String articleName) throws Exception {
		synchronized (shop) {
			super.putIntoBasket(articleName);
		}
	}
	
}

package de.unibremen.pi;

import java.util.Set;

public class Customer extends Thread {

	// maximale Anzahl von Artikeln, die ein Kunde in den Warenkorb legen kann
	private static final int MAX_NUM_ARTICLES = 10;

	private String name;

	private Basket basket;

	protected Shop shop;

	public Customer(String name, Shop shop) {

		this.name = name;
		this.basket = new Basket();
		this.shop = shop;
	}

	/**
	 * Lege einen zufälligen Artikel in den Warenkorb
	 */
	public void putRandomArticleIntoBasket() {
		// Liste alle Artikel auf
		Set<String> articleNames = shop.getArticleNames();
		if (!articleNames.isEmpty()) {
			// Wähle zufällig Artikel
			int articleIndex = (int) (Math.random() * articleNames.size());
			if (!articleNames.isEmpty()) {
				String articleName = (String) articleNames.toArray()[articleIndex];
				System.out.println(name + " hat gewählt: " + articleName);
				// Lege ausgewählten Artikel in den Warenkorb
				try {
					putIntoBasket(articleName);
				} catch (Exception e) {
					System.err.println(" >>> " + this.name + " konnte keinen " + articleName
							+ " in den Warenkorb legen: " + e.getMessage() + " <<<");
				}
			} else {
				System.err.println(
						" >>> " + this.name + " hat versucht, etwas zu kaufen; Lagerbestand ist aber leer. <<<");
			}
		}
	}

	/**
	 * Lege Artikel in den Warenkorb und entferne ihn vom Shopbestand
	 * 
	 * @param articleName
	 *            Name des gewählten Artikels
	 */
	public void putIntoBasket(String articleName) throws Exception {
		Article article;
		try {
			article = shop.removeArticle(articleName);
			basket.addArticle(article);
		} catch (Exception e) {
			throw e;
		}
		System.out.println(this.name + " hat einen " + articleName + " in den Warenkorb gelegt.");
	}

	/**
	 * Kaufe Artikel und leere damit den Warenkorb
	 */
	public void checkOut() {
		if (!this.basket.isEmpty()) {
			System.out.println(this.name + " hat folgende Artikel gekauft:\n" + basket);
		}
		this.basket.removeAllArticles();
	}

	/**
	 * Verhalten des Kunden/"Ablaufsteuerung" (Methode zur Thread-Erstellung)
	 */
	public void run() {
		// Endlosschleife
		while (true) {
			for (int i = 1; i <= (int) (Math.random() * MAX_NUM_ARTICLES); i++) {
				putRandomArticleIntoBasket();
				try {
					// pausiere eine zufällige Zeitspanne
					Thread.sleep((int) (Math.random() * 10));
				} catch (InterruptedException e) {
				}
			}
			// Kaufe Artikel im Warenkorb
			checkOut();
			try {
				// pausiere eine zufällige Zeitspanne
				Thread.sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Gib Namen des Kunden als String aus
	 */
	public String toString() {
		return this.name;
	}
}

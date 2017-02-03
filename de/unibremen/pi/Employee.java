package de.unibremen.pi;

public class Employee extends Thread {

	// maximale Anzahl von Artikeln, die ein Mitarbeiter gleichzeitig nachf�llt
	private static final int MAX_NUM_ARTICLES = 3;

	private String name;

	private Shop shop;

	public Employee(String name, Shop shop) {
		this.name = name;
		this.shop = shop;
	}

	/**
	 * F�lle das Lager auf
	 * 
	 * @param article
	 *            Artikel, der hinzugef�gt werden soll
	 */
	public void refillStock(Article article) {
		shop.addArticle(article);
		// System.out.println(this.name + " hat " + article + " nachgef�llt.");
	}

	/**
	 * Gib Namen des Mitarbeiters als String aus
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * Verhalten des Mitarbeiters/"Ablaufsteuerung" (Methode zur
	 * Thread-Erstellung)
	 */
	public void run() {
		// Artikel, die dem Bestand hinzugef�gt werden k�nnen
		String[] articles = { "Regenschirm rot", "Regenschirm Streifen", "Regenschirm Punkte",
				"Regenschirm durchsichtig", "Regenschirm gelb" };
		// Endlosschleife
		while (true) {
			// zuf�lligen Artikel w�hlen
			Article article = new Article(articles[(int) (Math.random() * articles.length)]);
			// zuf�llige Anzahl w�hlen
			int numArticles = (int) (Math.random() * MAX_NUM_ARTICLES);
			// Artikel dem Shop hinzuf�gen
			for (int i = 0; i < numArticles; ++i) {
				refillStock(article);
			}
			// pausiere eine zuf�llige Zeitspanne
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}

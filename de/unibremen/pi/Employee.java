package de.unibremen.pi;

public class Employee extends Thread {

	// maximale Anzahl von Artikeln, die ein Mitarbeiter gleichzeitig nachfüllt
	private static final int MAX_NUM_ARTICLES = 3;

	private String name;

	private Shop shop;

	public Employee(String name, Shop shop) {
		this.name = name;
		this.shop = shop;
	}

	/**
	 * Fülle das Lager auf
	 * 
	 * @param article
	 *            Artikel, der hinzugefügt werden soll
	 */
	public void refillStock(Article article) {
		shop.addArticle(article);
		// System.out.println(this.name + " hat " + article + " nachgefüllt.");
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
		// Artikel, die dem Bestand hinzugefügt werden können
		String[] articles = { "Regenschirm rot", "Regenschirm Streifen", "Regenschirm Punkte",
				"Regenschirm durchsichtig", "Regenschirm gelb" };
		// Endlosschleife
		while (true) {
			// zufälligen Artikel wählen
			Article article = new Article(articles[(int) (Math.random() * articles.length)]);
			// zufällige Anzahl wählen
			int numArticles = (int) (Math.random() * MAX_NUM_ARTICLES);
			// Artikel dem Shop hinzufügen
			for (int i = 0; i < numArticles; ++i) {
				refillStock(article);
			}
			// pausiere eine zufällige Zeitspanne
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}

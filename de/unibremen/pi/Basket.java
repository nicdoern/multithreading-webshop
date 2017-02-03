package de.unibremen.pi;

import java.util.HashMap;
import java.util.Map;

public class Basket {

	/**
	 * Key: Artikel, Value: Anzahl der vorhandenen Artikel des Typs
	 */
	private Map<Article, Integer> contents;

	public Basket() {
		this.contents = new HashMap<Article, Integer>();
	}

	/**
	 * Füge dem Warenkorb einen Artikel hinzu
	 * 
	 * @param article
	 *            Ausgewählter Artikel
	 */
	public void addArticle(Article article) {
		if (!contents.containsKey(article)) {
			contents.put(article, 1);
		} else {
			contents.replace(article, contents.get(article) + 1);
		}
	}

	/**
	 * Entferne alle Artikel aus dem Warenkorb
	 */
	public void removeAllArticles() {
		contents.clear();
	}

	/**
	 * Gib Namen der Artikel im Warenkorb aus
	 */
	public String toString() {
		String articles = "";
		// article: Objekt in diesem Durchgang
		for (Map.Entry<Article, Integer> article : contents.entrySet()) {
			articles += "  " + article.getKey() + ": " + article.getValue() + "\n";
		}
		return articles;
	}

	/**
	 * Überprüfe, ob der Warenkorb leer ist oder nicht
	 */
	public boolean isEmpty() {
		return contents.isEmpty();
	}
}

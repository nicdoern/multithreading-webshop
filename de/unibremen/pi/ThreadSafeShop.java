package de.unibremen.pi;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeShop extends Shop {

	ThreadSafeShop() {
		// benutze ConcurrentHashMap, damit keine
		// ConcurrentModificationExceptions auftreten
		this.stock = new ConcurrentHashMap<String, List<Article>>();
	}

	/**
	 * Füge einen Artikel hinzu
	 */
	public void addArticle(Article article) {
		synchronized (this) {
			super.addArticle(article);
		}
	}

	/**
	 * Entferne einen Artikel aus dem Shop
	 */
	public Article removeArticle(String articleName) throws Exception {
		synchronized (this) {
			return super.removeArticle(articleName);
		}
	}

}

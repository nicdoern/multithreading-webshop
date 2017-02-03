package de.unibremen.pi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Shop {

	// Key (String) = Artikelname, Value (List<Article>) = Liste von Artikeln
	// mit diesem Namen
	protected Map<String, List<Article>> stock;

	public Shop() {
		this.stock = new HashMap<String, List<Article>>();
	}

	/**
	 * Gib Liste von Artikeln aus, die den eingegebenen Namen besitzen
	 * 
	 * @param articleName
	 *            Name des Artikels
	 * @return List von Artikeln mit gew�hltem Namen
	 */
	public List<Article> getArticles(String articleName) {
		return stock.get(articleName);
	}

	/**
	 * Hole verf�gbare Artikelnamen
	 * 
	 * @return Set von Artikelnamen
	 */
	public Set<String> getArticleNames() {
		return stock.keySet();
	}

	/**
	 * F�ge dem Bestand einen neuen Artikel hinzu (nachdem �berpr�ft wurde, dass
	 * dieser bisher noch nicht vorhanden ist!)
	 * 
	 * @param article
	 *            einzelner Artikel
	 */
	public void addArticle(Article article) {
		// �berpr�fe, ob die Map bereits eine Artikelliste dieses
		// Artikeltyps enth�lt
		if (!stock.containsKey(article.getArticleName())) {
			// wenn nicht, erstelle neue Artikelliste
			List<Article> list = new ArrayList<Article>();
			// f�ge neue Liste der Map hinzu
			stock.put(article.getArticleName(), list);
		}
		// f�ge Artikel dem Bestand hinzu
		stock.get(article.getArticleName()).add(article);
	}

	/**
	 * Entferne einen Artikel aus der zugeh�rigen Artikelliste
	 * 
	 * @param articleName
	 *            Name des gew�hlten Artikels
	 * @return enfernter Artikel
	 * @throws Exception
	 */
	public Article removeArticle(String articleName) throws Exception {
		// pr�fe vor dem Entfernen, ob eine Artikelliste dieses Artikeltyps
		// vorhanden ist
		if (!stock.containsKey(articleName)) {
			throw new Exception(articleName + " ist nicht vorr�tig.");
		}
		List<Article> list = stock.get(articleName);
		if (list.isEmpty()) {
			throw new Exception(articleName + " ist nicht vorr�tig.");
		}
		// hole den Artikel aus der Artikelliste
		Article removedArticle = list.remove(0);
		// falls die Liste jetzt leer ist, l�sche den Eintrag f�r diesen
		// Artikel
		if (list.isEmpty()) {
			stock.remove(articleName);
		}
		return removedArticle;
	}

}

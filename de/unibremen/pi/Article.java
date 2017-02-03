package de.unibremen.pi;

public class Article {

	private String articleName;

	public Article(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String toString() {
		return articleName;
	}

	public int hashCode() {
		return articleName.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (articleName == null) {
			if (other.articleName != null)
				return false;
		} else if (!articleName.equals(other.articleName))
			return false;
		return true;
	}

}

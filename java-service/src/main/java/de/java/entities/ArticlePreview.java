package de.java.entities;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArticlePreview {

	private final Long articleId;
	private final String title;
	private final Category category;

	public ArticlePreview(Long articleId, Category category, String title) {
		this.articleId = articleId;
		this.category = category;
		this.title = title;
	}

	public Long getArticleId() {
		return articleId;
	}

	public Category getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ArticlePreview)) return false;

		ArticlePreview that = (ArticlePreview) o;

		if (articleId != null ? !articleId.equals(that.articleId) : that.articleId != null) return false;
		if (category != null ? !category.equals(that.category) : that.category != null) return false;
		if (title != null ? !title.equals(that.title) : that.title != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = articleId != null ? articleId.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (category != null ? category.hashCode() : 0);
		return result;
	}
}

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
	private final Tag tag;

	public ArticlePreview(Long articleId, Category category, Tag tag, String title) {
		this.articleId = articleId;
		this.category = category;
		this.title = title;
		this.tag = tag;
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

	public Tag getTag() {
		return tag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ArticlePreview)) return false;

		ArticlePreview preview = (ArticlePreview) o;

		if (articleId != null ? !articleId.equals(preview.articleId) : preview.articleId != null) return false;
		if (category != null ? !category.equals(preview.category) : preview.category != null) return false;
		if (tag != null ? !tag.equals(preview.tag) : preview.tag != null) return false;
		if (title != null ? !title.equals(preview.title) : preview.title != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = articleId != null ? articleId.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (category != null ? category.hashCode() : 0);
		result = 31 * result + (tag != null ? tag.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ArticlePreview{" +
				"articleId=" + articleId +
				", title='" + title + '\'' +
				", category=" + category +
				", tag=" + tag +
				'}';
	}
}

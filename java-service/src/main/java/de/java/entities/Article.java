package de.java.entities;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Article extends AbstractEntity {

	private String title;
	private String content;
	private Category category;
	private Tag tag;

	public Article(Long id, Category category, String content, String title) {
		this(id, category, content, title, null);
	}

	public Article(Long id, Category category, String content, String title, Tag tag) {
		super(id);
		this.category = category;
		this.content = content;
		this.title = title;
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Article)) return false;
		if (!super.equals(o)) return false;

		Article article = (Article) o;

		if (category != null ? !category.equals(article.category) : article.category != null) return false;
		if (content != null ? !content.equals(article.content) : article.content != null) return false;
		if (tag != null ? !tag.equals(article.tag) : article.tag != null) return false;
		if (title != null ? !title.equals(article.title) : article.title != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (category != null ? category.hashCode() : 0);
		result = 31 * result + (tag != null ? tag.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Article{" +
				"category=" + category +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", tag=" + tag +
				"} " + super.toString();
	}
}

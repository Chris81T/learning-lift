package de.java.entities;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/23/12
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comment extends AbstractEntity {

	private String title;
	private String message;
	private String author;
	private Long articleId;

	public Comment(Long id, Long articleId, String author, String message, String title) {
		super(id);
		this.articleId = articleId;
		this.author = author;
		this.message = message;
		this.title = title;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Comment)) return false;
		if (!super.equals(o)) return false;

		Comment comment = (Comment) o;

		if (articleId != null ? !articleId.equals(comment.articleId) : comment.articleId != null) return false;
		if (author != null ? !author.equals(comment.author) : comment.author != null) return false;
		if (message != null ? !message.equals(comment.message) : comment.message != null) return false;
		if (title != null ? !title.equals(comment.title) : comment.title != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (message != null ? message.hashCode() : 0);
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"articleId=" + articleId +
				", title='" + title + '\'' +
				", message='" + message + '\'' +
				", author='" + author + '\'' +
				"} " + super.toString();
	}
}

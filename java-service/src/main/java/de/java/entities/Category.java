package de.java.entities;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Category extends AbstractEntity {

	private String name;
	private Category parent;

	public Category(Long id, String name) {
		this(id, name, null);
	}

	public Category(Long id, String name, Category parent) {
		super(id);
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Category)) return false;

		Category category = (Category) o;

		if (name != null ? !name.equals(category.name) : category.name != null) return false;
		if (parent != null ? !parent.equals(category.parent) : category.parent != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (parent != null ? parent.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Category{" +
				"name='" + name + '\'' +
				", parent=" + parent +
				"} " + super.toString();
	}
}

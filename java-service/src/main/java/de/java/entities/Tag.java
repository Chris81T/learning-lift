package de.java.entities;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/22/12
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tag extends AbstractEntity {

	private String name;

	public Tag(Long id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tag)) return false;
		if (!super.equals(o)) return false;

		Tag tag = (Tag) o;

		if (name != null ? !name.equals(tag.name) : tag.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}


	@Override
	public String toString() {
		return "Tag{" +
				"name='" + name + '\'' +
				"} " + super.toString();
	}
}

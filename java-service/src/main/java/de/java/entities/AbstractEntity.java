package de.java.entities;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractEntity implements Serializable {

	private final Long id;

	protected AbstractEntity(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AbstractEntity)) return false;

		AbstractEntity that = (AbstractEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

}

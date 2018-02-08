package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.Entity;

@Entity(name = "Book")
public class Book extends Publication {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}
}
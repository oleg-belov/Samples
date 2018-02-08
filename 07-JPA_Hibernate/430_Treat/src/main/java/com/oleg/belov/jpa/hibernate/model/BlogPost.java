package com.oleg.belov.jpa.hibernate.model;

import javax.persistence.Entity;

@Entity(name = "BlogPost")
public class BlogPost extends Publication {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BlogPost)) {
			return false;
		}
		BlogPost other = (BlogPost) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}
}

package com.oleg.belov.jpa.hibernate.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Author {
	
	@Transient
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Version
	private int version;

	private String firstName;

	private String lastName;
	
	private LocalDateTime createdAt;

	public Long getId() {
		return this.id;
	}

	public int getVersion() {
		return this.version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	@PrePersist
	private void initializeCreatedAt() {
		this.createdAt = LocalDateTime.now();
		log.info("Set createdAt to "+this.createdAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "Author [log=" + log + ", id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName="
				+ lastName + ", createdAt=" + createdAt + "]";
	}
}
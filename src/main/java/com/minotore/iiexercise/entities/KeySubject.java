package com.minotore.iiexercise.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class KeySubject implements Serializable {
	/**
	 * Define KeySubject
	 */
	
	private static final long serialVersionUID = 3290094763844636065L;

	@Id
	private String keySubject;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "keySubjects")
	private List<Magazine> magasines;

	public KeySubject() {
		super();
	}

	public KeySubject(String keySubject) {
		super();
		this.keySubject = keySubject;
	}

	public String getKeySubject() {
		return keySubject;
	}

	public void setKeySubject(String keySubject) {
		this.keySubject = keySubject;
	}

	public List<Magazine> getMagasines() {
		return magasines;
	}

	public void setMagasines(List<Magazine> magasines) {
		this.magasines = magasines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keySubject == null) ? 0 : keySubject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeySubject other = (KeySubject) obj;
		if (keySubject == null) {
			if (other.keySubject != null)
				return false;
		} else if (!keySubject.equals(other.keySubject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KeySubject =" + keySubject;
	}
	
	

}

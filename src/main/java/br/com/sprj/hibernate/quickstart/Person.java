package br.com.sprj.hibernate.quickstart;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Person extends PanacheEntity {

	public String name;
	public LocalDate birth;
	public Status status;

	public String getName() {
		return name.toUpperCase();
	}

	public void setName() {
		this.name = name.toLowerCase();
	}

	public static Person findByName(String name) {
		return find("name", name).firstResult();
	}

	public static List<Person> findAlive() {
		return list("status", Status.Alive);
	}

}
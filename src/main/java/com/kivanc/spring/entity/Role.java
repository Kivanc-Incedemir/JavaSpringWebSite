package com.kivanc.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	public Role() {
	}


	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}

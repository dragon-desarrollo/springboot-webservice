package com.dragondesarrollo.restservices.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table( name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Username es un campo obligatorio. Por favor ingrese un username.")
	@Column(name = "USER_NAME", length=50, unique = true)
	private String username;
	
	@Size(min=2, message="First Name debe tener al menos 2 caracteres de largo.")
	@Column( name = "FIRST_NAME", length=50, nullable = false)
	private String firstName;
	
	@Column( name = "LAST_NAME", length=50, nullable = false)
	private String lastName;
	
	@Column( name = "EMAIL_ADDRESS", length = 50, nullable = false)
	private String email;
	
	@Column( name = "ROLE", length = 50, nullable = false )
	private String role;
	
	@Column( name = "SSN", length = 50, nullable = false)
	private String ssn;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	@Column(name = "ADDRESS")
	private String address;

	public User() {	}
	
	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String username, String firstName, String lastName, String email, String role, String ssn, String address) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = new ArrayList<>();
		this.address = address;
	}
	
	public User( String username, String firstName, String lastName, String email, String role, String ssn, String address) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = new ArrayList<>();
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", address=" + address + "]";
	}
}

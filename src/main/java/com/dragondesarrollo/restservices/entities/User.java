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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Éste modelo es para crear un usuario")
@Entity
@Table( name = "users")
public class User {
	
	@ApiModelProperty(notes = "ID único y autogenerado", required = true, position = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Username único en el sistema", required = true, example = "pantro", position = 2)
	@Size(min=2, max=50)
	@NotEmpty(message = "Username es un campo obligatorio. Por favor ingrese un username.")
	@Column(name = "USER_NAME", length=50, unique = true)
	private String username;
	
	@ApiModelProperty(notes = "Nombre del usuario", required = true, position = 3)
	@Size(min=2, max=50, message="First Name debe tener al menos 2 caracteres de largo.")
	@Column( name = "FIRST_NAME", length=50, nullable = false)
	private String firstName;
	
	@ApiModelProperty(notes = "Apellido del usuario", required = true, position = 4)
	@Column( name = "LAST_NAME", length=50, nullable = false)
	private String lastName;
	
	@ApiModelProperty(notes = "Email del usuario", required = true, position = 5)
	@Column( name = "EMAIL_ADDRESS", length = 50, nullable = false)
	private String email;
	
	@ApiModelProperty(notes = "Role del usuario", required = true, position = 6)
	@Column( name = "ROLE", length = 50, nullable = false )
	private String role;
	
	@ApiModelProperty(notes = "SSN del usuario", required = true, position = 7)
	@Column( name = "SSN", length = 50, nullable = false)
	private String ssn;
	
	@ApiModelProperty(notes = "Ordenes creadas por el usuario", required = false, position = 8)
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	public User() {	}
	
	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String username, String firstName, String lastName, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = new ArrayList<>();
	}
	
	public User( String username, String firstName, String lastName, String email, String role, String ssn) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = new ArrayList<>();
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	
	
	

}

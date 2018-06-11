package com.org.oh_backend.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ohuser")
public class OHUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private int userId;
	
	@NotEmpty
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String userName;

	@NotEmpty
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@NotEmpty
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@NotEmpty
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;
	
	@NotEmpty
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@NotEmpty
	@Column(name = "STATUS", nullable = false)
	private String status = OHUserStatus.ACTIVE.getStatus();

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "OHAPP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<OHUserProfile> userProfiles = new HashSet<OHUserProfile>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<OHUserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<OHUserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
}

package com.hpe.calEStore.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "department", catalog = "eshop")
public class Department implements java.io.Serializable {

	private Integer departmentId;
	
	@NotEmpty(message="Department name should not be empty.")
	private String departmentName;
	
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);

	public Department() {
		// Do nothing... Hibernate needs this mandatory
	}

	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department(String departmentName, Set<UserProfile> userProfiles) {
		this.departmentName = departmentName;
		this.userProfiles = userProfiles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_ID", unique = true, nullable = false)
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "DEPARTMENT_NAME", nullable = false, length = 25)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

}

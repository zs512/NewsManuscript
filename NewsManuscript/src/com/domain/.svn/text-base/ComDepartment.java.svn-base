package com.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ComDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_department", schema = "dbo", catalog = "NewsManuscript")
public class ComDepartment implements java.io.Serializable {

	// Fields

	private String departmentId;
	private String departmentName;
	private String parentDepartment;
	private Integer status;
	private Set<ComUser> comUsers = new HashSet<ComUser>(0);

	// Constructors

	/** default constructor */
	public ComDepartment() {
	}

	/** minimal constructor */
	public ComDepartment(String departmentName, Integer status) {
		this.departmentName = departmentName;
		this.status = status;
	}

	/** full constructor */
	public ComDepartment(String departmentName, String parentDepartment,
			Integer status, Set<ComUser> comUsers) {
		this.departmentName = departmentName;
		this.parentDepartment = parentDepartment;
		this.status = status;
		this.comUsers = comUsers;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "department_id", unique = true, nullable = false, length = 32)
	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "department_name", nullable = false, length = 32)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Column(name = "parent_department", length = 32)
	public String getParentDepartment() {
		return this.parentDepartment;
	}

	public void setParentDepartment(String parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comDepartment")
	public Set<ComUser> getComUsers() {
		return this.comUsers;
	}

	public void setComUsers(Set<ComUser> comUsers) {
		this.comUsers = comUsers;
	}

}
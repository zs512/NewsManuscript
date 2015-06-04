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
 * ComWorkType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_work_type", schema = "dbo", catalog = "NewsManuscript")
public class ComWorkType implements java.io.Serializable {

	// Fields

	private String workTypeId;
	private String workTypeName;
	private Integer status;
	private Set<ComManuscriptWorkType> comManuscriptWorkTypes = new HashSet<ComManuscriptWorkType>(
			0);

	// Constructors

	/** default constructor */
	public ComWorkType() {
	}

	/** minimal constructor */
	public ComWorkType(String workTypeName, Integer status) {
		this.workTypeName = workTypeName;
		this.status = status;
	}

	/** full constructor */
	public ComWorkType(String workTypeName, Integer status,
			Set<ComManuscriptWorkType> comManuscriptWorkTypes) {
		this.workTypeName = workTypeName;
		this.status = status;
		this.comManuscriptWorkTypes = comManuscriptWorkTypes;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "work_type_id", unique = true, nullable = false, length = 32)
	public String getWorkTypeId() {
		return this.workTypeId;
	}

	public void setWorkTypeId(String workTypeId) {
		this.workTypeId = workTypeId;
	}

	@Column(name = "work_type_name", nullable = false, length = 32)
	public String getWorkTypeName() {
		return this.workTypeName;
	}

	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comWorkType")
	public Set<ComManuscriptWorkType> getComManuscriptWorkTypes() {
		return this.comManuscriptWorkTypes;
	}

	public void setComManuscriptWorkTypes(
			Set<ComManuscriptWorkType> comManuscriptWorkTypes) {
		this.comManuscriptWorkTypes = comManuscriptWorkTypes;
	}

}
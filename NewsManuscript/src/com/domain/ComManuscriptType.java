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
 * ComManuscriptType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_manuscript_type", schema = "dbo", catalog = "NewsManuscript")
public class ComManuscriptType implements java.io.Serializable {

	// Fields

	private String manuscriptTypeId;
	private String manuscripterTypeName;
	private Integer status;
	private Set<ComReferee> comReferees = new HashSet<ComReferee>(0);
	private Set<ComManuscript> comManuscripts = new HashSet<ComManuscript>(0);

	// Constructors

	/** default constructor */
	public ComManuscriptType() {
	}

	/** minimal constructor */
	public ComManuscriptType(String manuscripterTypeName, Integer status) {
		this.manuscripterTypeName = manuscripterTypeName;
		this.status = status;
	}

	/** full constructor */
	public ComManuscriptType(String manuscripterTypeName, Integer status,
			Set<ComReferee> comReferees, Set<ComManuscript> comManuscripts) {
		this.manuscripterTypeName = manuscripterTypeName;
		this.status = status;
		this.comReferees = comReferees;
		this.comManuscripts = comManuscripts;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "manuscript_type_id", unique = true, nullable = false, length = 32)
	public String getManuscriptTypeId() {
		return this.manuscriptTypeId;
	}

	public void setManuscriptTypeId(String manuscriptTypeId) {
		this.manuscriptTypeId = manuscriptTypeId;
	}

	@Column(name = "manuscripter_type_name", nullable = false, length = 32)
	public String getManuscripterTypeName() {
		return this.manuscripterTypeName;
	}

	public void setManuscripterTypeName(String manuscripterTypeName) {
		this.manuscripterTypeName = manuscripterTypeName;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comManuscriptType")
	public Set<ComReferee> getComReferees() {
		return this.comReferees;
	}

	public void setComReferees(Set<ComReferee> comReferees) {
		this.comReferees = comReferees;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comManuscriptType")
	public Set<ComManuscript> getComManuscripts() {
		return this.comManuscripts;
	}

	public void setComManuscripts(Set<ComManuscript> comManuscripts) {
		this.comManuscripts = comManuscripts;
	}

}
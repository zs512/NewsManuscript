package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ComManuscriptWorkType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_manuscript_work_type", schema = "dbo", catalog = "NewsManuscript")
public class ComManuscriptWorkType implements java.io.Serializable {

	// Fields

	private String manuscriptWorkTypeId;
	private ComWorkType comWorkType;
	private ComManuscript comManuscript;
	private Integer status;

	// Constructors

	/** default constructor */
	public ComManuscriptWorkType() {
	}

	/** full constructor */
	public ComManuscriptWorkType(ComWorkType comWorkType,
			ComManuscript comManuscript, Integer status) {
		this.comWorkType = comWorkType;
		this.comManuscript = comManuscript;
		this.status = status;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "manuscript_work_type_id", unique = true, nullable = false, length = 32)
	public String getManuscriptWorkTypeId() {
		return this.manuscriptWorkTypeId;
	}

	public void setManuscriptWorkTypeId(String manuscriptWorkTypeId) {
		this.manuscriptWorkTypeId = manuscriptWorkTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_type_id", nullable = false)
	public ComWorkType getComWorkType() {
		return this.comWorkType;
	}

	public void setComWorkType(ComWorkType comWorkType) {
		this.comWorkType = comWorkType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manuscript_id", nullable = false)
	public ComManuscript getComManuscript() {
		return this.comManuscript;
	}

	public void setComManuscript(ComManuscript comManuscript) {
		this.comManuscript = comManuscript;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
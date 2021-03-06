package com.domain;

import java.sql.Timestamp;
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
 * ComReferee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_referee", schema = "dbo", catalog = "NewsManuscript")
public class ComReferee implements java.io.Serializable {

	// Fields

	private String refereeId;
	private ComUser comUser;
	private ComManuscriptType comManuscriptType;
	private ComManuscript comManuscript;
	private Timestamp refereeTime;
	private Integer refereeResult;
	private Integer status;

	// Constructors

	/** default constructor */
	public ComReferee() {
	}

	/** full constructor */
	public ComReferee(ComUser comUser, ComManuscriptType comManuscriptType,
			ComManuscript comManuscript, Timestamp refereeTime,
			Integer refereeResult, Integer status) {
		this.comUser = comUser;
		this.comManuscriptType = comManuscriptType;
		this.comManuscript = comManuscript;
		this.refereeTime = refereeTime;
		this.refereeResult = refereeResult;
		this.status = status;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "referee_id", unique = true, nullable = false, length = 32)
	public String getRefereeId() {
		return this.refereeId;
	}

	public void setRefereeId(String refereeId) {
		this.refereeId = refereeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referee_person_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manuscript_type_id", nullable = false)
	public ComManuscriptType getComManuscriptType() {
		return this.comManuscriptType;
	}

	public void setComManuscriptType(ComManuscriptType comManuscriptType) {
		this.comManuscriptType = comManuscriptType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manuscript_id", nullable = false)
	public ComManuscript getComManuscript() {
		return this.comManuscript;
	}

	public void setComManuscript(ComManuscript comManuscript) {
		this.comManuscript = comManuscript;
	}

	@Column(name = "referee_time", nullable = false, length = 23)
	public Timestamp getRefereeTime() {
		return this.refereeTime;
	}

	public void setRefereeTime(Timestamp refereeTime) {
		this.refereeTime = refereeTime;
	}

	@Column(name = "referee_result", nullable = false)
	public Integer getRefereeResult() {
		return this.refereeResult;
	}

	public void setRefereeResult(Integer refereeResult) {
		this.refereeResult = refereeResult;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
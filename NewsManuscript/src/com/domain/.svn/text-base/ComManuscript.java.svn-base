package com.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ComManuscript entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_manuscript", schema = "dbo", catalog = "NewsManuscript")
public class ComManuscript implements java.io.Serializable {

	// Fields

	private String manuscriptId;
	private ComUser comUserByUpdatePersonId;
	private ComManuscriptType comManuscriptType;
	private ComUser comUserByAuthorId;
	private String manuscriptTitle;
	private String manuscriptBody;
	private Integer manuscriptStatus;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp refereeTime;
	private String manuscriptPath;
	private Integer status;
	private Set<ComReferee> comReferees = new HashSet<ComReferee>(0);
	private Set<ComManuscriptForm> comManuscriptForms = new HashSet<ComManuscriptForm>(
			0);
	private Set<ComPending> comPendings = new HashSet<ComPending>(0);

	// Constructors

	/** default constructor */
	public ComManuscript() {
	}

	/** minimal constructor */
	public ComManuscript(ComUser comUserByUpdatePersonId,
			ComManuscriptType comManuscriptType, ComUser comUserByAuthorId,
			Integer manuscriptStatus, Timestamp createTime,
			Timestamp updateTime, String manuscriptPath, Integer status) {
		this.comUserByUpdatePersonId = comUserByUpdatePersonId;
		this.comManuscriptType = comManuscriptType;
		this.comUserByAuthorId = comUserByAuthorId;
		this.manuscriptStatus = manuscriptStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.manuscriptPath = manuscriptPath;
		this.status = status;
	}

	/** full constructor */
	public ComManuscript(ComUser comUserByUpdatePersonId,
			ComManuscriptType comManuscriptType, ComUser comUserByAuthorId,
			String manuscriptTitle, String manuscriptBody,
			Integer manuscriptStatus, Timestamp createTime,
			Timestamp updateTime, Timestamp refereeTime, String manuscriptPath,
			Integer status, Set<ComReferee> comReferees,
			Set<ComManuscriptForm> comManuscriptForms,
			Set<ComPending> comPendings) {
		this.comUserByUpdatePersonId = comUserByUpdatePersonId;
		this.comManuscriptType = comManuscriptType;
		this.comUserByAuthorId = comUserByAuthorId;
		this.manuscriptTitle = manuscriptTitle;
		this.manuscriptBody = manuscriptBody;
		this.manuscriptStatus = manuscriptStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.refereeTime = refereeTime;
		this.manuscriptPath = manuscriptPath;
		this.status = status;
		this.comReferees = comReferees;
		this.comManuscriptForms = comManuscriptForms;
		this.comPendings = comPendings;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "manuscript_id", unique = true, nullable = false, length = 32)
	public String getManuscriptId() {
		return this.manuscriptId;
	}

	public void setManuscriptId(String manuscriptId) {
		this.manuscriptId = manuscriptId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "update_person_id", nullable = false)
	public ComUser getComUserByUpdatePersonId() {
		return this.comUserByUpdatePersonId;
	}

	public void setComUserByUpdatePersonId(ComUser comUserByUpdatePersonId) {
		this.comUserByUpdatePersonId = comUserByUpdatePersonId;
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
	@JoinColumn(name = "author_id", nullable = false)
	public ComUser getComUserByAuthorId() {
		return this.comUserByAuthorId;
	}

	public void setComUserByAuthorId(ComUser comUserByAuthorId) {
		this.comUserByAuthorId = comUserByAuthorId;
	}

	@Column(name = "manuscript_title", length = 50)
	public String getManuscriptTitle() {
		return this.manuscriptTitle;
	}

	public void setManuscriptTitle(String manuscriptTitle) {
		this.manuscriptTitle = manuscriptTitle;
	}

	@Column(name = "manuscript_body", length = 500)
	public String getManuscriptBody() {
		return this.manuscriptBody;
	}

	public void setManuscriptBody(String manuscriptBody) {
		this.manuscriptBody = manuscriptBody;
	}

	@Column(name = "manuscript_status", nullable = false)
	public Integer getManuscriptStatus() {
		return this.manuscriptStatus;
	}

	public void setManuscriptStatus(Integer manuscriptStatus) {
		this.manuscriptStatus = manuscriptStatus;
	}

	@Column(name = "create_time", nullable = false, length = 23)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", nullable = false, length = 23)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "referee_time", length = 23)
	public Timestamp getRefereeTime() {
		return this.refereeTime;
	}

	public void setRefereeTime(Timestamp refereeTime) {
		this.refereeTime = refereeTime;
	}

	@Column(name = "manuscript_path", nullable = false, length = 500)
	public String getManuscriptPath() {
		return this.manuscriptPath;
	}

	public void setManuscriptPath(String manuscriptPath) {
		this.manuscriptPath = manuscriptPath;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comManuscript")
	public Set<ComReferee> getComReferees() {
		return this.comReferees;
	}

	public void setComReferees(Set<ComReferee> comReferees) {
		this.comReferees = comReferees;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comManuscript")
	public Set<ComManuscriptForm> getComManuscriptForms() {
		return this.comManuscriptForms;
	}

	public void setComManuscriptForms(Set<ComManuscriptForm> comManuscriptForms) {
		this.comManuscriptForms = comManuscriptForms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comManuscript")
	public Set<ComPending> getComPendings() {
		return this.comPendings;
	}

	public void setComPendings(Set<ComPending> comPendings) {
		this.comPendings = comPendings;
	}

}
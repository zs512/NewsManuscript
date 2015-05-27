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
 * ComForm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_form", schema = "dbo", catalog = "NewsManuscript")
public class ComForm implements java.io.Serializable {

	// Fields

	private String formId;
	private ComUser comUserByAnnouncerId;
	private ComProgram comProgram;
	private ComUser comUserByProducerId;
	private ComUser comUserByEditorChargeId;
	private Timestamp broadcastTime;
	private Integer status;
	private Integer formStatus;
	private Set<ComManuscriptForm> comManuscriptForms = new HashSet<ComManuscriptForm>(
			0);

	// Constructors

	/** default constructor */
	public ComForm() {
	}

	/** minimal constructor */
	public ComForm(ComProgram comProgram, ComUser comUserByProducerId,
			ComUser comUserByEditorChargeId, Integer status, Integer formStatus) {
		this.comProgram = comProgram;
		this.comUserByProducerId = comUserByProducerId;
		this.comUserByEditorChargeId = comUserByEditorChargeId;
		this.status = status;
		this.formStatus = formStatus;
	}

	/** full constructor */
	public ComForm(ComUser comUserByAnnouncerId, ComProgram comProgram,
			ComUser comUserByProducerId, ComUser comUserByEditorChargeId,
			Timestamp broadcastTime, Integer status, Integer formStatus,
			Set<ComManuscriptForm> comManuscriptForms) {
		this.comUserByAnnouncerId = comUserByAnnouncerId;
		this.comProgram = comProgram;
		this.comUserByProducerId = comUserByProducerId;
		this.comUserByEditorChargeId = comUserByEditorChargeId;
		this.broadcastTime = broadcastTime;
		this.status = status;
		this.formStatus = formStatus;
		this.comManuscriptForms = comManuscriptForms;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "form_id", unique = true, nullable = false, length = 32)
	public String getFormId() {
		return this.formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "announcer_id")
	public ComUser getComUserByAnnouncerId() {
		return this.comUserByAnnouncerId;
	}

	public void setComUserByAnnouncerId(ComUser comUserByAnnouncerId) {
		this.comUserByAnnouncerId = comUserByAnnouncerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id", nullable = false)
	public ComProgram getComProgram() {
		return this.comProgram;
	}

	public void setComProgram(ComProgram comProgram) {
		this.comProgram = comProgram;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producer_id", nullable = false)
	public ComUser getComUserByProducerId() {
		return this.comUserByProducerId;
	}

	public void setComUserByProducerId(ComUser comUserByProducerId) {
		this.comUserByProducerId = comUserByProducerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "editor_charge_id", nullable = false)
	public ComUser getComUserByEditorChargeId() {
		return this.comUserByEditorChargeId;
	}

	public void setComUserByEditorChargeId(ComUser comUserByEditorChargeId) {
		this.comUserByEditorChargeId = comUserByEditorChargeId;
	}

	@Column(name = "broadcast_time", length = 23)
	public Timestamp getBroadcastTime() {
		return this.broadcastTime;
	}

	public void setBroadcastTime(Timestamp broadcastTime) {
		this.broadcastTime = broadcastTime;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "form_status", nullable = false)
	public Integer getFormStatus() {
		return this.formStatus;
	}

	public void setFormStatus(Integer formStatus) {
		this.formStatus = formStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comForm")
	public Set<ComManuscriptForm> getComManuscriptForms() {
		return this.comManuscriptForms;
	}

	public void setComManuscriptForms(Set<ComManuscriptForm> comManuscriptForms) {
		this.comManuscriptForms = comManuscriptForms;
	}

}
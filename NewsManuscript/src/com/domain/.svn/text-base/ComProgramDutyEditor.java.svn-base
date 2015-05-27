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
 * ComProgramDutyEditor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_program_duty_editor", schema = "dbo", catalog = "NewsManuscript")
public class ComProgramDutyEditor implements java.io.Serializable {

	// Fields

	private String programDutyEditorChargeId;
	private ComProgram comProgram;
	private ComUser comUser;
	private Integer status;

	// Constructors

	/** default constructor */
	public ComProgramDutyEditor() {
	}

	/** full constructor */
	public ComProgramDutyEditor(ComProgram comProgram, ComUser comUser,
			Integer status) {
		this.comProgram = comProgram;
		this.comUser = comUser;
		this.status = status;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "program_duty_editor_charge_id", unique = true, nullable = false, length = 32)
	public String getProgramDutyEditorChargeId() {
		return this.programDutyEditorChargeId;
	}

	public void setProgramDutyEditorChargeId(String programDutyEditorChargeId) {
		this.programDutyEditorChargeId = programDutyEditorChargeId;
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
	@JoinColumn(name = "duty_editor_charge_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
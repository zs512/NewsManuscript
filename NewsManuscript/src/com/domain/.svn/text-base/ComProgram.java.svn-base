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
 * ComProgram entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_program", schema = "dbo", catalog = "NewsManuscript")
public class ComProgram implements java.io.Serializable {

	// Fields

	private String programId;
	private String programName;
	private String programDescribe;
	private Integer status;
	private Set<ComProgramEditorCharge> comProgramEditorCharges = new HashSet<ComProgramEditorCharge>(
			0);
	private Set<ComForm> comForms = new HashSet<ComForm>(0);
	private Set<ComProgramChief> comProgramChiefs = new HashSet<ComProgramChief>(
			0);
	private Set<ComProgramAppraiser> comProgramAppraisers = new HashSet<ComProgramAppraiser>(
			0);
	private Set<ComProgramProducer> comProgramProducers = new HashSet<ComProgramProducer>(
			0);
	private Set<ComProgramBoss> comProgramBosses = new HashSet<ComProgramBoss>(
			0);
	private Set<ComProgramDutyEditor> comProgramDutyEditors = new HashSet<ComProgramDutyEditor>(
			0);

	// Constructors

	/** default constructor */
	public ComProgram() {
	}

	/** minimal constructor */
	public ComProgram(String programName, Integer status) {
		this.programName = programName;
		this.status = status;
	}

	/** full constructor */
	public ComProgram(String programName, String programDescribe,
			Integer status,
			Set<ComProgramEditorCharge> comProgramEditorCharges,
			Set<ComForm> comForms, Set<ComProgramChief> comProgramChiefs,
			Set<ComProgramAppraiser> comProgramAppraisers,
			Set<ComProgramProducer> comProgramProducers,
			Set<ComProgramBoss> comProgramBosses,
			Set<ComProgramDutyEditor> comProgramDutyEditors) {
		this.programName = programName;
		this.programDescribe = programDescribe;
		this.status = status;
		this.comProgramEditorCharges = comProgramEditorCharges;
		this.comForms = comForms;
		this.comProgramChiefs = comProgramChiefs;
		this.comProgramAppraisers = comProgramAppraisers;
		this.comProgramProducers = comProgramProducers;
		this.comProgramBosses = comProgramBosses;
		this.comProgramDutyEditors = comProgramDutyEditors;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "program_id", unique = true, nullable = false, length = 32)
	public String getProgramId() {
		return this.programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	@Column(name = "program_name", nullable = false, length = 32)
	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Column(name = "program_describe", length = 500)
	public String getProgramDescribe() {
		return this.programDescribe;
	}

	public void setProgramDescribe(String programDescribe) {
		this.programDescribe = programDescribe;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comProgram")
	public Set<ComProgramEditorCharge> getComProgramEditorCharges() {
		return this.comProgramEditorCharges;
	}

	public void setComProgramEditorCharges(
			Set<ComProgramEditorCharge> comProgramEditorCharges) {
		this.comProgramEditorCharges = comProgramEditorCharges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comProgram")
	public Set<ComForm> getComForms() {
		return this.comForms;
	}

	public void setComForms(Set<ComForm> comForms) {
		this.comForms = comForms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comProgram")
	public Set<ComProgramChief> getComProgramChiefs() {
		return this.comProgramChiefs;
	}

	public void setComProgramChiefs(Set<ComProgramChief> comProgramChiefs) {
		this.comProgramChiefs = comProgramChiefs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comProgram")
	public Set<ComProgramAppraiser> getComProgramAppraisers() {
		return this.comProgramAppraisers;
	}

	public void setComProgramAppraisers(
			Set<ComProgramAppraiser> comProgramAppraisers) {
		this.comProgramAppraisers = comProgramAppraisers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comProgram")
	public Set<ComProgramProducer> getComProgramProducers() {
		return this.comProgramProducers;
	}

	public void setComProgramProducers(
			Set<ComProgramProducer> comProgramProducers) {
		this.comProgramProducers = comProgramProducers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comProgram")
	public Set<ComProgramBoss> getComProgramBosses() {
		return this.comProgramBosses;
	}

	public void setComProgramBosses(Set<ComProgramBoss> comProgramBosses) {
		this.comProgramBosses = comProgramBosses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comProgram")
	public Set<ComProgramDutyEditor> getComProgramDutyEditors() {
		return this.comProgramDutyEditors;
	}

	public void setComProgramDutyEditors(
			Set<ComProgramDutyEditor> comProgramDutyEditors) {
		this.comProgramDutyEditors = comProgramDutyEditors;
	}

}
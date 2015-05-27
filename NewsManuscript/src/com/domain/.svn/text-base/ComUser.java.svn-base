package com.domain;

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
 * ComUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_user", schema = "dbo", catalog = "NewsManuscript")
public class ComUser implements java.io.Serializable {

	// Fields

	private String userId;
	private ComDepartment comDepartment;
	private String loginName;
	private String loginPassword;
	private String name;
	private Integer status;
	private Set<ComProgramDutyEditor> comProgramDutyEditors = new HashSet<ComProgramDutyEditor>(
			0);
	private Set<ComManuscript> comManuscriptsForAuthorId = new HashSet<ComManuscript>(
			0);
	private Set<ComForm> comFormsForProducerId = new HashSet<ComForm>(0);
	private Set<ComForm> comFormsForAnnouncerId = new HashSet<ComForm>(0);
	private Set<ComProgramChief> comProgramChiefs = new HashSet<ComProgramChief>(
			0);
	private Set<ComProgramBoss> comProgramBosses = new HashSet<ComProgramBoss>(
			0);
	private Set<ComProgramEditorCharge> comProgramEditorCharges = new HashSet<ComProgramEditorCharge>(
			0);
	private Set<ComProgramAppraiser> comProgramAppraisers = new HashSet<ComProgramAppraiser>(
			0);
	private Set<ComPosition> comPositions = new HashSet<ComPosition>(0);
	private Set<ComManuscript> comManuscriptsForUpdatePersonId = new HashSet<ComManuscript>(
			0);
	private Set<ComReferee> comRefereesForManuscriptTypeId = new HashSet<ComReferee>(
			0);
	private Set<ComProgramProducer> comProgramProducers = new HashSet<ComProgramProducer>(
			0);
	private Set<ComPending> comPendings = new HashSet<ComPending>(0);
	private Set<ComForm> comFormsForEditorChargeId = new HashSet<ComForm>(0);
	private Set<ComReferee> comRefereesForRefereePersonId = new HashSet<ComReferee>(
			0);

	// Constructors

	/** default constructor */
	public ComUser() {
	}

	/** minimal constructor */
	public ComUser(ComDepartment comDepartment, String loginName,
			String loginPassword, String name, Integer status) {
		this.comDepartment = comDepartment;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.name = name;
		this.status = status;
	}

	/** full constructor */
	public ComUser(ComDepartment comDepartment, String loginName,
			String loginPassword, String name, Integer status,
			Set<ComProgramDutyEditor> comProgramDutyEditors,
			Set<ComManuscript> comManuscriptsForAuthorId,
			Set<ComForm> comFormsForProducerId,
			Set<ComForm> comFormsForAnnouncerId,
			Set<ComProgramChief> comProgramChiefs,
			Set<ComProgramBoss> comProgramBosses,
			Set<ComProgramEditorCharge> comProgramEditorCharges,
			Set<ComProgramAppraiser> comProgramAppraisers,
			Set<ComPosition> comPositions,
			Set<ComManuscript> comManuscriptsForUpdatePersonId,
			Set<ComReferee> comRefereesForManuscriptTypeId,
			Set<ComProgramProducer> comProgramProducers,
			Set<ComPending> comPendings,
			Set<ComForm> comFormsForEditorChargeId,
			Set<ComReferee> comRefereesForRefereePersonId) {
		this.comDepartment = comDepartment;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.name = name;
		this.status = status;
		this.comProgramDutyEditors = comProgramDutyEditors;
		this.comManuscriptsForAuthorId = comManuscriptsForAuthorId;
		this.comFormsForProducerId = comFormsForProducerId;
		this.comFormsForAnnouncerId = comFormsForAnnouncerId;
		this.comProgramChiefs = comProgramChiefs;
		this.comProgramBosses = comProgramBosses;
		this.comProgramEditorCharges = comProgramEditorCharges;
		this.comProgramAppraisers = comProgramAppraisers;
		this.comPositions = comPositions;
		this.comManuscriptsForUpdatePersonId = comManuscriptsForUpdatePersonId;
		this.comRefereesForManuscriptTypeId = comRefereesForManuscriptTypeId;
		this.comProgramProducers = comProgramProducers;
		this.comPendings = comPendings;
		this.comFormsForEditorChargeId = comFormsForEditorChargeId;
		this.comRefereesForRefereePersonId = comRefereesForRefereePersonId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	public ComDepartment getComDepartment() {
		return this.comDepartment;
	}

	public void setComDepartment(ComDepartment comDepartment) {
		this.comDepartment = comDepartment;
	}

	@Column(name = "login_name", nullable = false, length = 32)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "login_password", nullable = false, length = 32)
	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComProgramDutyEditor> getComProgramDutyEditors() {
		return this.comProgramDutyEditors;
	}

	public void setComProgramDutyEditors(
			Set<ComProgramDutyEditor> comProgramDutyEditors) {
		this.comProgramDutyEditors = comProgramDutyEditors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUserByAuthorId")
	public Set<ComManuscript> getComManuscriptsForAuthorId() {
		return this.comManuscriptsForAuthorId;
	}

	public void setComManuscriptsForAuthorId(
			Set<ComManuscript> comManuscriptsForAuthorId) {
		this.comManuscriptsForAuthorId = comManuscriptsForAuthorId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUserByProducerId")
	public Set<ComForm> getComFormsForProducerId() {
		return this.comFormsForProducerId;
	}

	public void setComFormsForProducerId(Set<ComForm> comFormsForProducerId) {
		this.comFormsForProducerId = comFormsForProducerId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUserByAnnouncerId")
	public Set<ComForm> getComFormsForAnnouncerId() {
		return this.comFormsForAnnouncerId;
	}

	public void setComFormsForAnnouncerId(Set<ComForm> comFormsForAnnouncerId) {
		this.comFormsForAnnouncerId = comFormsForAnnouncerId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComProgramChief> getComProgramChiefs() {
		return this.comProgramChiefs;
	}

	public void setComProgramChiefs(Set<ComProgramChief> comProgramChiefs) {
		this.comProgramChiefs = comProgramChiefs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComProgramBoss> getComProgramBosses() {
		return this.comProgramBosses;
	}

	public void setComProgramBosses(Set<ComProgramBoss> comProgramBosses) {
		this.comProgramBosses = comProgramBosses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComProgramEditorCharge> getComProgramEditorCharges() {
		return this.comProgramEditorCharges;
	}

	public void setComProgramEditorCharges(
			Set<ComProgramEditorCharge> comProgramEditorCharges) {
		this.comProgramEditorCharges = comProgramEditorCharges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComProgramAppraiser> getComProgramAppraisers() {
		return this.comProgramAppraisers;
	}

	public void setComProgramAppraisers(
			Set<ComProgramAppraiser> comProgramAppraisers) {
		this.comProgramAppraisers = comProgramAppraisers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComPosition> getComPositions() {
		return this.comPositions;
	}

	public void setComPositions(Set<ComPosition> comPositions) {
		this.comPositions = comPositions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUserByUpdatePersonId")
	public Set<ComManuscript> getComManuscriptsForUpdatePersonId() {
		return this.comManuscriptsForUpdatePersonId;
	}

	public void setComManuscriptsForUpdatePersonId(
			Set<ComManuscript> comManuscriptsForUpdatePersonId) {
		this.comManuscriptsForUpdatePersonId = comManuscriptsForUpdatePersonId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUserByManuscriptTypeId")
	public Set<ComReferee> getComRefereesForManuscriptTypeId() {
		return this.comRefereesForManuscriptTypeId;
	}

	public void setComRefereesForManuscriptTypeId(
			Set<ComReferee> comRefereesForManuscriptTypeId) {
		this.comRefereesForManuscriptTypeId = comRefereesForManuscriptTypeId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComProgramProducer> getComProgramProducers() {
		return this.comProgramProducers;
	}

	public void setComProgramProducers(
			Set<ComProgramProducer> comProgramProducers) {
		this.comProgramProducers = comProgramProducers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUser")
	public Set<ComPending> getComPendings() {
		return this.comPendings;
	}

	public void setComPendings(Set<ComPending> comPendings) {
		this.comPendings = comPendings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUserByEditorChargeId")
	public Set<ComForm> getComFormsForEditorChargeId() {
		return this.comFormsForEditorChargeId;
	}

	public void setComFormsForEditorChargeId(
			Set<ComForm> comFormsForEditorChargeId) {
		this.comFormsForEditorChargeId = comFormsForEditorChargeId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comUserByRefereePersonId")
	public Set<ComReferee> getComRefereesForRefereePersonId() {
		return this.comRefereesForRefereePersonId;
	}

	public void setComRefereesForRefereePersonId(
			Set<ComReferee> comRefereesForRefereePersonId) {
		this.comRefereesForRefereePersonId = comRefereesForRefereePersonId;
	}

}
package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import oracle.sql.CLOB;
@Entity(name="subject")
/**
 * 
 * @author thinkpad
 *
 */
public class Subject {
	
	
	
	private Integer subjectId;
	/**
	 * ��ˮ��
	 * @return
	 */
	private String  serialNumber;
	/**
	 * ��ͬ��
	 * @return
	 */
	private String  serialNo;
	/**
	 * �������
	 * @return
	 */
	private String  subjectName;
	/**
	 * �������
	 */
	private Integer subjectType;
	/**
	 * ���״̬
	 */
	private Integer status;
	/**
	 * ��Ͷ���
	 */
	private Float floorAmount ;
	/**
	 * ��Ľ��
	 */
	private Float   amount;
	/**
	 * ʼ��id
	 */
	private Integer  firstId;
	/**
	 * ʼ��id
	 */
	private Integer parentId;
	/**
	 * �������
	 */
	private Integer period;
	/**
	 * ���Ŀ��
	 * @return
	 */
	private String  purpose;
	/**
	 * ļ����ʼ
	 */
	private Date raiseStart;
	/**
	 * ļ����ʼ
	 */
	private Date  raiseEnd;
	/**
	 * ���ʽ
	 */
	private Integer refundWay;
	/**
	 * ���Ϸ�ʽ
	 */
	private Integer safeGuardWay;
	/**
	 * ��Ŀ�ʼ����
	 */
	private Date  startDate;
	/**
	 * ��Ľ�������
	 */
	private Date  endDate;
	/**
	 * �껯��
	 * @return
	 */
	private Float  yearRate ;
	/**
	 * ��Ʒ����
	 */
	@Transient
	private String  subjectComment;
	/**
	 * �ļ���Id
	 */
	private Integer   folderId;
	/**
	 * �Ƿ�ɾ��
	 */
	private Integer   delflag;
	/**
	 * ��������
	 */
	private Date   updateDate;
	/**
	 * ��������
	 */
	private Date createDate;
	/**
	 * ���������
	 * @return
	 */
	private String   borrowername;
	/**
	 * �����id
	 */
	private Integer   borrowerid;
	/**
	 * �ѹ�����
	 */
	private Integer bought;
	/**
	 * ��Ŀ����
	 */
	@Transient
	private String  projectDetails;
	/**
	 * ��ȫ����
	 */
	@Transient
	private String   safetyControl;
	/**
	 * ������Ƿ���Թ���0����1���ǣ�
	 */
	private Integer  experStatus;
	@Id
	@SequenceGenerator(name="subject",sequenceName="sql_subject",allocationSize=1)
	@GeneratedValue(generator="subject",strategy=GenerationType.SEQUENCE)
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Float getFloorAmount() {
		return floorAmount;
	}
	public Integer getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(Integer subjectType) {
		this.subjectType = subjectType;
	}
	public void setFloorAmount(Float floorAmount) {
		this.floorAmount = floorAmount;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getFirstId() {
		return firstId;
	}
	public void setFirstId(Integer firstId) {
		this.firstId = firstId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getRaiseStart() {
		return raiseStart;
	}
	public void setRaiseStart(Date raiseStart) {
		this.raiseStart = raiseStart;
	}
	public Date getRaiseEnd() {
		return raiseEnd;
	}
	public void setRaiseEnd(Date raiseEnd) {
		this.raiseEnd = raiseEnd;
	}
	public Integer getRefundWay() {
		return refundWay;
	}
	public void setRefundWay(Integer refundWay) {
		this.refundWay = refundWay;
	}
	public Integer getSafeGuardWay() {
		return safeGuardWay;
	}
	public void setSafeGuardWay(Integer safeGuardWay) {
		this.safeGuardWay = safeGuardWay;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Float getYearRate() {
		return yearRate;
	}
	public void setYearRate(Float yearRate) {
		this.yearRate = yearRate;
	}
	public String getSubjectComment() {
		return subjectComment;
	}
	public void setSubjectComment(String subjectComment) {
		this.subjectComment = subjectComment;
	}
	public Integer getFolderId() {
		return folderId;
	}
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getBorrowername() {
		return borrowername;
	}
	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}
	public Integer getBorrowerid() {
		return borrowerid;
	}
	public void setBorrowerid(Integer borrowerid) {
		this.borrowerid = borrowerid;
	}
	public Integer getBought() {
		return bought;
	}
	public void setBought(Integer bought) {
		this.bought = bought;
	}
	public String getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}
	public String getSafetyControl() {
		return safetyControl;
	}
	public void setSafetyControl(String safetyControl) {
		this.safetyControl = safetyControl;
	}
	public Integer getExperStatus() {
		return experStatus;
	}
	public void setExperStatus(Integer experStatus) {
		this.experStatus = experStatus;
	}

}

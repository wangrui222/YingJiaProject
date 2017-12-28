package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * 
 * @author thinkpad
 *
 */
@Entity
public class Subject {
	
	private Integer subjectId;
	/**
	 * 流水号
	 * @return
	 */
	private String  serialNumber;
	/**
	 * 合同号
	 * @return
	 */
	private String  serialNo;
	/**
	 * 标的名称
	 * @return
	 */
	private String  subjectName;
	/**
	 * 标的类型
	 */
	private Integer subjectType;
	/**
	 * 标的状态
	 */
	private Integer status;
	/**
	 * 起投金额
	 */
	private Float floorAmount ;
	/**
	 * 标的总金额(gus)
	 */
	private Float   amount;
	/**
	 * 始标id
	 */
	private Integer  firstId;
	/**
	 * 始标id
	 */
	private Integer parentId;
	/**
	 * 标的周期
	 */
	private Integer period;
	/**
	 * 借款目的
	 * @return
	 */
	private String  purpose;
	/**
	 * 募集开始
	 */
	private Date raiseStart;
	/**
	 * 募集开始
	 */
	private Date  raiseEnd;
	/**
	 * 还款方式
	 */
	private Integer refundWay;
	/**
	 * 保障方式
	 */
	private Integer safeguardWay;
	/**
	 * 标的开始日期
	 */
	private Date  startDate;
	/**
	 * 标的结束日期
	 */
	private Date  endDate;
	/**
	 * 年化率
	 * @return
	 */
	private Float  yearRate ;
	/**
	 * 产品速览
	 */
	private String  subjectComment;
	/**
	 * 文件夹Id
	 */
	private Integer   folderId;
	/**
	 * 是否删除
	 */
	private Integer   delflag;
	/**
	 * 更新日期
	 */
	private Date   updateDate;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 借款人姓名
	 * @return
	 */
	private String   borrowername;
	/**
	 * 借款人id
	 */
	private Integer   borrowerid;
	/**
	 * 已购人数
	 */
	private Integer bought;
	/**
	 * 项目详情
	 */
	private String  projectdetails;
	/**
	 * 安全保障
	 */
	private String   safetycontrol;
	/**
	 * 体验金是否可以购买（0：否，1：是）
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



	public Integer getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(Integer subjectType) {
		this.subjectType = subjectType;
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

	public Integer getSafeguardWay() {
		return safeguardWay;
	}
	public void setSafeguardWay(Integer safeguardWay) {
		this.safeguardWay = safeguardWay;
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

	
	public String getProjectdetails() {
		return projectdetails;
	}
	public void setProjectdetails(String projectdetails) {
		this.projectdetails = projectdetails;
	}
	public Integer getExperStatus() {
		return experStatus;
	}
	public String getSafetycontrol() {
		return safetycontrol;
	}
	public void setSafetycontrol(String safetycontrol) {
		this.safetycontrol = safetycontrol;
	}
	public void setExperStatus(Integer experStatus) {
		this.experStatus = experStatus;
	}
	public Subject(Integer subjectType, Integer status, Integer period, Float yearRate) {
		this.subjectType = subjectType;
		this.status = status;
		this.period = period;
		this.yearRate = yearRate;
	}
	public Subject() {
	}
	
}

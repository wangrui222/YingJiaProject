package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity

/**
 * 标的购买
 * @author thinkpad
 *
 */
public class SubjectPurchaseRecord {
	private Integer  sprId;
	/**
	 * 流水号
	 * @return
	 */
	private String serialNumber;
	/**
	 * 购买金额
	 */
	private Float  amount;
	/**
	 * 交易ip
	 * @return
	 */
	private String  dealip;
	/**
	 * 标的Id
	 */
	private Integer  subjectId;
	
	private Integer memberId ;
	
	private Integer  delflag;
	
	private Date createDate ;
	
	private Date updateDate;
	/**
	 * 结算利息
	 * @return
	 */
	private Float interest;
	
	/**
	 * 是否还款
	 */
	private Integer  ispayment;

	private Integer payInterestTimes;
	/**
	 * 最后计息日
	 */
	private Integer lastProfitDay;
	/**
	 * 红包金额信息（app端实际投资额度+红包额度）
	 */
	private String  bonusInfo;
	
	
	@Id
	@SequenceGenerator(name="subject_purchase_record",sequenceName="sql_subject_purchase_record",allocationSize=50)
	@GeneratedValue(generator="subject_purchase_record",strategy=GenerationType.SEQUENCE)
	public Integer getSprId() {
		return sprId;
	}
	public void setSprId(Integer sprId) {
		this.sprId = sprId;
	}
	
	public SubjectPurchaseRecord(String serialNumber, Float amount, String dealip, Integer subjectId, Integer memberId,
			Date createDate, Float interest, Integer ispayment, Integer lastProfitDay, String bonusInfo) {
		this.serialNumber = serialNumber;
		this.amount = amount;
		this.dealip = dealip;
		this.subjectId = subjectId;
		this.memberId = memberId;
		this.createDate = createDate;
		this.interest = interest;
		this.ispayment = ispayment;
		this.lastProfitDay = lastProfitDay;
		this.bonusInfo = bonusInfo;
	}
	
	
	public SubjectPurchaseRecord() {
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getDealip() {
		return dealip;
	}
	public void setDealip(String dealip) {
		this.dealip = dealip;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Float getInterest() {
		return interest;
	}
	public void setInterest(Float interest) {
		this.interest = interest;
	}
	public Integer getIspayment() {
		return ispayment;
	}
	public void setIspayment(Integer ispayment) {
		this.ispayment = ispayment;
	}
	public Integer getPayInterestTimes() {
		return payInterestTimes;
	}
	public void setPayInterestTimes(Integer payInterestTimes) {
		this.payInterestTimes = payInterestTimes;
	}
	public Integer getLastProfitDay() {
		return lastProfitDay;
	}
	public void setLastProfitDay(Integer lastProfitDay) {
		this.lastProfitDay = lastProfitDay;
	}
	public String getBonusInfo() {
		return bonusInfo;
	}
	public void setBonusInfo(String bonusInfo) {
		this.bonusInfo = bonusInfo;
	}
	
	
	
}

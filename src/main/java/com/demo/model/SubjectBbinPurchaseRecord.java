package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="subject_bbin_purchase_record")
/**
 * 体验金购买标的
 * @author thinkpad
 *
 */
public class SubjectBbinPurchaseRecord {
	private Integer sbprId ;
	/**
	 * 流水号
	 * @return
	 */
	private Integer   serialNumber ;
	/**
	 * 购买金额
	 */
	private Float   amount;
	/**
	 * 交易ip
	 * @return
	 */
	private String   dealIp;
	/**
	 * 标的Id
	 */
	 private Integer  subjectId;
	 private Integer  memberId;
	 private Integer  delflag;
	 private Date	 createDate;
	 private Date  updateDate ;
	 /**
	  * 结算利息
	  */
	 private Float  interest;
	 /**
	  * 是否还款
	  */
	  private Integer ispayment;
	 private Integer  payInterestTimes ;
	 /**
	  * 最后计息日
	  */
	 private Integer  lastProfitDay;
	 @Id
	 @SequenceGenerator(name="subject_bbin_purchase_record",sequenceName="sql_subject_bbin_purchase_record",allocationSize=1)
	 @GeneratedValue(generator="subject_bbin_purchase_record",strategy=GenerationType.SEQUENCE)
	public Integer getSbprId() {
		return sbprId;
	}
	public void setSbprId(Integer sbprId) {
		this.sbprId = sbprId;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getDealIp() {
		return dealIp;
	}
	public void setDealIp(String dealIp) {
		this.dealIp = dealIp;
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
	 

}

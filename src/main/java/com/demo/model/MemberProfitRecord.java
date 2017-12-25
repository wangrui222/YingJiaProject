package com.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * 收益记录表
 * @author admin
 *
 */
@Entity
public class MemberProfitRecord {
	private Integer	mprId ;//主键
	private	  String serialNumber ;//流水号
	private Integer  mprType;//
	private Float  amount  ;//金额
	private Integer  memberId ;//用户id
	private Integer  delflag  ;//
	private Date  createDate ;
	private Date  updateDate ;
	private  String mprComment ;//备注
	private  Integer purchaseId;//  标的id
	private	 Integer  profitYear;//计息年
	private	  Integer profitMonth  ;//计息月
	private  Integer profitDay ;//计息日
	
	@Id
	@SequenceGenerator(name="seq_MemberProfitRecord",sequenceName="sql_member_profit_record",allocationSize=1)
	@GeneratedValue(generator="seq_MemberProfitRecord",strategy=GenerationType.SEQUENCE)
	public Integer getMprId() {
		return mprId;
	}
	public void setMprId(Integer mprId) {
		this.mprId = mprId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getMprType() {
		return mprType;
	}
	public void setMprType(Integer mprType) {
		this.mprType = mprType;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
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
	public String getMprComment() {
		return mprComment;
	}
	public void setMprComment(String mprComment) {
		this.mprComment = mprComment;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Integer getProfitYear() {
		return profitYear;
	}
	public void setProfitYear(Integer profitYear) {
		this.profitYear = profitYear;
	}
	public Integer getProfitMonth() {
		return profitMonth;
	}
	public void setProfitMonth(Integer profitMonth) {
		this.profitMonth = profitMonth;
	}
	public Integer getProfitDay() {
		return profitDay;
	}
	public void setProfitDay(Integer profitDay) {
		this.profitDay = profitDay;
	}
	
	
	
}

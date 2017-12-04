package com.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 
 * @author admin
 *
 */
@Entity
@Table(name="member_profit_record ")
public class MemberProfitRecord {
	private Integer	mprId ;//����
	private	  String serialNumber ;//��ˮ��
	private Integer  mprType;//
	private Float  amount  ;//���
	private Integer  memberId ;//�û�id
	private Integer  delflag  ;//
	private Date  createDate ;
	private Date  updateDate ;
	private  String mprComment ;//��ע
	private  Integer purchaseId;//  ���id
	private	 Integer  profitYear;//��Ϣ��
	private	  Integer profitMonth  ;//��Ϣ��
	private  Integer profitDay ;//��Ϣ��
	
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

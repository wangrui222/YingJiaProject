package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 标的订单
 * @author thinkpad
 *
 */
@Entity(name="subject_order_record")
public class SubjectOrderRecord {
	
	private Integer sorId;
	/**
	 * 流水号
	 * @return
	 */
	private String  serialNumber;
	/**
	 * 交易类型
	 */
	private Integer dealType;
	/**
	 * 订单金额
	 */
	private Float  amount;
	/**
	 * 订单状态
	 */
	private Integer status;
	/**
	 * 标的id
	 */
	private Integer subjectId;
	/**
	 * 用户id
	 */
	private Integer memberId;
	/**
	 * 是否删除
	 */
	private Integer delflag;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 更新日期
	 */
	private Date  updateDate;
	@Id
	@SequenceGenerator(name="subject_order_record",sequenceName="sql_subject_order_record",allocationSize=1)
	@GeneratedValue(generator="subject_order_record",strategy=GenerationType.SEQUENCE)
	public Integer getSorId() {
		return sorId;
	}
	public void setSorId(Integer sorId) {
		this.sorId = sorId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getDealType() {
		return dealType;
	}
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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


}

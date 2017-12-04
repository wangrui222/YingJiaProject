package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="subject_order_record")
/**
 * ��Ķ���
 * @author thinkpad
 *
 */
public class SubjectOrderRecord {
	private Integer sorId;
	/**
	 * ��ˮ��
	 * @return
	 */
	private String  serialNumber;
	/**
	 * ��������
	 */
	private Integer dealType;
	/**
	 * �������
	 */
	private Float  amount;
	/**
	 * ����״̬
	 */
	private Integer status;
	/**
	 * ���id
	 */
	private Integer subjectId;
	/**
	 * �û�id
	 */
	private Integer memberId;
	/**
	 * �Ƿ�ɾ��
	 */
	private Integer delflag;
	/**
	 * ��������
	 */
	private Date createDate;
	/**
	 * ��������
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

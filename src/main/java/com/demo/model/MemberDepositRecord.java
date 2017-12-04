package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * ��ֵ��¼��
 * @author admin
 *
 */
@Entity
@Table(name="member_deposit_record")
public class MemberDepositRecord {
	private	Integer memberDepositRecordId ;//����
	private	 String  serialNumber ;//��ˮ��
	private  Integer memberId;//�û�id
	private Float  amount ;// ���
	private  Integer status ;//״̬(0:������;1:���)
	private  String payChannelName ;//��ֵ��������
	private	 String  payChannelOrderNo ;// ��ֵ����������
	private Integer  delFlag;//
	private  Date createDate  ;
	private  Date updateDate ;
	
	
	@Id
	@SequenceGenerator(name="seq_MemberDepositRecord",sequenceName="seq_member_deposit_record",allocationSize=1)
	@GeneratedValue(generator="seq_MemberDepositRecord",strategy=GenerationType.SEQUENCE)

	
	public Integer getMemberDepositRecordId() {
		return memberDepositRecordId;
	}
	public void setMemberDepositRecordId(Integer memberDepositRecordId) {
		this.memberDepositRecordId = memberDepositRecordId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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
	public String getPayChannelName() {
		return payChannelName;
	}
	public void setPayChannelName(String payChannelName) {
		this.payChannelName = payChannelName;
	}
	public String getPayChannelOrderNo() {
		return payChannelOrderNo;
	}
	public void setPayChannelOrderNo(String payChannelOrderNo) {
		this.payChannelOrderNo = payChannelOrderNo;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

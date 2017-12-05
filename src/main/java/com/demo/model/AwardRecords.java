package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author admin
 *--������¼��
 */
@Entity(name="award_records")
public class AwardRecords {
	
	private  Integer  awardRecordsId;//����
	private Integer  invitingid  ;//������id
	private Integer  byinvitingid;//��������id
	private Integer awardRecordsType;//��������
	private Float  amount;//'�������',
	private Integer  isAward ;//0:δ����  1���ѽ���'
	private Date addTime;//'���ʱ��'
	@Id
	@SequenceGenerator(name="seq_AwardRecords",sequenceName="seq_award_records",allocationSize=1)
	@GeneratedValue(generator="seq_AwardRecords",strategy=GenerationType.SEQUENCE)

	public Integer getAwardRecordsId() {
		return awardRecordsId;
	}
	public void setAwardRecordsId(Integer awardRecordsId) {
		this.awardRecordsId = awardRecordsId;
	}
	public Integer getInvitingid() {
		return invitingid;
	}
	public void setInvitingid(Integer invitingid) {
		this.invitingid = invitingid;
	}
	public Integer getByinvitingid() {
		return byinvitingid;
	}
	public void setByinvitingid(Integer byinvitingid) {
		this.byinvitingid = byinvitingid;
	}
	public Integer getAwardRecordsType() {
		return awardRecordsType;
	}
	public void setAwardRecordsType(Integer awardRecordsType) {
		this.awardRecordsType = awardRecordsType;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getIsAward() {
		return isAward;
	}
	public void setIsAward(Integer isAward) {
		this.isAward = isAward;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}



}

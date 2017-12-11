package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * -- ���ּ�¼�� 
 * @author admin
 *
 */
@Entity(name="member_withdraw_record")

public class MemberWithdrawRecord {
	private Integer mwrId ;//����
	private  String serialNumber ;//��ˮ��',
	private  Integer memberId ;//�û�id',
	private Float  amount  ;//'���ֽ��',
	private String bankName  ;//'��������',
	private String  bankCard  ;//����',
	private  Integer status ;//����״̬(0:�����;1:�Ѵ��;2�����;3:���ʧ��);',
	private  Integer delflag ;
	private String cardaddress  ;// '�����������ڵ�',
	private String channelName  ;// '���ͨ��������,������',
	private Date createDate ;
	private  Date updateDate  ;
	
	@Id
	@SequenceGenerator(name="MemberWithdrawRecord _seq",sequenceName="sql_member_withdraw_record",allocationSize=1)
	@GeneratedValue(generator="MemberWithdrawRecord _seq",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getMwrId() {
		return mwrId;
	}
	public void setMwrId(Integer mwrId) {
		this.mwrId = mwrId;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public String getCardaddress() {
		return cardaddress;
	}
	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

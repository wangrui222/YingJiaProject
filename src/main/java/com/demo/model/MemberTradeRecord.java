package com.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * ���׼�¼��
 * @author admin
 *
 */


@Entity
public class MemberTradeRecord {
	private Integer mtrId;//����
	private Integer  memberId ;//'�û�id',
	private  String tradeNo  ;//'���׺�',
	private  String tradeName ;//'��������',
	private  String counterpart ;//���׶Է�',
	private Float amount  ;//���׽��',
	private  String tradeType  ;//���׷���',
	private  Integer fundFlow  ;//�ʽ�����(0:����1:����);',
	private  Integer tradeStatus ;//����״̬',
	private String  extField_1 ;// '��չ1',
	private  String  extField_2 ;//--'��չ2',
	private String extField_3 ;//--'��չ3',
	private Date createDate  ;
	private Date updateDate  ;
	

	
	public MemberTradeRecord(Integer memberId, String tradeNo, String tradeName, Float amount, String tradeType,
			Integer fundFlow, Integer tradeStatus, String extField_1, Date createDate) {
		this.memberId = memberId;
		this.tradeNo = tradeNo;
		this.tradeName = tradeName;
		this.amount = amount;
		this.tradeType = tradeType;
		this.fundFlow = fundFlow;
		this.tradeStatus = tradeStatus;
		this.extField_1 = extField_1;
		this.createDate = createDate;
	}
	
	
	public MemberTradeRecord() {
	}




	@Id
	@SequenceGenerator(name="MemberTradeRecord_seq",sequenceName="sql_member_trade_record",allocationSize=1)
	@GeneratedValue(generator="MemberTradeRecord_seq",strategy=GenerationType.SEQUENCE)
	public Integer getMtrId() {
		return mtrId;
	}
	public void setMtrId(Integer mtrId) {
		this.mtrId = mtrId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getCounterpart() {
		return counterpart;
	}
	public void setCounterpart(String counterpart) {
		this.counterpart = counterpart;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public Integer getFundFlow() {
		return fundFlow;
	}
	public void setFundFlow(Integer fundFlow) {
		this.fundFlow = fundFlow;
	}
	public Integer getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public String getExtField_1() {
		return extField_1;
	}
	public void setExtField_1(String extField_1) {
		this.extField_1 = extField_1;
	}
	public String getExtField_2() {
		return extField_2;
	}
	public void setExtField_2(String extField_2) {
		this.extField_2 = extField_2;
	}
	public String getExtField_3() {
		return extField_3;
	}
	public void setExtField_3(String extField_3) {
		this.extField_3 = extField_3;
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

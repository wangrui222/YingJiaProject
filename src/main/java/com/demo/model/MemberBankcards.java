package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 银行卡表
 * @author admin
 *
 */
@Entity
public class MemberBankcards {
	private	Integer memberBankcardsId  ;//主键
	private String	memberBankcardsType  ;//银行卡类型
	private	 Integer memberId  ;//用户id
	private String cardNo  ;//卡号
	private	 Integer delflag ;//是否删除（0：正常使用，2：被删除）
	private	 Date createDate  ;//
	private	Date updateDate ;//
	private  String cardaddress  ;//开户银行所在地
	

	@Id
	@SequenceGenerator(name="seq_MemberBankcards",sequenceName="seq_member_bankcards",allocationSize=1)
	@GeneratedValue(generator="seq_MemberBankcards",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getMemberBankcardsId() {
		return memberBankcardsId;
	}
	public void setMemberBankcardsId(Integer memberBankcardsId) {
		this.memberBankcardsId = memberBankcardsId;
	}
	public String getMemberBankcardsType() {
		return memberBankcardsType;
	}
	public void setMemberBankcardsType(String memberBankcardsType) {
		this.memberBankcardsType = memberBankcardsType;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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
	public String getCardaddress() {
		return cardaddress;
	}
	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}
	
}

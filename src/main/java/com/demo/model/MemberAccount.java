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
@Entity(name="member_account")
public class MemberAccount {
	private	Integer memberAccountId ;//����
	private	Integer   memberId ;//�û�id
	private  Float useableBalance ;//�������
	private Float  imusealeBalance  ;//�������
	private  Float totalProfit  ;//�ۼ�����
	private Date  createDate ;//���ʱ��
	private  Date updateDate  ;//�޸�ʱ��
	private  Float bonusAmount ;// ������
	private  Float investAmount  ;//Ͷ���ܶ�
	private Integer  delflag  ;//
	private Float  bbinAmount ;//�����
	
	
	@Id
	@SequenceGenerator(name="seq_MemberAccount",sequenceName="seq_member_account",allocationSize=1)
	@GeneratedValue(generator="seq_MemberAccount",strategy=GenerationType.SEQUENCE)
	
	
	
	public Integer getMemberAccountId() {
		return memberAccountId;
	}
	public void setMemberAccountId(Integer memberAccountId) {
		this.memberAccountId = memberAccountId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Float getUseableBalance() {
		return useableBalance;
	}
	public void setUseableBalance(Float useableBalance) {
		this.useableBalance = useableBalance;
	}
	public Float getImusealeBalance() {
		return imusealeBalance;
	}
	public void setImusealeBalance(Float imusealeBalance) {
		this.imusealeBalance = imusealeBalance;
	}
	public Float getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(Float totalProfit) {
		this.totalProfit = totalProfit;
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
	public Float getBonusAmount() {
		return bonusAmount;
	}
	public void setBonusAmount(Float bonusAmount) {
		this.bonusAmount = bonusAmount;
	}
	public Float getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(Float investAmount) {
		this.investAmount = investAmount;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public Float getBbinAmount() {
		return bbinAmount;
	}
	public void setBbinAmount(Float bbinAmount) {
		this.bbinAmount = bbinAmount;
	}
	
	
	
}

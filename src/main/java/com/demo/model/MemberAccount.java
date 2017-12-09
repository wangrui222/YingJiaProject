package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author admin
 *
 */
@Entity(name="member_account")
public class MemberAccount {
	private	Integer memberAccountId ;//主键
	private	Members  members ;//用户id
	private  Float useableBalance ;//可用余额
	private Float  imusealeBalance  ;//冻结余额
	private  Float totalProfit  ;//累计收益
	private Date  createDate ;//添加时间
	private  Date updateDate  ;//修改时间
	private  Float bonusAmount ;// 红包金额
	private  Float investAmount  ;//投资总额
	private Integer  delflag  ;//
	private Float  bbinAmount ;//体验金
	
	
	@Id
	@SequenceGenerator(name="seq_MemberAccount",sequenceName="seq_member_account",allocationSize=1)
	@GeneratedValue(generator="seq_MemberAccount",strategy=GenerationType.SEQUENCE)
	
	
	
	public Integer getMemberAccountId() {
		return memberAccountId;
	}
	public void setMemberAccountId(Integer memberAccountId) {
		this.memberAccountId = memberAccountId;
	}
	@ManyToOne
	@JoinColumn(name="member_id")
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
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

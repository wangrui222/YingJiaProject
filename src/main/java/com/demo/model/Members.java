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
 *用户基本表
 */

@Entity
public class Members {
	private	Integer memberId ;//用户id
	private	 String memberName ;//真实姓名
	private String names ;//用户名
	private	String passwords ;//密码
	private String	salts; //密码盐
	private	String mobilePhone ;//手机号
	private	String status  ;//锁定，删除）
	private Integer	delFlag ;//删除标志
	private	String memberIdentity  ;//身份
	private	  Date createDate ;//创建时间
	private	Date updateDate;// 修改时间
	private String weiboaccount  ;//微博账号关联
	private	String weixinaccount ;//微信账号关联
	private	 Integer headid  ;//头像图片id
	private	 String invitationcode  ;//邀请码
	private String	withdrawPassword  ;//提款密码
	private	 String qqaccount  ;//QQ账号关联
	private	 String invitedcode  ;//被邀请码
	private	 String qqnumber ;//QQ号码
	
	
	
	@Id
	@SequenceGenerator(name="seq_Members",sequenceName=" seq_members",allocationSize=1)
	@GeneratedValue(generator="seq_Members",strategy=GenerationType.SEQUENCE)
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getSalts() {
		return salts;
	}
	public void setSalts(String salts) {
		this.salts = salts;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public String getMemberIdentity() {
		return memberIdentity;
	}
	public void setMemberIdentity(String memberIdentity) {
		this.memberIdentity = memberIdentity;
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

	public String getWeiboaccount() {
		return weiboaccount;
	}
	public void setWeiboaccount(String weiboaccount) {
		this.weiboaccount = weiboaccount;
	}
	
	public String getWeixinaccount() {
		return weixinaccount;
	}
	public void setWeixinaccount(String weixinaccount) {
		this.weixinaccount = weixinaccount;
	}
	public Integer getHeadid() {
		return headid;
	}
	public void setHeadid(Integer headid) {
		this.headid = headid;
	}
	
	public String getWithdrawPassword() {
		return withdrawPassword;
	}
	public void setWithdrawPassword(String withdrawPassword) {
		this.withdrawPassword = withdrawPassword;
	}

	public String getQqaccount() {
		return qqaccount;
	}
	public void setQqaccount(String qqaccount) {
		this.qqaccount = qqaccount;
	}
	
	public String getInvitationcode() {
		return invitationcode;
	}
	public void setInvitationcode(String invitationcode) {
		this.invitationcode = invitationcode;
	}
	public String getInvitedcode() {
		return invitedcode;
	}
	public void setInvitedcode(String invitedcode) {
		this.invitedcode = invitedcode;
	}
	public String getQqnumber() {
		return qqnumber;
	}
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}
	
	
	
	
	
	
}

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
 *�û�������
 */

@Entity(name="members")
public class Members {
	private	Integer memberId ;//�û�id
	private	 String memberName ;//��ʵ����
	private String names ;//�û���
	private	String passwords ;//����
	private String	salts; //������
	private	String mobilePhone ;//�ֻ���
	private	String status  ;//������ɾ����
	private Integer	delFlag ;//ɾ����־
	private	String memberIdentity  ;//���
	private	  Date createDate ;//����ʱ��
	private	Date updateDate;// �޸�ʱ��
	private String weiBoAccount  ;//΢���˺Ź���
	private	String weixinAccount ;//΢���˺Ź���
	private	 Integer headid  ;//ͷ��ͼƬid
	private	 String invitationCode  ;//������
	private String	withdrawPassword  ;//�������
	private	 String qqAccount  ;//QQ�˺Ź���
	private	 String invitedCode  ;//��������
	private	 String qqNumber ;//QQ����
	
	
	
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
	public String getWeiBoAccount() {
		return weiBoAccount;
	}
	public void setWeiBoAccount(String weiBoAccount) {
		this.weiBoAccount = weiBoAccount;
	}
	public String getWeixinAccount() {
		return weixinAccount;
	}
	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}
	public Integer getHeadid() {
		return headid;
	}
	public void setHeadid(Integer headid) {
		this.headid = headid;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public String getWithdrawPassword() {
		return withdrawPassword;
	}
	public void setWithdrawPassword(String withdrawPassword) {
		this.withdrawPassword = withdrawPassword;
	}
	public String getQqAccount() {
		return qqAccount;
	}
	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}
	public String getInvitedCode() {
		return invitedCode;
	}
	public void setInvitedCode(String invitedCode) {
		this.invitedCode = invitedCode;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	
	
	
	
	
}

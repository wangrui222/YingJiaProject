package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;




@Entity(name="associated_account")
/**
 * 关联账号表（第三方登录信息表）
 * @author admin
 *
 */
public class AssociatedAccount {
	
	private Integer associatedAccountId;//主键
	private Integer memberId  ;//会员id',
	private String associatedAccountType;//账号类型（微信，QQ）

	private String associatedAccountName ;//账号名称
	private String identifying;//账号标识
	private Integer status;//状态
	private Date createDate;//添加时间
	private Date updateDate;//修改时间
	
	@Id
	@SequenceGenerator(name="seq_AssociatedAccount",sequenceName="seq_associated_account",allocationSize=1)
	@GeneratedValue(generator="seq_AssociatedAccount",strategy=GenerationType.SEQUENCE)
	
	public Integer getAssociatedAccountId() {
		return associatedAccountId;
	}
	public void setAssociatedAccountId(Integer associatedAccountId) {
		this.associatedAccountId = associatedAccountId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getAssociatedAccountType() {
		return associatedAccountType;
	}
	public void setAssociatedAccountType(String associatedAccountType) {
		this.associatedAccountType = associatedAccountType;
	}
	public String getAssociatedAccountName() {
		return associatedAccountName;
	}
	public void setAssociatedAccountName(String associatedAccountName) {
		this.associatedAccountName = associatedAccountName;
	}
	public String getIdentifying() {
		return identifying;
	}
	public void setIdentifying(String identifying) {
		this.identifying = identifying;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

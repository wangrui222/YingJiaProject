package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * '缴费项目
 * @author admin
 *
 */
@Entity
@Table(name="member_puc_charge_item")
public class MemberPucChargeItem {
	private	 Integer mpciId  ;//主键
	private	 Integer  memberId ;//-用户id',
	private  Integer homeId  ;
	private String  chargeType ;//缴费类别',
	private  Integer chargeInstitutionId  ;//缴费机构id',
	private  String chargeInstitutionName ;//缴费机构名称',
	private  String chargeInstitutionCode ;//缴费机构编码',
	private  String customerCode  ;//'客户编码',
	private  String mpciComment ;//'备注',

	@Id
	@SequenceGenerator(name="MemberPucChargeItem_seq",sequenceName="sql_member_puc_charge_item",allocationSize=1)
	@GeneratedValue(generator="MemberPucChargeItem_seq",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getMpciId() {
		return mpciId;
	}
	public void setMpciId(Integer mpciId) {
		this.mpciId = mpciId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getHomeId() {
		return homeId;
	}
	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public Integer getChargeInstitutionId() {
		return chargeInstitutionId;
	}
	public void setChargeInstitutionId(Integer chargeInstitutionId) {
		this.chargeInstitutionId = chargeInstitutionId;
	}
	public String getChargeInstitutionName() {
		return chargeInstitutionName;
	}
	public void setChargeInstitutionName(String chargeInstitutionName) {
		this.chargeInstitutionName = chargeInstitutionName;
	}
	public String getChargeInstitutionCode() {
		return chargeInstitutionCode;
	}
	public void setChargeInstitutionCode(String chargeInstitutionCode) {
		this.chargeInstitutionCode = chargeInstitutionCode;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getMpciComment() {
		return mpciComment;
	}
	public void setMpciComment(String mpciComment) {
		this.mpciComment = mpciComment;
	}



}

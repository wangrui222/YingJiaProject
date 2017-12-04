package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * ��ɫ��
 * @author thinkpad
 *
 */
@Entity
@Table(name="user_role")
public class UserRole {
	/**
	 * ����
	 */
	private Integer userRoleId ;
	/**
	 * ������
	 */
	private String cname  ;
	/**
	 * Ӣ����
	 */
	private String ename  ;
	/**
	 * �Ƿ����
	 */
	private Integer available  ;
	/**
	 * ��ע
	 */
	private String remark  ;
	/**
	 * ����ʱ��
	 */
	private Date createDate  ;
	/**
	 * �޸�ʱ��
	 */
	private Date updateDate  ;
	private String userRoleCategory  ;
	private Integer sourceType  ;
	private Integer sourceId;
	private Integer delFlag  ;
	@Id
	@SequenceGenerator(name="user_role",sequenceName="sql_user_role",allocationSize=1)
	@GeneratedValue(generator="user_role",strategy=GenerationType.SEQUENCE)
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getUserRoleCategory() {
		return userRoleCategory;
	}
	public void setUserRoleCategory(String userRoleCategory) {
		this.userRoleCategory = userRoleCategory;
	}
	public Integer getSourceType() {
		return sourceType;
	}
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	

}

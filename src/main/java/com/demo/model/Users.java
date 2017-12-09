package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 用户基本表
 * @author thinkpad
 *
 */
@Entity(name="users")
public class Users {
	/**
	 * 用户id
	 */
	private Integer usersId ;
	/**
	 * 用户名
	 */
	private String userName  ;
	/**
	 * 名称
	 */
	private String usersName  ;
	/**
	 * 密码
	 */
	private String usersPassword  ;
	/**
	 * 密码盐
	 */
	private String usersSalt  ;
	/**
	 * 手机号
	 */
	private String mobilePhone;  
	/**
	 * 账号状态（正常，锁定，删除）
	 */
	private Integer status  ;
	/**
	 * 删除标志
	 */
	private Integer delFlag  ;
	/**
	 * 身份
	 */
	private Integer usersIdentity  ;
	/**
	 * 创建时间
	 */
	private Date createDate ;
	/**
	 * 修改时间
	 */
	private Date updateDate  ;
	
	@Id
	@SequenceGenerator(name="users",sequenceName="sql_users",allocationSize=1)
	@GeneratedValue(generator="users",strategy=GenerationType.SEQUENCE)
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
	public String getUsersSalt() {
		return usersSalt;
	}
	public void setUsersSalt(String usersSalt) {
		this.usersSalt = usersSalt;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public Integer getUsersIdentity() {
		return usersIdentity;
	}
	public void setUsersIdentity(Integer usersIdentity) {
		this.usersIdentity = usersIdentity;
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
	public Users(String userName, String usersPassword, String mobilePhone, Integer status) {
		this.userName = userName;
		this.usersPassword = usersPassword;
		this.mobilePhone = mobilePhone;
		this.status = status;
	}
	public Users() {
	}

	
	

}

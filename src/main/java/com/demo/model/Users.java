package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="users")
/**
 * �û�������
 * @author thinkpad
 *
 */
public class Users {
	/**
	 * �û�id
	 */
	private Integer usersId ;
	/**
	 * �û���
	 */
	private String userName  ;
	/**
	 * ����
	 */
	private String usersName  ;
	/**
	 * ����
	 */
	private String usersPassword  ;
	/**
	 * ������
	 */
	private String usersSalt  ;
	/**
	 * �ֻ���
	 */
	private String mobilePhone;  
	/**
	 * �˺�״̬��������������ɾ����
	 */
	private Integer status  ;
	/**
	 * ɾ����־
	 */
	private Integer delFlag  ;
	/**
	 * ���
	 */
	private Integer usersIdentity  ;
	/**
	 * ����ʱ��
	 */
	private Date createDate ;
	/**
	 * �޸�ʱ��
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


}

package com.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * �û�������
 * @author thinkpad
 *
 */
@Entity(name="users")
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
	
	private Set<UserRole> userRole = new HashSet<>();
	
	@Id
	@SequenceGenerator(name="users",sequenceName="sql_users",allocationSize=1)
	@GeneratedValue(generator="users",strategy=GenerationType.SEQUENCE)
	public Integer getUsersId() {
		return usersId;
	}
	
	@ManyToMany
	@JoinTable(
			name = "user_role_relation",
			joinColumns =@JoinColumn(name="userId"),
			inverseJoinColumns = @JoinColumn(name="roleId")
			)
	public Set<UserRole> getUserRole() {
		return userRole;
	}


	
	
	public Users(String userName, String usersPassword, String mobilePhone, Integer status) {
		this.userName = userName;
		this.usersPassword = usersPassword;
		this.mobilePhone = mobilePhone;
		this.status = status;
	}
	
	

	public Users() {
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
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

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", usersPassword=" + usersPassword + ", mobilePhone=" + mobilePhone
				+ ", status=" + status + "]";
	}


}

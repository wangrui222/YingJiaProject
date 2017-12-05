package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name="user_login_token")

/**
 * 
 * @author thinkpad
 *
 */
public class UserLoginToken {
	/**
	 * ���ƺ�
	 */
	private Integer token ;
	/**
	 * �û�id(����)
	 */
	private Integer userId ;
	/**
	 * ��¼ʱ���û������������û������ֻ��ŵ�
	 * @return
	 */
	private String  userName;
	/**
	 * ����
	 * @return
	 */
	private String  ultPassword ;
	/**
	 * ��Чʱ��
	 */
	private Date expireTime;
	/**
	 * ����ʱ��
	 */

	private Date createDate ;
	/**
	 * �޸�ʱ��
	 */
	private Date updateDate ;
	public Integer getToken() {
		return token;
	}
	public void setToken(Integer token) {
		this.token = token;
	}
	@Id
	@SequenceGenerator(name="user_login_token",sequenceName="sql_user_login_token",allocationSize=1)
	@GeneratedValue(generator="user_login_token",strategy=GenerationType.SEQUENCE)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUltPassword() {
		return ultPassword;
	}
	public void setUltPassword(String ultPassword) {
		this.ultPassword = ultPassword;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
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

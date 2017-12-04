package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="user_login_token")
/**
 * 
 * @author thinkpad
 *
 */
public class UserLoginToken {
	/**
	 * 令牌号
	 */
	private Integer token ;
	/**
	 * 用户id(主键)
	 */
	private Integer userId ;
	/**
	 * 登录时的用户名，可以是用户名，手机号等
	 * @return
	 */
	private String  userName;
	/**
	 * 密码
	 * @return
	 */
	private String  ultPassword ;
	/**
	 * 有效时间
	 */
	private Date expireTime;
	/**
	 * 创建时间
	 */

	private Date createDate ;
	/**
	 * 修改时间
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

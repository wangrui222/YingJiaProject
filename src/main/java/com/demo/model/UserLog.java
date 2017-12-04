package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="user_log")
/**
 *��¼��־
 * @author thinkpad
 *
 */
public class UserLog {
	private Integer	 userLogId ;
	/**
	 * �û�id
	 */
	private Integer userId ;
	/**
	 * ����
	 */
	private Integer action;
	/**
	 * ����ʱ��
	 */
	private Date   createDate ;
	/**
	 * �޸�ʱ��
	 */
	private Date	updateDate ;
	@Id
	@SequenceGenerator(name="user_log",sequenceName="sql_user_log",allocationSize=1)
	@GeneratedValue(generator="user_log",strategy=GenerationType.SEQUENCE)
	public Integer getUserLogId() {
		return userLogId;
	}
	public void setUserLogId(Integer userLogId) {
		this.userLogId = userLogId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
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

package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_role_relation")
/**
 * 
 * �û���ɫ������
 * @author thinkpad
 *
 */
public class UserRoleRelation {
	/**
	 * �û�id
	 */
	private Integer userId ;
	/**
	 * ��ɫid
	 */
	private Integer roleId ;
	/**
	 * ����ʱ��
	 */
	private Date createDate;
	@Id
	@SequenceGenerator(name="user_role_relation",sequenceName="sql_user_role_relation",allocationSize=1)
	@GeneratedValue(generator="user_role_relation",strategy=GenerationType.SEQUENCE)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

}

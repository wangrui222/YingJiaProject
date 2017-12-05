package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name="role_permission_relation")

/**
 * ��ɫȨ�ޱ�
 * @author thinkpad
 *
 */
public class RolePermissionRelation {
	/**
	 * ��ɫid
	 */
	private Integer  roleId;
	/**
	 * Ȩ������
	 * @return
	 */
	private String permissionEname;
	/**
	 * ����ʱ��
	 */
	private Date	createDate;
	@Id
	@SequenceGenerator(name="role_permission_relation",sequenceName="sql_role_permission_relation",allocationSize=1)
	@GeneratedValue(generator="role_permission_relation",strategy=GenerationType.SEQUENCE)
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getPermissionEname() {
		return permissionEname;
	}
	public void setPermissionEname(String permissionEname) {
		this.permissionEname = permissionEname;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}

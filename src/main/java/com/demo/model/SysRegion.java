package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="sys_region")
public class SysRegion {
	private Integer sysRegionID ;
	/**
	 * 行政区域国标代码
	 */
	private String gb2260 ;
	/**
	 * 行政区名称
	 */
	private String  sysRegionNname ;
	/**
	 * 行政区级别
	 */
	private String  regionLevel ;
	/**
	 * 父id
	 */
	private Integer  parentId ;
	/**
	 * 父id列表
	 */
	private String  parentIds ;
	/**
	 * 父编码
	 */
	private String parentGb2260;
	/**
	 * 电话区号
	 * @return
	 */
	private String  diallingCode;
	/**
	 * 创建时间
	 */
	private Date createDate;
	private Date  lastModified;
	@Id
	@SequenceGenerator(name="sys_region",sequenceName="sql_zsys_region",allocationSize=1)
	@GeneratedValue(generator="sys_region",strategy=GenerationType.SEQUENCE)
	public Integer getSysRegionID() {
		return sysRegionID;
	}
	public void setSysRegionID(Integer sysRegionID) {
		this.sysRegionID = sysRegionID;
	}
	public String getGb2260() {
		return gb2260;
	}
	public void setGb2260(String gb2260) {
		this.gb2260 = gb2260;
	}
	public String getSysRegionNname() {
		return sysRegionNname;
	}
	public void setSysRegionNname(String sysRegionNname) {
		this.sysRegionNname = sysRegionNname;
	}
	public String getRegionLevel() {
		return regionLevel;
	}
	public void setRegionLevel(String regionLevel) {
		this.regionLevel = regionLevel;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public String getParentGb2260() {
		return parentGb2260;
	}
	public void setParentGb2260(String parentGb2260) {
		this.parentGb2260 = parentGb2260;
	}
	public String getDiallingCode() {
		return diallingCode;
	}
	public void setDiallingCode(String diallingCode) {
		this.diallingCode = diallingCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}

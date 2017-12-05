package com.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * 
 * @author admin
 *
 */
@Entity(name="oversea_config ")
public class OverseaConfig {
	
private	Integer ocId ;//主键
private  String title ;//标题',
private  String ocContent;//   CLOB,--'内容',
private  Integer sortColum ;//排序值',
private  String childTitle ;//子标题',
private  String ocDescription  ;// '描述',
private String  userType  ;//用户群体',
private  Date updTime ;//修改时间',
private Date  addTime ;//添加时间',
private  String overseaIcon ;//图标',
private  Date startDate  ;//开始时间',
private Date  endDate  ;//结束时间',
private Integer  status ;//状态',

@Id
@SequenceGenerator(name="OverseaConfig_seq",sequenceName="sql_oversea_config",allocationSize=1)
@GeneratedValue(generator="OverseaConfig_seq",strategy=GenerationType.SEQUENCE)


public Integer getOcId() {
	return ocId;
}
public void setOcId(Integer ocId) {
	this.ocId = ocId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getOcContent() {
	return ocContent;
}
public void setOcContent(String ocContent) {
	this.ocContent = ocContent;
}
public Integer getSortColum() {
	return sortColum;
}
public void setSortColum(Integer sortColum) {
	this.sortColum = sortColum;
}
public String getChildTitle() {
	return childTitle;
}
public void setChildTitle(String childTitle) {
	this.childTitle = childTitle;
}
public String getOcDescription() {
	return ocDescription;
}
public void setOcDescription(String ocDescription) {
	this.ocDescription = ocDescription;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public Date getUpdTime() {
	return updTime;
}
public void setUpdTime(Date updTime) {
	this.updTime = updTime;
}
public Date getAddTime() {
	return addTime;
}
public void setAddTime(Date addTime) {
	this.addTime = addTime;
}
public String getOverseaIcon() {
	return overseaIcon;
}
public void setOverseaIcon(String overseaIcon) {
	this.overseaIcon = overseaIcon;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
	

}

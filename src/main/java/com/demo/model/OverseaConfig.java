package com.demo.model;
import java.sql.Clob;
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
@Entity
public class OverseaConfig {
	
private	Integer ocId ;//主键
private  String title ;//标题',
private  String ocContent;//   CLOB,--'内容',
private  Integer sortcolum ;//排序值',
private  String childTitle ;//子标题',
private  String ocDescription  ;// '描述',
private String  userType  ;//用户群体',
private  Date updtime ;//修改时间',
private Date  addtime ;//添加时间',
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
public Integer getSortcolum() {
	return sortcolum;
}
public void setSortcolum(Integer sortcolum) {
	this.sortcolum = sortcolum;
}
public Date getUpdtime() {
	return updtime;
}
public void setUpdtime(Date updtime) {
	this.updtime = updtime;
}
public Date getAddtime() {
	return addtime;
}
public void setAddtime(Date addtime) {
	this.addtime = addtime;
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

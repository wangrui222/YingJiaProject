package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author admin
 *
 */
@Entity(name="fp_subscribe_record")
public class FpSubscribeRecord {
private Integer	 fpsrId ;//主键
private	 Integer  memberId ;//会员id
private	  Integer subscribeId ;//私募预约记录id
private  String techUserId ;//e签宝个人账号
private  String techUserSeal;//  e签宝个人印章
private	 String  orgPath  ;//原签署文档路径
private String  newPath  ;//新签署文档路径
private Integer   status ;//状态
private   Date createDate ;//添加时间
private	  Date  updateDate ;//修改时间
private	String   filed ;//备用字段


@Id
@SequenceGenerator(name="seq_FpSubscribeRecord",sequenceName="seq_fpsr",allocationSize=1)
@GeneratedValue(generator="seq_FpSubscribeRecord",strategy=GenerationType.SEQUENCE)

public Integer getFpsrId() {
	return fpsrId;
}
public void setFpsrId(Integer fpsrId) {
	this.fpsrId = fpsrId;
}
public Integer getMemberId() {
	return memberId;
}
public void setMemberId(Integer memberId) {
	this.memberId = memberId;
}
public Integer getSubscribeId() {
	return subscribeId;
}
public void setSubscribeId(Integer subscribeId) {
	this.subscribeId = subscribeId;
}
public String getTechUserId() {
	return techUserId;
}
public void setTechUserId(String techUserId) {
	this.techUserId = techUserId;
}
public String getTechUserSeal() {
	return techUserSeal;
}
public void setTechUserSeal(String techUserSeal) {
	this.techUserSeal = techUserSeal;
}
public String getOrgPath() {
	return orgPath;
}
public void setOrgPath(String orgPath) {
	this.orgPath = orgPath;
}
public String getNewPath() {
	return newPath;
}
public void setNewPath(String newPath) {
	this.newPath = newPath;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
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
public String getFiled() {
	return filed;
}
public void setFiled(String filed) {
	this.filed = filed;
}





}

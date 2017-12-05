package com.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name="user_message")
/**
 * 用户消息表
 * @author thinkpad
 *
 */
public class UserMessage {
	/**
	 * 消息主键
	 */
	private Integer umId ;
	/**
	 * 用户id
	 */
	private Integer userId  ;
	/**
	 * 消息标题
	 */
	private String title  ;
	/**
	 * 业务类别
	 */
	private Integer businessType ;
	/**
	 * 业务id
	 */
	private Integer ownerId;
	/**
	 * 消息内容（clob）
	 */
	private String umContent   ;
	/**
	 * 状态,(已读未读)
	 */
	private Integer msgStatus ;
	/**
	 * 删除标志
	 */
	private Integer delFlag;
	/**
	 * 创建时间
	 */
	private Date createDate ;
	/**
	 * 修改时间
	 */
	private Date updateDate ;
	@Id
	@SequenceGenerator(name="user_message",sequenceName="sql_user_message",allocationSize=1)
	@GeneratedValue(generator="user_message",strategy=GenerationType.SEQUENCE)
	public Integer getUmId() {
		return umId;
	}
	public void setUmId(Integer umId) {
		this.umId = umId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBusinessType() {
		return businessType;
	}
	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getUmContent() {
		return umContent;
	}
	public void setUmContent(String umContent) {
		this.umContent = umContent;
	}
	public Integer getMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

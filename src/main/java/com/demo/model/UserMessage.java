package com.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="user_message")
/**
 * �û���Ϣ��
 * @author thinkpad
 *
 */
public class UserMessage {
	/**
	 * ��Ϣ����
	 */
	private Integer umId ;
	/**
	 * �û�id
	 */
	private Integer userId  ;
	/**
	 * ��Ϣ����
	 */
	private String title  ;
	/**
	 * ҵ�����
	 */
	private Integer businessType ;
	/**
	 * ҵ��id
	 */
	private Integer ownerId;
	/**
	 * ��Ϣ���ݣ�clob��
	 */
	private String umContent   ;
	/**
	 * ״̬,(�Ѷ�δ��)
	 */
	private Integer msgStatus ;
	/**
	 * ɾ����־
	 */
	private Integer delFlag;
	/**
	 * ����ʱ��
	 */
	private Date createDate ;
	/**
	 * �޸�ʱ��
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

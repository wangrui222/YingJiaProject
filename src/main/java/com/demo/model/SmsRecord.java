package com.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sms_record")

/**
 * ���ż�¼��
 * @author thinkpad
 *
 */
public class SmsRecord {
	private Integer smsRecordId ;
	/**
	 * ��������
	 */
	private Integer smsRecordtype;
	/**
	 * �ֻ�����
	 * @return
	 */
	private String phone;
	/**
	 * ��֤��
	 * @return
	 */
	private String smsRecordCode;
	/**
	 * ��������
	 * @return
	 */
	private String smsRecordContent ;
	/**
	 * ���ؽ��
	 * @return
	 */
	private String smsRecordResult;
	/**
	 * ״̬
	 */
	private Integer status ;
	/**
	 * ����ʱ��
	 */
	private Date senddate;
	/**
	 * ����ʱ��
	 */
	private Date createdate;
	@Id
	@SequenceGenerator(name="sms_record",sequenceName="sql_sms_record",allocationSize=1)
	@GeneratedValue(generator="sms_record",strategy=GenerationType.SEQUENCE)
	public Integer getSmsRecordId() {
		return smsRecordId;
	}
	public void setSmsRecordId(Integer smsRecordId) {
		this.smsRecordId = smsRecordId;
	}
	public Integer getSmsRecordtype() {
		return smsRecordtype;
	}
	public void setSmsRecordtype(Integer smsRecordtype) {
		this.smsRecordtype = smsRecordtype;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSmsRecordCode() {
		return smsRecordCode;
	}
	public void setSmsRecordCode(String smsRecordCode) {
		this.smsRecordCode = smsRecordCode;
	}
	public String getSmsRecordContent() {
		return smsRecordContent;
	}
	public void setSmsRecordContent(String smsRecordContent) {
		this.smsRecordContent = smsRecordContent;
	}
	public String getSmsRecordResult() {
		return smsRecordResult;
	}
	public void setSmsRecordResult(String smsRecordResult) {
		this.smsRecordResult = smsRecordResult;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getSenddate() {
		return senddate;
	}
	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}

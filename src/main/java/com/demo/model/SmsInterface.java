package com.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name="sms_interface")

/**
 * ���Žӿ�ģ��
 * @author thinkpad
 *
 */
public class SmsInterface {
	private Integer siId;
	/**
	 * ����ģ������
	 */
	private String   siName;
	/**
	 * ����ģ������
	 */
	private Integer  siType ;
	/**
	 * ����ģ���ַ
	 * @return
	 */
	private String   address ;
	/**
	 * ����ģ�����
	 * @return
	 */
	private String siParam ;
	/**
	 * ����ģ������
	 * @return
	 */
	private String  siContent;
	/**
	 * ���ʱ��
	 */
	private Date createdate;
	@Id
	@SequenceGenerator(name="sms_interface",sequenceName="sql_sms_interface",allocationSize=1)
	@GeneratedValue(generator="sms_interface",strategy=GenerationType.SEQUENCE)
	public Integer getSiId() {
		return siId;
	}
	public void setSiId(Integer siId) {
		this.siId = siId;
	}
	public String getSiName() {
		return siName;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}
	public Integer getSiType() {
		return siType;
	}
	public void setSiType(Integer siType) {
		this.siType = siType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSiParam() {
		return siParam;
	}
	public void setSiParam(String siParam) {
		this.siParam = siParam;
	}
	public String getSiContent() {
		return siContent;
	}
	public void setSiContent(String siContent) {
		this.siContent = siContent;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


}

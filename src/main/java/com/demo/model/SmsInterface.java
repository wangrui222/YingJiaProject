package com.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name="sms_interface")

/**
 * 短信接口模板
 * @author thinkpad
 *
 */
public class SmsInterface {
	private Integer siId;
	/**
	 * 短信模板名称
	 */
	private String   siName;
	/**
	 * 担心模板类型
	 */
	private Integer  siType ;
	/**
	 * 短信模板地址
	 * @return
	 */
	private String   address ;
	/**
	 * 短信模板参数
	 * @return
	 */
	private String siParam ;
	/**
	 * 短信模板内容
	 * @return
	 */
	private String  siContent;
	/**
	 * 添加时间
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

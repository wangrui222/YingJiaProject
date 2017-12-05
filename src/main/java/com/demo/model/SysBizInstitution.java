package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="sys_biz_institution")

/**
 * ��ҵ����
 * @author thinkpad
 *
 */
public class SysBizInstitution {
	private Integer sbiId ;
	/**
	 * ʡ
	 */
	private String  province;
	/**
	 * ����
	 * @return
	 */
	private String city ;
	/**
	 * ���������ɷ�JF
	 * @return
	 */
	private String  bizType ;
	/**
	 * �����������ɷ�ˮ��WATER
	 * @return
	 */
	private String bizSubType;
	/**
	 * ��������
	 * @return
	 */
	private String  institutionName;
	/**
	 * ��������
	 * @return
	 */
	private String institutionCode ;
	@Id
	@SequenceGenerator(name="sys_biz_institution",sequenceName="sql_sys_biz_institution",allocationSize=1)
	@GeneratedValue(generator="sys_biz_institution",strategy=GenerationType.SEQUENCE)
	public Integer getSbiId() {
		return sbiId;
	}
	public void setSbiId(Integer sbiId) {
		this.sbiId = sbiId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getBizSubType() {
		return bizSubType;
	}
	public void setBizSubType(String bizSubType) {
		this.bizSubType = bizSubType;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	
	
}

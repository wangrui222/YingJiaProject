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
@Entity(name="oversea_config_subscribe")
public class OverseaConfigSubscribe {
	private Integer ocsId  ;//����
	private Integer memberId  ;//��Աid',
	private  Integer overseaId ;//��������id',
	private String ocsName  ;//����',
	private String  phone ;//�绰',
	private  String addr  ;//��ַ',
	private  Integer status  ;
	private  Date createDate ;
	private  Date updateDate  ;
	@Id
	@SequenceGenerator(name="OverseaConfigSubscribe  _seq",sequenceName="sql_oversea_config_subscribe",allocationSize=1)
	@GeneratedValue(generator="OverseaConfigSubscribe  _seq",strategy=GenerationType.SEQUENCE)

	public Integer getOcsId() {
		return ocsId;
	}
	public void setOcsId(Integer ocsId) {
		this.ocsId = ocsId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getOverseaId() {
		return overseaId;
	}
	public void setOverseaId(Integer overseaId) {
		this.overseaId = overseaId;
	}
	public String getOcsName() {
		return ocsName;
	}
	public void setOcsName(String ocsName) {
		this.ocsName = ocsName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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

}

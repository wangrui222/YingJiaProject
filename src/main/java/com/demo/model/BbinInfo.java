package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
-- �������Ϣ
 * @author admin
 *
 */
@Entity
@Table(name="bbin_info")
public class BbinInfo {
	private Integer bbinInfoId;//����
	private Integer memberId;//��Աid
	private Float  amont;//'���'
	private Integer status;//״̬��0����)
	private Date createDate ;//����ʱ��
	private Date updateDate;//�޸�ʱ��
	
	@Id
	@SequenceGenerator(name="seq_BbinInfo",sequenceName="seq_bbin_info",allocationSize=1)
	@GeneratedValue(generator="seq_BbinInfo",strategy=GenerationType.SEQUENCE)

	
	public Integer getBbinInfoId() {
		return bbinInfoId;
	}
	public void setBbinInfoId(Integer bbinInfoId) {
		this.bbinInfoId = bbinInfoId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Float getAmont() {
		return amont;
	}
	public void setAmont(Float amont) {
		this.amont = amont;
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

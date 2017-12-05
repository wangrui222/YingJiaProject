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
-- 体验金信息
 * @author admin
 *
 */
@Entity(name="bbin_info")
public class BbinInfo {
	private Integer bbinInfoId;//主键
	private Integer memberId;//会员id
	private Float  amont;//'金额'
	private Integer status;//状态（0：是)
	private Date createDate ;//创建时间
	private Date updateDate;//修改时间
	
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

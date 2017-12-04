package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="finance_product_subscribe")
/**
 * 理财类基金产品预约记录表
 * @author admin
 *
 */
public class FinanceProductSubscribe {

	private String financeProductSubscribeId ;//主键
	private String   financeProductSubscribeName  ;//名称
	private Integer memberId  ;//会员id,
	private String phone  ;//联系电话,
	private Integer  productId ;//理财产品id,
	private String addr  ;//所在地区,
	private Integer status ;//是否处理(0:签署拍照|1:已签约|2:审核中|3:签署失败)
	private String fpsComment  ;//电子签署文档信息
	private String riskReveal  ;//风险揭示书
	private Date createDate ;//添加时间
	private Date updateDate  ;//修改时间
	private Float amount ;//私募购买金额
	private Float interest  ;//私募结算收益
	private Date startDate ;// 开始时间
	private  Date endDate  ;//结束时间
	private String  signedPhotos  ;//签署拍照
	
	

	@Id
	@SequenceGenerator(name="seq_FinanceProductSubscribe",sequenceName="seq_finance_product_subscribe",allocationSize=1)
	@GeneratedValue(generator="seq_FinanceProductSubscribe",strategy=GenerationType.SEQUENCE)
	
	
	public String getFinanceProductSubscribeId() {
		return financeProductSubscribeId;
	}
	public void setFinanceProductSubscribeId(String financeProductSubscribeId) {
		this.financeProductSubscribeId = financeProductSubscribeId;
	}
	public String getFinanceProductSubscribeName() {
		return financeProductSubscribeName;
	}
	public void setFinanceProductSubscribeName(String financeProductSubscribeName) {
		this.financeProductSubscribeName = financeProductSubscribeName;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public String getFpsComment() {
		return fpsComment;
	}
	public void setFpsComment(String fpsComment) {
		this.fpsComment = fpsComment;
	}
	public String getRiskReveal() {
		return riskReveal;
	}
	public void setRiskReveal(String riskReveal) {
		this.riskReveal = riskReveal;
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
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Float getInterest() {
		return interest;
	}
	public void setInterest(Float interest) {
		this.interest = interest;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSignedPhotos() {
		return signedPhotos;
	}
	public void setSignedPhotos(String signedPhotos) {
		this.signedPhotos = signedPhotos;
	}
	
	
}

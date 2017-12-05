package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/*
 * ���������Ʒ
 */


@Entity(name="finance_product_funds")

public class FinanceProductFunds {
	private Integer  financeProductFundsId ;//����
	private String financeProductFundsType ;//��Ʒ����
	private  String financeProductFundsName; //����
	private Integer  status;//״̬(0:δ������1:ļ���У�2:�ѽ���)
	private  Integer  period ;//����
	private Float  floorAmount;//��Ͷ���
	private Float yearRate  ;//�껯��
	private  Integer subscribeCount;//ԤԼ����
	private  String productTopic;//����ר��/���ڻ���(CLOB)
	private String productFactor ;//��ƷҪ��(CLOB)
	private String productStrategy;//��Ʒ����(CLOB)
	private String productManager ;//'��������ϸ(CLOB)
	private Date createDate;//���ʱ��
	private Date  updateDate ; //�޸�ʱ��
	private  String productManagerName  ;//--����������,
	private  String productManagerPic ;//������ͼƬ,
	private String productManagerTitle  ;// ������ͷ��,
	private String productManagerDesc;// ��Ʒ�����˽���,
	private String investPoints ;//Ͷ�ʷ���, 
	private Float amount  ;//ļ�����,
	private  Float soldAmount  ;//���۽��,
	private  Integer buyerCount ;// ��������,
	private  Date startDate  ;//��ʼʱ��,
	private  Date endDate ;//����ʱ��, 
	private  String financeProductFundsRatio  ;//��Ӷ����,
	private String  contract ;//˽ļ��ͬ(CLOB),
	private  String  bankAccount;//�����˻���֧������|�����˺�|������,
	
	@Id
	@SequenceGenerator(name="seq_FinanceProductFunds",sequenceName="seq_finance_product_funds",allocationSize=1)
	@GeneratedValue(generator="seq_FinanceProductFunds",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getFinanceProductFundsId() {
		return financeProductFundsId;
	}
	public void setFinanceProductFundsId(Integer financeProductFundsId) {
		this.financeProductFundsId = financeProductFundsId;
	}
	public String getFinanceProductFundsType() {
		return financeProductFundsType;
	}
	public void setFinanceProductFundsType(String financeProductFundsType) {
		this.financeProductFundsType = financeProductFundsType;
	}
	public String getFinanceProductFundsName() {
		return financeProductFundsName;
	}
	public void setFinanceProductFundsName(String financeProductFundsName) {
		this.financeProductFundsName = financeProductFundsName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public Float getFloorAmount() {
		return floorAmount;
	}
	public void setFloorAmount(Float floorAmount) {
		this.floorAmount = floorAmount;
	}
	public Float getYearRate() {
		return yearRate;
	}
	public void setYearRate(Float yearRate) {
		this.yearRate = yearRate;
	}
	public Integer getSubscribeCount() {
		return subscribeCount;
	}
	public void setSubscribeCount(Integer subscribeCount) {
		this.subscribeCount = subscribeCount;
	}
	public String getProductTopic() {
		return productTopic;
	}
	public void setProductTopic(String productTopic) {
		this.productTopic = productTopic;
	}
	public String getProductFactor() {
		return productFactor;
	}
	public void setProductFactor(String productFactor) {
		this.productFactor = productFactor;
	}
	public String getProductStrategy() {
		return productStrategy;
	}
	public void setProductStrategy(String productStrategy) {
		this.productStrategy = productStrategy;
	}
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
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
	public String getProductManagerName() {
		return productManagerName;
	}
	public void setProductManagerName(String productManagerName) {
		this.productManagerName = productManagerName;
	}
	public String getProductManagerPic() {
		return productManagerPic;
	}
	public void setProductManagerPic(String productManagerPic) {
		this.productManagerPic = productManagerPic;
	}
	public String getProductManagerTitle() {
		return productManagerTitle;
	}
	public void setProductManagerTitle(String productManagerTitle) {
		this.productManagerTitle = productManagerTitle;
	}
	public String getProductManagerDesc() {
		return productManagerDesc;
	}
	public void setProductManagerDesc(String productManagerDesc) {
		this.productManagerDesc = productManagerDesc;
	}
	public String getInvestPoints() {
		return investPoints;
	}
	public void setInvestPoints(String investPoints) {
		this.investPoints = investPoints;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Float getSoldAmount() {
		return soldAmount;
	}
	public void setSoldAmount(Float soldAmount) {
		this.soldAmount = soldAmount;
	}
	public Integer getBuyerCount() {
		return buyerCount;
	}
	public void setBuyerCount(Integer buyerCount) {
		this.buyerCount = buyerCount;
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
	public String getFinanceProductFundsRatio() {
		return financeProductFundsRatio;
	}
	public void setFinanceProductFundsRatio(String financeProductFundsRatio) {
		this.financeProductFundsRatio = financeProductFundsRatio;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	} 
	
	
	
	

}  
 
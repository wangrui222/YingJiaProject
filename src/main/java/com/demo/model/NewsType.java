package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * -  新闻类别列表
 * @author admin
 *
 */
@Entity
@Table(name="news_type ")
public class NewsType {
	private Integer newsTypeId ;//主键
	private String newsTypeName;//名称',
	private String newsTypeLink;//'链接',
	private  String note  ;//备注',
	private  Integer newsTypeSort  ;//排序',
	private  String pageType  ;//页面类型',
	private  Integer supType ;//上级类别',
	private  String info  ;// '简介',
	private String cPhoto  ;//封面图片',
	private String  text  ;//CLOB 内容',
	private String seoTitle  ;//页面seo标题',
	private String seoKey;// seo关键字', 
	private  String seoDes  ;//seo描述',
	private Integer addId  ;//添加人ID',
	private Integer updId ;//修改人ID',
	private Date updTime ;//修改时间',
	private  Date addTime  ;//添加时间',
	
	
	@Id
	@SequenceGenerator(name="NewsType _seq",sequenceName="sql_news_type",allocationSize=1)
	@GeneratedValue(generator="NewsType _seq",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getNewsTypeId() {
		return newsTypeId;
	}
	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	public String getNewsTypeName() {
		return newsTypeName;
	}
	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}
	public String getNewsTypeLink() {
		return newsTypeLink;
	}
	public void setNewsTypeLink(String newsTypeLink) {
		this.newsTypeLink = newsTypeLink;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getNewsTypeSort() {
		return newsTypeSort;
	}
	public void setNewsTypeSort(Integer newsTypeSort) {
		this.newsTypeSort = newsTypeSort;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public Integer getSupType() {
		return supType;
	}
	public void setSupType(Integer supType) {
		this.supType = supType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getcPhoto() {
		return cPhoto;
	}
	public void setcPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSeoTitle() {
		return seoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}
	public String getSeoKey() {
		return seoKey;
	}
	public void setSeoKey(String seoKey) {
		this.seoKey = seoKey;
	}
	public String getSeoDes() {
		return seoDes;
	}
	public void setSeoDes(String seoDes) {
		this.seoDes = seoDes;
	}
	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer addId) {
		this.addId = addId;
	}
	public Integer getUpdId() {
		return updId;
	}
	public void setUpdId(Integer updId) {
		this.updId = updId;
	}
	public Date getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
	
	

}

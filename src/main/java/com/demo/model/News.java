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
 *新闻列表
 */
@Entity(name="news")

public class News {
	private	Integer newsId  ;//主键
	private  Integer newsTypeId  ;//所属类别
	private  String title ;//标题
	private  String subTitle  ;//副标题
	private  Integer newsSort ;//排序
	private  String info  ;//简介',
	private  String cPhoto ;//封面图片',
	private   String newsLink  ;//链接地址'
	private  String author  ;// '作者', 
	private  String newsSource ;//'来源',
	private String  newsLabel  ;// '标签',
	private  Integer clickNumber  ;//点击数量',
	private  String text  ;//CLOB,-- '内容',
	private String  filelink  ;// '附件地址',
	private  String seoTitle ;// '页面seo标题',
	private  String seoKey  ;// seo关键字,
	private String  seoDes ;// 'seo描述',
	private Integer  placTop  ;//是否置顶 0：为是  1为否',
	private Integer  recommend  ;//是否推荐',
	private  Integer news_audit ;//是否审核',
	private  Integer addId  ;// '添加人ID',
	private   Integer updId ;//'修改人ID',
	private  Date updTime ;// '修改时间',
	private  Date addTime ;// '添加时间', 
	
	@Id
	@SequenceGenerator(name="News",sequenceName="sql_news",allocationSize=1)
	@GeneratedValue(generator="News",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public Integer getNewsTypeId() {
		return newsTypeId;
	}
	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Integer getNewsSort() {
		return newsSort;
	}
	public void setNewsSort(Integer newsSort) {
		this.newsSort = newsSort;
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
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNewsSource() {
		return newsSource;
	}
	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}
	public String getNewsLabel() {
		return newsLabel;
	}
	public void setNewsLabel(String newsLabel) {
		this.newsLabel = newsLabel;
	}
	public Integer getClickNumber() {
		return clickNumber;
	}
	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFilelink() {
		return filelink;
	}
	public void setFilelink(String filelink) {
		this.filelink = filelink;
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
	public Integer getPlacTop() {
		return placTop;
	}
	public void setPlacTop(Integer placTop) {
		this.placTop = placTop;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public Integer getNews_audit() {
		return news_audit;
	}
	public void setNews_audit(Integer news_audit) {
		this.news_audit = news_audit;
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

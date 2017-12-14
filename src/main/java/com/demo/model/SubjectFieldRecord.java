package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

/**
 * 
 * @author thinkpad
 *
 */
public class SubjectFieldRecord {
	private Integer sfrId;
	/**
	 * 标的Id
	 */
	private Integer   subjectId ;
	/**
	 * 字段id
	 */
	 private Integer  fieldId;
	 /**
	  * 字段值
	  * @return
	  */
	 private String  fieldValue;
	 /**
	  * 删除标记
	  */
	private Integer   delflag;
	/**
	 * 创建日期
	 */
	 private Date  createDate ;
	 /**
	  * 更新日期
	  */
	 private Date  updateDate ;
	 @Id
	 @SequenceGenerator(name="subject_field_record",sequenceName="sql_subject_field_record",allocationSize=1)
	 @GeneratedValue(generator="subject_field_record",strategy=GenerationType.SEQUENCE)
	public Integer getSfrId() {
		return sfrId;
	}
	public void setSfrId(Integer sfrId) {
		this.sfrId = sfrId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getFieldId() {
		return fieldId;
	}
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
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
